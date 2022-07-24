package com.example.cmtrdtest.controller;

import com.example.cmtrdtest.aop.Logging;
import com.example.cmtrdtest.model.Hello;
import com.example.cmtrdtest.repository.HelloRepository;
import com.example.cmtrdtest.service.GoogleTranslateService;
import com.example.cmtrdtest.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
@Validated
public class HelloController {

    private final GoogleTranslateService googleTranslateService;
    private final HelloService helloService;

    private final HelloRepository helloRepository;

    @Autowired
    public HelloController(GoogleTranslateService googleTranslateService, HelloService helloService, HelloRepository helloRepository) {
        this.googleTranslateService = googleTranslateService;
        this.helloService = helloService;
        this.helloRepository = helloRepository;
    }

    @GetMapping(path = "/")
    public String home(){
        return "home";
    }

    @Logging
    @GetMapping(path = "/hello")
    public String getPhrase(@RequestParam(name = "lang", defaultValue = "en") String lang, Model model){
        model.addAttribute("hello_world", helloService.getPhrase(lang));
        return "hello-there";
    }

    @GetMapping(path = "/secure/hello")
    public String login(){
        return "login-page";
    }

    @GetMapping(path = "/add-language")
    public String addLanguage(Model model){
        model.addAttribute("hello", new Hello());
        return "add-language";
    }

    @PostMapping(path = "/add")
    public String add(@ModelAttribute Hello hello, Model model){
        Hello helloPair = new Hello();
        helloPair.setMsg(hello.getMsg());
        helloPair.setLang(hello.getLang());
        helloService.save(helloPair);
        return "redirect:/add-language";
    }

    @GetMapping(path = "/hello-api")
    public String googleTranslate(@RequestParam(name = "lang", defaultValue = "es") String lang, Model model){
        model.addAttribute("hello_world", googleTranslateService.googleTranslate(lang));
        return "/hello-there";
    }
}
