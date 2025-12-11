// Question 2: Check for balanced parentheses in a string using a stack

import java.util.*;
public class Question2 {
  public static boolean isValid(String str) {
    Stack<Character> st = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (ch == '(' || ch == '{' || ch == '[') {
        st.push(ch);
      } else if (ch == ')' || ch == '}' || ch == ']') {
        if (st.isEmpty()) {
          return false;
        }
        char top = st.pop();
        if ((ch == ')' && top != '(') ||
            (ch == '}' && top != '{') ||
            (ch == ']' && top != '[')) {
          return false;
        }
      }
    }
    return st.isEmpty();
  }
  public static void main(String[] args) {
    String str1 = "{[()]}";
    System.out.println(isValid(str1)); // Output: true

    String str2 = "{[(])}";
    System.out.println(isValid(str2)); // Output: false

    String str3 = "{{[[(())]]}}";
    System.out.println(isValid(str3)); // Output: true

    String str4 = "((())";
    System.out.println(isValid(str4)); // Output: false
  }
}
