package com.sample.threadPool;

import java.util.List;
import java.util.Vector;

public class ThreadPool {

  private int size;
  private List<PThread> idleThreads;

  public ThreadPool(int size) {
    idleThreads = new Vector<PThread>(size);
    this.size = size;
  }

  public void start(Runnable task) throws InterruptedException {
    if (idleThreads.isEmpty()) {
      wait();
    }

    // TODO is that okay to pick up first one
    PThread thread = idleThreads.get(0);
    thread.setTarget(task);
    idleThreads.remove(0);
  }

  public void repool(PThread thread) {
    idleThreads.add(thread);
  }
}
