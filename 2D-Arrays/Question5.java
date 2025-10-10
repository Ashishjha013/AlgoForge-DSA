// Question No. 5
// Print elements of a 2D array in spiral form
// --------------------------------------------
// Pattern: Spiral Traversal
// Level: Medium
// Tags: #Matrix #Traversal #Loops

/*
Problem Statement:
------------------
Given a 2D matrix, print its elements in spiral order,
starting from the top-left corner and moving inward
(clockwise direction).

Example:
---------
Input:
1   2   3   4
5   6   7   8
9  10  11  12

Output:
1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7, END
*/

public class Question5 {

  // Function to print matrix in spiral form
  public static void printSpiral(int arr[][]) {
    int n = arr.length; // number of rows
    int m = arr[0].length; // number of columns

    int startRow = 0, endRow = n - 1;
    int startCol = 0, endCol = m - 1;

    // Loop until all layers are printed
    while (startRow <= endRow && startCol <= endCol) {

      // 1️⃣ Top Wall (Left → Right)
      for (int j = startCol; j <= endCol; j++) {
        System.out.print(arr[startRow][j] + ", ");
      }
      startRow++;

      // 2️⃣ Right Wall (Top → Bottom)
      for (int i = startRow; i <= endRow; i++) {
        System.out.print(arr[i][endCol] + ", ");
      }
      endCol--;

      // 3️⃣ Bottom Wall (Right → Left)
      if (startRow <= endRow) {
        for (int j = endCol; j >= startCol; j--) {
          System.out.print(arr[endRow][j] + ", ");
        }
        endRow--;
      }

      // 4️⃣ Left Wall (Bottom → Top)
      if (startCol <= endCol) {
        for (int i = endRow; i >= startRow; i--) {
          System.out.print(arr[i][startCol] + ", ");
        }
        startCol++;
      }
    }

    System.out.println("END");
  }

  // Main function
  public static void main(String[] args) {
    int[][] arr = {
        { 1, 2, 3, 4, 5 },
        { 6, 7, 8, 9, 18 },
        { 13, 12, 11, 10, 19 },
    };

    printSpiral(arr);
  }
}

/*
 * Key Takeaways:
 * ---------------
 * 1. Maintain 4 boundaries: startRow, endRow, startCol, endCol.
 * 2. After traversing each wall, update that boundary.
 * 3. Continue until startRow > endRow or startCol > endCol.
 * 4. Time Complexity: O(n × m)
 * 
 * Quick Questions:
 * ----------------
 * 1. How would you modify it for *anticlockwise* spiral?
 * 2. What happens if the matrix has only one row or one column?
 * 3. How can you collect spiral elements in a list instead of printing?
 */
