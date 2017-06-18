package com.sample.producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author One producer with multiple consumers.
 *
 */
public class Test {

  public static void main(String[] args) {
    BlockingQueue<String> queue = new ArrayBlockingQueue<>(20);

    Thread producer = new Thread(new Producer(queue));
    Thread consumer1 = new Thread(new Consumer(queue));
    Thread consumer2 = new Thread(new Consumer(queue));
    Thread consumer3 = new Thread(new Consumer(queue));

    producer.start();
    consumer1.start();
    consumer2.start();
    consumer3.start();
  }
}
