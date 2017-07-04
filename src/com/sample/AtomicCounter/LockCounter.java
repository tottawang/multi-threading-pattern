package com.sample.AtomicCounter;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class LockCounter implements Counter {

  private long counter = 0L;
  private WriteLock lock = new ReentrantReadWriteLock().writeLock();

  @Override
  public void increment() {
    lock.lock();
    counter++;
    lock.unlock();
  }

  @Override
  public long getCounter() {
    return this.counter;
  }

}
