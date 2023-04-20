package com.example.demo.serve;

import com.example.demo.dao.DaoUser;
import com.example.demo.classes.MyUser;

import java.util.Iterator;
import java.util.List;

public class UserServe {
    DaoUser daoUser;
    public UserServe() {
        daoUser=new DaoUser();
    }

    public String login(String UID, String password){
        List<MyUser>select=daoUser.selectTableByUID(UID);
        if(select.isEmpty()){
            return "not found";
        }
        Iterator<MyUser> iter=select.iterator();
        if(iter.next().getPassword().equals(password)){
            return "success";
        }
        else return "error";
    }

    public String register(String UID, String username,String password,String email){
        List<MyUser>select1=daoUser.selectTableByUID(UID);
        if(select1.size()!=0){
            return "UID existing";
        }

        List<MyUser>select2=daoUser.selectTableByEmail(email);
        if(select2.size()!=0){
            return "email existing";
        }

        if(daoUser.insertTable(UID,username,password,email)==0){
            return "error";
        }
        else return "success";
    }

}
