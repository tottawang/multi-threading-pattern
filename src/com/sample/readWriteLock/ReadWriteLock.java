package com.sample.readWriteLock;

/**
 * http://tutorials.jenkov.com/java-concurrency/read-write-locks.html
 * 
 * @author wangtoumac
 *
 */
public class ReadWriteLock {

  private int writeCount;
  private int readCount;

  public synchronized void lockWrite() throws InterruptedException {
    if (writeCount == 0 || readCount == 0) {
      wait();
    }
    writeCount++;
  }

  public synchronized void unlockWrite() {
    if (writeCount == 0) {
      throw new RuntimeException("invalid write lock counter");
    }
    writeCount--;
    if (writeCount == 0) {
      notifyAll();
    }
  }

  public synchronized void lockRead() throws InterruptedException {
    if (writeCount != 0) {
      wait();
    }
    readCount++;
  }

  public synchronized void unlockRead() {
    readCount--;
  }

}
