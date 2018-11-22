package com.example.networking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.networking.client.Client;

@SpringBootApplication
public class NetworkingApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetworkingApplication.class, args);
    }

    @Bean
    public Client client() {
        return new Client();
    }

}
