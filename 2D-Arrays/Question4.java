// Question No. 2
// Print element of array in wave form

// hint: Use two loops, one for rows and one for columns.

public class Question4 {
  // function to print array in wave form
  public static void printWave(int[][] arr) {
    int n = arr.length, m = arr[0].length;

    for (int j = 0; j < m; j++) {

      if (j % 2 == 0) {
        for (int i = 0; i < n; i++) {
          System.out.print(arr[i][j] + ", ");
        }
      } else {
        for (int i = n - 1; i >= 0; i--) {
          System.out.print(arr[i][j] + ", ");
        }
      }

      System.out.println();
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

    printWave(arr);
  }
}
