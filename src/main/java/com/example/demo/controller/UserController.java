package com.example.demo.controller;

import com.example.demo.serve.FileDownload;
import com.example.demo.serve.UserServe;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jincan
 */
@RestController
@RequestMapping("/user")
public class UserController {
    UserServe userOperation;
    public UserController() {
        userOperation = new UserServe();
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/login")
    public String login(@RequestParam("UID") String uid,@RequestParam("password") String password) {
        return userOperation.login(uid,password);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/register")
    public String register(@RequestParam("UID") String uid, @RequestParam("username") String username,
                           @RequestParam("password") String password,@RequestParam("email") String email) {
        return userOperation.register(uid,username,password,email);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/modify")
    public String modify(@RequestParam("UID") String uid, @RequestParam("username") String username,
                           @RequestParam("password") String password,@RequestParam("email") String email) {
        return userOperation.modify(uid,username,password,email);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/modifyImage")
    public String modifyImage(@RequestParam("UID") String uid, @RequestParam("image") String image) {
        return userOperation.modifyImage(uid,image);
    }

    @CrossOrigin(origins = {"*"})
    @GetMapping("/download")
    public void downloadCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
        FileDownload.fileDownload(request,response);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/findUsernameByUID")
    public String findUsernameById(@RequestParam("UID") String uid) {
        return userOperation.findUsernameById(uid);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/findImageByUID")
    public String findImageByUid(@RequestParam("UID") String uid) {
        return userOperation.findImageByUID(uid);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/follow")
    public String follow(@RequestParam("following") String following, @RequestParam("followed") String followed) {
        return userOperation.follow(following,followed);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/cancelFollow")
    public String cancelFollow(@RequestParam("following") String following, @RequestParam("followed") String followed) {
        return userOperation.cancelFollow(following,followed);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/searchFollowByUID")
    public String searchFollowByUid(@RequestParam("UID") String uid) {
        return userOperation.searchFollowByUid(uid);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/collect")
    public String collect(@RequestParam("uid") String uid, @RequestParam("id") String id) {
        return userOperation.collect(uid,id);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/cancelCollect")
    public String cancelCollect(@RequestParam("uid") String uid, @RequestParam("id")String id) {
        return userOperation.cancelCollect(uid,id);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/searchCollectByUID")
    public String searchCollectByUid(@RequestParam("UID") String UID) {
        return userOperation.searchCollectByUid(UID);
    }
}



