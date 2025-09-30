// Question 1: Print Decreasing
// Print numbers from n to 1 using recursion

// hint: Print n first, then call the function again with n-1

public class Question1 {
  public static void printDecreasing(int n) {
    if (n == 0) {
      return;
    }
    System.out.println(n);
    printDecreasing(n - 1);
  }
  public static void main(String[] args) {
    int n = 5;
    printDecreasing(n);
  }
}
