package com.example.cmtrdtest.controller;

import com.example.cmtrdtest.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello-rest")
public class HelloRestController {

    final public HelloService helloService;

    public HelloRestController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    public String hello(@RequestParam(name = "lang", defaultValue = "en") String lang){
        return helloService.getPhrase(lang);
    }
}
