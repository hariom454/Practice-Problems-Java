package com.shashtra.datastructure.doublylinkedlist;

class Node {
    int val;
    Node next, prev;

    Node(int val) {
        this.val = val;
    }
}

public class DoubleLinkedList {
    Node head;

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.head = new Node(0);
        for (int i = 1; i < 6; i++)
            list.append(i);
        for (int i = -1; i > -5; i--)
            list.push(i);
        list.printList();

        System.out.println("List Length: " + list.listLength());
    }

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
