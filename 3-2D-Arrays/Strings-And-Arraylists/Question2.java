// Question No. 1
// Compress String 

// hint: Use a new string to store the answer
public class Question2 {
  public static String compressString(String str) {
    String ans = "";
    if (str == null || str.isEmpty())
      return ans;

    int count = 1; // current run length (start with 1 for the first char)

    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i) == str.charAt(i - 1)) {
        count++;
      } else {
        ans = ans + str.charAt(i - 1) + count;
        count = 1;
      }
    }
    // flush the last run
    ans = ans + str.charAt(str.length() - 1) + count;

    return ans;
  }

  public static void main(String[] args) {
    String str = "aabbbcccdddeeeffggg";

    String compressedString = compressString(str);

    System.out.println(compressedString);
  }
}
