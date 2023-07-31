package org.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    private HelloService2 helloService2;

    public String test(String name) {
    	String teste = helloService2.teste();
        return name + ": Hello " + helloService2.test();
    }
}
