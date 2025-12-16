// Question 6: Postfix expression evaluation using stacks

// approach similar to Question 5
// but here we directly evaluate postfix expression
// without needing to convert from infix to postfix
// we use a single stack to store operands
// and evaluate as we encounter operators
// when we see an operator, we pop top two operands
// from stack, apply the operator and push result back onto stack

import java.util.*;
public class Question6 {

  public static int evaluatePostfix(String exp) {
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < exp.length(); i++) {
      char ch = exp.charAt(i);

      while (Character.isDigit(ch)) {
        stack.push(ch - '0');
        break;
        
      }
    }

    return stack.pop();
  }

  public static void main(String[] args) {
    String exp = "23*54*+";
    int result = evaluatePostfix(exp);
    System.out.println("Result: " + result);
  }
}
