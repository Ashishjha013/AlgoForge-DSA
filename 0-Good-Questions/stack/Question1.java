// Question 1: Reverse a String using Stack
// GFG = https://www.geeksforgeeks.org/reverse-a-string-using-stack

import java.util.*;

public class Question1 {
  public static String reverseString(String str) {
    Stack<Character> st = new Stack<>();
    int idx = 0;
    while (idx < str.length()) {
      st.push(str.charAt(idx));
      idx++;
    }

    StringBuilder result = new StringBuilder("");
    while (!st.isEmpty()) {
      char curr = st.pop();
      result.append(curr);
    }
    return result.toString();
  }

  public static void main(String[] args) {
    String str = "Ginnny";
    String result = reverseString(str);
    System.out.println(result);
  }
}
