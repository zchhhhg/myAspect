package com.example.spring.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Cheng
 * @date 2021-10-14-15:46
 */
public class JunitTest {

    @Before
    public void testBefore(){
        System.out.println("我是before");
    }
    @After
    public void testAfter(){
        System.out.println("我是after");
    }
    @Test
    public void testAdd(){
        System.out.println("123");
        Assert.assertEquals("123", "124");
    }
}
