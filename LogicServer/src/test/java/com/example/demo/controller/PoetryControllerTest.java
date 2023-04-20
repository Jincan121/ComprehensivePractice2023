package com.example.demo.controller;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PoetryControllerTest {


    @Test
    public void testRecommendByRand() {
        PoetryController poetryController=new PoetryController();
        String target=poetryController.recommendByRand();
        Assert.assertNotEquals(target,"123");
    }

}