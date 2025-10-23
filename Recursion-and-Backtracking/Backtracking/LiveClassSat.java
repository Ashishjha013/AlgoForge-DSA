
public class LiveClassSat {
  public static void findAllSubsets(int arr[], int idx, int target, String ans) {
    if (idx == arr.length) {
      if (target == 0) {
        System.out.println(ans);
      }
      return;
    }

    findAllSubsets(arr, idx + 1, target - arr[idx], ans + arr[idx] + ", "); // yes call
    findAllSubsets(arr, idx + 1, target, ans); // no call
  }

  public static boolean isSafeTOPlaceHere(boolean board[][], int row, int col) {
    // vertical up
    for(int i=row-1; i>=0; i--) {
      if(board[i][col]) {
        return false;
      }
    }

    // diagonal left up
    for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
      if(board[i][j]) {
        return false;
      }
    }

    // diagonal right up
    for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++) {
      if(board[i][j]) {
        return false;
      }
    }

    return true;
  }

  public static void nQueens(boolean board[][], int n, int row, String ans) {
    if(row == n) {
      System.out.println(ans);
      return;
    }

    for(int col=0; col<n; col++) {
      if(isSafeTOPlaceHere(board, row, col)) {
        board[row][col] = true;
        nQueens(board, n, row + 1, ans + "(" + row + "," + col + ")");
        board[row][col] = false;
      }
    }
  }

  public static void main(String[] args) {
    // int arr[] = { 2, 5, 3, 1, 4, 6, -8 };
    // int target = 8;
    // findAllSubsets(arr, 0, target, "");

    int n = 4;
    boolean board[][] = new boolean[n][n];
    nQueens(board, n, 0, "");
  }
}
