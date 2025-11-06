// ------------------------------------------------------------
// 🧮 Question 2: Find All Subsets with Target Sum
// ------------------------------------------------------------
// 🧩 Find all subsets of array that sum to target value
// 🔑 Backtracking + Include/Exclude - binary choice for each element
// 💡 At each index: include element (reduce target) OR exclude it
//
// Pattern: Backtracking (Subset Sum - Include/Exclude)
// Level: 🟡 Medium | Similar to LeetCode #39, #40
// Tags: #Backtracking #SubsetSum #Recursion
// ------------------------------------------------------------

public class Question2 {
  // WHY: Parameters track position, remaining target, and current subset
  // WHAT: idx = current element, target = remaining sum needed, ans = subset
  // built so far
  // HOW: At each index, try including or excluding current element
  public static void printTargetSumSubsets(int arr[], int idx, int target, String ans) {

    // WHY: Base case - processed all elements
    // WHAT: Check if we achieved target sum with chosen elements
    // HOW: If target reduced to 0, current subset is valid
    if (idx == arr.length) {
      if (target == 0) {
        System.out.println(ans); // Found valid subset!
      }
      return; // Backtrack regardless of target value
    }

    // WHY: "YES" branch - include current element in subset
    // WHAT: Add arr[idx] to answer string and reduce target by arr[idx]
    // HOW: target - arr[idx] = new remaining target after including this element
    printTargetSumSubsets(arr, idx + 1, target - arr[idx], ans + arr[idx] + ", ");

    // WHY: "NO" branch - exclude current element from subset
    // WHAT: Move to next element without modifying target or answer
    // HOW: Same target, same ans (element not included)
    printTargetSumSubsets(arr, idx + 1, target, ans);
  }

  public static void main(String[] args) {
    // int arr[] = { 2, 5, 3, 1, 4, 6, -8 };
    // int target = 8;
    int arr[] = { 2, 1, 3, 2 };
    int target = 4;
    printTargetSumSubsets(arr, 0, target, "");
    // Output: Subsets like "2, 5, 1, " or "3, 1, 4, " that sum to 8
  }
}

// ------------------------------------------------------------
// ⚡ COMPLEXITY ANALYSIS
// ------------------------------------------------------------
//
// SUBSET SUM:
// Time: O(2^n) - Each element has 2 choices (include/exclude)
// Space: O(n) - Recursion depth = array length
//
// ------------------------------------------------------------
// 🎯 PATTERNS USED
// ------------------------------------------------------------
//
// SUBSET SUM: Include/Exclude Pattern (Binary Choice Tree)
// 🗣️ "For each element, make binary choice: include it (reduce target)
// or exclude it (keep target same). Base case: all processed."

// ------------------------------------------------------------
// 🧠 SUBSET SUM - Execution Trace (arr=[2,3], target=5)
// ------------------------------------------------------------
//
// findAllSubsets(idx=0, target=5, "")
// / \
// Include 2 Exclude 2
// | |
// (idx=1, target=3, "2, ") (idx=1, target=5, "")
// / \ / \
// Include 3 Exclude 3 Include 3 Exclude 3
// | | | |
// (idx=2, (idx=2, (idx=2, (idx=2,
// target=0, target=3, target=2, target=5,
// "2, 3, ") "2, ") "3, ") "")
// ✓ PRINT ✗ ✗ ✗
//
// Output: "2, 3, " (only this subset sums to 5)
//
// ------------------------------------------------------------
// 🧠 REVISION QUESTIONS
// ------------------------------------------------------------
//
// === SUBSET SUM ===
// Q1. Why do we reduce target by arr[idx] in "yes" call?
// → Including element means it contributes to sum
// → New target = original target - current element
// → If target becomes 0, we found exact sum!
//
// Q2. Can we handle negative numbers?
// → YES! This solution works with negatives
// → Example: arr=[-2, 3, 5], target=1 → "-2, 3, " is valid
//
// Q3. What if we want count instead of printing?
//
// int countSubsets(int arr[], int idx, int target) {
// if (idx == arr.length) {
// return (target == 0) ? 1 : 0; // Found or not
// }
// int includeCount = countSubsets(arr, idx+1, target - arr[idx]);
// int excludeCount = countSubsets(arr, idx+1, target);
// return includeCount + excludeCount;
// }
//
// ------------------------------------------------------------
// 🔥 KEY INSIGHTS
// ------------------------------------------------------------
//
// === SUBSET SUM ===
// 1. **Binary decision tree**: Include OR Exclude at each step
// 2. **Target tracking**: Reduce target when including elements
// 3. **Order doesn't matter**: [2,3] and [3,2] are same subset
// 4. **Similar problems**: Combination Sum, Partition Equal Subset Sum
//
// 💡 Common Theme: use of BACKTRACKING
// - Try a choice
// - Recurse with that choice
// - Undo the choice (backtrack)
// - Try next choice
//
// This is the essence of exploring all possibilities systematically!
// ------------------------------------------------------------