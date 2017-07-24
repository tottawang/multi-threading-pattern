package com.sample.future;

public class Test {

  public static void main(String[] args) {
    Client client = new Client();
    FutureData future = client.requestData("test");
    System.out.println("Returned future object");

    long start = System.currentTimeMillis();
    future.getResult();
    long end = System.currentTimeMillis();
    System.out.println("Time taken to get future data " + (end - start) + " milliseconds");
  }
}
