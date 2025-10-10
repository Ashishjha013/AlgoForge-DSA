// Question No. 11
// Find First Index of Target Using Recursion
// ------------------------------------------
// Pattern: Recursion on Arrays
// Level: Easy
// Tags: #Recursion #Array #LinearSearch

/*
Problem Statement:
------------------
Given an array of integers and a target value,
find the first index of the target value in the array using recursion.

Example:
---------
Input: arr = [4, 8, 12, 33, 16, 20, 12], target = 12
Output: 2
*/

public class Question11 {

  // Recursive function to find the first index of target
  public static int firstIndex(int arr[], int idx, int target) {
    // Base Case: if we reach end, target not found
    if (idx == arr.length) {
      return -1;
    }

    // Check current element first (so it gives first occurrence)
    if (arr[idx] == target) {
      return idx;
    }

    // Recursive Call: move to next index
    return firstIndex(arr, idx + 1, target);
  }

  // Main function
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

/*
 * 🔍 Concept Recap:
 * ----------------
 * 1. Check current index → if match, return index.
 * 2. Otherwise, move recursively to the next index.
 * 3. Base case handles the “not found” scenario.
 * 
 * ⏱️ Time Complexity: O(n)
 * 💾 Space Complexity: O(n) (due to recursion stack)
 * 
 * 🧠 Quick Practice:
 * ------------------
 * 1. Write a function to find the *last* index recursively.
 * 2. Try printing *all indices* where target appears.
 */
