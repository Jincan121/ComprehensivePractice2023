package com.example.demo.serve;

import com.alibaba.fastjson.JSON;
import com.example.demo.classes.Writes;
import com.example.demo.dao.DaoWrites;

import java.util.List;

public class WritesServe {
    DaoWrites daoWrites;
    public WritesServe() {
        daoWrites = new DaoWrites();
    }

    public String insetWrite(String UID,String headline,String content){
        if(daoWrites.insertWrites(UID,headline,content)>0){
            return "success";
        }
        return "error";
    }

    public String deleteWrite(String UID,String id){
        if(daoWrites.deleteWrites(UID,id)>0){
            return "success";
        }
        return "error";
    }

    public String searchWritesByUID(String UID){
        List<Writes> list=daoWrites.selectWritesByUID(UID);
        if(list.isEmpty()){
            return "empty";
        }
        return JSON.toJSONString(list);
    }

    public String searchWritesAll(){
        List<Writes> list=daoWrites.searchWritesAll();
        if(list.isEmpty()){
            return "empty";
        }
        return JSON.toJSONString(list);
    }


    public String searchWritesByFollow(String UID){
        List<Writes> list=daoWrites.searchWritesByFollow(UID);
        if(list.isEmpty()){
            return "empty";
        }
        return JSON.toJSONString(list);
    }
}
