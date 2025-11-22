// ------------------------------------------------------------
// 🧮 LinkedList Introduction
// ------------------------------------------------------------
// 🧩 Chain of nodes connected by pointers
// 🔑 Core: Node (data + next) → Traverse until null
// 💡 Pattern: Manual linking and traversal
//
// Level: 🟢 Beginner | Tags: #LinkedList #Basics
// ------------------------------------------------------------

import java.util.*;

// WHY: Node is building block of LinkedList
// WHAT: Stores data and reference to next node
// HOW: Two fields - data and next pointer
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

    // WHY: Create 4 separate nodes
    // WHAT: Each node holds one value
    // HOW: Create using constructor
    System.out.print("Enter 4 nodes: ");
    Node node1 = new Node(sc.nextInt());
    Node node2 = new Node(sc.nextInt());
    Node node3 = new Node(sc.nextInt());
    Node node4 = new Node(sc.nextInt());

    // WHY: Link nodes to form chain
    // WHAT: Set next pointers
    // HOW: node1→node2→node3→node4→null
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;

    // WHY: Display linked list
    // WHAT: Traverse from head to null
    // HOW: Follow next pointers
    System.out.print("Linked List: ");
    Node current = node1;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }

    sc.close();
  }
}

// ⚡ Time: O(n) | Space: O(1)
// 🗣️ "Chain of nodes. Each has data + next. Traverse by following next."

// ------------------------------------------------------------
// 🧠 VISUAL: Input = 10 20 30 40
// ------------------------------------------------------------
// [10]→[20]→[30]→[40]→null
//
// Traversal steps:
// current=node1 → print 10 → move to node2
// current=node2 → print 20 → move to node3
// current=node3 → print 30 → move to node4
// current=node4 → print 40 → move to null
// current=null → stop
//
// Output: 10 20 30 40
