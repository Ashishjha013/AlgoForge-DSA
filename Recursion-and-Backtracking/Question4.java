// Question 4: 
// Find factorial of a number using recursion

// hint: return 1 if n is 0 or 1, otherwise return n * fact(n-1)

public class Question4 {
  public static int fact(int n) {
    if (n <= 1) {
      return 1;
    }

    int fact = fact(n - 1);
    int ans = n * fact;

    return ans;
  }

  public static void main(String[] args) {
    int n = 5;
    int smallAns = fact(n);
    System.out.println(smallAns);
  }
}
