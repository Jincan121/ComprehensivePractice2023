package com.example.demo.serve;

import com.alibaba.fastjson.JSON;
import com.example.demo.classes.Follow;
import com.example.demo.classes.MyJason;
import com.example.demo.classes.MyUser;
import com.example.demo.classes.Poetry;
import com.example.demo.dao.DaoUser;

import java.util.Iterator;
import java.util.List;

public class UserServe {
    DaoUser daoUser;
    public UserServe() {
        daoUser=new DaoUser();
    }

    public String login(String uid, String password){
        List<MyUser>select=daoUser.selectTableByUID(uid);
        if(select.isEmpty()){
            return "not found";
        }
        Iterator<MyUser> iter=select.iterator();
        if(iter.next().getPassword().equals(password)){
            return "success";
        }
        else {
            return "error";
        }
    }

    public String register(String uid, String username,String password,String email){
        List<MyUser>select1=daoUser.selectTableByUID(uid);
        if(select1.size()!=0){
            return "UID existing";
        }

        List<MyUser>select2=daoUser.selectTableByEmail(email);
        if(select2.size()!=0){
            return "email existing";
        }

        if(daoUser.insertUser(uid,username,password,email)==0){
            return "error";
        }
        else {
            if(daoUser.insertTRecommend(uid)==0) {
                return "error";
            }
            return "success";
        }
    }

    public String modify(String UID, String username,String password,String email){
        List<MyUser>select=daoUser.selectTableByUID(UID);
        if(select.isEmpty()){
            return "not found";
        }
        Iterator<MyUser> iter=select.iterator();
        if(iter.next().getEmail().equals(email)){
            //匹配邮箱通过
            int result=daoUser.modify(UID,username,password);
            if(result>0){
                return "success";
            }
            return "error";
        }
        return "email error";
    }

    public String modifyImage(String UID, String image){
        List<MyUser>select=daoUser.selectTableByUID(UID);
        if(select.isEmpty()){
            return "not found";
        }
        if(daoUser.modifyImage(UID,image)>0){
            return "success";
        }
        return "error";
    }

    public String findUsernameById(String uid){
        String username=daoUser.findUsernameByID(uid);
        if(username.isEmpty()){
            return "not found";
        }
        return MyJason.toJason("username",username);
    }

    public String findImageByUID(String uid){
        String image=daoUser.findImageByID(uid);
        if(image.isEmpty()){
            return "not found";
        }
        return MyJason.toJason("image",image);
    }

    public String follow(String following,String followed){
        List<Follow> list=daoUser.searchFollowByUID(following);
        Iterator<Follow>iter=list.iterator();
        while(iter.hasNext()){
            if(iter.next().getFollowed().equals(followed)){
                return "existing";
            }
        }
        if(daoUser.follow(following,followed)==0){
            return "error";
        }
        else {
            return "success";
        }
    }

    public String cancelFollow(String following,String followed){
        List<Follow> list=daoUser.searchFollowByUID(following);
        Iterator<Follow>iter=list.iterator();
        while(iter.hasNext()){
            if(iter.next().getFollowed().equals(followed)){
                if(daoUser.cancelFollow(following,followed)==0){
                    return "error";
                }
                else {
                    return "success";
                }
            }
        }
        return "not existing";
    }

    public String searchFollowByUid(String uid){
        List<Follow> list=daoUser.searchFollowByUID(uid);
        if(list.isEmpty()){
            return "empty";
        }
        return JSON.toJSONString(list);
    }

    public String collect(String UID,String id){
        List<Poetry> list=daoUser.searchCollectionByUID(UID);
        Iterator<Poetry>iter=list.iterator();
        while(iter.hasNext()){
            if(iter.next().getId().equals(id)){
                return "existing";
            }
        }
        if(daoUser.collection(UID,id)==0){
            return "error";
        }
        else {
            return "success";
        }
    }

    public String cancelCollect(String UID,String id){
        List<Poetry> list=daoUser.searchCollectionByUID(UID);
        Iterator<Poetry>iter=list.iterator();
        while(iter.hasNext()){
            if(iter.next().getId().equals(id)){
                if(daoUser.cancelCollection(UID,id)==0){
                    return "error";
                }
                else {
                    return "success";
                }
            }
        }
        return "not existing";
    }

    public String searchCollectByUid(String uid){
        List<Poetry> list=daoUser.searchCollectionByUID(uid);
        if(list.isEmpty()){
            return "empty";
        }
        return JSON.toJSONString(list);
    }
}
