package org.example.services;

import org.example.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class HelloService2 {

    @Autowired
    private RestTemplate restTemplate;

    private static final String url = "http://localhost:8082/api/test";

    public String test() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity(headers);

        Response response = restTemplate.exchange(url, HttpMethod.GET, entity, Response.class).getBody();
        return response.getMessage();
    }

    public String teste(){
    	return "Jonas";
    }
}
