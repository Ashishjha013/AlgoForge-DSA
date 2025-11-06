// Question No. 8
// Search in 2D Sorted Array
// LeetCode: 74. Search a 2D Matrix
// --------------------------------
// Pattern: Matrix Search
// Level: Medium
// Tags: #Matrix #BinarySearch #OptimizedTraversal

/*
Problem Statement:
------------------
You are given an m x n matrix where each row is sorted in ascending order,
and the first element of each row is greater than the last element of the previous row.

Write an efficient algorithm to search for a given target value.

Example:
---------
Input:
matrix =
[
 [1, 3, 5, 7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
]
target = 3

Output: true
*/

import java.util.Scanner;

public class Question8 {

  // Function to search in a 2D sorted matrix
  public static boolean searchMatrix(int[][] matrix, int target) {
    int n = matrix.length, m = matrix[0].length;

    int row = 0, col = m - 1; // Start from top-right corner

    // Traverse the matrix
    while (row < n && col >= 0) {
      if (matrix[row][col] == target) {
        return true; // Found
      } else if (matrix[row][col] < target) {
        row++; // Move down if target is greater
      } else {
        col--; // Move left if target is smaller
      }
    }

    return false; // Not found
  }

  // Utility function to print the 2D matrix
  public static void print2DArray(int arr[][]) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + "\t");
      }
      System.out.println();
    }
  }

  // Main Function
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[][] arr = {
        { 1, 5, 8, 11, 100 },
        { 2, 10, 12, 21, 22 },
        { 29, 40, 45, 48, 68 },
        { 35, 46, 53, 98, 101 },
        { 37, 51, 54, 110, 120 },
    };

    System.out.print("Enter the target to search: ");
    int target = sc.nextInt();

    print2DArray(arr);

    // Print result
    if (searchMatrix(arr, target)) {
      System.out.println("✅ Target " + target + " found in the matrix!");
    } else {
      System.out.println("❌ Target " + target + " not found in the matrix.");
    }

    sc.close();
  }
}

/*
 * 🔍 Concept Recap:
 * ----------------
 * 1. Start from the top-right corner:
 * - If current > target → move left (col--)
 * - If current < target → move down (row++)
 * 2. Each step eliminates one row or one column → O(n + m)
 * 
 * ⏱️ Time Complexity: O(n + m)
 * 💾 Space Complexity: O(1)
 * 
 * 🧠 Quick Practice:
 * ------------------
 * 1. Modify this for a matrix sorted row-wise *and* column-wise.
 * 2. Try solving the same using binary search on the entire matrix (treat it as
 * a 1D array).
 */
