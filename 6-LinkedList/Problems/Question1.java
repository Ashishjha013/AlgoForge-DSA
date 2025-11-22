// Question 1: Reverse a Linked List by changing pointers

class Node {
  int data;
  Node next;

  Node(int data) {
    this.data = data;
    this.next = null;
  }
}

class LinkedList {
  Node head;
  Node tail;
  int size;

  public LinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public void reverseLinkedList() {
    Node curr = head;
    Node prev = null;

    while (curr != null) {
      Node currKaNext = curr.next;
      curr.next = prev;
      prev = curr;
      curr = currKaNext;
    }
    tail = head;
    head = prev;
  }

  public void display() {
    Node curr = head;
    while (curr != null) {
      System.out.print(curr.data + " -> ");
      curr = curr.next;
    }
    System.out.println("null");
  }
}

public class Question1 {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.head = new Node(1);
    list.head.next = new Node(2);
    list.head.next.next = new Node(3);
    list.tail = list.head.next.next;
    list.size = 3;

    System.out.println("Original List:");
    list.display();

    list.reverseLinkedList();

    System.out.println("Reversed List:");
    list.display();
  }
}
