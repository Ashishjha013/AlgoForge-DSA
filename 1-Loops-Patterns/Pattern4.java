// Question No. 4
// Print the following pattern for n rows:

// hint: Use four loops, one for each direction.

import java.util.Scanner;

public class Pattern4 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the number of rows for the pattern: ");
    int rows = sc.nextInt();

    int totalLines = rows;
    int currentLine = 1;

    int stars = rows;
    int spaces = 0;

    while (currentLine <= totalLines) {
      for (int i = 1; i <= spaces; i++) {
        System.out.print("  ");
      }

      for (int i = 1; i <= stars; i++) {
        System.out.print("* ");
      }

      // Prepare for next line
      System.out.println();
      currentLine++;
      stars--;
      spaces++;
    }

    sc.close();
  }
}
