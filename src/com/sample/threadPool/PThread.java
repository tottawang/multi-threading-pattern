package com.sample.threadPool;

public class PThread extends Thread {

  private ThreadPool threadPool;
  private boolean isIdle = false;
  private Runnable target;

  public PThread(ThreadPool threadPool) {
    this.threadPool = threadPool;
  }

  public synchronized void setTarget(Runnable task) {
    this.target = task;
  }

  @Override
  public void run() {
    while (true) {
      isIdle = false;
      if (target != null) {
        target.run();
        // task complete
        isIdle = true;
      }
      threadPool.repool(this);
    }
  }
}
