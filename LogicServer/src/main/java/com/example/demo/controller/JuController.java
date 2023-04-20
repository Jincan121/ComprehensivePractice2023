package com.example.demo.controller;

import com.example.demo.serve.JuServe;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ju")
public class JuController {
    JuServe juServe;
    public JuController() {
        juServe = new JuServe();
    }

    //解决同源跨域问题
    @CrossOrigin(origins = {"*"})
    @RequestMapping("/rand")
    public String rand() {
        return juServe.rand();
    }
}
