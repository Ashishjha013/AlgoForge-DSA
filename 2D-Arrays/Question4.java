// Question No. 4
// Print elements of a 2D array in wave form
// ------------------------------------------
// Pattern: Column-wise Wave Traversal
// Level: Basic
// Tags: #Matrix #Traversal #Loops

/*
Problem Statement:
------------------
Given a 2D array (matrix), print its elements in wave form.

Wave Form Rule:
- For even column index (0, 2, 4...), traverse from top to bottom.
- For odd column index (1, 3, 5...), traverse from bottom to top.
*/

/*
Example:
--------
Matrix:
1  2  3
4  5  6
7  8  9

Output (wave form):
1 4 7 8 5 2 3 6 9
*/

public class Question4 {

  // Function to print elements of matrix in wave form
  public static void printWave(int[][] arr) {
    int n = arr.length; // number of rows
    int m = arr[0].length; // number of columns

    // Traverse each column one by one
    for (int j = 0; j < m; j++) {

      // For even columns → top to bottom
      if (j % 2 == 0) {
        for (int i = 0; i < n; i++) {
          System.out.print(arr[i][j] + ", ");
        }
      }
      // For odd columns → bottom to top
      else {
        for (int i = n - 1; i >= 0; i--) {
          System.out.print(arr[i][j] + ", ");
        }
      }
    }

    System.out.println("END"); // optional marker for output end
  }

  // Main function
  public static void main(String[] args) {
    int[][] arr = new int[5][5];

    // Fill the array with consecutive numbers
    int num = 1;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        arr[i][j] = num++;
      }
    }

    // Print in wave form
    printWave(arr);
  }
}

/*
 * Key Takeaways:
 * ---------------
 * 1. Wave traversal alternates direction on each column.
 * 2. Use column index (j) to decide traversal direction.
 * 3. Time Complexity: O(n × m)
 * 
 * Quick Questions:
 * ----------------
 * 1. How would the logic change for a *row-wise* wave form?
 * 2. What happens if n or m = 1 (edge case)?
 */
