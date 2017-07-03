package com.sample.threadPool;

import java.util.List;
import java.util.Vector;

public class ThreadPool {

  private int size;
  private int created;
  private List<PThread> idleThreads;

  public ThreadPool(int size) {
    idleThreads = new Vector<PThread>(size);
    this.size = size;
  }

  public synchronized void start(Runnable task) throws InterruptedException {
    if (!idleThreads.isEmpty()) {
      PThread thread = idleThreads.get(0);
      thread.setTarget(task);
      idleThreads.remove(0);
    } else {
      if (created < size) {
        PThread newThread = new PThread(this);
        newThread.setTarget(task);
        newThread.start();
        created++;
      } else {
        wait();
      }
    }
  }

  public synchronized void repool(PThread thread) {
    idleThreads.add(thread);
    notifyAll();
  }
}
