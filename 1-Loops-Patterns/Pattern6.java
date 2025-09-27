// Question No. 6
// Print the following pattern for n rows:

// hint: Use two loops, one for spaces and one for stars.

import java.util.Scanner;

public class Pattern6 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the number of rows for the pattern: ");
    int rows = sc.nextInt();

    int totalLines = rows;
    int currentLine = 1;

    int stars = (rows / 2) + 1;
    int spaces = 1;

    while (currentLine <= totalLines) {
      for (int i = 1; i <= stars; i++) {
        System.out.print("* ");
      }

      for (int i = 1; i <= spaces; i++) {
        System.out.print("  ");
      }

      for (int i = 1; i <= stars; i++) {
        System.out.print("* ");
      }

      // Prepare for next line
      if (currentLine <= totalLines / 2) {
        stars--;
        spaces += 2;
      } else {
        stars++;
        spaces -= 2;
      }
      System.out.println();
      currentLine++;
    }

    sc.close();
  }
}
