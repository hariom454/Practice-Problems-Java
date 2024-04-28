package com.shashtra.concurrency.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class Test {

  public static void main(String[] args) {
    Problem test = new Problem();
    int nThreads = Runtime.getRuntime().availableProcessors();
    System.out.println(nThreads);
    Solver solver = new Solver(test.getList());
    ForkJoinPool pool = new ForkJoinPool(nThreads);
    pool.execute(solver);
    long result = solver.result;
    System.out.println(result);
    long sum = 0;
    for (int i = 0; i < test.getList().length; i++) {
      sum += test.getList()[i];
    }
    System.out.println(sum);
  }

}
