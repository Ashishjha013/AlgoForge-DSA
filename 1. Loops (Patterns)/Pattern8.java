import java.util.Scanner;

public class Pattern8 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the number of rows for the pattern: ");
    int rows = sc.nextInt();

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < rows; j++) {
        if (i + j == rows - 1) {
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
