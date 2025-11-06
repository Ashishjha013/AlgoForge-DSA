// ------------------------------------------------------------
// 🧮 Question 12: Find Last Index of Target Using Recursion
// ------------------------------------------------------------
// 🧩 Find the rightmost (last) occurrence of target in array using recursion
// 🔑 Post-order Recursion - check from end first, then current position
// 💡 Go deep first (reach end), check on way back (return journey finds last)
//
// Pattern: Recursion on Arrays (Post-order Traversal)
// Level: 🟢 Easy
// Tags: #Recursion #Array #LinearSearch #PostOrder
// ------------------------------------------------------------

public class Question12 {

  // WHY: Parameters track current position and what we're searching for
  // WHAT: idx = current index being checked, target = value to find
  // HOW: idx starts at 0, moves forward until arr.length
  public static int lastIndex(int arr[], int idx, int target) {

    // WHY: Base case - reached end of array without return
    // WHAT: Return -1 to signal "not found in remaining array"
    // HOW: When idx == arr.length, no more elements to check
    if (idx == arr.length) {
      return -1; // End reached, target not found from here
    }

    // WHY: Go deeper first before checking current (POST-ORDER strategy)
    // WHAT: Get result from rest of array (idx+1 to end)
    // HOW: Recursively search remaining elements, trust it returns correct answer
    int foundIndexInRest = lastIndex(arr, idx + 1, target);

    // WHY: Prioritize matches found later (they're more "right" = "last")
    // WHAT: If target was found anywhere ahead, return that index immediately
    // HOW: foundIndexInRest != -1 means match exists to the right
    if (foundIndexInRest != -1) {
      return foundIndexInRest; // Found later = this is last occurrence
    }

    // WHY: No match found ahead, so check current position
    // WHAT: If current element matches, this is the last occurrence (so far)
    // HOW: Compare arr[idx] with target
    if (arr[idx] == target) {
      return idx; // Current position is last occurrence
    }

    // WHY: Current doesn't match, nothing found ahead either
    // WHAT: Return -1 to tell previous recursion level "not found"
    // HOW: This propagates "not found" signal backward
    return -1;
  }

  public static void main(String[] args) {
    int arr[] = { 10, 19, 4, 3, 4, 4, 5, 6, 8 };
    int target = 4;
    int lastIdx = lastIndex(arr, 0, target);

    if (lastIdx != -1) {
      System.out.println("✅ Last index of " + target + " is: " + lastIdx);
    } else {
      System.out.println("❌ " + target + " not found in the array.");
    }
  }
}

// ------------------------------------------------------------
// ⚡ Complexity Analysis
// ------------------------------------------------------------
// Time: O(n) - Visit each element once
// Space: O(n) - Recursion stack depth equals array length
//
// ------------------------------------------------------------
// 🎯 Pattern: Post-order Array Traversal
// 🗣️ Interview: "Recursively search rest of array first. If found there,
// return it.
// Otherwise check current. This ensures rightmost match wins."
//
// ------------------------------------------------------------
// 🧠 Execution Trace (arr=[10,4,3,4], target=4):
// ------------------------------------------------------------
//
// Going DOWN (Pre-order - moving forward):
// ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
// lastIndex(arr, idx=0, target=4) arr[0]=10
// ↓ Recurse first
// lastIndex(arr, idx=1, target=4) arr[1]=4 ✓
// ↓ Recurse first (don't check yet!)
// lastIndex(arr, idx=2, target=4) arr[2]=3
// ↓ Recurse first
// lastIndex(arr, idx=3, target=4) arr[3]=4 ✓
// ↓ Recurse first
// lastIndex(arr, idx=4, target=4) Base case!
// → return -1
//
// Coming BACK UP (Post-order - checking phase):
// ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
// At idx=3: foundIndexInRest = -1
// arr[3]==4 ✓ → return 3
// ↑
// At idx=2: foundIndexInRest = 3 (found later!)
// return 3 immediately (skip current check)
// ↑
// At idx=1: foundIndexInRest = 3 (found later!)
// return 3 immediately (even though arr[1]==4)
// ↑
// At idx=0: foundIndexInRest = 3 (found later!)
// return 3 immediately
// ↑
// FINAL ANSWER: 3 ✓ (rightmost occurrence)
//
// ------------------------------------------------------------
// 🔥 Why Post-Order Works for "Last Index":
// ------------------------------------------------------------
// 1. **Forward traversal** would return FIRST match (index 1)
// 2. **Post-order** checks rightmost elements first during return
// 3. Key line: `if (foundIndexInRest != -1) return foundIndexInRest;`
// → This ensures matches found later take priority
// 4. Current index only matters if nothing found ahead
//
// ------------------------------------------------------------
// 🧠 Revision Questions
// ------------------------------------------------------------
// Q1. Why must we recurse BEFORE checking current element?
// → To ensure we explore all elements to the RIGHT first
// → Post-order = process after children (right side processed first)
// → If we checked current first, we'd return first match, not last
//
// Q2. What if we want FIRST index instead?
// → Check current element BEFORE recursing (pre-order)
//
// int firstIndex(int arr[], int idx, int target) {
// if (idx == arr.length) return -1;
//
// // Check current FIRST (pre-order)
// if (arr[idx] == target) return idx;
//
// // Then recurse
// return firstIndex(arr, idx + 1, target);
// }
//
// Q3. Count total occurrences recursively?
// → Don't short-circuit on match, count at each level
//
// int countOccurrences(int arr[], int idx, int target) {
// if (idx == arr.length) return 0;
//
// int countInRest = countOccurrences(arr, idx + 1, target);
// int currentMatch = (arr[idx] == target) ? 1 : 0;
//
// return currentMatch + countInRest;
// }
//
// ------------------------------------------------------------
// 🔥 Key Insights:
// ------------------------------------------------------------
// 1. **Order matters**: Pre-order finds first, Post-order finds last
// 2. **Priority logic**: `if (foundIndexInRest != -1)` is the key
// - Matches found "later" (to the right) take precedence
// 3. **Trust recursion**: Assume recursive call returns correct answer
// 4. **Pattern recognition**:
// - First occurrence → Pre-order (check current first)
// - Last occurrence → Post-order (check current last)
//
// 💡 Interview Tip:
// When asked "first vs last", think "pre-order vs post-order"!
// ------------------------------------------------------------