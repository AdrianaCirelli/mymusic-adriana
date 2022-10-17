package com.ciandt.summit.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiMusicApp {

    public static void main(String[] args) {

        SpringApplication.run(ApiMusicApp.class, args);
    }
}
