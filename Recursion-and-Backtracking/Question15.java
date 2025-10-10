// ------------------------------------------------------------
// 🧮 Question 15: Get Keypad Combinations
// ------------------------------------------------------------
//
// Pattern: Recursion + Backtracking (Digit to Letter Mapping) 
// Level: 🟡 Medium
// Tags: #Recursion #Strings #Backtracking #Keypad
//
// ------------------------------------------------------------
// 🔹 Core Idea:
// Each digit maps to a set of letters (like on a phone keypad).  
// Recursively generate all combinations by:
// - Picking one letter for the current digit  
// - Appending it to all combinations of remaining digits
//
// Base case: Empty string → return list containing empty string.
//
// ------------------------------------------------------------

import java.util.*;

public class Question15 {

  // Mapping digits to letters (0 and 1 are dummy)
  static String[] lettersArray = { ",:", "<;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

  public static ArrayList<String> getKeypadCombinations(String str) {
    // Base case: if string is empty, return list with empty string
    if (str.length() == 0) {
      ArrayList<String> baseAns = new ArrayList<>();
      baseAns.add("");
      return baseAns;
    }

    // Recursively get combinations of remaining digits
    String smallerString = str.substring(1);
    ArrayList<String> smallerAns = getKeypadCombinations(smallerString);

    ArrayList<String> myAns = new ArrayList<>();
    int firstDigit = str.charAt(0) - '0';
    String letters = lettersArray[firstDigit];

    // Combine each letter of current digit with combinations from remaining digits
    for (int i = 0; i < letters.length(); i++) {
      char letter = letters.charAt(i);
      for (String s : smallerAns) {
        myAns.add(letter + s);
      }
    }

    return myAns;
  }

  public static void main(String[] args) {
    String input = "84";
    ArrayList<String> combinations = getKeypadCombinations(input);
    System.out.println(combinations);
  }
}

// ------------------------------------------------------------
// 🧭 Key Takeaways
// ------------------------------------------------------------
// - Each recursive call handles one digit at a time.
// - Base case returns empty string to start building combinations.
// - Time Complexity: O(4^n) in worst case (because digits like 7,9 have 4
// letters)
// - Space Complexity: O(4^n) for output list + recursion stack
//
// ------------------------------------------------------------
// 🧠 Quick Questions
// ------------------------------------------------------------
// 1. How does recursion ensure that all letter combinations are generated?
// 2. What changes if you want only combinations of length k?
// 3. How would you implement it iteratively using a queue?
// ------------------------------------------------------------
