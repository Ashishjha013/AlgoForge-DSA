// Question No. 1
// Toggle Case of a String

// hint: Use a new string to store the answer

public class Question4 {
  public static String toggleCase(String str) {
    String ans = "";

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (Character.isUpperCase(ch)) {
        ans = ans + Character.toLowerCase(ch);
      } else {
        ans = ans + Character.toUpperCase(ch);
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    String str = "AbcdEfgh";
    String result = toggleCase(str);
    System.out.println(result);
  }
}
