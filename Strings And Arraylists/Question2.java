// Question No. 1
//

// hint: 
public class Question2 {
  public static String compressString(String str) {
    String ans = "";

    int count = 0;

    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i) == str.charAt(i - 1)) {
        count++;
      } else {
        ans = ans + str.charAt(i - 1) + count;
        count = 1;
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
