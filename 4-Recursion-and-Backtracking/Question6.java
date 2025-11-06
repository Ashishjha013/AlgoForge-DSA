// Question 6:
// Print Zig-Zag pattern

// hint: Print n, call for n-1, print n, call for n-1, print n.

public class Question6 {
  public static void printZigZag(int n) {
    if (n <= 0) {
      return;
    }
    
    System.out.print(n + " ");
    printZigZag(n - 1);
    System.out.print(n + " ");
    printZigZag(n - 1);
    System.out.print(n + " ");
  }

  public static void main(String[] args) {
    printZigZag(4);
  }
}
