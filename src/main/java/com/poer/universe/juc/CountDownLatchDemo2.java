package com.poer.universe.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多等一
 * 模拟跑步，一声令下冲
 * 伞兵一号卢本伟准备就绪
 */
public class CountDownLatchDemo2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(5);
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            final int p = i + 1;
            service.submit(() -> {
                System.out.println(p + "号伞兵准备就绪");
                try {
                    latch.await();
                    System.out.println(p + "号伞兵冲");
                    Thread.sleep((long) (Math.random() * 10000));
                    System.out.println(p + "号伞兵落地成盒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    end.countDown();
                }
            });
        }
        Thread.sleep(5000);
        System.out.println("一声枪响gogo");
        latch.countDown();
        end.await();
        System.out.println("死光了");
    }
}
