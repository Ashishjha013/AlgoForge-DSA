// Construction of a Stack data structure in Java
// Using Arrays

class MyStack {
  public int[] arr;
  public int top;
  int maxSize = 8;

  public MyStack(int size) {
    arr = new int[size];
    maxSize = size;
    top = -1;
  }

  public void resizeArray() {
    int newArr[] = new int[maxSize * 2];
    for (int i = 0; i < arr.length; i++) {
      newArr[i] = arr[i];
    }
    arr = newArr;
  }

  public void push(int val) {
    if (top == maxSize - 1) {
      System.out.println("Stack Overflow");
      return;
    }
    // Dynamic resizing of the stack array
    if(top == maxSize - 1) {
      resizeArray();
    }
    arr[++top] = val;
  }

  public int pop() {
    if (top == -1) {
      System.out.println("Stack is Empty");
      return -1;
    }
    return arr[top--];
  }

  public int peek() {
    if (top == -1) {
      System.out.println("stack is Empty");
      return -1;
    }
    return arr[top];
  }

  public int size() {
    return top + 1;
  }
}

public class Stack {
  public static void main(String[] args) {
    MyStack st = new MyStack(5);
    st.push(4);
    st.push(8);
    st.push(12);
    st.push(16);
    System.out.println("Top element is: " + st.peek()); // 3
    System.out.println("Stack size is: " + st.size()); // 3
    System.out.println("Popped element is: " + st.pop()); // 3
    System.out.println("Top element is: " + st.peek()); // 2
  }
}
