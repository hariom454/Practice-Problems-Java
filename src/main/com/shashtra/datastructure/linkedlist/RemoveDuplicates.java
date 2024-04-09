package com.shashtra.datastructure.linkedlist;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Node2 {

  int val;
  Node2 next;

  Node2(int val) {
    this.val = val;
    this.next = null;
  }
}

class LinkedList2 {

  Node2 head;

  LinkedList2() {
    head = null;
  }

  LinkedList2(int val) {
    head = new Node2(val);
  }

  void append(int val) {
    Node2 temp = head;
    Node2 newNode = new Node2(val);
    if (head == null) {
      head = newNode;
      return;
    }
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = newNode;
  }

  void print() {
    Node2 temp = head;
    while (temp != null) {
      System.out.println(temp.val);
      temp = temp.next;
    }
  }

  void removeDuplicates() {
    head = removeDuplicates2();
  }

  Node2 removeDuplicates2() {
    Node2 temp = head;
    Node2 temp2 = head;
    Map<Integer, Boolean> mp = new HashMap<>();
    while (temp.next != null) {
      if (!mp.containsKey(temp.next.val)) {
        mp.put(temp.next.val, true);
        temp2.next = temp.next;
        temp2 = temp2.next;
      }
      temp = temp.next;
    }
    temp2.next = null;
    return temp2;
  }
}

public class RemoveDuplicates {

  public static void main(String[] args) {
    LinkedList2 list = new LinkedList2();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      int x = sc.nextInt();
      list.append(x);
    }
    list.print();
    list.removeDuplicates();
    list.print();
  }


}
