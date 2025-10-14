// ------------------------------------------------------------
// 🧮 Question 16: Get All Paths to Climb Stairs
// ------------------------------------------------------------
// 🧩 Find all possible ways to climb n stairs using 1, 2, or 3 steps at a time
// 🔑 Recursion + Backtracking - explore all choices, collect valid paths
// 💡 For each stair, try all 3 options, recursively solve remaining stairs
//
// Pattern: Recursion + Backtracking (Staircase Problem)
// Level: 🟡 Medium
// Tags: #Recursion #Backtracking #PathGeneration
// ------------------------------------------------------------

import java.util.*;

public class Question16 {

  public static ArrayList<String> getStairPaths(int n) {
    // WHY: Base case - reached destination (0 stairs left)
    // WHAT: Return list with empty string (represents one valid complete path)
    // HOW: Empty string will be prefixed with steps taken during recursion
    if (n == 0) {
      ArrayList<String> baseAns = new ArrayList<>();
      baseAns.add(""); // One valid path exists with 0 moves needed
      return baseAns;
    }

    // WHY: Invalid case - overshot the target (negative stairs)
    // WHAT: Return empty list (no valid paths from this state)
    // HOW: This branch will contribute 0 paths to final answer
    if (n < 0) {
      return new ArrayList<>();
    }

    // WHY: Explore all 3 choices available at current stair
    // WHAT: Get all possible paths after taking 1, 2, or 3 steps
    // HOW: Recursively solve smaller subproblems (n-1, n-2, n-3)
    ArrayList<String> pathsAfterOneStep = getStairPaths(n - 1); // Take 1 step
    ArrayList<String> pathsAfterTwoStep = getStairPaths(n - 2); // Take 2 steps
    ArrayList<String> pathsAfterThreeStep = getStairPaths(n - 3); // Take 3 steps

    // WHY: Collect all paths from all choices
    // WHAT: Combine paths from all 3 recursive calls
    // HOW: Prefix each returned path with the step we took to get there
    ArrayList<String> allPaths = new ArrayList<>();

    // WHY: Prepend "1" to show we took 1 step first
    // WHAT: For each path after taking 1 step, add "1" at beginning
    // HOW: "1" + remaining_path = complete path starting with 1-step
    for (String s : pathsAfterOneStep) {
      allPaths.add("1" + s);
    }

    // WHY: Prepend "2" to show we took 2 steps first
    // WHAT: For each path after taking 2 steps, add "2" at beginning
    // HOW: "2" + remaining_path = complete path starting with 2-step
    for (String s : pathsAfterTwoStep) {
      allPaths.add("2" + s);
    }

    // WHY: Prepend "3" to show we took 3 steps first
    // WHAT: For each path after taking 3 steps, add "3" at beginning
    // HOW: "3" + remaining_path = complete path starting with 3-step
    for (String s : pathsAfterThreeStep) {
      allPaths.add("3" + s);
    }

    return allPaths; // Return all valid paths from current stair
  }

  public static void main(String[] args) {
    int stairs = 4;
    ArrayList<String> ans = getStairPaths(stairs);
    System.out.println(ans); // Output: [1111, 112, 121, 211, 22, 13, 31]
  }
}

// ------------------------------------------------------------
// ⚡ Complexity Analysis
// ------------------------------------------------------------
// Time: O(3^n) - At each step, 3 recursive calls, depth = n
// Space: O(3^n) - Storing all possible paths + O(n) recursion stack
//
// ------------------------------------------------------------
// 🎯 Pattern: Path Generation using Recursion
// 🗣️ Interview: "Try all 3 choices at each step, prepend choice to paths from
// subproblems"
//
// ------------------------------------------------------------
// 🧠 Revision Questions
// ------------------------------------------------------------
// Q1. Recursion Tree for n=3?
// getStairPaths(3)
// ├─ 1 + getStairPaths(2)
// ├─ 2 + getStairPaths(1)
// └─ 3 + getStairPaths(0) ✓
//
// Q2. DP Optimization?
// Memoize count of paths (not paths themselves) → O(n) time
//
// Q3. Only {1,2} steps allowed?
// Remove pathsAfterThreeStep and its loop
//
// ------------------------------------------------------------
// 🔥 Key Insight:
// This is "top-down" thinking: "I'm at step n, what are my choices?"
// Could also solve "bottom-up": Build paths from 0 to n
// ------------------------------------------------------------
