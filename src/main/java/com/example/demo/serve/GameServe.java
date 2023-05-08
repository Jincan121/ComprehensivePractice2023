package com.example.demo.serve;

import com.example.demo.classes.MyJason;
import com.example.demo.classes.Poetry;
import com.example.demo.dao.DaoGame;

import java.util.List;

/**
 * @author jincan
 */
public class GameServe {
    DaoGame daoGame;
    Integer acLength=7;

    String[] type=new String[]{"feng","hua","xue","yue"};
    String[] poetType=new String[]{"李白","杜甫","苏轼","李清照"};

    public GameServe() {
        daoGame=new DaoGame();
    }

    public String playFeiHuaLing(String content){
        if(content.length()!=acLength){
            return "false";
        }

        List<Poetry> list=daoGame.searchContentExist(content);
        //查询限制一条数据，list为空 或 有一条数据
        if(list.isEmpty()){
            return "false";
        }
        return "true";
    }

    public String passFeihualing(String uid,String content){
        Integer user=daoGame.getContent(uid);
        //二进制取第四位
        if(type[0].equals(content)){
            if(user/8!=1){
                user+=8;
                daoGame.setContent(uid,user);
                return "success";
            }
            return "exist";
        }
        //第三位
        else if(type[1].equals(content)){
            if(user%8/4!=1){
                user+=4;
                daoGame.setContent(uid,user);
                return "success";
            }
            return "exist";
        }
        else if(type[2].equals(content)){
            if(user%4/2!=1){
                user+=2;
                daoGame.setContent(uid,user);
                return "success";
            }
            return "exist";
        }
        else if(type[3].equals(content)){
            if(user%2!=1){
                user+=1;
                daoGame.setContent(uid,user);
                return "success";
            }
            return "exist";
        }
        else {
            return "error";
        }
    }

    public String findFeihualing(String uid){
        Integer content=daoGame.getContent(uid);
        String[] target={"false","false","false","false"};
        if(content/8==1){
            target[0]="success";
        }
        if(content%8/4==1){
            target[1]="success";
        }
        if(content%4/2==1){
            target[2]="success";
        }
        if(content%2==1){
            target[3]="success";
        }
        return MyJason.toJasonList(type,target);
    }

    public String playPoetLevel(List<String> content,String poet){
        String[] target=new String[]{"empty","empty","empty","empty","empty","empty","empty","empty","empty","empty"};

        for(int i=0;i<content.size();i++){
            if("".equals(content.get(i))){
                continue;
            }
            else {
                String[]sp=content.get(i).split(",|，|！|!|？");
                boolean bol=true;
                for(String iter:sp){
                    List<Poetry> list=daoGame.searchPoetContentExist(iter,poet);
                    if(list.isEmpty()){
                        target[i]="false";
                        bol=false;
                        break;
                    }
                }
                if(bol){
                    target[i]="true";
                }
            }
        }
        return MyJason.toJasonList(new String[]{"1","2","3","4","5","6","7","8","9","10"},target);
    }

    public String passPoetLevel(String uid,String poet){
        Integer user=daoGame.getPoet(uid);
        //二进制取第四位
        if(poetType[0].equals(poet)){
            if(user/8!=1){
                user+=8;
                daoGame.setPoet(uid,user);
                return "success";
            }
            return "exist";
        }
        //第三位
        else if(poetType[1].equals(poet)){
            if(user%8/4!=1){
                user+=4;
                daoGame.setPoet(uid,user);
                return "success";
            }
            return "exist";
        }
        else if(poetType[2].equals(poet)){
            if(user%4/2!=1){
                user+=2;
                daoGame.setPoet(uid,user);
                return "success";
            }
            return "exist";
        }
        else if(poetType[3].equals(poet)){
            if(user%2!=1){
                user+=1;
                daoGame.setPoet(uid,user);
                return "success";
            }
            return "exist";
        }
        else {
            return "error";
        }
    }

    public String findPoetLevel(String uid){
        Integer content=daoGame.getPoet(uid);
        String[] target={"false","false","false","false"};
        if(content/8==1){
            target[0]="success";
        }
        if(content%8/4==1){
            target[1]="success";
        }
        if(content%4/2==1){
            target[2]="success";
        }
        if(content%2==1){
            target[3]="success";
        }
        return MyJason.toJasonList(poetType,target);
    }
}
