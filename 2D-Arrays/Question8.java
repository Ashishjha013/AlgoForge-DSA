// Question No. 8
// Seearch in 2D Sorted Array
// Leetcode: 74. Search a 2D Matrix

// hint: Start from top right corner

import java.util.Scanner;

public class Question8 {
  public static boolean searchMatrix(int[][] matrix, int target) {
    int n = matrix.length, m = matrix[0].length;

    int row = 0, col = m - 1;

    while(row < n && col >= 0) {
      if(matrix[row][col] == target) {
        return true;
      } else if (matrix[row][col] < target) {
        row++;
      } else {
        col--;
      }
    }
    return false;
  }

  // Function to print 2D array
  public static void print2DArray(int arr[][]) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + ", ");
      }
      System.out.println();
    }
  }

  // Main Function
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[][] arr = {
        { 1, 5, 8, 11, 100 },
        { 2, 10, 12, 21, 22 },
        { 29, 40, 45, 48, 68 },
        { 35, 46, 53, 98, 101 },
        { 37, 51, 54, 110, 120 },
    };

    System.out.print("Enter the target from 2D Matrix: ");
    int target = sc.nextInt();

    print2DArray(arr);
    searchMatrix(arr, target);

    sc.close();
  }
}
