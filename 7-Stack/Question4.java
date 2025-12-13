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

      while (st.size() > 0 && prices[st.peek()] <= currentPrice) {
        st.pop();
      }

      if (st.size() == 0) {
        span.add(i + 1);
      } else {
        span.add(i - st.peek());
      }

      st.push(i);
    }
    return span;
  }
  public static void main(String[] args) {
    int[] prices = { 100, 80, 60, 70, 60, 75, 85 };
    ArrayList<Integer> span = stockSpan(prices);
    System.out.println(span); // Output: [1, 1, 1, 2, 1, 4, 6]
  }
}
