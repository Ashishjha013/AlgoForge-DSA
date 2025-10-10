// Question No. 7
// LeetCode - 48. Rotate Image
// -----------------------------
// Pattern: Matrix Manipulation
// Level: Medium
// Tags: #Matrix #2DArray #Transpose #InPlaceRotation

/*
Problem Statement:
------------------
You are given an n × n 2D matrix representing an image.
Rotate the image 90 degrees (clockwise) in-place.

Example:
---------
Input:
[
 [5,  1,  9, 11],
 [2,  4,  8, 10],
 [13, 3,  6,  7],
 [15, 14, 12, 16]
]

Output:
[
 [15, 13, 2, 5],
 [14, 3, 4, 1],
 [12, 6, 8, 9],
 [16, 7, 10, 11]
]
*/

public class Question7 {

  // Step 1: Transpose the matrix
  // (Swap elements across the main diagonal)
  public static void transposeMatrix(int[][] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
      }
    }
  }

  // Step 2: Reverse each row
  // (This turns the transposed matrix into a 90° rotated one)
  public static void reverseRows(int matrix[][]) {
    int n = matrix.length;
    for (int row = 0; row < n; row++) {
      int start = 0, end = n - 1;
      while (start < end) {
        int temp = matrix[row][start];
        matrix[row][start] = matrix[row][end];
        matrix[row][end] = temp;
        start++;
        end--;
      }
    }
  }

  // Utility function to print a 2D matrix
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
        { 5, 1, 9, 11 },
        { 2, 4, 8, 10 },
        { 13, 3, 6, 7 },
        { 15, 14, 12, 16 },
    };

    transposeMatrix(arr); // Step 1
    reverseRows(arr); // Step 2
    print2DArray(arr); // Final Output
  }
}

/*
 * 🔍 Concept Recap:
 * ----------------
 * 1. Transpose swaps rows ↔ columns (flip over diagonal).
 * 2. Reversing each row gives a clockwise 90° rotation.
 * 3. To rotate counterclockwise, reverse columns instead.
 * 
 * ⏱️ Time Complexity: O(n²)
 * 💾 Space Complexity: O(1)
 * 
 * 🧠 Quick Practice:
 * ------------------
 * 1. Modify to rotate 90° counterclockwise.
 * 2. How would you rotate 180° without repeating work?
 * 3. Try the same logic for an anti-diagonal transpose.
 */
