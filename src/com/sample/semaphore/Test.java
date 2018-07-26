package com.sample.semaphore;

public class Test {

  static Semaphore semaphore = new Semaphore(3);

  static class MyTestThread extends Thread {

    public void run() {

      try {
        semaphore.acquire();
      } catch (InterruptedException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }

      try {
        for (int i = 1; i <= 5; i++) {
          System.out.println(Thread.currentThread().getName() + " : is performing operation " + i
              + ", available Semaphore permits : " + semaphore.availablePermits());
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
      } finally {
        semaphore.release();
      }
    }
  }


  public static void main(String[] args) {

    MyTestThread thread1 = new MyTestThread();
    thread1.start();

    MyTestThread thread2 = new MyTestThread();
    thread2.start();

    MyTestThread thread3 = new MyTestThread();
    thread3.start();

    MyTestThread thread4 = new MyTestThread();
    thread4.start();

    MyTestThread thread5 = new MyTestThread();
    thread5.start();

  }

}
