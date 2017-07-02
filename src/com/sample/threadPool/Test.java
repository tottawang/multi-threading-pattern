package com.sample.threadPool;

public class Test {

  public static void main(String[] args) {
    ThreadPool threadPool = new ThreadPool(5);
    SampleTask task = new SampleTask(1);
    threadPool.run(task);
  }

}
