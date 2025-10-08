// Question 6: 
// Implement a function to calculate x^y in O(log y) time complexity using recursion.

// hint: if y is 0 return 1

public class Question7 {
  public static void printZigZag(int n) {
    if (n <= 0) {
      return;
    }

    System.out.print(n);
    printZigZag(n - 1);
    System.out.print(n);
    printZigZag(n - 1);
    System.out.print(n);
  }

  public static void main(String[] args) {
    // int n = 5;
    printZigZag(4);
  }
}
