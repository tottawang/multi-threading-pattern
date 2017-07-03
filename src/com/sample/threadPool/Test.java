package com.sample.threadPool;

public class Test {

  public static void main(String[] args) throws InterruptedException {
    ThreadPool threadPool = new ThreadPool(5);
    for (int index = 0; index < 10000; index++) {
      SampleTask task = new SampleTask(index);
      threadPool.start(task);
    }
  }
}
