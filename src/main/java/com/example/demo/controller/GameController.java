package com.example.demo.controller;

import com.example.demo.serve.GameServe;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jincan
 */
@RestController
@RequestMapping("/game")
public class GameController {
    GameServe gameServe;
    public GameController(){
        gameServe=new GameServe();
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/Feihualing")
    public String playFeiHuaLing(@RequestParam("content") String content) {
        return gameServe.playFeiHuaLing(content);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/passFeihualing")
    public String passFeihualing(@RequestParam("UID") String uid,@RequestParam("content") String content) {
        return gameServe.passFeihualing(uid,content);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/findFeihualing")
    public String findFeihualing(@RequestParam("UID") String uid) {
        return gameServe.findFeihualing(uid);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/poetLevel")
    public String playPoetLevel(@RequestParam List<String> content,@RequestParam String poet) {
        return gameServe.playPoetLevel(content,poet);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/passPoetLevel")
    public String passPoetLevel(@RequestParam("UID") String uid,@RequestParam("poet") String poet) {
        return gameServe.passPoetLevel(uid,poet);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/findPoetLevel")
    public String findPoetLevel(@RequestParam("UID") String uid) {
        return gameServe.findPoetLevel(uid);
    }
}
