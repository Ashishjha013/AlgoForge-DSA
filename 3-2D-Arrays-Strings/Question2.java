// Question No. 2
// Multiply two matrices

// hint: use 3 loops
// 1st loop for rows of 1st matrix
// 2nd loop for columns of 2nd matrix
// 3rd loop for columns of 1st matrix / rows of 2nd matrix

public class Question2 {
  // function to multiply two matrices
  public static int[][] multiplyMatices(int[][] A, int[][] B) {
    // A's rows and columns
    int r1 = A.length, c1 = A[0].length;
    // B's rows and columns
    int r2 = B.length, c2 = B[0].length;

    if (c1 != r2) {
      System.out.println(("Matrix multiplication not possible"));
      return null;
    }

    int[][] result = new int[r1][c2];
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[0].length; j++) {
        for (int k = 0; k < c1; k++) {
          result[i][j] += A[i][k] * B[k][j];
        }
      }
    }
    return result;
  }

  // function to fill values in matrix
  public static void fillValues(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        arr[i][j] = (i + j);
      }
    }
  }

  // function to print matrix
  public static void print2DArrays(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + ", ");
      }
      System.out.println();
    }
  }

  // main function
  public static void main(String[] args) {
    int[][] A = new int[4][3];
    int[][] B = new int[3][2];
    fillValues(A);
    fillValues(B);

    int[][] result = multiplyMatices(A, B);
    print2DArrays(result);
  }
}
