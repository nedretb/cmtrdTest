package com.example.cmtrdtest.config;

import com.example.cmtrdtest.model.Hello;
import com.example.cmtrdtest.repository.HelloRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class HelloConfig {

    @Bean
    CommandLineRunner commandLineRunner2(HelloRepository repository){
        return  args -> {
            Hello en = new Hello("Hello World", "en");
            Hello bos = new Hello("Zdravo svijete", "bos");
            Hello azer = new Hello("salam dunya", "azer");
            Hello latv = new Hello("Sveika pasaule", "latv");
            Hello cat = new Hello("Hola món", "cat");
            Hello est = new Hello("Tere, Maailm", "est");
            Hello ger = new Hello("Hallo Welt", "ger");
            Hello dk = new Hello("Hej Verden", "dk");
            Hello ita = new Hello("Ciao mondo", "ita");
            Hello slo = new Hello("Pozdravljen, svet", "slo");

            repository.saveAll(List.of(en, bos, azer, latv, cat, est, ger, dk, ita, slo));
        };
    }
}
