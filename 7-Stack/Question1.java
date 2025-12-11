// Question 1: Duplicate Brackets

import java.util.*;

public class Question1 {
  public static boolean isDuplicate(String str) {
    // Create a Stack to store characters
    Stack<Character> st = new Stack<>();

    // Traverse the given string character by character
    for (int i = 0; i < str.length(); i++) {
      // Get the current character
      char ch = str.charAt(i);

      // If the current character is a closing bracket
      if (ch == ')') {
        // Check for duplicate brackets
        if (st.peek() == '(') {
          return true;
        } else {
          // Pop elements from the stack until we find a '('
          while (st.peek() != '(') {
            st.pop();
          }
          // Pop the opening bracket '(' from the stack
          st.pop();
        }
        // If the current character is not a closing bracket
      } else {
        // Push the current character onto the stack
        st.push(ch);
      }
    }
    // If no duplicate brackets are found, return false
    return false;
  }

  public static void main(String[] args) {
    String str = "((a+b)+((c+d)))";
    System.out.println(isDuplicate(str)); // Output: true

    String str2 = "(a+b)+(c+d)";
    System.out.println(isDuplicate(str2)); // Output: false

    String str3 = "(a+b*(c-d))";
    System.out.println(isDuplicate(str3)); // Output: false

    String str4 = "(((a+b)+(c+d)+(e+f)))";
    System.out.println(isDuplicate(str4)); // Output: true
  }
}
