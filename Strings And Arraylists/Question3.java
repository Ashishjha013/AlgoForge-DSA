// Question No. 1
//

// hint: 

public class Question3 {
  public static String compressString(String str) {
    String ans = "";

    if (str == null || str.isEmpty())
      return ans;

    int count = 1; // start count at 1 for the first character

    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i) == str.charAt(i - 1)) {
        count++;
      } else {
        if (count > 1) {
          ans = ans + str.charAt(i - 1) + count;
        } else {
          ans = ans + str.charAt(i - 1);
        }
        count = 1; // reset for new run
      }
    }
    // flush the last run
    if (count > 1) {
      ans = ans + str.charAt(str.length() - 1) + count;
    } else {
      ans = ans + str.charAt(str.length() - 1);
    }

    return ans;
  }

  public static void main(String[] args) {
    String str = "aabbbcdddeeeffggg";

    String compressedString = compressString(str);

    System.out.println(compressedString);
  }
}
