// Question No. 12
// Find Last Index of Target Using Recursion
// -----------------------------------------
// Pattern: Recursion on Arrays
// Level: Easy
// Tags: #Recursion #Array #LinearSearch

/*
Problem Statement:
------------------
Given an array of integers and a target value,
find the last index of the target value in the array using recursion.

Example:
---------
Input:  arr = [10, 19, 4, 3, 4, 4, 5, 6, 8], target = 4
Output: 5
*/

public class Question12 {

  // Recursive function to find the last index of target
  public static int lastIndex(int arr[], int idx, int target) {
    // Base Case: if we reach end of array, return -1 (not found)
    if (idx == arr.length) {
      return -1;
    }

    // Recursive Call: move to the next index first
    int foundIndexInRest = lastIndex(arr, idx + 1, target);

    // If found later in recursion, keep that value (since it's last)
    if (foundIndexInRest != -1) {
      return foundIndexInRest;
    }

    // Otherwise, check current element
    if (arr[idx] == target) {
      return idx;
    }

    // Not found anywhere
    return -1;
  }

  // Main function
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

/*
 * 🔍 Concept Recap:
 * ----------------
 * 1. Go deeper (to end of array) → recursion explores all elements.
 * 2. When returning, if found later → keep that index.
 * 3. If not, check current index → helps get the last occurrence.
 * 
 * ⏱️ Time Complexity: O(n)
 * 💾 Space Complexity: O(n)
 * 
 * 🧠 Quick Practice:
 * ------------------
 * Try modifying this to:
 * 1. Return *all indices* of target recursively.
 * 2. Count total occurrences of target recursively.
 */
