package org.example.controllers;

import org.example.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootConfiguration
@RestController
public class HelloWorld {

    @Autowired
    private HelloService helloService;

    @GetMapping("/")
    public String test(@RequestParam(value = "name") String name) {
        return this.helloService.test(name);
    }
}
