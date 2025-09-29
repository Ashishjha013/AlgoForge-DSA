// Question No. 7
// LeetCode - 48. Rotate Image

// hint: Use two loops, one for rows and one for columns.

public class Question7 {
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

  public static void reverse(int matrix[][]) {
    int n = matrix.length;

    for (int row = 0; row < n; row++) {
      int arr[] = matrix[row];
      int start = 0, last = n - 1;
      while (start < last) {
        int temp = arr[start];
        arr[start] = arr[last];
        arr[last] = temp;

        start++;
        last--;
      }
    }
  }

  public static void print2DArray(int arr[][]) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + ", ");
      }
      System.out.println();
    }
  }

  // main function
  public static void main(String[] args) {
    int[][] arr = {
        { 5, 1, 9, 11 },
        { 2, 4, 8, 10 },
        { 13, 3, 6, 7 },
        { 15, 14, 12, 16 },
    };

    transposeMatrix(arr);
    reverse(arr);
    print2DArray(arr);
  }
}
