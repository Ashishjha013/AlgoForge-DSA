// Question 2: Next Greater Element

import java.util.*;
import java.util.Stack;

public class Question3 {
  public static ArrayList<Integer> nextGreaterElements(int[] arr) {
    int n = arr.length;
    // Array to store the Next Greater Right elements
    int[] nextGreater = new int[n];
    // Stack to keep track of indices of elements
    Stack<Integer> st = new Stack<>();

    // Traverse the array from right to left
    for (int i = n - 1; i >= 0; i--) {
      // Step 1: Pop elements from the stack until we find a greater element than the
      // current
      // element arr[i]
      while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
        st.pop();
      }
      // Step 2: If the stack becomes empty then the Next Greater Right element is -1
      if (st.isEmpty()) {
        nextGreater[i] = -1;
        // Or: The Next Greater Right element is arr[st.peek()]
      } else {
        nextGreater[i] = arr[st.peek()];
      }
      // Step 3: Now push the Greater Element index in the stack
      st.push(i);
    }

    // Convert the result array to an ArrayList and return
    ArrayList<Integer> ans = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      ans.add(nextGreater[i]);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 4, 5, 2, 10, 8 };

    // Find the next greater elements
    ArrayList<Integer> result = nextGreaterElements(nums);
    System.out.println(result); // Output: [5, 10, 10, -1, -1]
  }
}
