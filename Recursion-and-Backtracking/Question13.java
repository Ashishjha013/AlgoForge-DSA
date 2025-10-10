// ------------------------------------------------------------
// 🧮 Question 13: Find All Indices of a Target in Array (Recursion)
// ------------------------------------------------------------
//
// Pattern: Recursion + Array Traversal
// Level: 🟡 Medium
// Tags: #Recursion #Arrays #Backtracking
//
// ------------------------------------------------------------
// 🔹 Core Idea:
// Use recursion to traverse the array. Keep a counter (fsf = "found so far") 
// to track how many times target has been found. 
// Build the result array from the back of recursion (post-order filling).
//
// Formula / Logic:
// 1. Base case: if idx == arr.length, return new array of size fsf
// 2. Recursive call:
//    - if arr[idx] == target → fsf + 1
//    - else → fsf
// 3. Fill answer array at index fsf during backtracking
//
// ------------------------------------------------------------

import java.util.Arrays;

public class Question13 {

  // idx = current index, fsf = "found so far" count
  public static int[] findAllIndices(int[] arr, int target, int idx, int fsf) {
    // Base case: reached end of array
    if (idx == arr.length) {
      return new int[fsf]; // create array of size = total occurrences
    }

    int[] ans;

    // Recursive call, increment fsf if current element matches target
    if (arr[idx] == target) {
      ans = findAllIndices(arr, target, idx + 1, fsf + 1);
    } else {
      ans = findAllIndices(arr, target, idx + 1, fsf);
    }

    // Fill answer array during backtracking
    if (arr[idx] == target) {
      ans[fsf] = idx;
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] arr = { 10, 19, 4, 3, 5, 4, 4, 6 };
    int target = 4;

    int[] ans = findAllIndices(arr, target, 0, 0);
    System.out.println("All indices of target: " + Arrays.toString(ans));
  }
}

// ------------------------------------------------------------
// 🧭 Key Takeaways
// ------------------------------------------------------------
// - Recursion can track "found so far" (fsf) instead of using extra lists.
// - Fill result array during backtracking (post-order recursion).
// - Time Complexity: O(n), Space Complexity: O(n) for recursion stack + output
// array.
//
// ------------------------------------------------------------
// 🧠 Quick Questions
// ------------------------------------------------------------
// 1. How does fsf help to correctly place indices in the result array?
// 2. What happens if we try to fill the array before the recursive call
// (pre-order)?
// 3. How would you modify this to return a List<Integer> instead of array?
// ------------------------------------------------------------
