package com.sample.future;

public class FutureData implements Data {

  private Data data;

  public synchronized void setResult(Data data) {
    this.data = data;
    this.notifyAll();
  }

  /*
   * Blocking call to get result.
   */
  @Override
  public synchronized String getResult() {
    try {
      this.wait();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    return data.getResult();
  }

}
