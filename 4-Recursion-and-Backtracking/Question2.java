// Question 2: Print Increasing
// Print numbers from 1 to n using recursion

// hint: Call the function first with n-1, then print n

public class Question2 {
  public static void printIncreasing(int n) {
    if (n == 0) {
      return;
    }
    printIncreasing(n - 1);
    System.out.println(n);
  }

  public static void main(String[] args) {
    int n = 5;
    printIncreasing(n);
  }
}
