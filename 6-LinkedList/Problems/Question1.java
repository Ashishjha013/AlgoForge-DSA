// ------------------------------------------------------------
// 🧮 Question 1: Reverse LinkedList (LeetCode #206)
// ------------------------------------------------------------
// 🧩 Reverse by changing next pointers (not data)
// 🔑 Core: Three pointers (prev, curr, next)
// 💡 Pattern: Iterative pointer reversal
//
// Level: 🟡 Medium | Tags: #LinkedList #Pointers
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

  // WHY: Reverse list by changing pointers
  // WHAT: Make each node point to previous instead of next
  // HOW: Use three pointers - prev, curr, and save next before reversing
  public void reverseLinkedList() {
    Node curr = head;
    Node prev = null;

    // WHY: Traverse and reverse each link
    // WHAT: curr.next should point to prev instead of next
    // HOW: Save next, reverse pointer, move forward
    while (curr != null) {
      Node currKaNext = curr.next; // Save next before losing it
      curr.next = prev; // Reverse the link
      prev = curr; // Move prev forward
      curr = currKaNext; // Move curr forward
    }

    // WHY: Update head and tail after reversal
    // WHAT: Old head becomes tail, old tail becomes head
    // HOW: tail = old head, head = prev (last node processed)
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

    // Build list: 1 -> 2 -> 3 -> null
    list.head = new Node(1);
    list.head.next = new Node(2);
    list.head.next.next = new Node(3);
    list.tail = list.head.next.next;
    list.size = 3;

    System.out.println("Original:");
    list.display();
    // Output: 1 -> 2 -> 3 -> null

    list.reverseLinkedList();

    System.out.println("Reversed:");
    list.display();
    // Output: 3 -> 2 -> 1 -> null
  }
}

// ⚡ Time: O(n) | Space: O(1)
// 🗣️ "Save next, reverse curr.next to prev, move forward."

// ------------------------------------------------------------
// 🧠 TRACE: [1→2→3→null]
// ------------------------------------------------------------
//
// Initial: prev=null, curr=1
// [1]→[2]→[3]→null
// ↑
// curr
//
// Step 1: currKaNext=2, curr.next=null, prev=1, curr=2
// null←[1] [2]→[3]→null
// ↑ ↑
// prev curr
//
// Step 2: currKaNext=3, curr.next=1, prev=2, curr=3
// null←[1]←[2] [3]→null
// ↑ ↑
// prev curr
//
// Step 3: currKaNext=null, curr.next=2, prev=3, curr=null
// null←[1]←[2]←[3] null
// ↑ ↑
// prev curr (loop ends)
//
// Final: head=prev=3, tail=old head=1
// Result: [3]→[2]→[1]→null ✓

// ------------------------------------------------------------
// 🔑 KEY INSIGHT: Why save next?
// ------------------------------------------------------------
// If we don't save curr.next before reversing:
//
// BAD: curr.next = prev (link reversed)
// curr = curr.next (WRONG! curr.next now points backward!)
//
// GOOD: currKaNext = curr.next (save forward link)
// curr.next = prev (reverse link)
// curr = currKaNext (move forward using saved link)
//
// We need to save next before breaking the forward link!

// ------------------------------------------------------------
// 🧠 EDGE CASES
// ------------------------------------------------------------
// Empty list: head=null, nothing to reverse
// Single node [1]: Reverses to [1] (unchanged)
// Two nodes [1→2]: Reverses to [2→1]