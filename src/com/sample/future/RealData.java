package com.sample.future;

public class RealData implements Data {

  private String data = null;

  public RealData(String data) {
    try {
      // very expensive to instantiate
      Thread.sleep(1000 * 10);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    this.data = data;
  }

  @Override
  public String getResult() {
    return data;
  }

}
