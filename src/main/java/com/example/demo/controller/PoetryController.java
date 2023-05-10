package com.example.demo.controller;

import com.example.demo.serve.PoetryServe;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/poetry")
public class PoetryController {
    PoetryServe poetryServe;
    public PoetryController() throws FileNotFoundException {
        poetryServe = new PoetryServe();
    }

    //解决同源跨域问题
    @CrossOrigin(origins = {"*"})
    @RequestMapping("/rand")
    public String recommendByRand() {
        return poetryServe.recommendByRand();
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/search")
    public String search(@RequestParam("content") String content) {
        return poetryServe.searchByContent(content);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/searchByTag")
    public String searchByTag(@RequestParam("tag") String tag) {
        return poetryServe.searchByTag(tag);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/searchByPoetname")
    public String searchByPoetname(@RequestParam("poetname") String poetname) {
        return poetryServe.searchByPoetname(poetname);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/searchByID")
    public String searchByID(@RequestParam("id") String id) {
        return poetryServe.searchById(id);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/findSupportExsit")
    public String findSupportExsit(@RequestParam("UID") String UID,@RequestParam("id") String id) {
        return poetryServe.findSupportExsit(UID,id);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/support")
    public String support(@RequestParam("UID") String UID,@RequestParam("id") String id) {
        return poetryServe.support(UID,id);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/cancelSupport")
    public String cancelSupport(@RequestParam("UID") String UID,@RequestParam("id") String id) {
        return poetryServe.cancelSupport(UID,id);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/recommend")
    public String recommend(@RequestParam("UID") String UID) {
        return poetryServe.recommendByUser(UID);
    }


}

