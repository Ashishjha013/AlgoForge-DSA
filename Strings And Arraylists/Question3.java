// Question No. 1
//

// hint: 

public class Question3 {
  public static String compressString(String str) {
    String ans = "";

    int count = 0;

    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i) == str.charAt(i - 1)) {
        count++;
      } else {
        if(count > 1) {
          ans = ans + str.charAt(i - 1) + count;
          count = 1;
        } else {
          ans = ans + str.charAt(i - 1);
        }
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    String str = "aabbbcdddeeeffggg";

    String compressedString = compressString(str);

    System.out.println(compressedString);
  }
}
