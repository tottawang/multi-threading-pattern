package com.sample.threadState;

/**
 * https://blog.csdn.net/yonghumingshishenme/article/details/6285259
 * 
 * @author wangto
 *
 */
public class InterruptThread {

  /**
   * interrupted vs isInterrupted
   * 
   * @param args
   */
  public static void main(String[] args) {
    Thread.currentThread().interrupt();
    if (Thread.interrupted())
      System.out.println("Interrupted:" + Thread.interrupted());
    else {
      System.out.println("Not Interrupted:" + Thread.interrupted());
    }
  }

}
