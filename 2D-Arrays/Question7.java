// Question No. 2
// transpose of a matrix

// hint: Use two loops, one for rows and one for columns.

public class Question7 {
  public static void transposeMatrix(int[][] arr) {
    int n = arr.length;
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
        { 1, 2, 3, 4, 5 },
        { 6, 7, 8, 9, 10 },
        { 11, 12, 13, 14, 15 },
        { 16, 17, 18, 19, 20 },
        { 21, 22, 23, 24, 25 },
    };

    // transposeMatrix(arr);
    print2DArray(arr);
  }
}
