// Question No. 2
// transpose of a matrix

// hint: Use two loops, one for rows and one for columns.

public class Question6 {
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

  // main function
  public static void main(String[] args) {
    int[][] arr = new int[5][5];

    int num = 1;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        arr[i][j] = num++;
      }
    }

    transposeMatrix(arr);
  }
}
