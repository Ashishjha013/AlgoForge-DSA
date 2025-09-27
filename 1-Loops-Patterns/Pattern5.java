// Question No. 5
// Print the following pattern for n rows:

// hint: Use four loops, one for each direction.

import java.util.Scanner;

public class Pattern5 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the number of rows for the pattern: ");
    int rows = sc.nextInt();

    int totalLines = (2 * rows) + 1;
    int currentLine = 1;

    int stars = 1;
    int spaces = rows;

    while (currentLine <= totalLines) {
      for (int i = 1; i <= spaces; i++) {
        System.out.print("  ");
      }

      for (int i = 1; i <= stars; i++) {
        System.out.print("* ");
      }

      // Prepare for next line
      if (currentLine <= totalLines/2) {
        stars += 2;
        spaces--;
      } else {
        spaces++;
        stars -= 2;
      }
      System.out.println();
      currentLine++;
    }

    sc.close();
  }
}
