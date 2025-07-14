package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyClientSideController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ribbon-client-call")
    public String callServerViaRibbon() {
        
        String url = "http://rest-ribbon-server/api/hello";  // Assuming server exposes /api/hello
        return restTemplate.getForObject(url, String.class);
    }
}
