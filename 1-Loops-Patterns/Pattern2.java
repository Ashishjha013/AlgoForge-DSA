// Question No. 2
// Print the following pattern for n rows:

// hint: Use two loops, one for spaces and one for stars.

import java.util.Scanner;

public class Pattern2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the number of rows for the pattern: ");
    int rows = sc.nextInt();

    int totalLines = rows;
    int currentLine = 1;

    int stars = rows;

    while (currentLine <= totalLines) {
      for (int i = 1; i <= stars; i++) {
        System.out.print("* ");
      }

      // Prepare for next line
      System.out.println();
      stars--;
      currentLine++;
    }

    sc.close();
  }
}
