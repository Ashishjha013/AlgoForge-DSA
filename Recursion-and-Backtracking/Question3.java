// Question 1: Print numbers from n to 1, print again from 1 to n using recursion
// 

// hint: first print from n to 1, then print from 1 to n

public class Question3 {
  public static void printDecreasingIncreasing(int n) {
    if (n == 1) {
      System.out.print(n + " ");
      return;
    }
    System.out.print(n + " ");
    printDecreasingIncreasing(n - 1);
    System.out.print(n + " ");
  }

  public static void main(String[] args) {
    int n = 5;
    printDecreasingIncreasing(n);
  }
}
