// Question 5:
// Find x raise to power y

// hint: if y is 0 return 1, otherwise return x * pow(x, y-1)

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
    int result = pow(2, 5);
    System.out.println(result);
  }
}
