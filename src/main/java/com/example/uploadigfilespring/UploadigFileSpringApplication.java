package com.example.uploadigfilespring;

import com.example.uploadigfilespring.storage.StorageProperties;
import com.example.uploadigfilespring.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({StorageProperties.class})

public class UploadigFileSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(UploadigFileSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
