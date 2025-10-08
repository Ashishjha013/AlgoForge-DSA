// Question 6: 
//  Find x raise to power y in log(y) time

// hint: if y is 0 return 1, otherwise if y is even return powerLog(x, y/2) * powerLog(x, y/2), else return x * powerLog(x, y/2) * powerLog(x, y/2)

public class Question6 {
  public static int powerLog(int x, int y) {
    if (y <= 0) {
      return 1;
    }

    int smallAns = powerLog(x, y / 2);
    int ans = smallAns * smallAns;
    if (y % 2 != 0) {
      ans = ans * x;
    }

    return ans;
  }

  public static void main(String[] args) {
    // int n = 5;
    int smallAns = powerLog(2, 9);
    System.out.println(smallAns);
  }
}
