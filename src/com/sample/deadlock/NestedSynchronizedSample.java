package com.sample.deadlock;

/**
 * What we can do to avoid deadlock
 * 
 * <ul>
 * <li>Nested synchronized (current class)
 * <li>Lock only what is required
 * <li>Avoid waiting indefinitely
 * </ul>
 * 
 * @author wangtoumac
 *
 */
public class NestedSynchronizedSample {

  public static void main(String[] args) {
    Object firstLevelLock = new Object();
    Object secondLevelLock = new Object();

    Thread thread1 = new Thread(new DeakLockThread(firstLevelLock, secondLevelLock));
    thread1.start();

    Thread thread2 = new Thread(new DeakLockThread(secondLevelLock, firstLevelLock));
    thread2.start();
  }

  public static class DeakLockThread implements Runnable {

    private Object firstLevelLock;
    private Object secondLevelLock;

    public DeakLockThread(Object first, Object second) {
      firstLevelLock = first;
      secondLevelLock = second;
    }

    @Override
    public void run() {
      synchronized (firstLevelLock) {
        doSomeWork();
        synchronized (secondLevelLock) {
          doSomeWork();
        }
      }
    }

    private void doSomeWork() {
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
