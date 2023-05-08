package com.example.demo.controller;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class PoetryControllerTest {

    @Test
    public void testRecommendByRand() throws FileNotFoundException {
        PoetryController poetryController=new PoetryController();
        String target=poetryController.recommendByRand();
        Assert.assertNotEquals(target,"123");
    }

}