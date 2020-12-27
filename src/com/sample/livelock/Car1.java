package com.sample.livelock;

public class Car1 {

  private boolean honking = true;

  public void passBridge(Car2 car2) {

    while (car2.hasPassedBridge()) {
      System.out.println("Car1 waiting to pass the bridge");
      try {
        Thread.sleep(5000);
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }

    System.out.println("Passed bridge");
    this.honking = false;
  }

  public boolean hasPassedBridge() {
    return this.honking;
  }
}
