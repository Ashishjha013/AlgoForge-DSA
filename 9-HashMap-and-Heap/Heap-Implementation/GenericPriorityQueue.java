import java.util.ArrayList;

class genericPriorityQueue {
  static class PriorityQueue {
    ArrayList<Integer> data;
    boolean isMinHeap;

    public PriorityQueue(boolean isMinHeap) {
      data = new ArrayList<Integer>();
      this.isMinHeap = isMinHeap;
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
      int dataAtI = data.get(i);
      int dataAtJ = data.get(j);

      data.set(i, dataAtJ);
      data.set(j, dataAtI);
    }

    private boolean isMorePrior(int i, int j) {
      if (isMinHeap) { // If it's a min-heap, smaller element should be on top
        return data.get(i) < data.get(j);
      } else {        // If it's a max-heap, larger element should be on top
        return data.get(i) > data.get(j);
      }
    }

    // Up-heapify to maintain the heap property after insertion of a new element
    private void upHeapify(int childIdx) {
      if (childIdx == 0) {
        return;
      }
      int parentIdx = (childIdx - 1) / 2;

      if (isMorePrior(childIdx, parentIdx)) {
        swap(parentIdx, childIdx);
        upHeapify(parentIdx);
      }
    }

    // Down-heapify to maintain the heap property after removal of the minimum
    // element
    private void downHeapify(int parentIdx) {
      int leftChildIdx = (2 * parentIdx) + 1;
      int rightChildIdx = (2 * parentIdx + 2);

      int minIdx = parentIdx;

      if (leftChildIdx < data.size() && isMorePrior(leftChildIdx, minIdx)) {
        minIdx = leftChildIdx;
      }
      if (rightChildIdx < data.size() && isMorePrior(rightChildIdx, minIdx)) {
        minIdx = rightChildIdx;
      }
      if (parentIdx != minIdx) {
        swap(parentIdx, minIdx);
        downHeapify(minIdx);
      }
    }

    // Add an element to the heap
    public void add(int val) {
      data.add(val);
      upHeapify(data.size() - 1);
    }

    // Remove and return the minimum element from the heap
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

  public static void main(String[] args) {
    PriorityQueue pq = new PriorityQueue(false);

    pq.add(10);
    pq.add(5);
    pq.add(7);
    pq.add(15);

    System.out.println(pq.remove());
    System.out.println(pq.remove());
    System.out.println(pq.remove());
    System.out.println(pq.remove());

    // System.out.println("Size: " + pq.size()); // Output: Size: 4
    // System.out.println("Peek: " + pq.peek()); // Output: Peek: 5
    // System.out.println("Removed: " + pq.remove()); // Output: Removed: 5
    // System.out.println("Peek after removal: " + pq.peek()); // Output: Peek after
    // removal: 7
  }
}
