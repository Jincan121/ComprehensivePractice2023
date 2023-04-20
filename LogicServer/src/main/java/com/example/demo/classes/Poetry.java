package com.example.demo.classes;

public class Poetry {
    public String id;
    public String star;
    public String content;
    public String name;
    public String dynasty;
    public String tag;
    public String poet_name;

    public Poetry() {}
    public Poetry(String id, String star, String content, String name, String dynasty, String tag, String poet_name) {
        this.id = id;
        this.star = star;
        this.content = content;
        this.name = name;
        this.dynasty = dynasty;
        this.tag = tag;
        this.poet_name = poet_name;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", star='" + star + '\'' +
                ", content='" + content + '\'' +
                ", name='" + name + '\'' +
                ", dynasty='" + dynasty + '\'' +
                ", tag='" + tag + '\'' +
                ", poet_name='" + poet_name + '\'' +
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
}
