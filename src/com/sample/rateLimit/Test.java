package com.sample.rateLimit;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Test {

  Semaphore semaphore;

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
    ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(new Callable() {
      public Object call() throws Exception {
        System.out.println("Executed!");
        return "Called!";
      }
    }, 5, TimeUnit.SECONDS);

    System.out.println("result = " + scheduledFuture.get());
    scheduledExecutorService.shutdown();
  }

}
