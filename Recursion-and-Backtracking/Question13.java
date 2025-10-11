// ------------------------------------------------------------
// 🧮 Question 13: Find All Indices of Target in Array (Recursion)
// ------------------------------------------------------------
// 🧩 Find all positions where target appears in array using recursion
// 🔑 Recursion + Post-order Processing - count occurrences going down, fill array coming back
// 💡 Track "found so far" count to create exact-size array, fill during backtracking
//
// Pattern: Recursion + Array Traversal (Post-order Fill)
// Level: 🟡 Medium
// Tags: #Recursion #Arrays #Backtracking #PostOrder
// ------------------------------------------------------------

import java.util.Arrays;

public class Question13 {

  // WHY: Parameters track recursion state and progress
  // WHAT: idx = current position, fsf = count of matches found so far
  // HOW: idx moves forward (0→n), fsf increments when match found
  public static int[] findAllIndices(int[] arr, int target, int idx, int fsf) {

    // WHY: Base case - reached end of array, know total count now
    // WHAT: Create array of exact size needed (fsf = total occurrences)
    // HOW: This array will be filled during backtracking as recursion unwinds
    if (idx == arr.length) {
      return new int[fsf]; // Array size = number of matches found
    }

    // WHY: Prepare to store result from recursive call
    // WHAT: Will hold the filled array returned from deeper recursion
    // HOW: Declare outside if-else so both branches can use it
    int[] ans;

    // WHY: Decide whether to increment fsf for next recursive call
    // WHAT: If current element matches, tell next call we found one more
    // HOW: Pass fsf+1 vs fsf based on match
    if (arr[idx] == target) {
      ans = findAllIndices(arr, target, idx + 1, fsf + 1); // Found match, increment count
    } else {
      ans = findAllIndices(arr, target, idx + 1, fsf); // No match, same count
    }

    // WHY: Fill array during backtracking (post-order processing)
    // WHAT: Place current index in result array if it's a match
    // HOW: Use fsf as position - it represents "how many matches before this one"
    // fsf=0 means first match goes to ans[0], fsf=1 means second match to ans[1]
    if (arr[idx] == target) {
      ans[fsf] = idx; // Store this index at position fsf
    }

    // WHY: Pass the array up to previous recursion level
    // WHAT: Return partially/fully filled array
    // HOW: Each level adds its contribution, final level returns complete array
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = { 10, 19, 4, 3, 5, 4, 4, 6 };
    int target = 4;
    int[] ans = findAllIndices(arr, target, 0, 0);
    System.out.println("All indices of target: " + Arrays.toString(ans));
    // Output: [2, 5, 6] (target 4 found at these indices)
  }
}

// ------------------------------------------------------------
// ⚡ Complexity Analysis
// ------------------------------------------------------------
// Time: O(n) - Visit each element once
// Space: O(n) - Recursion stack depth + output array
//
// ------------------------------------------------------------
// 🎯 Pattern: Post-order Array Fill using Recursion
// 🗣️ Interview: "Count matches going down, create exact-size array at base
// case,
// fill positions during backtracking using fsf as index"
//
// ------------------------------------------------------------
// 🧠 Execution Trace Example (arr=[10,4,3,4], target=4):
// ------------------------------------------------------------
//
// Going DOWN (Pre-order - counting phase):
// ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
// findAllIndices(arr, 4, idx=0, fsf=0) arr[0]=10 ≠ 4
// ↓
// findAllIndices(arr, 4, idx=1, fsf=0) arr[1]=4 ✓
// ↓
// findAllIndices(arr, 4, idx=2, fsf=1) arr[2]=3 ≠ 4
// ↓
// findAllIndices(arr, 4, idx=3, fsf=1) arr[3]=4 ✓
// ↓
// findAllIndices(arr, 4, idx=4, fsf=2) Base case!
// → return new int[2] (array: [_, _])
//
// Coming BACK UP (Post-order - filling phase):
// ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
// At idx=3, fsf=1: arr[3]==4 → ans[1]=3 (array: [_, 3])
// ↑
// At idx=2, fsf=1: arr[2]≠4 → no change (array: [_, 3])
// ↑
// At idx=1, fsf=0: arr[1]==4 → ans[0]=1 (array: [1, 3])
// ↑
// At idx=0, fsf=0: arr[0]≠4 → no change (array: [1, 3])
// ↑
// FINAL: [1, 3] ✓
//
// ------------------------------------------------------------
// 🧠 Revision Questions
// ------------------------------------------------------------
// Q1. How does fsf help place indices correctly?
// → fsf represents "position in result array" = "number of matches seen before"
// → First match (fsf=0) goes to ans[0], second (fsf=1) to ans[1], etc.
// → Think of it as a counter that doubles as an array index
//
// Q2. What if we fill array before recursive call (pre-order)?
// → FAILS! Array doesn't exist yet (created at base case)
// → We'd get NullPointerException
// → Must wait for array to be created and returned from base case
//
// Q3. How to return List<Integer> instead?
// → Simpler approach: Create list at start, add indices as you find them
//
// ArrayList<Integer> findIndices(int[] arr, int target, int idx) {
// if (idx == arr.length) {
// return new ArrayList<>(); // Empty list at base
// }
// ArrayList<Integer> ans = findIndices(arr, target, idx+1);
// if (arr[idx] == target) {
// ans.add(0, idx); // Add at front (since backtracking)
// }
// return ans;
// }
//
// ------------------------------------------------------------
// 🔥 Key Insights:
// ------------------------------------------------------------
// 1. **fsf is dual-purpose**: Tracks count AND serves as array index
// 2. **Post-order is essential**: Need array size before filling
// 3. **Backtracking fills array**: Bottom-up filling ensures correct order
// 4. **Why fsf as index works**:
// - At each match, fsf = "how many matches happened before me"
// - This IS the correct position in result array!
//
// 💡 Alternative approach (easier but less elegant):
// - Use ArrayList, add indices during forward traversal
// - Convert to array at the end
// - This solution showcases pure recursion array manipulation!
// ------------------------------------------------------------