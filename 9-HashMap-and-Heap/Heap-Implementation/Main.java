// Heap Implementation in Java
// This code demonstrates a simple implementation of a Min-Heap data structure.
// It includes methods for inserting elements, removing the minimum element, and peeking at the minimum element.

import java.util.*;

public class Main {

  static class PriorityQueue {
    ArrayList<Integer> data;

    // Constructor to initialize the heap data structure
    // It creates an empty ArrayList to hold the heap elements
    public PriorityQueue() {
      data = new ArrayList<Integer>();
    }

    // Helper method to swap two elements in the heap
    // i and j are the indices of the elements to be swapped
    // This method exchanges the values at indices i and j in the data list
    // ensuring that the heap structure can be maintained during up-heapify and down-heapify operations
    // It is a private method used internally by the PriorityQueue class
    // to facilitate element swapping during heap operations No return value is needed for this method
    // as it modifies the data list in place
    private void swap(int i, int j) {
      int dataAtI = data.get(i);
      int dataAtJ = data.get(j);

      data.set(i, dataAtJ);
      data.set(j, dataAtI);
    }

    // Up-heapify to maintain the heap property after insertion of a new element
    // childIdx is the index of the newly added element
    // It ensures that the element at childIdx is moved up the heap
    // until the heap property is restored
    // by comparing the child with its parent and swapping if necessary
    // This process continues recursively until the heap property is restored
    // or the child becomes the root of the heap
    private void upHeapify(int childIdx) {
      if (childIdx == 0) {
        return;
      }
      int parentIdx = (childIdx - 1) / 2;

      if (data.get(parentIdx) > data.get(childIdx)) {
        swap(parentIdx, childIdx);
        upHeapify(parentIdx);
      }
    }

    // Down-heapify to maintain the heap property after removal of the minimum
    // element
    // parentIdx is the index of the element to be down-heapified
    // It ensures that the subtree rooted at parentIdx satisfies the heap property
    // by comparing the parent with its children and swapping if necessary
    // This process continues recursively until the heap property is restored
    // or the parent is a leaf node
    private void downHeapify(int parentIdx) {
      int leftChildIdx = (2 * parentIdx) + 1;
      int rightChildIdx = (2 * parentIdx + 2);

      int minIdx = parentIdx;

      if (leftChildIdx < data.size() && data.get(leftChildIdx) < data.get(minIdx)) {
        minIdx = leftChildIdx;
      }
      if (rightChildIdx < data.size() && data.get(rightChildIdx) < data.get(minIdx)) {
        minIdx = rightChildIdx;
      }
      if (parentIdx != minIdx) {
        swap(parentIdx, minIdx);
        downHeapify(minIdx);
      }
    }

    // Add an element to the heap
    // The new element is added at the end of the heap
    // and then up-heapified to maintain the heap property
    // This ensures that the smallest element is always at the root of the heap
    // val is the value to be added to the heap
    public void add(int val) {
      data.add(val);
      upHeapify(data.size() - 1);
    }

    // Remove and return the minimum element from the heap
    // The root element (minimum) is swapped with the last element
    // and then removed from the heap
    // The down-heapify process is then called on the root to restore the heap
    // property
    // If the heap is empty, an appropriate message is displayed
    // Returns the minimum element that was removed
    // If the heap is empty, returns -1
    public int remove() {
      if (data.size() == 0) {
        System.out.println("Priority Queue is empty!");
        return -1;
      }

      swap(0, data.size() - 1);
      int topElement = data.remove(data.size() - 1);
      downHeapify(0);
      return topElement;
    }

    // Return the minimum element without removing it
    // If the heap is empty, an appropriate message is displayed
    // Returns the minimum element at the root of the heap
    // If the heap is empty, returns -1
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

  }

  // Main method to demonstrate the functionality of the PriorityQueue
  public static void main(String[] args) {
    PriorityQueue pq = new PriorityQueue();
    pq.add(10);
    pq.add(5);
    pq.add(20);
    pq.add(15);

    System.out.println("Minimum element: " + pq.peek()); // Should print 5
    System.out.println("Removed element: " + pq.remove()); // Should print 5
    System.out.println("New minimum element: " + pq.peek()); // Should print 10
  }
}
