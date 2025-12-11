// Question 2: Next Greater Element

import java.util.*;

public class Question2 {
  public static ArrayList<Integer> nextGreaterElements(int[] nums) {
    int n = nums.length;
    // ngr = next greater
    int[] ngr = new int[n];

    Stack<Integer> st = new Stack<>();

    for (int i = n - 1; i >= 0; i--) {
      int currentEle = nums[i];

      while (st.size() > 0 && st.peek() <= currentEle) {
        st.pop();
      }

      if (st.size() == 0) {
        ngr[i] = -1;

      } else {
        ngr[i] = st.peek();
      }
      st.push(currentEle);
    }

    ArrayList<Integer> ans = new ArrayList<>();
    for (int i = 0; i < n; i++)
      ans.add(ngr[i]);
    return ans;
  }
  public static void main(String[] args) {
    int[] nums = {4, 5, 2, 10, 8};
    ArrayList<Integer> result = nextGreaterElements(nums);
    System.out.println(result); // Output: [5, 10, 10, -1, -1]
  }
}
