// Question 5:
// Find x raise to power y

// hint: Use recursion to multiply x, y times.

public class Question5 {
  // Question: 5
  public static int power(int x, int y) {
    if (y <= 0) {
      return 1;
    }

    int smallAns = power(x, y - 1);
    int ans = x * smallAns;
    return ans;
  }

  // Question: 5 (part - 2)
  // Optimized approach
  // Time Complexity: O(log y)
  public static int powerLog(int x, int y) {
    if (y <= 0) {
      return 1;
    }

    int smallAns = power(x, y / 2);
    int ans = smallAns * smallAns;
    if (y % 2 != 0) {
      ans = ans * x;
    }
    return ans;
  }

  public static void main(String[] args) {
    int result = powerLog(2, 5);
    System.out.println(result);
  }
}
