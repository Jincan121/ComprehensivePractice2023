package com.example.demo.serve;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GameServeTest {
    public GameServe gameServe=new GameServe();
    @Test
    public void testPlayFeiHuaLing() {
        Assert.assertEquals(gameServe.playFeiHuaLing("日照香炉生紫烟"),"true");
    }

    @Test
    public void testPassFeihualing() {
        Assert.assertEquals(gameServe.playFeiHuaLing("日照香炉生紫烟"),"true");
    }

    @Test
    public void testFindFeihualing() {
        Assert.assertEquals(gameServe.playFeiHuaLing("日照香炉生紫烟"),"true");
    }

    @Test
    public void testPlayPoetLevel() {
        Assert.assertEquals(gameServe.playFeiHuaLing("日照香炉生紫烟"),"true");
    }

    @Test
    public void testPassPoetLevel() {
        Assert.assertEquals(gameServe.playFeiHuaLing("日照香炉生紫烟"),"true");
    }

    @Test
    public void testFindPoetLevel() {
        Assert.assertEquals(gameServe.playFeiHuaLing("日照香炉生紫烟"),"true");
    }
}