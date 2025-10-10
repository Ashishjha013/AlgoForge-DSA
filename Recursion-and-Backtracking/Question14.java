// ------------------------------------------------------------
// 🧮 Question 14: Get All Subsequences of a String
// ------------------------------------------------------------
//
// Pattern: Recursion + Backtracking (Include / Exclude) 
// Level: 🟡 Medium
// Tags: #Recursion #Strings #Backtracking
//
// ------------------------------------------------------------
// 🔹 Core Idea:
// Build subsequences recursively by deciding for each character:
// - Include it in the current subsequence ("yes")  
// - Exclude it from the current subsequence ("no")  
// Continue until all characters are processed.
//
// Base case: Empty string → return list with empty string.
//
// ------------------------------------------------------------

import java.util.*;

public class Question14 {

  public static ArrayList<String> getSubSequences(String str) {
    // Base case: if string is empty, return list containing empty string
    if (str.length() == 0) {
      ArrayList<String> baseAns = new ArrayList<>();
      baseAns.add("");
      return baseAns;
    }

    // Remove first character and get subsequences of remaining string
    String smallerString = str.substring(1);
    ArrayList<String> smallAns = getSubSequences(smallerString);

    char firstChar = str.charAt(0);

    ArrayList<String> allSubs = new ArrayList<>();

    // "No" branch: skip first character
    for (String s : smallAns) {
      allSubs.add(s);
    }

    // "Yes" branch: include first character
    for (String s : smallAns) {
      allSubs.add(firstChar + s);
    }

    return allSubs;
  }

  public static void main(String[] args) {
    String str = "abc";
    ArrayList<String> ans = getSubSequences(str);
    System.out.println("All subsequences of `" + str + "` are: ");
    System.out.println(ans);
  }
}

// ------------------------------------------------------------
// 🧭 Key Takeaways
// ------------------------------------------------------------
// - For each character, we have two choices: include or exclude
// - Base case returns list with empty string to start building subsequences
// - Time Complexity: O(2^n) as every character doubles the number of
// subsequences
// - Space Complexity: O(2^n) for the output list + recursion stack
//
// ------------------------------------------------------------
// 🧠 Quick Questions
// ------------------------------------------------------------
// 1. How does the recursive tree look for input "abc"?
// 2. What changes if we want only subsequences of length k?
// 3. How to generate subsequences without using extra space for lists
// (in-place)?
// ------------------------------------------------------------
