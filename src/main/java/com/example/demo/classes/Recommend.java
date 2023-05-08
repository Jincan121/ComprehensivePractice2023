package com.example.demo.classes;

public class Recommend {
    private int UID;
    private int ZhuTi;
    private int RenWu;
    private int TiCai;
    private int XieJing;
    private int DiDian;
    private int ShuQing;
    private int ShiLing;
    private int JieRi;
    private int HuaNiao;
    private int XvanJi;

    public Recommend() {
    }

    @Override
    public String toString() {
        return "{" +
                "UID=" + UID +
                ", ZhuTi=" + ZhuTi +
                ", RenWu=" + RenWu +
                ", TiCai=" + TiCai +
                ", XieJing=" + XieJing +
                ", DiDian=" + DiDian +
                ", ShuQing=" + ShuQing +
                ", ShiLing=" + ShiLing +
                ", JieRi=" + JieRi +
                ", HuaNiao=" + HuaNiao +
                ", XvanJi=" + XvanJi +
                '}';
    }

    public Recommend(int UID, int zhuTi, int renWu, int tiCai, int xieJing, int diDian, int shuQing, int shiLing, int jieRi, int huaNiao, int xvanJi) {
        this.UID = UID;
        ZhuTi = zhuTi;
        RenWu = renWu;
        TiCai = tiCai;
        XieJing = xieJing;
        DiDian = diDian;
        ShuQing = shuQing;
        ShiLing = shiLing;
        JieRi = jieRi;
        HuaNiao = huaNiao;
        XvanJi = xvanJi;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public int getZhuTi() {
        return ZhuTi;
    }

    public void setZhuTi(int zhuTi) {
        ZhuTi = zhuTi;
    }

    public int getRenWu() {
        return RenWu;
    }

    public void setRenWu(int renWu) {
        RenWu = renWu;
    }

    public int getTiCai() {
        return TiCai;
    }

    public void setTiCai(int tiCai) {
        TiCai = tiCai;
    }

    public int getXieJing() {
        return XieJing;
    }

    public void setXieJing(int xieJing) {
        XieJing = xieJing;
    }

    public int getDiDian() {
        return DiDian;
    }

    public void setDiDian(int diDian) {
        DiDian = diDian;
    }

    public int getShuQing() {
        return ShuQing;
    }

    public void setShuQing(int shuQing) {
        ShuQing = shuQing;
    }

    public int getShiLing() {
        return ShiLing;
    }

    public void setShiLing(int shiLing) {
        ShiLing = shiLing;
    }

    public int getJieRi() {
        return JieRi;
    }

    public void setJieRi(int jieRi) {
        JieRi = jieRi;
    }

    public int getHuaNiao() {
        return HuaNiao;
    }

    public void setHuaNiao(int huaNiao) {
        HuaNiao = huaNiao;
    }

    public int getXvanJi() {
        return XvanJi;
    }

    public void setXvanJi(int xvanJi) {
        XvanJi = xvanJi;
    }
}
