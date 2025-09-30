// Question 1: 
// 

// hint:

public class Question6 {
  public static int powerLog(int x, int y) {
    if (y <= 0) {
      return 1;
    }

    int smallAns = powerLog(x, y / 2);
    int ans = smallAns * smallAns;

    if (y % 2 == 1) {
      return x * ans;
    }

    return ans;
  }

  public static void main(String[] args) {
    // int n = 5;
    int smallAns = powerLog(2, 9);
    System.out.println(smallAns);
  }
}
