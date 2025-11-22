// ------------------------------------------------------------
// 🧮 Question 2: Kth Node From End of LinkedList
// ------------------------------------------------------------
// 🧩 Find kth node from end in one pass
// 🔑 Core: Two-pointer technique (fast/slow)
// 💡 Pattern: Gap of k nodes between pointers
//
// Level: 🟡 Medium | Tags: #LinkedList #TwoPointers
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

  // WHY: Find kth node from end without knowing size
  // WHAT: Use two pointers with k gap between them
  // HOW: Move fast k steps ahead, then move both until fast reaches end
  public int kthFromEnd(int k) {
    Node slow = head;
    Node fast = head;

    // STEP 1: Move fast pointer k steps ahead

    // WHY: Create gap of k nodes between fast and slow
    // WHAT: Advance fast pointer k times
    // HOW: Loop k times, move fast forward
    while (k-- > 0) {
      if (fast == null) {
        return -1; // k is larger than list length
      }
      fast = fast.next;
    }

    // STEP 2: Move both pointers until fast reaches end

    // WHY: Maintain k gap while moving to end
    // WHAT: When fast reaches null, slow is at kth from end
    // HOW: Move both pointers one step at a time
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }

    return slow.data; // slow now points to kth from end
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

public class Question2 {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    // Build list: 10 -> 20 -> 30 -> 40 -> null
    list.head = new Node(10);
    list.head.next = new Node(20);
    list.head.next.next = new Node(30);
    list.head.next.next.next = new Node(40);
    list.tail = list.head.next.next.next;
    list.size = 4;

    System.out.println("Original List:");
    list.display();

    int k = 2;
    int result = list.kthFromEnd(k);

    if (result != -1) {
      System.out.println(k + "th from end: " + result);
      // Output: 2nd from end: 30
    } else {
      System.out.println("k is too large");
    }
  }
}

// ⚡ Time: O(n) | Space: O(1)
// 🗣️ "Move fast k steps ahead. Then move both until fast hits null.
// Slow is now at kth from end."

// ------------------------------------------------------------
// 🧠 TRACE: list = 10→20→30→40→null, k=2
// ------------------------------------------------------------
//
// STEP 1: Move fast 2 steps ahead
// slow→[10]→[20]→[30]→[40]→null
// fast→[10]→[20]→[30]→[40]→null
// fast→[20]→[30]→[40]→null (k=1)
// fast→[30]→[40]→null (k=0, stop)
//
// After Step 1:
// slow→[10], fast→[30] (gap of 2 nodes)
//
// STEP 2: Move both until fast reaches null
// slow→[10], fast→[30]
// slow→[20], fast→[40]
// slow→[30], fast→null (stop)
//
// Result: slow at [30] → 2nd from end ✓

// ------------------------------------------------------------
// 🔑 KEY INSIGHT: Why this works?
// ------------------------------------------------------------
// Gap = k nodes between fast and slow
//
// When fast reaches end (null):
// slow is exactly k nodes behind = kth from end!
//
// Example: k=2
// [10]→[20]→[30]→[40]→null
// ↑gap=2↑
// slow fast(null)
// slow is 2nd from end!

// ------------------------------------------------------------
// 🧠 EDGE CASES
// ------------------------------------------------------------
// k > length: fast becomes null → return -1
// k = 1: Returns last node
// k = length: Returns first node
