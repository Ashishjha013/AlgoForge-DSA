// ------------------------------------------------------------
// 🧮 Question 15: Get Keypad Combinations (Letter Combinations of Phone Number)
// ------------------------------------------------------------
// 🧩 Generate all letter combinations for a digit string (phone keypad mapping)
// 🔑 Recursion + Backtracking - pick one letter per digit, explore all choices
// 💡 For first digit's letters, combine each with all combos of remaining digits
//
// Pattern: Recursion + Backtracking (Digit to Letter Mapping)
// Level: 🟡 Medium | LeetCode #17
// Tags: #Recursion #Strings #Backtracking #Keypad
// ------------------------------------------------------------

import java.util.*;

public class Question15 {

  // WHY: Store digit-to-letter mapping (like phone keypad)
  // WHAT: Array where index = digit, value = possible letters
  // HOW: lettersArray[2] = "abc", lettersArray[3] = "def", etc.
  static String[] lettersArray = {
      ",:", // 0 (not typically used)
      "<;", // 1 (not typically used)
      "abc", // 2
      "def", // 3
      "ghi", // 4
      "jkl", // 5
      "mno", // 6
      "pqrs", // 7
      "tuv", // 8
      "wxyz" // 9
  };

  public static ArrayList<String> getKeypadCombinations(String str) {

    // WHY: Base case - no more digits to process
    // WHAT: Return list with empty string (represents one valid path)
    // HOW: Empty string will be prefixed with letters during backtracking
    if (str.length() == 0) {
      ArrayList<String> baseAns = new ArrayList<>();
      baseAns.add(""); // One combination exists: empty sequence
      return baseAns;
    }

    // WHY: Divide problem - process first digit separately
    // WHAT: Get all combinations for remaining digits
    // HOW: Recursively solve substring(1) to end
    String smallerString = str.substring(1); // Remove first digit
    ArrayList<String> smallerAns = getKeypadCombinations(smallerString);

    // WHY: Prepare to build final combinations
    // WHAT: List to store all combinations with first digit included
    // HOW: Combine first digit's letters with smallerAns
    ArrayList<String> myAns = new ArrayList<>();

    // WHY: Extract the first digit from input string
    // WHAT: Convert character to integer (e.g., '2' → 2)
    // HOW: ASCII math: '2' - '0' = 2
    int firstDigit = str.charAt(0) - '0';

    // WHY: Get all possible letters for this digit
    // WHAT: Fetch mapped letters from array (e.g., 2 → "abc")
    // HOW: Use firstDigit as index into lettersArray
    String letters = lettersArray[firstDigit];

    // WHY: Generate all combinations by trying each letter
    // WHAT: For each letter of current digit, combine with all smaller answers
    // HOW: Nested loops - outer for letters, inner for existing combinations
    for (int i = 0; i < letters.length(); i++) {
      char letter = letters.charAt(i); // Pick one letter (e.g., 'a')

      // WHY: Append current letter to all combinations from remaining digits
      // WHAT: Prepend chosen letter to each result from recursive call
      // HOW: letter + existing_combination = new complete combination
      for (String s : smallerAns) {
        myAns.add(letter + s); // e.g., 'a' + "dg" = "adg"
      }
    }

    return myAns; // Return all combinations for current digit + remaining
  }

  public static void main(String[] args) {
    String input = "84";
    ArrayList<String> combinations = getKeypadCombinations(input);
    System.out.println(combinations);
    // Output: [tg, th, ti, ug, uh, ui, vg, vh, vi]
  }
}

// ------------------------------------------------------------
// ⚡ Complexity Analysis
// ------------------------------------------------------------
// Time: O(4^n * n) - 4^n combinations, each takes O(n) to build string
// Space: O(4^n * n) - Store all combinations + O(n) recursion depth
// Where n = length of input string
//
// ------------------------------------------------------------
// 🎯 Pattern: Cartesian Product using Recursion
// 🗣️ Interview: "For each letter of first digit, prepend to all combos of
// remaining digits"
//
// ------------------------------------------------------------
// 🧠 Recursion Tree Example (input = "23"):
// ------------------------------------------------------------
// getKPC("23")
// / | \
// a+ b+ c+
// | | |
// getKPC("3") getKPC("3") getKPC("3")
// / | \ / | \ / | \
// d e f d e f d e f
// ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓
// ad ae af bd be bf cd ce cf
//
// ------------------------------------------------------------
// 🧠 Revision Questions
// ------------------------------------------------------------
// Q1. How does recursion ensure all combinations?
// → Each level picks one letter, recursion handles rest
// → Cartesian product: letters[i] × combinations(remaining)
//
// Q2. Only combinations of length k?
// → Add parameter k, decrement on each recursion
// → Base case: k == 0 instead of str.length() == 0
//
// Q3. Iterative using queue?
// → BFS approach: Start with [""], for each digit expand all strings
// → Queue: [""] → ["a","b","c"] → ["ad","ae","af","bd",...]
//
// ------------------------------------------------------------
// 🔥 Key Insight:
// This is the "Cartesian Product" pattern - combining elements from multiple
// sets
// Same pattern used in: Product of arrays, combination sum, word formation
// ------------------------------------------------------