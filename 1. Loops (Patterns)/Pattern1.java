import java.util.Scanner;

public class Pattern1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the number of rows for the pattern: ");
    int rows = sc.nextInt();

    int totalLines = rows;
    int currentLine = 1;

    int stars = 1;
    int spaces = rows - 1;

    while (currentLine <= totalLines) {
      for(int i=1; i<=spaces; i++) {
        System.out.print("  ");
      }

      for (int i = 1; i <= stars; i++) {
        System.out.print("* ");
      }

      // Prepare for next line
      System.out.println();
      currentLine++;
      stars++;
      spaces--;
    }

    sc.close();
  }
}
