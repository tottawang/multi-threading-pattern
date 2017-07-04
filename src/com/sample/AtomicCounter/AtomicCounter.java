package com.sample.AtomicCounter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Good reference http://mishadoff.com/blog/java-magic-part-4-sun-dot-misc-dot-unsafe/
 * 
 * @author wangto
 *
 */
public class AtomicCounter implements Counter {

  private AtomicLong counter = new AtomicLong(0);

  @Override
  public void increment() {
    counter.incrementAndGet();
  }

  @Override
  public long getCounter() {
    return counter.get();
  }

}
