package com.example.demo.controller;

import com.example.demo.serve.WritesServe;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/writes")
public class WritesController {
    WritesServe writesServe;
    WritesController(){
        writesServe=new WritesServe();
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/write")
    public String write(@RequestParam("UID") String UID, @RequestParam("headline") String headline,@RequestParam("content") String content){
        return writesServe.insetWrite(UID,headline,content);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/deleteWrite")
    public String deleteWrite(@RequestParam("UID") String UID, @RequestParam("id") String id){
        return writesServe.deleteWrite(UID,id);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/searchWritesByUID")
    public String searchWritesByUID(@RequestParam("UID") String UID){
        return writesServe.searchWritesByUID(UID);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/searchWritesAll")
    public String searchWritesAll(){
        return writesServe.searchWritesAll();
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/searchWritesByFollow")
    public String searchWritesByFollow(@RequestParam("UID") String UID){
        return writesServe.searchWritesByFollow(UID);
    }

}
