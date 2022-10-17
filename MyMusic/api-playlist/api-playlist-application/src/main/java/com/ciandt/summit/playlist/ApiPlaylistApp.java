package com.ciandt.summit.playlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiPlaylistApp {

    public static void main(String[] args) {
        SpringApplication.run(ApiPlaylistApp.class, args);
    }
}
