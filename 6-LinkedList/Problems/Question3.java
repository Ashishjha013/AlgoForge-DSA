// ------------------------------------------------------------
// 🧮 Question 3: Middle of LinkedList (LeetCode #876)
// ------------------------------------------------------------
// 🧩 Find middle node in one pass
// 🔑 Core: Slow/Fast pointers (Tortoise and Hare)
// 💡 Pattern: Fast moves 2x speed of slow
//
// Level: 🟢 Easy | Tags: #LinkedList #TwoPointers
// ------------------------------------------------------------

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

  // WHY: Find middle node (second middle for even length)
  // WHAT: Fast moves 2 steps, slow moves 1 step
  // HOW: When fast reaches end, slow is at middle
  public int findMiddle() {
    Node slow = head;
    Node fast = head;

    // WHY: Move fast at double speed
    // WHAT: fast moves 2 nodes, slow moves 1 node per iteration
    // HOW: Loop while fast can move 2 steps ahead
    while (fast != null && fast.next != null) {
      slow = slow.next; // Move 1 step
      fast = fast.next.next; // Move 2 steps
    }

    return slow.data; // slow at middle
  }

  // WHY: Find first middle for even length lists
  // WHAT: Similar to above but stops one step earlier
  // HOW: Check fast.next.next to stop before second middle
  public int findFirstMiddle() {
    Node slow = head;
    Node fast = head;

    // WHY: Extra check for fast.next.next
    // WHAT: Stops slow at first middle instead of second
    // HOW: Loop condition includes fast.next.next != null
    while (fast != null && fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow.data;
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

public class Question3 {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    // Build list: 1 -> 2 -> 3 -> 4 -> 5 -> null
    list.head = new Node(1);
    list.head.next = new Node(2);
    list.head.next.next = new Node(3);
    list.head.next.next.next = new Node(4);
    list.head.next.next.next.next = new Node(5);
    list.tail = list.head.next.next.next.next;
    list.size = 5;

    System.out.println("Original List:");
    list.display();

    System.out.println("Middle: " + list.findMiddle());
    // Output: 3 (for odd length)

    // Add one more node to test even length
    list.tail.next = new Node(6);
    list.tail = list.tail.next;
    list.size = 6;

    System.out.println("\nAfter adding 6:");
    list.display();
    System.out.println("Middle (second): " + list.findMiddle());
    System.out.println("Middle (first): " + list.findFirstMiddle());
    // Output: Middle (second): 4, Middle (first): 3
  }
}

// ⚡ Time: O(n) | Space: O(1)
// 🗣️ "Fast moves 2x speed. When fast hits end, slow at middle."

// ------------------------------------------------------------
// 🧠 TRACE: Odd length [1→2→3→4→5]
// ------------------------------------------------------------
// Start: slow→1, fast→1
// Step 1: slow→2, fast→3
// Step 2: slow→3, fast→5
// Step 3: fast.next=null, stop
// Result: slow at 3 (middle) ✓

// ------------------------------------------------------------
// 🧠 TRACE: Even length [1→2→3→4→5→6]
// ------------------------------------------------------------
// findMiddle():
// Start: slow→1, fast→1
// Step 1: slow→2, fast→3
// Step 2: slow→3, fast→5
// Step 3: slow→4, fast→null (stop)
// Result: slow at 4 (second middle) ✓
//
// findFirstMiddle():
// Start: slow→1, fast→1
// Step 1: slow→2, fast→3
// Step 2: slow→3, fast→5
// Step 3: fast.next.next=null, stop
// Result: slow at 3 (first middle) ✓

// ------------------------------------------------------------
// 🔑 KEY INSIGHT: Why fast = 2x slow?
// ------------------------------------------------------------
// Fast covers 2n distance, slow covers n distance
// When fast reaches end (distance 2n):
// slow is at n (exactly middle!)
//
// Odd length: [1,2,3,4,5]
// fast at 5 (end) → slow at 3 (exact middle)
//
// Even length: [1,2,3,4,5,6]
// fast at null → slow at 4 (second middle)
// OR fast.next.next check → slow at 3 (first middle)

// ------------------------------------------------------------
// 🧠 EDGE CASES
// ------------------------------------------------------------
// Single node [1]: Returns 1 (fast=1, fast.next=null)
// Two nodes [1,2]: findMiddle()→2, findFirstMiddle()→1
// Empty list: Check head==null before calling