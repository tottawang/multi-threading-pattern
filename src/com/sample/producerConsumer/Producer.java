package com.sample.producerConsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

  private final BlockingQueue<String> queue;

  public Producer(BlockingQueue<String> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      String value = "job: " + i;
      try {
        queue.put(value);
        Thread.sleep(50);
        System.out.println("Add job: " + i);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
