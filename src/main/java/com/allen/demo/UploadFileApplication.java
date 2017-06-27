package com.allen.demo;

import com.allen.demo.storage.StorageProperties;
import com.allen.demo.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * Created by Allen on 2017/6/27.
 */
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class UploadFileApplication {
    public static void main(String[] args) {
        SpringApplication.run(UploadFileApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (arg) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
