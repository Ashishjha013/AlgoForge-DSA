// Question No. 1
// Compress String

// hint: Use a new string to store the answer

public class Question1 {
  public static String compressString(String str) {
    String ans = "";
    ans += str.charAt(0);

    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i) != str.charAt(i - 1)) {
        ans += str.charAt(i);
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    String str = "aabbbcccdddeeeffggg";

    String compressedString = compressString(str);

    System.out.println(compressedString);
  }
}
