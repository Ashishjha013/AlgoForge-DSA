// Construction of a Stack data structure in Java
// Using Queues

import java.util.*;

class Stack {
  private LinkedList<Integer> que;

  public Stack() {
    que = new LinkedList<>();
  }

  // O(1)
  public void push(int val) {
    que.addLast(val);
  }

  public int pop() {
    if (que.isEmpty()) {
      throw new NoSuchElementException("Stack is empty");
    }
    return que.removeLast();
  }

  public int peek() {
    if (que.isEmpty()) {
      throw new NoSuchElementException("Stack is empty");
    }
    return que.getLast();
  }

  public boolean isEmpty() {
    return que.isEmpty();
  }

  public int size() {
    return que.size();
  }

}

public class Main {
  public static void main(String[] args) {
    Stack st = new Stack();
    st.push(10);
    st.push(20);
    st.push(30);
    System.out.println(st.peek()); // Output: 30
    System.out.println(st.pop());  // Output: 30
    System.out.println(st.size()); // Output: 2
    System.out.println(st.isEmpty()); // Output: false
  }
}
