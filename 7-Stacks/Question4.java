// Question 4: Stock Span (Next Greater on Left)
// GFG = https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1

import java.util.*;

public class Question4 {
  public static ArrayList<Integer> stockSpan(int[] prices) {
    int n = prices.length;
    ArrayList<Integer> span = new ArrayList<>();
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < n; i++) {
      int currentPrice = prices[i];

      while (!st.isEmpty() && prices[st.peek()] <= currentPrice) {
        st.pop();
      }

      if (st.isEmpty()) {
        span.add(i + 1);
      } else {
        span.add(i - st.peek());
      }

      st.push(i);
    }
    return span;
  }

  public static ArrayList<Integer> stockSpan1(int[] stocks) {
    Stack<Integer> st = new Stack<>();
    ArrayList<Integer> span = new ArrayList<>();
    span.add(1);
    st.push(0);

    for (int i = 1; i < stocks.length; i++) {
      int currPrice = stocks[i];

      while (!st.isEmpty() && currPrice > stocks[st.peek()]) {
        st.pop();
      }
      if (st.isEmpty()) {
        span.add(i + 1);
      } else {
        int prevHigh = st.peek();
        span.add(i - prevHigh);
      }
      st.push(i);
    }
    return span;
  }

  public static void main(String[] args) {
    // int[] stocks = { 100, 80, 60, 70, 60, 75, 85 };
    int[] stocks = { 100, 80, 60, 70, 60, 85, 100 };

  }
}
