package com.philosophers.dining;

import java.util.Random;

public class Philosopher implements Runnable {
  private final Object leftFork;
  private final Object rightFork;

  Philosopher(Object leftFork, Object rightFork) {
    this.leftFork = leftFork;
    this.rightFork = rightFork;
  }

  @Override
  public void run() {
    try {
      while (true) {
        doAction("- thinking...");
        synchronized (leftFork) {
          doAction("pick up left fork");
          synchronized (rightFork) {
            doAction("pick up right fork... dining");
            doAction("put down right fork");
          }
          doAction("put down left fork");
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void doAction(String action) throws InterruptedException {
    System.out.printf("%s %s%n", Thread.currentThread().getName(), action);
    Thread.sleep(new Random().nextInt(1500));
  }
}
