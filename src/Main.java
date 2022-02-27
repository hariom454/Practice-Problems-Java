/***************
 **   @author: Hariom Singh
 **  Date: 26/02/22
 *****************/
public class Main {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.head = new Node(1);
        Node second = new Node(2);
        list.head.next = second;
        //list.insertAtEnd(3);
        list.insertAfterGivenNode(list.head.next, 3);
        list.insertAtEnd(4);
        list.insertAtFront(0);
        list.insertAtEnd(5);
        for (int i = 6; i < 10; i++)
            list.insertAtEnd(i);
        list.printList();
        System.out.println("Lenght of linked list: " + list.ListLength());

    }
}
