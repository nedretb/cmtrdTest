package com.example.cmtrdtest.service;

import com.example.cmtrdtest.model.Hello;
import com.example.cmtrdtest.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private final HelloRepository helloRepository;

    @Autowired
    public HelloService(HelloRepository helloRepository){
        this.helloRepository = helloRepository;
    }

    public String getPhrase(String lang){
        return helloRepository.findByLang(lang).get(0).getMsg();
    }


    public void save(Hello hello){ helloRepository.save(hello);}
}
