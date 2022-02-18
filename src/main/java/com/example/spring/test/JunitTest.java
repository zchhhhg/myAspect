package com.example.spring.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Cheng
 * @date 2021-10-14-15:46
 */
public class JunitTest {

    @Test
    public void testAdd(){
        ExecutorService threadPool =  Executors.newSingleThreadExecutor();
        Future<String> future =
                threadPool.submit(
                        new Callable<String>() {
                            public String call() throws Exception {
                                return "hello";
                            };
                        }
                );
        System.out.println("等待线程执行");
        try {
            System.out.println("拿到结果：" + future.get());
            System.out.println("over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
