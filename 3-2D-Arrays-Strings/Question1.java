import java.util.*; // ✅ fixed: 'iimport' → 'import'

public class Question1 {
  public static void fillValues(int[][] arr, int n) {
    int m = arr[0].length;
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter elements of array: ");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[i][j] = sc.nextInt();
      }
    }

    System.out.println("The 2D array is: ");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }

    sc.close();

  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter size of row in 2D array: ");
    int n = sc.nextInt();
    
    System.out.print("Enter size of column in 2D array: ");
    int m = sc.nextInt();

    int[][] arr = new int[n][m];

    // System.out.println("Enter elements of array: ");
    // for (int i = 0; i < n; i++) {
    //   for (int j = 0; j < m; j++) {
    //     arr[i][j] = sc.nextInt();
    //   }
    // }

    // System.out.println("The 2D array is: ");
    // for (int i = 0; i < n; i++) {
    //   for (int j = 0; j < m; j++) {
    //     System.out.print(arr[i][j] + " ");
    //   }
    //   System.out.println();
    // }

    fillValues(arr, n);

    sc.close();
  }
}
