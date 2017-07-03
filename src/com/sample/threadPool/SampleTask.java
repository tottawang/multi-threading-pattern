package com.sample.threadPool;

public class SampleTask implements Runnable {

  private int taskId = -1;

  public SampleTask(int taskId) {
    this.taskId = taskId;
  }

  @Override
  public void run() {
    System.out.println("[" + Thread.currentThread().getName() + "] " + "Execute task: " + taskId);
  }

}
