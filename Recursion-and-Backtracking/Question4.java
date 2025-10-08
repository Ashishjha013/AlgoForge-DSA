// Question 4: 
// Find factorial of a number using recursion

// hint: return 1 if n is 0 or 1, otherwise return n * fact(n-1)

public class Question4 {
  public static int power(int x, int y) {
    if (y <= 1) {
      return 1;
    }

    int pow = x * power(x, y - 1);
    // int ans = x * smallPower;
    return pow;
  }

  public static void main(String[] args) {
    System.out.println(power(2, 5));
  }
}
