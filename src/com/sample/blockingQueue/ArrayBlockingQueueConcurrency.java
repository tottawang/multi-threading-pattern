package com.sample.blockingQueue;

import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueConcurrency {

  /**
   * Verify the 'blocking time' when queue is full and call drainTo at the same time
   * 
   */
  public static void main(String[] args) throws InterruptedException {

    BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(3);
    blockingQueue.offer(0);
    blockingQueue.offer(1);
    blockingQueue.offer(2);

    log(String.format("test1 started"));
    ExecutorService worker1 = Executors.newFixedThreadPool(5000);
    for (int k = 0; k < 500000; k++) {
      worker1.submit(() -> offer(blockingQueue));
    }
    log(String.format("worker1 started"));

    // int count = 0;
    while (true) {

      Thread.sleep(5000);
      // count++;

      // drainTo will make notFull.signal call so that offer will be notified after 3s
      // log(String.format("test2 started"));
      ExecutorService worker2 = Executors.newFixedThreadPool(1);
      worker2.submit(() -> drainTo(blockingQueue));
      log(String.format("worker2 started"));
    }
  }

  private static Object offer(BlockingQueue<Integer> blockingQueue) throws InterruptedException {
    // log(String.format("offer call started"));
    // queue is full, offer call with timeout would take 30s to return
    long start = System.currentTimeMillis();

    if (!blockingQueue.offer(3, 10, TimeUnit.SECONDS)) {
      log("Offer: timed out waiting");
      throw new IllegalStateException("Offer: timed out waiting");
    }

    long end = System.currentTimeMillis();
    log(String.format("offer duration done: %d ms", end - start));
    return null;
  }

  private static Object drainTo(BlockingQueue<Integer> blockingQueue) {
    log(String.format("drainTo call started"));
    long start = System.currentTimeMillis();
    BlockingQueue<Integer> drainToBlockingQueue = new ArrayBlockingQueue<Integer>(3);
    blockingQueue.drainTo(drainToBlockingQueue);
    log("drainTo size: " + drainToBlockingQueue.size());
    long end = System.currentTimeMillis();
    log(String.format("drainTo duration done: %d ms", end - start));
    return null;
  }

  public static void log(String message) {
    System.out.println("[" + Thread.currentThread().getName() + "]" + "["
        + new Timestamp(new Date().getTime()).toString() + "] " + message);
  }
}
