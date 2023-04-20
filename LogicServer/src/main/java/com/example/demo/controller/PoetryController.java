package com.example.demo.controller;

import com.example.demo.serve.PoetryServe;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/poetry")
public class PoetryController {
    PoetryServe poetryServe;
    public PoetryController() {
        poetryServe = new PoetryServe();
    }

    //解决同源跨域问题
    @CrossOrigin(origins = {"*"})
    @RequestMapping("/rand")
    public String recommendByRand() {
        return poetryServe.recommendByRand();
    }
}

