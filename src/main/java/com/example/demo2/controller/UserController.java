package com.example.demo2.controller;

import com.example.demo2.service.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private User user;


    @GetMapping("reflush")
    public String getName() {
        user.reflush();
        return "ok";
    }

    public static void main(String[] args) {


    }

    @GetMapping("/user/getAge")
    public int getAge() {
        return 213;
    }
}
