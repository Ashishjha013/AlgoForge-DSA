// Question No. 2
// Print in spiral form

// hint: Use four loops, one for each direction.

public class Question5 {
  // function to print array in spiral form
  public static void printSpiral(int arr[][]) {
    int n = arr.length, m = arr[0].length;

    int startRow = 0, endRow = n - 1;
    int startCol = 0, endCol = m - 1;

    while (startRow <= endRow && startCol <= endCol) {
      // Left Wall
      for (int i = startRow; i <= endRow; i++) {
        System.out.print(arr[i][startCol] + ", ");
      }
      startCol++;

      // Bottom Wall
      for (int i = startCol; i <= endCol; i++) {
        System.out.print(arr[endRow][i] + ", ");
      }
      endRow--;

      // Right Wall
      if (startCol <= endCol) {
        for (int i = endRow; i >= startRow; i--) {
          System.out.print(arr[i][endCol] + ", ");
        }
        endCol--;
      }

      // Top Wall
      if (startRow <= endRow) {
        for (int i = endCol; i >= startCol; i--) {
          System.out.print(arr[startRow][i] + ", ");
        }
        startRow++;
      }
    }
  }

  // main function
  public static void main(String[] args) {
    int[][] arr = {
        { 1, 2, 3, 4, 5 },
        { 6, 7, 8, 9, 18 },
        { 13, 12, 11, 10, 19 },
    };

    printSpiral(arr);
  }
}
