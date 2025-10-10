// ------------------------------------------------------------
// 🧮 Question 16: Get All Paths to Climb Stairs
// ------------------------------------------------------------
//
// Pattern: Recursion + Backtracking (Staircase Problem) 
// Level: 🟡 Medium
// Tags: #Recursion #Backtracking #DP_Concept
//
// ------------------------------------------------------------
// 🔹 Core Idea:
// From a stair with n steps remaining, you can take 1, 2, or 3 steps.  
// Recursively explore all options until you reach the base case:
// - n == 0 → valid path completed  
// - n < 0  → invalid path, return empty list
//
// Each path is represented as a string of steps taken.
//
// ------------------------------------------------------------

import java.util.*;

public class Question16 {

  public static ArrayList<String> getStairPaths(int n) {
    // Base case: exactly 0 stairs left → valid path
    if (n == 0) {
      ArrayList<String> baseAns = new ArrayList<>();
      baseAns.add("");
      return baseAns;
    }

    // Base case: negative stairs → invalid path
    if (n < 0) {
      return new ArrayList<>();
    }

    // Recursive calls for 1, 2, and 3 steps
    ArrayList<String> pathsAfterOneStep = getStairPaths(n - 1);
    ArrayList<String> pathsAfterTwoStep = getStairPaths(n - 2);
    ArrayList<String> pathsAfterThreeStep = getStairPaths(n - 3);

    ArrayList<String> allPaths = new ArrayList<>();

    // Add current step to all paths returned by recursion
    for (String s : pathsAfterOneStep) {
      allPaths.add("1" + s);
    }
    for (String s : pathsAfterTwoStep) {
      allPaths.add("2" + s);
    }
    for (String s : pathsAfterThreeStep) {
      allPaths.add("3" + s);
    }

    return allPaths;
  }

  public static void main(String[] args) {
    int stairs = 4;
    ArrayList<String> ans = getStairPaths(stairs);
    System.out.println(ans);
  }
}

// ------------------------------------------------------------
// 🧭 Key Takeaways
// ------------------------------------------------------------
// - Each recursive call represents all possible steps from current stair.
// - Base cases: n==0 (path complete), n<0 (invalid path).
// - Time Complexity: O(3^n), Space Complexity: O(3^n) for output + recursion
// stack.
//
// ------------------------------------------------------------
// 🧠 Quick Questions
// ------------------------------------------------------------
// 1. How does recursion tree look for n = 3?
// 2. How would you optimize this using DP / memoization?
// 3. How to modify the code if allowed steps are only {1, 2}?
// ------------------------------------------------------------
