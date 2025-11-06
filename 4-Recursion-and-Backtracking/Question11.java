// ------------------------------------------------------------
// 🧮 Question 11: Find First Index of Target Using Recursion
// ------------------------------------------------------------
// 🧩 Find the leftmost (first) occurrence of target in array using recursion
// 🔑 Pre-order Recursion - check current position first, then move forward
// 💡 Check before recurse → ensures leftmost match is found first
//
// Pattern: Recursion on Arrays (Pre-order Traversal)
// Level: 🟢 Easy
// Tags: #Recursion #Array #LinearSearch #PreOrder
// ------------------------------------------------------------

public class Question11 {

  // WHY: Parameters track position and search target
  // WHAT: idx = current index to check, target = value we're looking for
  // HOW: idx starts at 0, increments until arr.length
  public static int firstIndex(int arr[], int idx, int target) {

    // WHY: Base case - exhausted entire array
    // WHAT: Return -1 to signal "target not found"
    // HOW: When idx reaches arr.length, no more elements exist
    if (idx == arr.length) {
      return -1; // Target doesn't exist in array
    }

    // WHY: Check current element BEFORE recursing (PRE-ORDER strategy)
    // WHAT: If match found, immediately return this index
    // HOW: Compare current element with target, return idx if equal
    if (arr[idx] == target) {
      return idx; // Found! This is first occurrence (leftmost)
    }

    // WHY: Current doesn't match, search in remaining array
    // WHAT: Recursively check next index onward
    // HOW: Move to idx+1, trust recursion to search rest correctly
    return firstIndex(arr, idx + 1, target);
  }

  public static void main(String[] args) {
    int arr[] = { 4, 8, 12, 33, 16, 20, 12 };
    int target = 12;
    int firstIdx = firstIndex(arr, 0, target);

    if (firstIdx != -1) {
      System.out.println("✅ First index of " + target + " is: " + firstIdx);
    } else {
      System.out.println("❌ " + target + " not found in the array.");
    }
  }
}

// ------------------------------------------------------------
// ⚡ Complexity Analysis
// ------------------------------------------------------------
// Time: O(n) - Visit each element once in worst case (target at end/absent)
// Space: O(n) - Recursion stack depth equals array length in worst case
//
// ------------------------------------------------------------
// 🎯 Pattern: Pre-order Array Traversal
// 🗣️ Interview: "Check current element first. If match, return immediately.
// Otherwise recurse to next index. Leftmost match wins."
//
// ------------------------------------------------------------
// 🧠 Execution Trace (arr=[4,8,12,33,12], target=12):
// ------------------------------------------------------------
//
// Sequential Checking (Pre-order):
// ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
// firstIndex(arr, idx=0, target=12)
// Check: arr[0]=4 ≠ 12 ✗
// → Recurse to idx=1
//
// firstIndex(arr, idx=1, target=12)
// Check: arr[1]=8 ≠ 12 ✗
// → Recurse to idx=2
//
// firstIndex(arr, idx=2, target=12)
// Check: arr[2]=12 == 12 ✓
// → RETURN 2 immediately
//
// Result propagates back:
// ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
// return 2 ← firstIndex(..., idx=2, ...)
// ↑
// return 2 ← firstIndex(..., idx=1, ...)
// ↑
// return 2 ← firstIndex(..., idx=0, ...)
//
// FINAL ANSWER: 2 ✓ (first occurrence, even though 12 also at idx=4)
//
// ------------------------------------------------------------
// 🔥 Pre-order vs Post-order Comparison:
// ------------------------------------------------------------
//
// PRE-ORDER (this solution):
// ┌─────────────────────────────────────┐
// │ 1. Check current element FIRST │
// │ 2. If match → return immediately │
// │ 3. Else → recurse to next │
// │ Result: FIRST occurrence found │
// └─────────────────────────────────────┘
//
// POST-ORDER (Question 12):
// ┌─────────────────────────────────────┐
// │ 1. Recurse to next FIRST │
// │ 2. Check result from recursion │
// │ 3. Then check current element │
// │ Result: LAST occurrence found │
// └─────────────────────────────────────┘
//
// 🎯 Key Difference: WHEN you check current element!
//
// ------------------------------------------------------------
// 🧠 Revision Questions
// ------------------------------------------------------------
// Q1. Why does checking current FIRST find FIRST occurrence?
// → We traverse left-to-right (idx=0 → n)
// → First match encountered IS the leftmost match
// → Immediate return prevents checking duplicates to the right
// → Pre-order = process before recursion = leftmost priority
//
// Q2. Find LAST index recursively?
// → Already covered in Question 12! (Post-order approach)
// → Key: Recurse FIRST, check current LAST
//
// Q3. Print ALL indices where target appears?
// → Don't return on match, continue recursing and collect
//
// void printAllIndices(int arr[], int idx, int target) {
// if (idx == arr.length) return; // Base case
//
// // Check current and print if match
// if (arr[idx] == target) {
// System.out.print(idx + " ");
// }
//
// // Continue to next regardless of match
// printAllIndices(arr, idx + 1, target);
// }
//
// // For returning list instead of printing:
// ArrayList<Integer> getAllIndices(int arr[], int idx, int target) {
// if (idx == arr.length) {
// return new ArrayList<>(); // Empty list at end
// }
//
// ArrayList<Integer> restIndices = getAllIndices(arr, idx+1, target);
//
// if (arr[idx] == target) {
// restIndices.add(0, idx); // Add current at front
// }
//
// return restIndices;
// }
//
// ------------------------------------------------------------
// 🔥 Key Insights:
// ------------------------------------------------------------
// 1. **Traversal Order = Result Order**:
// - Pre-order (check first) → First match
// - Post-order (check last) → Last match
//
// 2. **Early Return Optimization**:
// - Finding first? Return immediately on match
// - Finding last? Must check all, return on backtrack
//
// 3. **Pattern Recognition Table**:
// ┌─────────────────┬──────────────┬─────────────────┐
// │ Goal │ Order │ When to Check │
// ├─────────────────┼──────────────┼─────────────────┤
// │ First Index │ Pre-order │ Before recurse │
// │ Last Index │ Post-order │ After recurse │
// │ All Indices │ Pre-order │ Don't return │
// │ Count │ Either │ Accumulate │
// └─────────────────┴──────────────┴─────────────────┘
//
// 4. **Interview Strategy**:
// "For FIRST occurrence, I check before recursing (pre-order).
// For LAST occurrence, I recurse first (post-order).
// The order determines which match takes priority."
//
// 💡 Remember: Pre = Process Early = First Match
// Post = Process Late = Last Match
// ------------------------------------------------------------