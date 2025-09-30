// Question 1: 
// 

// hint:

public class Question4 {
  public static int fact(int n) {
    if (n <= 1) {
      return n;
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
