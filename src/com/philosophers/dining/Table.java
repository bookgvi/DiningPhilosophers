package com.philosophers.dining;

import java.util.*;
import java.util.stream.IntStream;

public class Table {
  public static void main(String[] args) {
    final int PHILOSOPHERS_COUNT = 5;
    List<Thread> philosophers = new ArrayList<>();
    Object[] forks = new Object[PHILOSOPHERS_COUNT];

    Arrays.fill(forks, new Object());

    for(int i = 0; i < PHILOSOPHERS_COUNT; i++) {
      philosophers.add(new Thread(new Philosopher(
        forks[i],
        forks[(i + 1) % PHILOSOPHERS_COUNT]
      )));
    }

    for(Thread t: philosophers) {
      t.start();
    }
  }
}
