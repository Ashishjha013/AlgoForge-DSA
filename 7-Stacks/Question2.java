// Question 2: Valid Parentheses
// LeetCode Problem: 20. Valid Parentheses

import java.util.*;

public class Question2 {
  // Function to check if the parentheses in the string are valid
  public static boolean isValid(String str) {
    Stack<Character> st = new Stack<>();

    // Traverse the string
    for (int i = 0; i < str.length(); i++) {
      // Get the current character
      char ch = str.charAt(i);

      // If it's an opening bracket, push it onto the stack
      if (ch == '(' || ch == '{' || ch == '[') {
        st.push(ch);
        // If it's a closing bracket, check for matching opening bracket
      } else if (ch == ')' || ch == '}' || ch == ']') {
        // If stack is empty or top doesn't match, return false
        if (st.isEmpty()) {
          return false;
        }
        // Pop the top element and check for matching
        char top = st.pop();
        if ((ch == ')' && top != '(') ||
            (ch == '}' && top != '{') ||
            (ch == ']' && top != '[')) {
          return false;
        }
      }
    }
    // If stack is empty, all brackets were matched
    return st.isEmpty();
  }

  // Main method to test the isValid function
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
