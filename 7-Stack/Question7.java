// Question 7: LeetCode 239 - Sliding Window Maximum

// Given an array nums and a sliding window size k,
// use ngr concept to find maximum in each sliding window
import java.util.*;
public class Question7 {

  public static int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k <= 0) {
      return new int[0];
    }

    int n = nums.length;
    int[] result = new int[n - k + 1];
    Deque<Integer> deque = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      // Remove indices that are out of the current window
      if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
        deque.pollFirst();
      }

      // Remove elements smaller than the current element
      while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
        deque.pollLast();
      }

      // Add current element at the back of the deque
      deque.offerLast(i);

      // The front of the deque is the largest element for the current window
      if (i >= k - 1) {
        result[i - k + 1] = nums[deque.peekFirst()];
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
    int[] result = maxSlidingWindow(nums, k);
    System.out.println("Result: " + Arrays.toString(result));
  }
}
