// Question 4: 234. Palindrome Linked List

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

  // for: Check if linked list is a palindrome
  // ⚡ Time: O(n) | Space: O(1)
  // 🗣️ "Find middle, reverse second half, compare both halves.
  // Restore list if needed.
  // Return true if palindrome, else false."
  public static Node findMid(Node head) {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  public static boolean isPalindrome(Node head) {
    if (head == null || head.next == null) {
      return true;
    }

    Node mid = findMid(head);

    Node curr = mid;
    Node prev = null;
    while (curr != null) {
      Node currsNext = curr.next;
      curr.next = prev;
      prev = curr;
      curr = currsNext;
    }

    Node right = prev;
    Node left = head;
    while (right != null) {
      if (right.data != left.data) {
        return false;
      }

      left = left.next;
      right = right.next;
    }

    return true;
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

public class Question4 {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    // Build list: 1 -> 2 -> 3 -> 2 -> 1 -> null
    list.head = new Node(1);
    list.head.next = new Node(2);
    list.head.next.next = new Node(3);
    list.head.next.next.next = new Node(2);
    list.head.next.next.next.next = new Node(1);
    list.tail = list.head.next.next.next.next;
    list.size = 5;

    System.out.println("Original List:");
    list.display();

    boolean isPalindrome = LinkedList.isPalindrome(list.head);
    System.out.println("Is Palindrome: " + isPalindrome);
    // Output: Is Palindrome: true
  }
}
