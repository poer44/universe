package com.poer.universe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.*;

@SpringBootApplication
public class UniverseApplication {

    public static void main(String[] args) {
        Callable en = () -> {
            System.out.println(Thread.currentThread().getName());
            int s=9/0;
            Thread.sleep(1000);
            return s;
        };
        FutureTask task = new FutureTask(en);

        ExecutorService cachedThreadPool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Future fu=cachedThreadPool.submit(task);
                System.out.println(fu.get());
            }catch (Exception e){
                e.printStackTrace();
            }
            try {
                cachedThreadPool.execute(task);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        final String[] result = new String[1];
        final int[] result2=new int[1];
        Runnable r = () -> {
            result[0] = "hello world";
            result2[0]=88;
        };
        Future<String[]> future = Executors.newSingleThreadExecutor().submit(r, result);
        try {
            System.out.println( future.get().length);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        SpringApplication.run(UniverseApplication.class, args);
        System.out.println("Hello");
    }

}
