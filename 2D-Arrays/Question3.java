// Question No. 3
// Find the exit point of a matrix

// hint: use while loop
// 1st loop for rows
// 2nd loop for columns
// 3rd loop for direction

public class Question3 {
  public static void findExitPoint(int mat[][]) {
    int n = mat.length, m = mat[0].length;

    int row = 0, col = 0;
    int dir = 0;

    while(row >= 0 && row < n && col >= 0 && col < m) {
      if(mat[row][col] == 1) {
        dir = (dir + 1) % 4;
      }

      if(dir == 0) {
        // Right
        col++;
      } else if(dir == 1) {
        // Down
        row++;
      } else if(dir == 2) {
        // Left
        col--;
      } else {
        // Up
        row--;
      }
    }

    if(dir == 0) {
      col++;
    } else if(dir == 1) {
      col--;
    } else if(dir == 2) {
      col++;
    } else {}

    System.out.println("Exit Point: (" + row + ", " + col + ")");
  }
  public static void main(String[] args) {
    int[][] binaryMatrix = {
        { 0, 0, 0, 1, 0, 0 },
        { 0, 1, 0, 0, 0, 0 },
        { 1, 0, 1, 0, 1, 0 },
        { 0, 1, 0, 1, 1, 0 },
        { 0, 0, 0, 0, 0, 1 }
    };

    findExitPoint(binaryMatrix);
  }
}
