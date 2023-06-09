package com.example.demo.serve;

import com.alibaba.fastjson.JSON;
import com.example.demo.classes.Ju;
import com.example.demo.dao.DaoJu;

import java.util.Iterator;
import java.util.List;

public class JuServe {
    DaoJu daoJu;
    public JuServe() {
        daoJu=new DaoJu();
    }

    public String rand(){
        List<Ju>list=daoJu.selectTableByRand();
        if(list.isEmpty()){
            return "error";
        }
        Iterator<Ju> iter=list.iterator();
        Ju ju=iter.next();
        if(ju.getPoetName()==null)ju.setPoetName("佚名");
        String content=ju.getContent();
        content=content.replace("，","\n");
        content=content.replace("。","\n");
        content=content.replace("?","\n");
        content=content.replace("？","\n");
        content=content.replace("！","\n");
        content=content.replace("!","\n");
        content=content.replace(";","\n");
        content=content.replace("；","\n");
        content=content.replace("、","\n");

        ju.setContent(content);
        return JSON.toJSONString(ju);
    }
}
