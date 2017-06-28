package com.allen.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

//@SpringBootApplication
//@EnableScheduling
public class DemoApplication {
//    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
//
//    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
//    }
//
//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }
//
//    @Bean
//    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//        return args -> {
////            http://115.159.24.246:8080/JsServertest.json
////            Quote quote = restTemplate.getForObject(
////                    "http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
//            JsServerBean[] serverBean = restTemplate.getForObject("http://115.159.24.246:8080/JsServertest.json", JsServerBean[].class);
//            log.info(Arrays.toString(serverBean));
//
//        };
//    }



}
