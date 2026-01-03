// Queue using Stacks

import java.util.*;

class MyQueue {
  private Stack<Integer> stack1;
  private Stack<Integer> stack2;

  public MyQueue() {
    stack1 = new Stack<>();
    stack2 = new Stack<>();
  }

  public void add(int value) {
    stack1.push(value);
  }

  public int pop() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    return stack2.pop();
  }

  public int peek() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    return stack2.peek();
  }

  // pop eficiently
  public int popEfficiently() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    return stack2.pop();
  }

}

public class Question1 {
  public static void main(String[] args) {
    MyQueue queue = new MyQueue();

    queue.add(10);
    queue.add(20);
    queue.add(30);
    queue.add(40);

    System.out.println(queue.pop());
    System.out.println(queue.pop());
    System.out.println(queue.peek());
    System.out.println(queue.pop());
  }
}

