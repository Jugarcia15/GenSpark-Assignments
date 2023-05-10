package org.Genspark;


import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class Main {

    @GetMapping("/")
    public String hello(){
        return "Hello, world!";
    }

    @GetMapping("/user/{name}")
    public String greet(@PathVariable String name){
        return ("Hello, " + name + "!");
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return user;
    }
}