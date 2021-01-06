package com.philosophers.dining;

import java.util.*;
import java.util.stream.IntStream;

public class Table {
  public static void main(String[] args) {
    final int PHILOSOPHERS_COUNT = 5;
    Philosopher[] philosophers = new Philosopher[PHILOSOPHERS_COUNT];
    Object[] forks = new Object[PHILOSOPHERS_COUNT];

    for (int i = 0; i < forks.length; i++) {
      forks[i] = new Object();
    }

    for(int i = 0; i < philosophers.length; i++) {
      Object rightFork = forks[(i + 1) % forks.length];
      Object leftFork = forks[i];
      if (i == philosophers.length - 1) {
        philosophers[i] = new Philosopher(rightFork, leftFork);
      } else {
        philosophers[i] = new Philosopher(leftFork, rightFork);
      }
    }

    IntStream.range(0, philosophers.length).forEach(i -> {
      new Thread(philosophers[i], "Philosopher " + (i + 1)).start();
    });
  }
}
