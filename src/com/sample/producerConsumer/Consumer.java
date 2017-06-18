package com.sample.producerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {

  private final BlockingQueue<String> queue;

  public Consumer(BlockingQueue<String> q) {
    this.queue = q;
  }

  @Override
  public void run() {
    String threadId = "Consumer-" + Thread.currentThread().getId();
    try {
      while (true) {
        String value = queue.poll(5, TimeUnit.SECONDS);
        if (value == null) {
          break;
        }
        System.out.println(threadId + "job: " + value);
      }
      System.out.println(threadId + " STOPPED.");
    } catch (InterruptedException ie) {
      ie.printStackTrace();
    }
  }
}
