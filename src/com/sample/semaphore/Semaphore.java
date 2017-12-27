package com.sample.semaphore;


/**
 * http://tutorials.jenkov.com/java-concurrency/semaphores.html
 * 
 * Implement a simple semaphore.
 * 
 * @author wangto
 *
 */
public class Semaphore {

  private int permits = 0;

  public Semaphore(int permits) {
    this.permits = permits;
  }

  /**
   * Blocking call to get available permit.
   * 
   * @throws InterruptedException
   */
  public synchronized void acquire() throws InterruptedException {
    if (permits == 0) {
      wait();
    }
    permits--;
    System.out.println("acquired");
  }

  public synchronized void release() {
    permits++;
    notify();
    System.out.println("released");
  }

  public int availablePermits() {
    return permits;
  }

}
