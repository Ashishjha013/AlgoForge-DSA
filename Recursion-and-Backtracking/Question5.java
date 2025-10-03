// Question 5: 
// Find power of a number using recursion

// hint: return 1 if y is 0, otherwise return x * pow(x, y-1)

public class Question5 {
  public static int pow(int x, int y) {
    if (y == 0) {
      return 1;
    }

    int smallAns = pow(x, y - 1);
    int ans = x * smallAns;

    return ans;
  }

  public static void main(String[] args) {
    // int n = 5;
    int smallAns = pow(2, 5);
    System.out.println(smallAns);
  }
}
