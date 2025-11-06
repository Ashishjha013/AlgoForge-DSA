// ------------------------------------------------------------
// 🧮 Question 14: Get All Subsequences of a String
// ------------------------------------------------------------
// 🧩 Generate all possible subsequences (subsets) of a string
// 🔑 Recursion + Backtracking - for each character, choose to include or exclude
// 💡 Binary choice at each level: "yes" (include) or "no" (exclude)
//
// Pattern: Recursion + Backtracking (Include/Exclude Decision Tree)
// Level: 🟡 Medium | Similar to LeetCode #78 (Subsets)
// Tags: #Recursion #Strings #Backtracking #PowerSet
// ------------------------------------------------------------

import java.util.*;

public class Question14 {

  public static ArrayList<String> getSubSequences(String str) {
    // WHY: Base case - no more characters to decide on
    // WHAT: Return list with empty string (one valid subsequence exists)
    // HOW: Empty string represents the subsequence where we excluded everything
    if (str.length() == 0) {
      ArrayList<String> baseAns = new ArrayList<>();
      baseAns.add(""); // The empty subsequence always exists
      return baseAns;
    }

    // WHY: Divide problem - process first character separately
    // WHAT: Get all subsequences of remaining string (without first char)
    // HOW: Recursive call on substring starting from index 1
    String smallerString = str.substring(1); // Remove first character
    ArrayList<String> smallAns = getSubSequences(smallerString);

    // WHY: Extract first character to make include/exclude decision
    // WHAT: Store first character for prepending later
    // HOW: charAt(0) gives us the decision point character
    char firstChar = str.charAt(0);

    // WHY: Collect all subsequences (with and without first character)
    // WHAT: Final list containing 2 × smallAns.size() subsequences
    // HOW: Add all from "no" branch, then all from "yes" branch
    ArrayList<String> allSubs = new ArrayList<>();

    // WHY: "NO" branch - exclude first character from subsequence
    // WHAT: Add all subsequences that don't include firstChar
    // HOW: Copy smallAns as-is (these already skip firstChar)
    for (String s : smallAns) {
      allSubs.add(s); // e.g., if firstChar='a', s="bc" → add "bc"
    }

    // WHY: "YES" branch - include first character in subsequence
    // WHAT: Add all subsequences that include firstChar
    // HOW: Prepend firstChar to each subsequence from smallAns
    for (String s : smallAns) {
      allSubs.add(firstChar + s); // e.g., if firstChar='a', s="bc" → add "abc"
    }

    return allSubs; // Return doubled list: exclusions + inclusions
  }

  public static void main(String[] args) {
    String str = "abc";
    ArrayList<String> ans = getSubSequences(str);
    System.out.println("All subsequences of `" + str + "` are: ");
    System.out.println(ans);
    // Output: ["", "c", "b", "bc", "a", "ac", "ab", "abc"]
  }
}

// ------------------------------------------------------------
// ⚡ Complexity Analysis
// ------------------------------------------------------------
// Time: O(2^n * n) - 2^n subsequences, each string operation takes O(n)
// Space: O(2^n * n) - Store all subsequences + O(n) recursion depth
// Where n = length of input string
//
// ------------------------------------------------------------
// 🎯 Pattern: Power Set / Binary Choice Tree
// 🗣️ Interview: "For each character, make binary choice: include or exclude.
// Recursively solve for rest, then combine both branches."
//
// ------------------------------------------------------------
// 🧠 Recursion Tree Example (input = "abc"):
// ------------------------------------------------------------
// getSub("abc")
// / \
// exclude 'a' include 'a'
// | |
// getSub("bc") getSub("bc")
// / \ / \
// exclude 'b' include exclude include
// | | | |
// getSub("c") getSub("c") ... ...
// / \ / \
// exclude include ... ...
// | |
// getSub("") getSub("")
// ↓ ↓
// "" "c"
//
// Final combinations:
// Left branch (no 'a'): "", "c", "b", "bc"
// Right branch (yes 'a'): "a", "ac", "ab", "abc"
//
// ------------------------------------------------------------
// 🧠 Revision Questions
// ------------------------------------------------------------
// Q1. Recursion tree for "abc"?
// → Binary tree with 2^n leaves (8 for n=3)
// → Each path from root to leaf = one subsequence
// → Left child = exclude, Right child = include
//
// Q2. Only subsequences of length k?
// → Add parameter 'k' and 'currentLength'
// → Base case: currentLength == k → add to result
// → Prune branches where remaining chars < needed chars
//
// Q3. Generate in-place (without lists)?
// → Use StringBuilder/char[] to build current subsequence
// → Pass it down recursion, print/store when base case hit
// → Backtrack by removing last character after recursive call
//
// Example skeleton:
// void generate(String str, int idx, StringBuilder current) {
// if (idx == str.length()) {
// print(current); // Found one subsequence
// return;
// }
// // Exclude
// generate(str, idx+1, current);
// // Include
// current.append(str.charAt(idx));
// generate(str, idx+1, current);
// current.deleteCharAt(current.length()-1); // Backtrack
// }
//
// ------------------------------------------------------------
// 🔥 Key Insights:
// ------------------------------------------------------------
// 1. This is the "Power Set" pattern - generating all subsets
// 2. Binary decision tree: 2 choices per character = 2^n total subsequences
// 3. Order matters: "no" branch first gives lexicographic-like ordering
// 4. Same pattern for: Subsets, Combination Sum, Partition problems
//
// 💡 Alternative approaches:
// - Bit masking (iterative): Use numbers 0 to 2^n-1, bits represent
// include/exclude
// - BFS with queue: Start with [""], expand each by adding next character
// -----------------------------------------------------