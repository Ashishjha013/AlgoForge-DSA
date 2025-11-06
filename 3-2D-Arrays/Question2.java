// Question 2: Multiply Two Matrices
// --------------------------------
// Pattern: Triple Nested Loop (Row × Column Multiplication)
// Level: Basic
// Tags: #Matrix #Loops #Implementation

/*
Core Idea:
-----------
For every cell result[i][j],
multiply the i-th row of mat1 with the j-th column of mat2 (dot product).

Condition:
Matrix multiplication is possible only if columns(mat1) == rows(mat2).

Formula:
result[i][j] = Σ (mat1[i][k] * mat2[k][j]) for k = 0 → c1-1
*/

import java.util.Arrays;

public class Question2 {

  // Function to multiply two matrices
  public static int[][] multiplyTwoMatrices(int[][] mat1, int[][] mat2) {
    int r1 = mat1.length, c1 = mat1[0].length;
    int r2 = mat2.length, c2 = mat2[0].length;

    // Check if multiplication is possible
    if (c1 != r2) {
      System.out.println("Matrix multiplication not possible");
      return new int[0][0]; // return empty matrix
    }

    // Resultant matrix will be of size r1 x c2
    int[][] res = new int[r1][c2];

    // Triple nested loop pattern
    for (int i = 0; i < r1; i++) { // Loop through rows of mat1
      for (int j = 0; j < c2; j++) { // Loop through columns of mat2
        for (int k = 0; k < c1; k++) { // Loop for dot product calculation
          res[i][j] += mat1[i][k] * mat2[k][j];
        }
      }
    }

    return res;
  }

  public static void main(String[] args) {
    // Input matrices
    int[][] a = {
        { 1, 7, 11 },
        { 6, 2, 8 },
        { 9, 5, 3 },
        { 4, 12, 10 }
    };

    int[][] b = {
        { 6, 5 },
        { 4, 1 },
        { 2, 3 }
    };

    // Call function
    int[][] ans = multiplyTwoMatrices(a, b);

    // Print result using Arrays.deepToString()
    System.out.println("Matrix 1: " + Arrays.deepToString(a));
    System.out.println("Matrix 2: " + Arrays.deepToString(b));
    System.out.println("Result  : " + Arrays.deepToString(ans));
  }
}

/*
 * Key Takeaways:
 * ---------------
 * 1. Matrix multiplication uses row × column dot product.
 * 2. Valid only if c1 == r2.
 * 3. Result matrix size → (r1 × c2)
 * 4. Time Complexity: O(n³)
 * 
 * Quick Questions:
 * ----------------
 * 1. Why must columns(A) == rows(B)?
 * 2. What happens if you forget to reset res[i][j] inside the loop?
 */
