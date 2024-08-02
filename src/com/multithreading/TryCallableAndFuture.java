package com.multithreading;

import java.util.Random;
import java.util.concurrent.*;

public class TryCallableAndFuture {
    public static void main(String[] args) {
        ExecutorService executorService  = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                int duration = random.nextInt(4000);
                System.out.println("Starting to run...");
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished!");
                return duration;
            }
        });
        executorService.shutdown();
//        executorService.awaitTermination(1, TimeUnit.DAYS);
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
