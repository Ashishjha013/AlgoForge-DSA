// Question 4: 
// Find factorial of a number using "Recursion"

// hint: if n is 0 or 1 return 1, otherwise return n * factorial(n-1)

public class Question4 {
  public static int factorial(int n) {
    if (n <= 1) {
      return 1;
    }

    int smallAns = factorial(n - 1);
    int ans = n * smallAns;
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(factorial(5));
  }
}
