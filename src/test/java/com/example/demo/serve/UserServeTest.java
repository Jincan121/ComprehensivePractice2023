package com.example.demo.serve;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserServeTest {
    public UserServe userServe=new UserServe();
    @Test
    public void testLogin() {
        Assert.assertEquals(userServe.login("1","123456"),"success");
        Assert.assertEquals(userServe.login("1","12345"),"error");
        Assert.assertEquals(userServe.login("1435","123456"),"not found");
    }

    @Test
    public void testRegister() {
        Assert.assertEquals(userServe.login("1","123456"),"success");
    }

    @Test
    public void testModify() {
        Assert.assertEquals(userServe.login("1","123456"),"success");
    }

    @Test
    public void testModifyImage() {
        Assert.assertEquals(userServe.login("1","123456"),"success");
    }

    @Test
    public void testFindUsernameById() {
        Assert.assertEquals(userServe.login("1","123456"),"success");
    }

    @Test
    public void testFindImageByUID() {
        Assert.assertEquals(userServe.login("1","123456"),"success");
    }

    @Test
    public void testFollow() {
        Assert.assertEquals(userServe.login("1","123456"),"success");
    }

    @Test
    public void testCancelFollow() {
        Assert.assertEquals(userServe.login("1","123456"),"success");
    }

    @Test
    public void testSearchFollowByUid() {
        Assert.assertEquals(userServe.login("1","123456"),"success");
    }

    @Test
    public void testCollect() {
        Assert.assertEquals(userServe.login("1","123456"),"success");
    }

    @Test
    public void testCancelCollect() {
        Assert.assertEquals(userServe.login("1","123456"),"success");
    }

    @Test
    public void testSearchCollectByUid() {
        Assert.assertEquals(userServe.login("1","123456"),"success");
    }
}