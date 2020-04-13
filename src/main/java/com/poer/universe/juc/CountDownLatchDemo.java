package com.poer.universe.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 一等多
 * 5个工人都好才ok
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            final int p = i + 1;
            service.submit(() -> {
                try {
                    Thread.sleep((long) (Math.random() * 10000));
                    System.out.println(p + "号工人检查完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }
        System.out.println("5个工人检查完成才可冲");
        latch.await();
        System.out.println("ok!");
    }
}
