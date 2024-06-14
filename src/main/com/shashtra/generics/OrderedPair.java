package com.shashtra.generics;

public class OrderedPair<K, V> implements Pair<K, V> {

  private K key;
  private V value;

  public OrderedPair(K key, V value) {
    this.key = key;
    this.value = value;
  }

  @Override
  public K getKey() {
    return this.key;
  }

  @Override
  public V getValue() {
    return this.value;
  }

  public static void main(String[] args) {
    OrderedPair<String, Integer> p1 = new OrderedPair<>("myRollNo", 8);
    OrderedPair<String, String> p2 = new OrderedPair<>("myName", "Hariom Singh");
    System.out.println("content of first pair: " + p1.getKey() + " " + p1.getValue());
    System.out.println("Content of second pair: " + p2.getKey() + " " + p2.getValue());

    OrderedPair<String, Integer> p3 = new OrderedPair<>("myRollNo", 1);
    boolean isSame = Util.compare(p1, p3);
    System.out.println("P1 and P3 are: " + (isSame ? "same" : "different"));

  }
}

class Util {

  public static <K, V> boolean compare(OrderedPair<K, V> p1, OrderedPair<K, V> p2) {
    return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
  }
}
