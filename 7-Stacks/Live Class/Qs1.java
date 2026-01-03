// Merge Intervals using Stack

import java.util.*;
import java.util.Stack;

public class Qs1 {
  class Pair {
    int startTime;
    int endTime;

    public Pair(int startTime, int endTime) {
      this.startTime = startTime;
      this.endTime = endTime;
    }
  }

  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (int[] a, int[] b) -> {
      if (a[0] == b[0]) {
      }
      return a[0] - b[0]; // increasing order on the basis of 0th index, for decreasing b[0] - a[0];
    });

    int n = intervals.length;
    Pair[] timeIntervals = new Pair[n];
    for (int i = 0; i < n; i++) {
      timeIntervals[i] = new Pair(intervals[i][0], intervals[i][1]);
    }

    Stack<Pair> st = new Stack<>();
    for (int i = 0; i < n; i++) {
      Pair current = timeIntervals[i];

      if (st.size() > 0 && st.peek().endTime >= current.startTime) {
        Pair prev = st.pop();

        current.startTime = prev.startTime; // merge start
        current.endTime = Math.max(prev.endTime, current.endTime); // merge end
      }
      st.push(current);
    }

    int[][] ans = new int[st.size()][2];
    // order of answer doesn't matter
    for (int i = 0; i < ans.length; i++) {
      ans[i][0] = st.peek().startTime;
      ans[i][1] = st.peek().endTime;

      st.pop();
    }

    return ans;
  }

  public static void main(String[] args) {
    Qs1 solution = new Qs1();
    int[][] intervals = { { 1, 3 }, { 2, 4 }, { 5, 7 }, { 6, 8 } };
    int[][] mergedIntervals = solution.merge(intervals);

    System.out.println("Merged Intervals:");
    for (int[] interval : mergedIntervals) {
      System.out.println(Arrays.toString(interval));
    }
  }
}
