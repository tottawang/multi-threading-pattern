package com.sample.livelock;

/**
 * 
 * livelock Difference from deadlock: The threads are not blocked; they are simply busy responding
 * to each other and unable to progress any further.
 * 
 * https://javatutorial.net/livelock-and-deadlock-in-java
 *
 */
public class BridgeCheck {

  static final Car2 car2 = new Car2();
  static final Car1 car1 = new Car1();

  public static void main(String[] args) {
    Thread t1 = new Thread(new Runnable() {
      public void run() {
        car2.passBridge(car1);
      }
    });
    t1.start();

    Thread t2 = new Thread(new Runnable() {
      public void run() {
        car1.passBridge(car2);
      }
    });
    t2.start();
  }
}
