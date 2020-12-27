package com.sample.livelock;

public class Car2 {

  private boolean honking = true;

  public void passBridge(Car1 car1) {

    while (car1.hasPassedBridge()) {
      System.out.println("Car 2 is waiting to pass the bridge");
      try {
        Thread.sleep(5000);
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }

    System.out.println("Car 2 has passed the bridge!");
    this.honking = false;
  }

  public boolean hasPassedBridge() {
    return this.honking;
  }
}
