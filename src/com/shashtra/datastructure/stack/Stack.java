package com.shashtra.datastructure.stack;

/***************
 **   @author: Hariom Singh
 **  Date: 27/02/22
 *****************/
public class Stack {
    int max_size = 100; //take user input to assign the stack size
    int arr[];
    int top;

    Stack() {
        arr = new int[max_size];
        top = -1;
    }

    void push(int val) {
        if (top == max_size) {
            System.out.println("Stack is full, remove first to insert");
            return;
        }
        arr[++top] = val;
    }

    int top() throws Exception {
        if (top == -1) {
            throw new Exception("Stack is empty, please push element to check the top");
        } else {
            return arr[top];
        }
    }

    int pop() throws Exception {
        if (top == -1) {
            throw new Exception("Stack is empty, please push element to check the top");
        }
        return arr[top--];
    }

    boolean isEmpty() {
        return top <= -1;
    }

}
