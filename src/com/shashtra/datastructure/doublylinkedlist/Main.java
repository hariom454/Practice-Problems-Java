package com.shashtra.datastructure.doublylinkedlist;

/***************
 **   @author: Hariom Singh
 **  Date: 27/02/22
 *****************/
public class Main {
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
}
