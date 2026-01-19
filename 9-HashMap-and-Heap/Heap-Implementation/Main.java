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

    // Helper method to swap two elements in the heap
    private void swap(int i, int j) {
      int dataAtI = data.get(i);
      int dataAtJ = data.get(j);

      data.set(i, dataAtJ);
      data.set(j, dataAtI);
    }

    // Up-heapify to maintain the heap property after insertion of a new element
    // childIdx is the index of the newly added element 
    public void upHeapify(int childIdx) {
      int parentIdx = (childIdx - 1) / 2;

      if (data.get(parentIdx) > childIdx) {
        swap(parentIdx, childIdx);
        upHeapify(parentIdx);
      }
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
      if (data.size() == 0) {
        System.out.println("Priority Queue is empty!");
        return -1;
      }
      return data.get(0); // Placeholder
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
