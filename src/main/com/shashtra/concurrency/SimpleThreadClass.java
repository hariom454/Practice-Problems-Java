package com.shashtra.concurrency;

public class SimpleThreadClass {

  static void threadMessage(String msg) {
    String threadName = Thread.currentThread().getName();
    System.out.format("%s: %s\n", threadName, msg);
  }

  private static class MessageLoop implements Runnable {

    @Override
    public void run() {
      String[] messages = {
          "I am not a fan",
          "I am not a fan of ipl",
          "I am a fan of Sehwag",
          "and So is everyone"
      };
      try {
        for (String message : messages) {
          Thread.sleep(4000);
          threadMessage(message);
        }
      } catch (InterruptedException e) {
        threadMessage("Sorry Shaktiman! I am not finished");
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    long waitTime = 1000 * 60; //1min
    if (args.length > 0) {
      waitTime = Long.parseLong(args[0]) * 1000;
    }
    threadMessage("starting message loop thread from main!");
    long startTime = System.currentTimeMillis();
    Thread t = new Thread(new MessageLoop());
    t.start();
    threadMessage("Waiting for message loop thread to finish");

    while (t.isAlive()) {
      threadMessage("still waiting....");
      t.join(1000);
      if (System.currentTimeMillis() - startTime > waitTime && t.isAlive()) {
        threadMessage("sorry Shaktiman!, tired of waiting");
        t.interrupt();
        t.join();
      }
    }
    threadMessage("finally! we are done");
  }

}
