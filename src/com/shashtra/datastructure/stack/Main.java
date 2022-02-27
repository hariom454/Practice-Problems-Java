package com.shashtra.datastructure.stack;

/***************
 **   @author: Hariom Singh
 **  Date: 27/02/22
 *****************/
public class Main {
    public static void main(String[] args) {
        Stack myStack = new Stack();
        myStack.push(1);

        System.out.println("Is stack empty? " + myStack.isEmpty());
        try {
            System.out.println("Current top element on stack: " + myStack.top());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Removing: " + myStack.pop());
            System.out.println("Current top element: " + myStack.top());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
