package org.genspark;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @GetMapping("/")
    public String welcome(){
        return "Welcome!";
    }

    @GetMapping("/home/{name}")
    public String home(@PathVariable String name){
        return "Welcome to home." + name;
    }
}
