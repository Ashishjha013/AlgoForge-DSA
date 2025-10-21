// ------------------------------------------------------------
// 🧮 Question 2A: Find All Subsets with Target Sum
// ------------------------------------------------------------
// 🧩 Find all subsets of array that sum to target value
// 🔑 Backtracking + Include/Exclude - binary choice for each element
// 💡 At each index: include element (reduce target) OR exclude it
//
// Pattern: Backtracking (Subset Sum - Include/Exclude)
// Level: 🟡 Medium | Similar to LeetCode #39, #40
// Tags: #Backtracking #SubsetSum #Recursion
// ------------------------------------------------------------

// ------------------------------------------------------------
// 🧮 Question 2B: N-Queens Problem
// ------------------------------------------------------------
// 🧩 Place N queens on N×N board such that no two queens attack each other
// 🔑 Backtracking + Constraint Checking - place queen, check safety, backtrack
// 💡 Try placing queen in each column of current row, recurse to next row
//
// Pattern: Backtracking on 2D Grid (Constraint Satisfaction)
// Level: 🔴 Hard | LeetCode #51
// Tags: #Backtracking #NQueens #ConstraintSatisfaction
// ------------------------------------------------------------

public class Question2 {

  // ============================================================
  // PROBLEM 1: SUBSET SUM
  // ============================================================

  // WHY: Parameters track position, remaining target, and current subset
  // WHAT: idx = current element, target = remaining sum needed, ans = subset
  // built so far
  // HOW: At each index, try including or excluding current element
  public static void findAllSubsets(int arr[], int idx, int target, String ans) {

    // WHY: Base case - processed all elements
    // WHAT: Check if we achieved target sum with chosen elements
    // HOW: If target reduced to 0, current subset is valid
    if (idx == arr.length) {
      if (target == 0) {
        System.out.println(ans); // Found valid subset!
      }
      return; // Backtrack regardless of target value
    }

    // WHY: "YES" branch - include current element in subset
    // WHAT: Add arr[idx] to answer string and reduce target by arr[idx]
    // HOW: target - arr[idx] = new remaining target after including this element
    findAllSubsets(arr, idx + 1, target - arr[idx], ans + arr[idx] + ", ");

    // WHY: "NO" branch - exclude current element from subset
    // WHAT: Move to next element without modifying target or answer
    // HOW: Same target, same ans (element not included)
    findAllSubsets(arr, idx + 1, target, ans);
  }

  // ============================================================
  // PROBLEM 2: N-QUEENS
  // ============================================================

  // WHY: Check if placing queen at (row,col) is safe from attacks
  // WHAT: Verify no queens exist in vertical up, diagonal left up, diagonal right
  // up
  // HOW: Check three directions - only need to check "up" since we place
  // row-by-row
  public static boolean isSafeTOPlaceHere(boolean board[][], int row, int col) {

    // WHY: Check vertical column above current row
    // WHAT: Ensure no queen exists in same column in previous rows
    // HOW: Loop from row-1 down to 0, check board[i][col]
    for (int i = row - 1; i >= 0; i--) {
      if (board[i][col]) {
        return false; // Queen found in vertical path - not safe!
      }
    }

    // WHY: Check diagonal going left-up (↖ direction)
    // WHAT: Ensure no queen exists in left-up diagonal
    // HOW: Decrement both row and col simultaneously (i--, j--)
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j]) {
        return false; // Queen found in left diagonal - not safe!
      }
    }

    // WHY: Check diagonal going right-up (↗ direction)
    // WHAT: Ensure no queen exists in right-up diagonal
    // HOW: Decrement row, increment col (i--, j++)
    for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
      if (board[i][j]) {
        return false; // Queen found in right diagonal - not safe!
      }
    }

    return true; // No queens attacking this position - safe to place!
  }

  // WHY: Recursively place queens row by row
  // WHAT: Try placing queen in each column of current row, recurse to next row
  // HOW: For each safe position, place queen, recurse, then backtrack
  public static void nQueens(boolean board[][], int n, int row, String ans) {

    // WHY: Base case - successfully placed queens in all rows
    // WHAT: If row == n, we placed n queens validly
    // HOW: Print the solution (positions of all queens)
    if (row == n) {
      System.out.println(ans); // Found valid queen placement!
      return; // Backtrack to find more solutions
    }

    // WHY: Try placing queen in each column of current row
    // WHAT: Iterate through all columns, attempt placement at each
    // HOW: For each col, check safety, place queen, recurse, backtrack
    for (int col = 0; col < n; col++) {

      // WHY: Only place queen if position is safe
      // WHAT: Check if no queens attack this position
      // HOW: Use isSafeTOPlaceHere() to validate
      if (isSafeTOPlaceHere(board, row, col)) {

        // WHY: Mark queen placement
        // WHAT: Set board[row][col] = true to indicate queen present
        // HOW: This position now occupied for constraint checking
        board[row][col] = true;

        // WHY: Recurse to place queen in next row
        // WHAT: Move to row+1, append current position to answer string
        // HOW: Build answer as "(row,col)" pairs showing queen positions
        nQueens(board, n, row + 1, ans + "(" + row + "," + col + ")");

        // WHY: BACKTRACK - remove queen to try next column
        // WHAT: Reset board[row][col] = false
        // HOW: Allows trying different column positions for this row
        board[row][col] = false;
      }
    }
    // After loop: tried all columns, backtrack to previous row
  }

  public static void main(String[] args) {
    // ========== SUBSET SUM EXAMPLE ==========
    // int arr[] = { 2, 5, 3, 1, 4, 6, -8 };
    // int target = 8;
    // findAllSubsets(arr, 0, target, "");
    // Output: Subsets like "2, 5, 1, " or "3, 1, 4, " that sum to 8

    // ========== N-QUEENS EXAMPLE ==========
    int n = 4;
    boolean board[][] = new boolean[n][n];
    nQueens(board, n, 0, "");
    // Output: "(0,1)(1,3)(2,0)(3,2)" and "(0,2)(1,0)(2,3)(3,1)"
    // Two valid solutions for 4-Queens problem
  }
}

// ------------------------------------------------------------
// ⚡ COMPLEXITY ANALYSIS
// ------------------------------------------------------------
//
// SUBSET SUM:
// Time: O(2^n) - Each element has 2 choices (include/exclude)
// Space: O(n) - Recursion depth = array length
//
// N-QUEENS:
// Time: O(n!) - Approximately, due to constraint pruning
// Space: O(n²) - Board storage + O(n) recursion depth
//
// ------------------------------------------------------------
// 🎯 PATTERNS USED
// ------------------------------------------------------------
//
// SUBSET SUM: Include/Exclude Pattern (Binary Choice Tree)
// 🗣️ "For each element, make binary choice: include it (reduce target)
// or exclude it (keep target same). Base case: all processed."
//
// N-QUEENS: Constraint Satisfaction with Backtracking
// 🗣️ "Place queens row by row. For each row, try all columns. Only place
// if safe (no attacks). Recurse to next row. Backtrack if no solution."
//
// ------------------------------------------------------------
// 🧠 SUBSET SUM - Execution Trace (arr=[2,3], target=5)
// ------------------------------------------------------------
//
// findAllSubsets(idx=0, target=5, "")
// / \
// Include 2 Exclude 2
// | |
// (idx=1, target=3, "2, ") (idx=1, target=5, "")
// / \ / \
// Include 3 Exclude 3 Include 3 Exclude 3
// | | | |
// (idx=2, (idx=2, (idx=2, (idx=2,
// target=0, target=3, target=2, target=5,
// "2, 3, ") "2, ") "3, ") "")
// ✓ PRINT ✗ ✗ ✗
//
// Output: "2, 3, " (only this subset sums to 5)
//
// ------------------------------------------------------------
// 🧠 N-QUEENS - Visual Example (4-Queens)
// ------------------------------------------------------------
//
// Board representation (Q = Queen, . = Empty):
//
// Solution 1: "(0,1)(1,3)(2,0)(3,2)"
// ┌───┬───┬───┬───┐
// │ . │ Q │ . │ . │ Row 0: Queen at col 1
// ├───┼───┼───┼───┤
// │ . │ . │ . │ Q │ Row 1: Queen at col 3
// ├───┼───┼───┼───┤
// │ Q │ . │ . │ . │ Row 2: Queen at col 0
// ├───┼───┼───┼───┤
// │ . │ . │ Q │ . │ Row 3: Queen at col 2
// └───┴───┴───┴───┘
//
// Why this works:
// - No two queens in same row ✓ (place one per row)
// - No two queens in same col ✓ (checked by isSafe)
// - No two queens in same diagonal ✓ (checked by isSafe)
//
// Backtracking visualization for Row 0:
// Try col 0 → Place queen → Recurse to row 1
// → Eventually no solution → Backtrack, remove queen
// Try col 1 → Place queen → Recurse to row 1
// → Solution found! → Print, then backtrack for more solutions
// Try col 2 → Place queen → Recurse to row 1
// → Solution found! → Print, then backtrack
// Try col 3 → Place queen → Recurse to row 1
// → No solution → Backtrack
//
// ------------------------------------------------------------
// 🧠 REVISION QUESTIONS
// ------------------------------------------------------------
//
// === SUBSET SUM ===
// Q1. Why do we reduce target by arr[idx] in "yes" call?
// → Including element means it contributes to sum
// → New target = original target - current element
// → If target becomes 0, we found exact sum!
//
// Q2. Can we handle negative numbers?
// → YES! This solution works with negatives
// → Example: arr=[-2, 3, 5], target=1 → "-2, 3, " is valid
//
// Q3. What if we want count instead of printing?
//
// int countSubsets(int arr[], int idx, int target) {
// if (idx == arr.length) {
// return (target == 0) ? 1 : 0; // Found or not
// }
// int includeCount = countSubsets(arr, idx+1, target - arr[idx]);
// int excludeCount = countSubsets(arr, idx+1, target);
// return includeCount + excludeCount;
// }
//
// === N-QUEENS ===
// Q4. Why only check "up" directions (vertical, diagonals up)?
// → We place queens row by row (top to bottom)
// → Rows below current row don't have queens yet
// → Only need to check positions where queens already exist (above)
//
// Q5. What's time complexity and why?
// → Approximately O(n!) due to constraint pruning
// → Row 0: n choices, Row 1: ~(n-2) choices, Row 2: ~(n-4)...
// → Much better than O(n^n) due to safety checks
//
// Q6. How to return board configurations instead of printing?
//
// ArrayList<List<String>> solveNQueens(int n) {
// ArrayList<List<String>> result = new ArrayList<>();
// boolean[][] board = new boolean[n][n];
// nQueensCollect(board, n, 0, result);
// return result;
// }
//
// void nQueensCollect(boolean[][] board, int n, int row,
// ArrayList<List<String>> result) {
// if (row == n) {
// result.add(constructBoard(board)); // Convert board to strings
// return;
// }
// // ... rest same, but collect instead of print
// }
//
// ------------------------------------------------------------
// 🔥 KEY INSIGHTS
// ------------------------------------------------------------
//
// === SUBSET SUM ===
// 1. **Binary decision tree**: Include OR Exclude at each step
// 2. **Target tracking**: Reduce target when including elements
// 3. **Order doesn't matter**: [2,3] and [3,2] are same subset
// 4. **Similar problems**: Combination Sum, Partition Equal Subset Sum
//
// === N-QUEENS ===
// 1. **Constraint satisfaction**: Must satisfy "no attack" rule
// 2. **Row-by-row placement**: Guarantees one queen per row
// 3. **Safety check optimization**: Only check upward directions
// 4. **Backtracking is essential**: Try → Fail → Undo → Try next
// 5. **Similar problems**: Sudoku Solver, Word Search, Rat in Maze
//
// 💡 Common Theme: Both use BACKTRACKING
// - Try a choice
// - Recurse with that choice
// - Undo the choice (backtrack)
// - Try next choice
//
// This is the essence of exploring all possibilities systematically!
// ------------------------------------------------------------