// Heap Implementation in Java
// This code demonstrates a simple implementation of a Min-Heap data structure.
// It includes methods for inserting elements, removing the minimum element, and peeking at the minimum element.

import java.util.*;

public class Main {

  public class PriorityQueue {
    ArrayList<Integer> data;

    // Constructor to initialize the heap
    public PriorityQueue() {
      data = new ArrayList<Integer>();
    }

    // Add an element to the heap
    public void add(int val) {
      //
    }

    // Remove and return the minimum element from the heap
    public int remove() {
      return -1; // Placeholder
    }

    // Return the minimum element without removing it
    public int peek() {
      return -1; // Placeholder
    }

    // Return the size of the heap
    public int size() {
      return data.size();
    }

    public static void main(String[] args) {
      PriorityQueue pq = new PriorityQueue();
      pq.add(10);
      pq.add(5);
      pq.add(20);
      System.out.println("Minimum element: " + pq.peek()); // Should print 5
      System.out.println("Removed element: " + pq.remove()); // Should print 5
      System.out.println("New minimum element: " + pq.peek()); // Should print 10
    }
  }
}
