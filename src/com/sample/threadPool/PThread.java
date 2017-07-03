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
      runTarget();
    }
  }

  private void runTarget() {
    if (target != null) {
      isIdle = false;
      try {
        target.run();
      } catch (Throwable e) {
        e.printStackTrace();
      } finally {
        repool();
      }
    }
  }

  private void repool() {
    this.target = null;
    this.isIdle = true;
    this.threadPool.repool(this);
  }
}
