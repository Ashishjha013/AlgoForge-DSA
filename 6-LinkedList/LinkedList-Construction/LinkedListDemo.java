// ------------------------------------------------------------
// 🧮 LinkedList Implementation (Custom)
// ------------------------------------------------------------
// 🧩 Singly LinkedList with common operations
// 🔑 Core Concept: Nodes connected via next pointers
// 💡 Pattern: Linear Data Structure
//
// Level: 🟡 Medium
// Tags: #LinkedList #DataStructures #Pointers
// ------------------------------------------------------------

// WHY: Node represents each element in LinkedList
// WHAT: Contains data and reference to next node
// HOW: Class with data field and next pointer
class Node {
  int data;
  Node next;

  // WHY: Create new node with given data
  // WHAT: Initialize node with value, next as null
  // HOW: Constructor sets data, next defaults to null
  Node(int data) {
    this.data = data;
    this.next = null;
  }
}

// WHY: LinkedList class manages the chain of nodes
// WHAT: Maintains head, tail pointers and size
// HOW: Provides methods to add, remove, access nodes
class LinkedList {
  Node head; // First node
  Node tail; // Last node
  int size; // Number of nodes

  // WHY: Initialize empty LinkedList
  // WHAT: Set head, tail to null, size to 0
  // HOW: Constructor initializes fields
  public LinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  // ========== ADD OPERATIONS ==========

  // WHY: Add node at beginning
  // WHAT: Insert new node before current head
  // HOW: Create node, point to head, update head
  public void addFirst(int data) {
    Node newNode = new Node(data);

    if (head == null) {
      head = tail = newNode; // First node in list
    } else {
      newNode.next = head; // New node points to old head
      head = newNode; // Update head to new node
    }
    size++;
  }

  // WHY: Add node at end
  // WHAT: Insert new node after current tail
  // HOW: Create node, attach to tail, update tail
  public void addLast(int data) {
    Node newNode = new Node(data);

    if (head == null) {
      head = tail = newNode; // First node in list
    } else {
      tail.next = newNode; // Old tail points to new node
      tail = newNode; // Update tail to new node
    }
    size++;
  }

  // WHY: Add node at specific index
  // WHAT: Insert new node at position idx
  // HOW: Get node before idx, adjust pointers
  public void addAt(int idx, int val) {
    if (idx < 0 || idx > size) { // Note: idx can be equal to size
      System.out.println("Invalid index!");
      return;
    }

    if (idx == 0) {
      addFirst(val);
      return;
    }

    if (idx == size) {
      addLast(val);
      return;
    }

    // WHY: Insert in middle - adjust pointers
    // WHAT: Get node before idx, insert between
    // HOW: newNode.next = prev.next, prev.next = newNode
    Node prev = getNodeAt(idx - 1);
    Node newNode = new Node(val);
    newNode.next = prev.next;
    prev.next = newNode;
    size++;
  }

  // ========== REMOVE OPERATIONS ==========

  // WHY: Remove first node
  // WHAT: Delete head node
  // HOW: Move head to next node
  public void removeFirst() {
    if (head == null) {
      System.out.println("List is empty!");
      return;
    }

    if (head == tail) {
      head = tail = null; // Only one node
      size = 0;
    } else {
      head = head.next; // Move head forward
      size--;
    }
  }

  // WHY: Remove last node
  // WHAT: Delete tail node
  // HOW: Traverse to second-last, update tail
  public void removeLast() {
    if (size == 0) {
      System.out.println("List is empty!");
      return;
    }

    if (head == tail) {
      head = tail = null; // Only one node
      size = 0;
    } else {
      // WHY: Find second-last node
      // WHAT: Traverse until curr.next == tail
      // HOW: Loop stops at node before tail
      Node curr = head;
      while (curr.next != tail) {
        curr = curr.next;
      }
      curr.next = null; // Remove tail
      tail = curr; // Update tail
      size--;
    }
  }

  // WHY: Remove node at specific index
  // WHAT: Delete node at position idx
  // HOW: Get node before idx, skip over target node
  public void removeAt(int idx) {
    if (idx < 0 || idx >= size) {
      System.out.println("Invalid index!");
      return;
    }

    if (idx == 0) {
      removeFirst();
      return;
    }

    if (idx == size - 1) {
      removeLast();
      return;
    }

    // WHY: Remove middle node - bypass it
    // WHAT: Connect previous to next.next
    // HOW: prev.next = prev.next.next
    Node prev = getNodeAt(idx - 1);
    prev.next = prev.next.next;
    size--;
  }

  // ========== ACCESS OPERATIONS ==========

  // WHY: Get node at specific index
  // WHAT: Return node reference at position idx
  // HOW: Traverse from head idx times
  public Node getNodeAt(int idx) {
    if (idx < 0 || idx >= size) {
      System.out.println("Invalid index!");
      return null;
    }

    Node curr = head;
    for (int i = 0; i < idx; i++) {
      curr = curr.next;
    }
    return curr;
  }

  // ========== UTILITY OPERATIONS ==========

  // WHY: Reverse data in list (not pointers)
  // WHAT: Swap data between nodes from ends toward center
  // HOW: Two pointers approach - swap values
  public void reverseData() {
    if (size <= 1) {
      return;
    }

    int left = 0, right = size - 1;

    while (left < right) {
      Node leftNode = getNodeAt(left);
      Node rightNode = getNodeAt(right);

      // WHY: Swap data of left and right nodes
      // WHAT: Exchange values using temp variable
      // HOW: Classic swap with temporary storage
      int temp = leftNode.data;
      leftNode.data = rightNode.data;
      rightNode.data = temp;

      left++;
      right--;
    }
  }

  // WHY: Display entire list
  // WHAT: Print all node values
  // HOW: Traverse from head to null
  public void display() {
    Node curr = head;
    while (curr != null) {
      System.out.print(curr.data + " -> ");
      curr = curr.next;
    }
    System.out.println("null");
  }
}

// ========== DEMO ==========

public class LinkedListDemo {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    // Build list: 5 -> 10 -> 23 -> 43 -> 13 -> null
    list.addLast(23);
    list.addLast(43);
    list.addLast(13);
    list.addFirst(10);
    list.addFirst(5);

    System.out.println("Original List:");
    list.display();
    // Output: 5 -> 10 -> 23 -> 43 -> 13 -> null

    System.out.println("\nAfter Reverse:");
    list.reverseData();
    list.display();
    // Output: 13 -> 43 -> 23 -> 10 -> 5 -> null

    System.out.println("\nAdd at index 2:");
    list.addAt(2, 99);
    list.display();
    // Output: 13 -> 43 -> 99 -> 23 -> 10 -> 5 -> null

    System.out.println("\nRemove at index 2:");
    list.removeAt(2);
    list.display();
    // Output: 13 -> 43 -> 23 -> 10 -> 5 -> null
  }
}

// ⚡ Complexity (per operation):
// addFirst/removeFirst: O(1)
// addLast: O(1) with tail pointer
// removeLast: O(n) - need to traverse to second-last
// addAt/removeAt: O(n) - need getNodeAt
// reverseData: O(n²) - calls getNodeAt n/2 times

// 🗣️ Interview: "LinkedList uses nodes with next pointers. Add/remove at
// head is O(1). Operations in middle require traversal O(n)."
