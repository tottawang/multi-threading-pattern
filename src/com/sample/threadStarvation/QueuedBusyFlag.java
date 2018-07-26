package com.sample.threadStarvation;

import java.util.Vector;

public class QueuedBusyFlag {

  private Vector<Thread> waitors;
  private int busyCount = 0;
  private Thread bustThread;

  public QueuedBusyFlag() {
    waitors = new Vector<>();
  }

  public synchronized void getBusyFlag() {
    Thread me = Thread.currentThread();
    if (me == bustThread) {
      return;
    }

    waitors.add(me);
    while (waitors.get(0) != me) {
      try {
        wait();
      } catch (Exception ex) {
      }
    }
    bustThread = me;
    busyCount = 0;
  }

  public synchronized void freeBusyFlag() {
    if (Thread.currentThread() != bustThread) {
      throw new RuntimeException("fail to free busy flag");
    }

    if (busyCount == 0) {
      waitors.removeElementAt(0);
      notifyAll();
    } else {
      busyCount--;
    }
  }
}
