package com.example.demo.classes;

public class MyJason {
    public MyJason() {
    }
    public static String toJason(String type,String content){
        return "{\""+type+"\":\""+content+"\"}";
    }

    public static String toJasonList(String[] type, String[]content){
        int length=type.length;
        if(length!=content.length||length==0){
            return "length error";
        }
        StringBuilder builder = new StringBuilder("{");
        for(int i=0;i<length;i++){
            builder.append("\"");
            builder.append(type[i]);
            builder.append("\":\"");
            builder.append(content[i]);
            builder.append("\"");
            if(i!=length-1){builder.append(",");}
        }
        builder.append("}");
        return builder.toString();
    }

    public static String standard(String content){
        content=content.replace(" ","");
        content=content.replace("</span>","");
        content=content.replace("<span>","");
        content=content.replace("<p>","");
        content=content.replace("</p>","\n");
        content=content.replace("<br>","\n");
        return content;
    }

}
