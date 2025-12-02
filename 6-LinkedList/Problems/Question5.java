// 138. Copy List with Random Pointer

class Node {
  int data;
  Node next;
  Node random;

  Node(int data) {
    this.data = data;
    this.next = null;
    this.random = null;
  }
}

class LinkedList {
  Node head;
  Node tail;
  int size;

  public void display() {
    Node curr = head;
    while (curr != null) {
      System.out.print(curr.data + " -> ");
      curr = curr.next;
    }
    System.out.println("null");
  }

  public void addCopyNodes(Node head) {
    Node curr = head;

    while (curr != null) {
      Node currKaNext = curr.next;
      Node copyNode = new Node(curr.data);

      curr.next = copyNode;
      copyNode.next = currKaNext;

      curr = currKaNext;
    }
  }

  public void assignRandom(Node head) {
    Node curr = head;

    while (curr != null) {
      Node copyNode = curr.next;

      if (curr.random != null) {
        copyNode.random = curr.random.next;
      }
      curr = curr.next.next;
    }
  }

  public Node removeCopyList(Node head) {
    Node dummy = new Node(-1);
    Node curr = head;
    Node copyCurr = dummy;

    while (curr != null) {
      Node copyNode = curr.next;
      Node currKaNext = copyNode.next;

      copyCurr.next = copyNode;
      curr.next = currKaNext;

      curr = currKaNext;
      copyCurr = copyCurr.next;
    }
    return dummy.next;
  }

  public Node copyRandomList(Node head) {
    if (head == null) return null;

    // Step 1: Create a copy of each node
    Node curr = head;
    while (curr != null) {
      Node copyNode = new Node(curr.data);
      copyNode.next = curr.next;
      curr.next = copyNode;
      curr = copyNode.next;
    }

    // Step 2: Assign random pointers to the copy nodes
    curr = head;
    while (curr != null) {
      Node copyNode = curr.next;
      copyNode.random = (curr.random != null) ? curr.random.next : null;
      curr = copyNode.next;
    }

    // Step 3: Separate the copy list from the original list
    curr = head;
    Node copyHead = head.next;
    Node copyCurr = copyHead;

    while (curr != null) {
      curr.next = (curr.next != null) ? curr.next.next : null;
      curr = curr.next;
      copyCurr.next = (copyCurr.next != null) ? copyCurr.next.next : null;
      copyCurr = copyCurr.next;
    }

    return copyHead;
  }
}

public class Question5 {
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
