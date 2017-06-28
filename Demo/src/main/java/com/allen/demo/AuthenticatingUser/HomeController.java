package com.allen.demo.AuthenticatingUser;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/27.
 */
@RestController
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "Welcome to the home page!";
    }
}
