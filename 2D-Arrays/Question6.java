// Question No. 6
// Transpose of a Matrix
// ----------------------
// Pattern: Matrix Manipulation
// Level: Easy
// Tags: #Matrix #2DArray #Swap

/*
Problem Statement:
------------------
Given a square matrix (n x n), find its transpose.
The transpose of a matrix is formed by flipping it over its main diagonal.

Example:
---------
Input:
1 2 3
4 5 6
7 8 9

Output:
1 4 7
2 5 8
3 6 9
*/

public class Question6 {

  // Function to transpose a square matrix in-place
  public static void transposeMatrix(int[][] arr) {
    int n = arr.length;

    // Only traverse upper triangle (excluding diagonal)
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        // Swap symmetric elements across the diagonal
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
      }
    }
  }

  // Function to print 2D array
  public static void print2DArray(int arr[][]) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + ", ");
      }
      System.out.println();
    }
  }

  // Main Function
  public static void main(String[] args) {
    int[][] arr = {
        { 1, 2, 3, 4, 5 },
        { 6, 7, 8, 9, 10 },
        { 11, 12, 13, 14, 15 },
        { 16, 17, 18, 19, 20 },
        { 21, 22, 23, 24, 25 },
    };

    transposeMatrix(arr); // Step 1: Transpose
    print2DArray(arr); // Step 2: Print result
  }
}

/*
 * 🔍 Concept Recap:
 * ----------------
 * 1. Transpose swaps rows with columns → arr[i][j] ↔ arr[j][i].
 * 2. We traverse only half the matrix (above diagonal) to avoid double
 * swapping.
 * 3. Works only for square matrices (n == m).
 * 
 * 🧠 Quick Practice Questions:
 * ----------------------------
 * 1. How would you transpose a rectangular (non-square) matrix?
 * 2. What if you want to return a *new* transposed matrix instead of modifying
 * in-place?
 * 3. Can you print the transpose without actually changing the matrix?
 * 
 * ⏱️ Time Complexity: O(n²)
 * 💾 Space Complexity: O(1)
 */
