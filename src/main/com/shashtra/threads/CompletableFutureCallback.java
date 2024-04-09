package com.shashtra.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureCallback {

  public static CompletableFuture<Integer> getCompletableFuture() {
    CompletableFuture<Integer> futureCount = CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException ex) {
      }
      return 10;
    });
    return futureCount;
  }

  public static void main(String[] args) {
    long started = System.currentTimeMillis();
    CompletableFuture<String> count = getCompletableFuture().thenApply((data) -> {
      return data * 5;
    }).thenApply((item) -> "Return output as string " + item);
    System.out.println("Took: " + (System.currentTimeMillis() - started));

    try {
      System.out.println(count.get());
      System.out.println("Completable future took: " + (System.currentTimeMillis() - started));
    } catch (ExecutionException | InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

}
