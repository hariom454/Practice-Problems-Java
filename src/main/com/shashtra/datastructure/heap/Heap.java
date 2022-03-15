package com.shashtra.datastructure.heap;

import java.util.Scanner;

/***************
 **   author: Hariom Singh
 **  Date: 12/03/22
 *****************/
public class Heap {
    int[] numbers;
    int size;

    Heap(int n) {
        this.size = n;
        numbers = new int[size];
    }

    Heap(int[] a) {
        this.size = a.length;
        numbers = a;
    }

    public static void main(String[] args) {
        //int n;
        Scanner in = new Scanner(System.in);
        //n = in.nextInt();
        // Heap heap = new Heap(n);
        // for(int i = 0; i < n; i ++)
        // {
        //     int x = in.nextInt();
        //     heap.numbers[i] = x;
        // }
        int[] a = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        Heap heap = new Heap(a);

        //heap.BuildMaxHeap();
        //heap.BuildMinHeap();
        heap.heapSort();
        in.close();
    }

    private int left(int node) {
        return node * 2 + 1;
    }

    private int right(int node) {
        return node * 2 + 2;
    }

    private int parent(int child) {
        return (child - 1) / 2;
    }

    void BuildMaxHeap() {
        for (int i = size / 2; i >= 0; i--) {
            maxHeapify(i, size);
        }
        //for (int i = 0; i < size; i++)
        //  System.out.printf("%d ", numbers[i]);
        //System.out.println();
    }

    private void maxHeapify(int i, int size) {
        int largest = i;
        int left = left(i);
        int right = right(i);

        if (left < size && numbers[left] > numbers[largest])
            largest = left;

        if (right < size && numbers[right] > numbers[largest])
            largest = right;

        if (largest != i) {
            int temp = numbers[largest];
            numbers[largest] = numbers[i];
            numbers[i] = temp;
            maxHeapify(largest, size);
        }
    }

    void BuildMinHeap() {
        for (int i = size / 2; i >= 0; i--) {
            minHeapify(i, size);
        }
        //for(int i = 0; i < size; i ++)
        //  System.out.printf("%d ", numbers[i]);
        //System.out.println();
    }

    private void minHeapify(int i, int size) {
        int largest = i;
        int left = left(i);
        int right = right(i);

        if (left < size && numbers[left] < numbers[largest])
            largest = left;

        if (right < size && numbers[right] < numbers[largest])
            largest = right;

        if (largest != i) {
            int temp = numbers[largest];
            numbers[largest] = numbers[i];
            numbers[i] = temp;
            minHeapify(largest, size);
        }
    }

    void heapSort() {
        BuildMaxHeap();

        for (int i = size - 1; i > 0; i--) {
            //swap 1st element with last and then heapify
            int temp = numbers[i];
            numbers[i] = numbers[0];
            numbers[0] = temp;
            maxHeapify(0, i);
        }

        for (int i = 0; i < size; i++)
            System.out.printf("%d ", numbers[i]);
        System.out.println();

    }
}
