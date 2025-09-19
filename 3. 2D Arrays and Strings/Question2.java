import java.util.*;

public class Question2 {
  public static int[][] multiplyMatices(int[][] arr1, int[][] arr2, int r1, int c1, int r2, int c2) {
    if (c1 != r2) {
      System.out.println(("Matrix multiplication not possible"));
      return null;
    }

    int[][] result = new int[r1][c2];
    for (int i = 0; i < r1; i++) {
      for (int j = 0; j < c2; j++) {
        for (int k = 0; k < c1; k++) {
          result[i][j] += arr1[i][k] * arr2[k][j];
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[][] arr1 = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };
    int[][] arr2 = { { 1, 2, 3 }, { 4, 5, 6 } };

    int r1 = arr1.length;
    int c1 = arr1[0].length;
    int r2 = arr2.length;
    int c2 = arr2[0].length;

    int[][] result = multiplyMatices(arr1, arr2, r1, c1, r2, c2);
    if (result != null) {
      System.out.println("Resultant matrix after multiplication is: ");
      for (int i = 0; i < r1; i++) {
        for (int j = 0; j < c2; j++) {
          System.out.print(result[i][j] + " ");
        }
        System.out.println();
      }
      System.out.println();
    }
  }
}
