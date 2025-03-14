package edu.ncu.pay.demo.starter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class Test {

    @GetMapping("/1")
    public String test() {
        return "test";
    }

}
