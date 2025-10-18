import java.util.ArrayList;

public class LiveClass {
  public static void printPermutations(String str, String ans) {
    if (str.length() == 0) {
      System.out.println(ans);
      return;
    }

    for (int i = 0; i < str.length(); i++) {
      char currChar = str.charAt(i);

      String ros = str.substring(0, i);
      String leftRemaining = str.substring(i + 1);
      printPermutations(ros, ans + currChar);
    }
  }

  public static int findMaxPath(int[][] mat, int row, int col) {
    if (row >= mat.length || col >= mat[0].length) {
      return Integer.MIN_VALUE;
    }
    if (row == mat.length - 1 && col == mat[0].length - 1) {
      return mat[row][col];
    }

    int rightPath = findMaxPath(mat, row, col + 1);
    int downPath = findMaxPath(mat, row + 1, col);

    return mat[row][col] + Math.max(rightPath, downPath);
  }

  public static void floodFIll(int row, int col, int[][] mat, boolean[][] visited, int n, int m, String psf) {
    if (row < 0 || col < 0 || row >= n || col >= m || mat[row][col] == 1 || visited[row][col] == true) {
      return;
    }
    if (row == n - 1 && col == m - 1) {
      System.out.println(psf);
      return;
    }

    visited[row][col] = true;

    floodFIll(row - 1, col, mat, visited, n, m, psf + "t");
    floodFIll(row, col - 1, mat, visited, n, m, psf + "l");
    floodFIll(row + 1, col, mat, visited, n, m, psf + "d");
    floodFIll(row, col + 1, mat, visited, n, m, psf + "r");

    visited[row][col] = false;
  }

  public static void main(String[] args) {
    // int[][] grid = {
    // { 11, 9, 14, 21 },
    // { -1, 8, 5, -41 },
    // { 20, 16, 4, 39 },
    // { 1, 3, 15, 8 }
    // };
    // int ans = findMaxPath(grid, 0, 0);
    // System.out.println(ans);

    int[][] mat = { { 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 1, 0 },
        { 0, 0, 0, 0, 0, 0, }, { 0, 1, 0, 1, 1, 0 },
        { 0, 1, 0, 1, 1, 0 }, { 0, 0, 0, 1, 1, 0 } };
    boolean[][] visited = new boolean[mat.length][mat[0].length];
    floodFIll(0, 0, mat, visited, mat.length, mat[0].length, ""); 
  }
}
