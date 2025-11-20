
// LinkedList Class Implementation

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

  // Method to add a new node at first of the list
  public void addFirst(int data) {
    Node newNode = new Node(data);

    if (head == null) {
      head = tail;
      head = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }

    this.size++;
  }

  // Method to add a new node at the end of the list
  public void addLast(int data) {
    Node n1 = new Node(data);

    if (head == null) {
      head = tail = n1;
    } else {
      tail.next = n1;
      tail = n1;
    }
    this.size++;
  }

  public void removeFirst() {
    if(size == 0) {
      System.out.println("List is empty!");
    } else {
      head = head.next;
      size--;
    }
  }

  public void removeLast() {
    if (size == 0) {
      System.out.println("List is empty!");
    } else if (head == tail) {
      head = tail = null;
      size = 0;
    } else {
      Node curr = head;
      while (curr.next != tail) {
        curr = curr.next;
      }
      curr.next = null;
      tail = curr;
      size--;
    }
  }

  // Method to display the linked list
  public void display() {
    Node curr = head;
    while (curr != null) {
      System.out.print(curr.data + " -> ");
      curr = curr.next;
    }
    System.out.println("null");
  }
}
 
public class LinkedListDemo {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    list.addLast(23);
    list.addLast(43);
    list.addLast(30);
    list.addFirst(5);

    list.display(); // Output: 5 -> 10 -> 20 -> 30 -> null
    System.out.print("Size of LinkedList: " + list.size);
  }
}
