package com.ciandt.summit.user.adapters;

import com.ciandt.summit.user.exception.GetPremiumException;
import com.ciandt.summit.user.PlaylistModel;
import com.ciandt.summit.user.UserModel;
import com.ciandt.summit.user.port.in.ManipulatingMusicInPlaylistDTO;
import com.ciandt.summit.user.port.in.UserUseCasePort;
import com.ciandt.summit.user.port.out.ApiPlaylistPort;
import com.ciandt.summit.user.port.out.TokenProviderPort;
import com.ciandt.summit.user.port.out.UserRepositoryPort;
import org.apache.log4j.Logger;


import java.util.UUID;

public class UserUseCaseAdapter implements UserUseCasePort {

    private UserRepositoryPort userRepositoryPort;
    private TokenProviderPort tokenProviderPort;

    private ApiPlaylistPort apiPlaylistPort;

    private static final Logger logger = Logger.getLogger(UserUseCaseAdapter.class);

    public UserUseCaseAdapter(UserRepositoryPort userRepositoryPort,
                              TokenProviderPort tokenProviderPort,
                              ApiPlaylistPort apiPlaylistPort) {
        this.userRepositoryPort = userRepositoryPort;
        this.tokenProviderPort = tokenProviderPort;
        this.apiPlaylistPort = apiPlaylistPort;
    }

    @Override
    public UserModel findUserByUUID(UUID idUser) {

        logger.info("Buscando usuário por id");

        return userRepositoryPort.findUserById(idUser);
    }

    @Override
    public UserModel findUserByName(String name) {

        logger.info("Realizando login de usuário");

        return userRepositoryPort.findUserByName(name);
    }

    @Override
    public PlaylistModel getUserPlaylist(UUID idUser) {

        logger.info("Buscando playlist do usuário por id");

        UserModel user = validateAndAutenticateUser(idUser);

        PlaylistModel playlistById = apiPlaylistPort.getPlaylistByUser(user);

        logger.info("Playlist encontrada com sucesso.");

        return playlistById;
    }

    @Override
    public PlaylistModel removeMusic(UUID idUser, ManipulatingMusicInPlaylistDTO removeMusicDto) {

        logger.info("Iniciando remoção de música da playlist");

        validateAndAutenticateUser(idUser);

        PlaylistModel playlistUpdated = apiPlaylistPort.removeMusic(removeMusicDto);

        logger.info("Música removida da playlist com sucesso.");

        return playlistUpdated;
    }

    @Override
    public PlaylistModel addMusicToPlaylist(UUID idUser, ManipulatingMusicInPlaylistDTO addMusicDto) {
        var user = validateAndAutenticateUser(idUser);

        var isPremium = user.getTipoUsuario().getDescricao().equalsIgnoreCase("premium");

        var amountOfMusicsInPlaylist = user.getPlaylist().getMusics();

        PlaylistModel playlistUpdate;

        if(isPremium || amountOfMusicsInPlaylist.size() < 5 ){

            playlistUpdate = apiPlaylistPort.addMusic(addMusicDto);
        } else {

            logger.warn("Limite máximo de músicas para o usuário Comum atingido.");
            throw new GetPremiumException("Você atingiu o número máximo de músicas em sua playlist. Para adicionar mais músicas contrate o plano Premium.");
        }

        return playlistUpdate;
    }

    public UserModel validateAndAutenticateUser(UUID idUser){
        var user = findUserByUUID(idUser);

        var token = tokenProviderPort.requestToken(user.getName());

        tokenProviderPort.validateToken(user.getName(), token);

        return user;
    }

    public String toLower(String word){
        return word.toLowerCase();
    }


}
