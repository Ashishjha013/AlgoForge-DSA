// Question 16:
// Get all paths to climb stairs

// hint: Use a recursive function that explores all possible steps (1, 2, or 3) from the current stair. For each step, recursively call the function with the remaining stairs until you reach the base case of 0 stairs left. Collect and return all valid paths.

import java.util.*;

public class Question16 {
  public static ArrayList<String> getStairPaths(int n) {
    if (n == 0) {
      ArrayList<String> baseAns = new ArrayList<>();
      baseAns.add("");
      return baseAns;
    }
    if (n < 0) {
      ArrayList<String> baseAns = new ArrayList<>();
      return baseAns;
    }

    ArrayList<String> pathsAfterOneStep = getStairPaths(n - 1);
    ArrayList<String> pathsAfterTwoStep = getStairPaths(n - 2);
    ArrayList<String> pathsAfterThreeStep = getStairPaths(n - 3);

    ArrayList<String> allPaths = new ArrayList<>();

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
    ArrayList<String> ans = getStairPaths(4);
    System.out.println(ans);
  }
}
