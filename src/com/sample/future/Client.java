package com.sample.future;

public class Client {

  public FutureData requestData(String value) {

    FutureData future = new FutureData();

    new Thread() {
      public void run() {
        RealData realData = new RealData(value);
        future.setResult(realData);
      }
    }.start();;

    return future;
  }

}
