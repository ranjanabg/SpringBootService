package com.ranjana.springboot.localMVP.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestService {

    @GetMapping("/")
    public String SayHello () {
        return "Hello Ranjana";
    }

    @GetMapping("/hororscope")
    public String ReadTodayHoroscope() {
        return "Abundance of success will flow into your life!";
    }
}
