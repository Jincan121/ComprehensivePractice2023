package com.example.demo.serve;

import com.example.demo.classes.Poetry;
import com.example.demo.dao.DaoPoetry;

import java.util.Iterator;
import java.util.List;

public class PoetryServe {
    DaoPoetry daoPoetry;
    public PoetryServe() {
        daoPoetry=new DaoPoetry();
    }

    public String recommendByRand(){
        List<Poetry> list=daoPoetry.selectTableByRand();
        if(list.isEmpty()){
            return "error";
        }
        Iterator<Poetry> iter=list.iterator();
        while(iter.hasNext()){
            Poetry poetry=iter.next();
            String content=poetry.getContent();
            content=content.replace("<p>","");
            content=content.replace("</p>","");
            content=content.replace("<br>","");
            content=content.replace("</br>","");
            poetry.setContent(content);
        }

        return list.toString();
    }
}
