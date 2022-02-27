package com.shashtra.datastructure.doublylinkedlist;

public class DoubleLinkedList {
    Node head;

    void push(int val) {
        Node new_node = new Node(val);
        if (head == null) {
            head = new_node;
            return;
        }
        new_node.next = head;
        head.prev = new_node;
        head = new_node;
    }

    void append(int val) {
        Node new_node = new Node(val);
        if (head == null) {
            head = new_node;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = new_node;
        new_node.prev = temp;
    }

    void printList() {
        System.out.println("============Current Doubly linked list:=========");
        Node temp = head;
        while (temp != null) {
            System.out.printf("%d ", temp.val);
            temp = temp.next;
        }
        System.out.println("\n================================================\n");
    }

    int listLength() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }
}
