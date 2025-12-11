// Question 2: Next Greater Element

import java.util.*;

public class Question3 {
  public static ArrayList<Integer> nextGreaterElements(int[] nums) {
    int n = nums.length;
    // Create an array to store the next greater elements
    int[] ngr = new int[n];
    // Create a Stack to help find the next greater elements
    Stack<Integer> st = new Stack<>();

    // Traverse the array from right to left
    for (int i = n - 1; i >= 0; i--) {
      // Get the current element
      int currentEle = nums[i];

      // Pop elements from the stack while they are less than or equal to the current
      // element
      while (st.size() > 0 && st.peek() <= currentEle) {
        st.pop();
      }
      // If the stack is empty, there is no greater element to the right
      if (st.size() == 0) {
        ngr[i] = -1;
        // If the stack is empty, there is no greater element to the right
      } else {
        ngr[i] = st.peek();
      }
      // Push the current element onto the stack
      st.push(currentEle);
    }

    // Convert the ngr array to an ArrayList and return
    ArrayList<Integer> ans = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      ans.add(ngr[i]);
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
