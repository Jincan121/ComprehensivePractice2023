package com.example.demo.serve;

import com.alibaba.fastjson.JSON;
import com.example.demo.classes.MyJason;
import com.example.demo.classes.Poetry;
import com.example.demo.classes.Recommend;
import com.example.demo.classes.Support;
import com.example.demo.dao.DaoPoetry;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

public class PoetryServe {
    DaoPoetry daoPoetry;
    public PoetryServe() throws FileNotFoundException {
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
            content=content.replace("</span>","");
            content=content.replace("<span>","");
            content=content.replace("<p>","");
            content=content.replace("</p>","\n");
            content=content.replace("<br>","\n");
            poetry.setContent(content);
        }
        return JSON.toJSONString(list);
    }

    public String recommendByUser(String UID){
        //查询supertag
        List<Recommend>listTag=daoPoetry.selectRecommendByUID(UID);
        if(listTag.isEmpty()){
            System.out.println("recommend中没有用户数据");
            return this.recommendByRand();
        }
        Iterator<Recommend> tagIter=listTag.iterator();

        Recommend recommend=tagIter.next();
        int superTagNum=recommend.getHuaNiao();
        String superTag="HuaNiao";
        if(recommend.getDiDian()>superTagNum){
            superTag="DiDian";superTagNum=recommend.getDiDian();
        }
        if(recommend.getJieRi()>superTagNum){
            superTag="JieRi";superTagNum=recommend.getJieRi();
        }
        if(recommend.getRenWu()>superTagNum){
            superTag="RenWu";superTagNum=recommend.getRenWu();
        }
        if(recommend.getShiLing()>superTagNum){
            superTag="ShiLing";superTagNum=recommend.getShiLing();
        }
        if(recommend.getShuQing()>superTagNum){
            superTag="ShuQing";superTagNum=recommend.getShuQing();
        }
        if(recommend.getTiCai()>superTagNum){
            superTag="TiCai";superTagNum=recommend.getTiCai();
        }
        if(recommend.getXieJing()>superTagNum){
            superTag="XieJing";superTagNum=recommend.getXieJing();
        }
        if(recommend.getXvanJi()>superTagNum){
            superTag="XvanJi";superTagNum=recommend.getXvanJi();
        }
        if(recommend.getZhuTi()>superTagNum){
            superTag="ZhuTi";superTagNum=recommend.getZhuTi();
        }

        //获得supertag下的随机tag
        String tag=daoPoetry.selectRecommendByUser(superTag);
        List<Poetry>list=daoPoetry.searchContent(tag);
        if(list.isEmpty()){
            return "error";
        }
        Iterator<Poetry> iter=list.iterator();
        while(iter.hasNext()){
            Poetry poetry=iter.next();
            poetry.setContent(MyJason.standard(poetry.getContent()));
        }
        return JSON.toJSONString(list);
    }

    public String searchByContent(String content){
        List<Poetry> list=daoPoetry.searchContent(content);
        if(list.isEmpty()){
            return "error";
        }
        Iterator<Poetry> iter=list.iterator();
        while(iter.hasNext()){
            Poetry poetry=iter.next();
            poetry.setContent(MyJason.standard(poetry.getContent()));
        }
        return JSON.toJSONString(list);
    }

    public String searchByTag(String tag){
        List<Poetry> list=daoPoetry.searchByTag(tag);
        if(list.isEmpty()){
            return "error";
        }
        Iterator<Poetry> iter=list.iterator();
        while(iter.hasNext()){
            Poetry poetry=iter.next();

            poetry.setContent(MyJason.standard(poetry.getContent()));
        }
        return JSON.toJSONString(list);
    }

    public String searchByID(String id){
        List<Poetry> list=daoPoetry.searchID(id);
        if(list.isEmpty()){
            return "error";
        }
        Iterator<Poetry> iter=list.iterator();
        Poetry poetry=iter.next();

        poetry.setContent(MyJason.standard(poetry.getContent()));

        return JSON.toJSONString(poetry);
    }

    public String findSupportExsit(String UID,String id){
        List<Support>list=daoPoetry.selectSupportByUID(UID);
        Iterator<Support>iter=list.listIterator();
        while(iter.hasNext()){
            if(iter.next().getId().equals(id))return "true";
        }
        return "false";
    }

    public String support(String UID,String id){
        if(findSupportExsit(UID,id).equals("true")){
            return "existing";
        }
        else {
            if(daoPoetry.insertSupport(UID,id)==0)return "error";
            else {
                String tags=daoPoetry.searchTagByID(id);

                String []tag=tags.split(",");
                for(int i=0;i<tag.length;i++){
                    daoPoetry.recommend(UID,tag[i]);
                }
                return "success";
            }
        }
    }

    public String cancelSupport(String UID,String id){
        if(findSupportExsit(UID,id).equals("false")){
            return "not existing";
        }
        else {
            if(daoPoetry.cancelSupport(UID,id)==0)return "error";
            else {
                String tags=daoPoetry.searchTagByID(id);

                String []tag=tags.split(",");
                for(int i=0;i<tag.length;i++){
                    daoPoetry.cancelRecommend(UID,tag[i]);
                }
                return "success";
            }
        }
    }

}
