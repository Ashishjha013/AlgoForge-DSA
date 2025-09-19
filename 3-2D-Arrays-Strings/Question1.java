// Question No. 1
// Print 2D arrays and fill values in it

// hint: use 2 loops
// 1st loop for rows
// 2nd loop for columns

public class Question1 {
  public static void print2DArrays(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + ", ");
      }
      System.out.println();
    }
  }

  public static void fillValues(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        arr[i][j] = (i + j);
      }
    }
  }

  public static void main(String[] args) {
    int[][] arr = new int[4][2];

    fillValues(arr);

    print2DArrays(arr);
  }
}
