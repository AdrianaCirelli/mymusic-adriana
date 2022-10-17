package com.ciandt.summit.playlist.rest.consummer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.UUID;

@FeignClient(name = "api-music")
public interface ApiMusicProxy {

    @GetMapping(value = "/api/v1/musics/{idMusic}")
    MusicDtoResponse findMusic(@PathVariable UUID idMusic);
}
