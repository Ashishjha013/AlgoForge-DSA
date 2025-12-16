// Question 5: Calculate infix expression

import java.util.*;

public class Question5 {

  // FIX 1: make precedence static
  public static int precedence(char op) {
    if (op == '+' || op == '-') {
      return 1;
    }
    if (op == '*' || op == '/') {
      return 2;
    }
    return 0;
  }

  // FIX 2: add evaluate method
  public static int evaluate(int v1, int v2, char op) {
    if (op == '+')
      return v1 + v2;
    if (op == '-')
      return v1 - v2;
    if (op == '*')
      return v1 * v2;
    if (op == '/')
      return v1 / v2;
    return 0;
  }

  public static int calculateInfix(String exp) {

    Stack<Integer> operands = new Stack<>();
    Stack<Character> operators = new Stack<>();

    for (int i = 0; i < exp.length(); i++) {
      char ch = exp.charAt(i);

      if (ch >= '0' && ch <= '9') {
        operands.push(ch - '0');
      } else if (ch == '(') {
        operators.push(ch);
      } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

        while (!operators.isEmpty() &&
            operators.peek() != '(' &&
            precedence(operators.peek()) >= precedence(ch)) {

          char op = operators.pop();
          int v2 = operands.pop();
          int v1 = operands.pop();
          operands.push(evaluate(v1, v2, op));
        }
        operators.push(ch);
      } else if (ch == ')') {

        while (operators.peek() != '(') {
          char op = operators.pop();
          int v2 = operands.pop();
          int v1 = operands.pop();
          operands.push(evaluate(v1, v2, op));
        }
        operators.pop();
      }
    }

    while (!operators.isEmpty()) {
      char op = operators.pop();
      int v2 = operands.pop();
      int v1 = operands.pop();
      operands.push(evaluate(v1, v2, op));
    }

    return operands.pop();
  }

  public static void main(String[] args) {
    String exp = "2+3/5-8*4+3*(9+5-8*6)";
    int result = calculateInfix(exp);
    System.out.println("Result: " + result);
  }
}
