package com.shashtra.concurrency;

public class Deadlock {

  static class Friend {

    private String name;

    public Friend(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public synchronized void bow(Friend friend) {

      System.out.format("%s: %s has bowed to me!%n", this.name, friend.getName());
      friend.bowBack(this);

    }

    private synchronized void bowBack(Friend friend) {
      System.out.format("%s: %s has bowed back to me!%n", this.name, friend.getName());
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Friend prince = new Friend("Prince");
    Friend hariom = new Friend("Hariom");
    Runnable r1 = () -> prince.bow(hariom);
    Runnable r2 = () -> hariom.bow(prince);
    Thread t1 = new Thread(r1);
    t1.start();
    Thread t2 = new Thread(r2);
    t2.start();
    while (t1.isAlive() || t2.isAlive()) {
      System.out.println(
          "threads are waiting for resources! sleeping" + Thread.currentThread().getName());
      Thread.sleep(100);
    }

  }

}
