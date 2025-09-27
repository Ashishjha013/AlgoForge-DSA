// Question No. 2
// Print the following pattern for n rows:

// hint: Use one loop for rows and one loop for columns.

import java.util.Scanner;

public class Pattern7 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the number of rows for the pattern: ");
    int rows = sc.nextInt();

    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= rows; j++) {
        if (i == j) {
          System.out.print("* ");
        } else {
          System.out.print("  ");
        }
      }
      System.out.println();
    }

    sc.close();
  }
}
