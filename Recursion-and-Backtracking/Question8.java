// Question 8: Implement the Tower of Hanoi problem using recursion.

public class Question8 {
  public static void towerOfHanoi(int n, int A, int B, int C) {
    if (n == 0) {
      return;
    }

    towerOfHanoi(n - 1, A, B, C);

    System.out.println("Move disk " + n + " from rod " + A + " to rod " + B);

    towerOfHanoi(n - 1, B, A, C);
  }

  public static void main(String[] args) {
    towerOfHanoi(3, 1, 2, 3);
    // System.out.println();
  }
}
