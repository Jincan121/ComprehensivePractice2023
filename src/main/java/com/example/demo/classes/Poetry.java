package com.example.demo.classes;

public class Poetry {
    private  String id;
    private  String star;
    private  String content;
    private  String name;
    private  String dynasty;
    private  String tag;
    private  String poet_name;
    private  String poet_id;

    public Poetry() {}

    public Poetry(String id, String star, String content, String name, String dynasty, String tag, String poet_name, String poet_id) {
        this.id = id;
        this.star = star;
        this.content = content;
        this.name = name;
        this.dynasty = dynasty;
        this.tag = tag;
        this.poet_name = poet_name;
        this.poet_id = poet_id;
    }


    @Override
    public String toString() {
        return "Poetry{" +
                "id='" + id + '\'' +
                ", star='" + star + '\'' +
                ", content='" + content + '\'' +
                ", name='" + name + '\'' +
                ", dynasty='" + dynasty + '\'' +
                ", tag='" + tag + '\'' +
                ", poet_name='" + poet_name + '\'' +
                ", poet_id='" + poet_id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPoet_name() {
        return poet_name;
    }

    public void setPoet_name(String poet_name) {
        this.poet_name = poet_name;
    }

    public String getPoet_id() {
        return poet_id;
    }

    public void setPoet_id(String poet_id) {
        this.poet_id = poet_id;
    }
}
