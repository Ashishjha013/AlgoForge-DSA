import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter 4 nodes: ");
    Node node1 = new Node(sc.nextInt());
    Node node2 = new Node(sc.nextInt());
    Node node3 = new Node(sc.nextInt());
    Node node4 = new Node(sc.nextInt());

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;

    System.out.print("Linked List: ");
    Node current = node1;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }

    sc.close();
  }
}
