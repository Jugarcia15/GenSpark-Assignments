package com.genspark.SecurityDemo.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myController {
    @GetMapping("/home")
    public String home() {
        return "<HTML><H1>Welcome to Home Page</H1></HTML>";
    }

    @GetMapping("/user")
    public String user() {
        return "<HTML><H1>Welcome to User Page</H1></HTML>";
    }

    @GetMapping("/admin")
    public String admin() {
        return "<HTML><H1>Welcome to Admin Page</H1></HTML>";
    }

}
