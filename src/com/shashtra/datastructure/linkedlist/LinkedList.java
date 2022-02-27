package com.shashtra.datastructure.linkedlist;

class LinkedList {
    private Node head;

    /**
     * @param val create new node with val and
     *            add it front of the list
     */
    void insertAtFront(int val) {
        Node new_node = new Node(val);
        new_node.next = head;
        head = new_node;
    }

    /**
     * @param val create a new node using provided value and insert it at end of the list
     *            Insert node at the end with new node
     *            if list is null create new node and make it new
     */
    void insertAtEnd(int val) {
        Node temp = head;
        Node new_node = new Node(val);
        if (temp == null) {
            head = new_node;
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new_node;
    }

    /**
     * @param PrevNode Prev node after which new node needs to be inserted
     * @param val      create new ndoe with provided with given value
     *                 create a new node and insert after given node
     */
    void insertAfterGivenNode(Node PrevNode, int val) {
        Node new_node = new Node(val);
        if (PrevNode == null) {
            System.out.println("Prev node can't be null");
            return;
        }
        new_node.next = PrevNode.next;
        PrevNode.next = new_node;
    }

    /**
     * Used to print the given linked list
     * input: head
     * output: nodes of given linked list
     */
    void printList() {
        Node temp = head;
        System.out.println("===========Current linked list:===============");
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println("\n==============================================");
    }

    /**
     * @return length of the given linked list
     */
    int ListLength() {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
}
