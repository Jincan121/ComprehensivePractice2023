package com.example.demo.classes;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MyJasonTest {

    @Test
    public void testToJason() {

    }

    @Test
    public void testToJasonList() {
        String []type={"content","name","1","2"};
        String []content={"123","xiaoming","1551","1557"};
        Assert.assertEquals("{\"content\":\"123\",\"name\":\"xiaoming\",\"1\":\"1551\",\"2\":\"1557\"}",MyJason.toJasonList(type,content));
    }

    @Test
    public void testStandard() {
    }
}