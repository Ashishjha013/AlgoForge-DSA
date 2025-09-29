// Question No. 1
// Multiply two matrices

// hint: use 3 loops
// 1st loop for rows
// 2nd loop for columns
// 3rd loop for multiplication and addition

import java.util.Arrays;

public class Question2 {
  public static int[][] multiplyTwoMatrices(int mat1[][], int mat2[][]) {
    int r1 = mat1.length, c1 = mat1[0].length;
    int r2 = mat2.length, c2 = mat2[0].length;

    if (c1 != r2) {
      System.out.println("Multiplication of these two matrices is not possible.");
      return new int[][] {};
    }

    int result[][] = new int[r1][c2];
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[0].length; j++) {

        int currAns = 0;
        for (int k = 0; k < c1; k++) {
          currAns += mat1[i][k] * mat2[k][j];
        }

        result[i][j] = currAns;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    // 3x3 matrix
    int[][] matrix1 = {
        { 1, 7, 11 },
        { 6, 2, 8 },
        { 9, 5, 3 },
        { 4, 12, 10 }
    };

    // 3x2 matrix
    int[][] matrix2 = {
        { 6, 5 },
        { 4, 1 },
        { 2, 3 }
    };

    int ans[][] = multiplyTwoMatrices(matrix1, matrix2);
    // Using Arrays.deepToString to print 2D arrays
    System.out.println("Matrix 1 : " + Arrays.deepToString(matrix1));
    System.out.println("Matrix 2 : " + Arrays.deepToString(matrix2));
    System.out.println("Matrix 3 : " + Arrays.deepToString(ans));
  }
}
