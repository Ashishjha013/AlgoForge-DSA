// ------------------------------------------------------------
// 🧮 Question 17: Get All Maze Paths (Horizontal & Vertical Moves)
// ------------------------------------------------------------
// 🧩 Find all paths from (sr,sc) to (dr,dc) using only right(h) and down(v) moves
// 🔑 Recursion + Path Generation - at each cell, try both directions
// 💡 Binary choice: move right OR move down, combine with paths from subproblems
//
// Pattern: Recursion + Path Generation (Grid Traversal)
// Level: 🟡 Medium
// Tags: #Recursion #PathFinding #Grid #Combinations
// ------------------------------------------------------------

import java.util.*;

public class Question17 {

  // WHY: Parameters define current position and destination
  // WHAT: sr,sc = current row,col; dr,dc = destination row,col
  // HOW: Start at (sr,sc), can only move right(h) or down(v) to reach (dr,dc)
  public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

    // WHY: Invalid position check - went out of valid bounds
    // WHAT: If current position is beyond destination, path is invalid
    // HOW: sr > dr means went too far down, sc > dc means went too far right
    if (sr > dr || sc > dc) {
      return new ArrayList<>(); // No valid paths from invalid position
    }

    // WHY: Base case - reached destination successfully
    // WHAT: When at destination, return list with empty string (one valid path
    // exists)
    // HOW: Empty string will be prefixed with moves during backtracking
    if (sr == dr && sc == dc) {
      ArrayList<String> baseArr = new ArrayList<>();
      baseArr.add(""); // One path exists: no more moves needed
      return baseArr;
    }

    // WHY: Explore both possible moves from current cell
    // WHAT: Get all paths after moving horizontally (right) and vertically (down)
    // HOW: Recursive calls with updated position (sc+1 for right, sr+1 for down)

    // Try horizontal move (right): column increases
    ArrayList<String> pathsAfterHStep = getMazePaths(sr, sc + 1, dr, dc);

    // Try vertical move (down): row increases
    ArrayList<String> pathsAfterVStep = getMazePaths(sr + 1, sc, dr, dc);

    // WHY: Collect all valid paths from both directions
    // WHAT: Combine paths from both choices
    // HOW: Prepend current move choice to each path from recursive result
    ArrayList<String> allPaths = new ArrayList<>();

    // WHY: Add current horizontal move to all paths after horizontal step
    // WHAT: For each path after moving right, prepend "h" (horizontal)
    // HOW: "h" + remaining_path = complete path starting with horizontal move
    for (String path : pathsAfterHStep) {
      allPaths.add("h" + path); // e.g., "h" + "vv" = "hvv"
    }

    // WHY: Add current vertical move to all paths after vertical step
    // WHAT: For each path after moving down, prepend "v" (vertical)
    // HOW: "v" + remaining_path = complete path starting with vertical move
    for (String path : pathsAfterVStep) {
      allPaths.add("v" + path); // e.g., "v" + "hh" = "vhh"
    }

    return allPaths; // Return all paths from current position to destination
  }

  public static void main(String[] args) {
    ArrayList<String> ans = getMazePaths(0, 0, 2, 2);
    System.out.println(ans);
    // Output: [hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]
    // Each path uses 2 h's (right moves) and 2 v's (down moves)
  }
}

// ------------------------------------------------------------
// ⚡ Complexity Analysis
// ------------------------------------------------------------
// Time: O(2^(m+n)) - Each cell has 2 choices, total cells = (m+n)
// Space: O(2^(m+n)) - Store all possible paths + O(m+n) recursion depth
// Where m = dr-sr (rows to travel), n = dc-sc (cols to travel)
//
// More precisely: Total paths = C(m+n, m) = (m+n)! / (m! * n!)
// For (0,0) to (2,2): C(4,2) = 6 paths
//
// ------------------------------------------------------------
// 🎯 Pattern: Path Generation in Grid (Combinatorics)
// 🗣️ Interview: "At each cell, try moving right and down. Recursively get
// paths
// from new positions, then prepend current move to those paths.
// Total paths = combinations of m downs and n rights."
//
// ------------------------------------------------------------
// 🧠 Visual Example (0,0) to (2,2):
// ------------------------------------------------------------
//
// Grid (S=start at 0,0; E=end at 2,2):
// ┌───┬───┬───┐
// │ S │ │ │ Row 0
// ├───┼───┼───┤
// │ │ │ │ Row 1
// ├───┼───┼───┤
// │ │ │ E │ Row 2
// └───┴───┴───┘
// C0 C1 C2
//
// To reach (2,2) from (0,0):
// - Need 2 down moves (v v)
// - Need 2 right moves (h h)
// - Total: 4 moves, choosing 2 positions for 'h' (or 'v')
//
// All 6 possible arrangements:
// 1. h h v v (right right down down)
// 2. h v h v (right down right down)
// 3. h v v h (right down down right)
// 4. v h h v (down right right down)
// 5. v h v h (down right down right)
// 6. v v h h (down down right right)
//
// Formula: C(m+n, m) = C(4, 2) = 6 paths ✓
//
// ------------------------------------------------------------
// 🧠 Recursion Tree (0,0) to (1,1):
// ------------------------------------------------------------
//
// getMazePaths(0,0)
// / \
// move h(0,1) move v(1,0)
// / \
// getMazePaths(0,1) getMazePaths(1,0)
// / \ / \
// h(0,2) v(1,1) h(1,1) v(2,0)
// | | | |
// invalid BASE CASE BASE CASE invalid
// [] [""] [""] []
//
// Backtracking:
// getMazePaths(0,1) returns: ["hv", "vh"] → prepend "h" → ["hhv", "hvh"]
// getMazePaths(1,0) returns: ["hv", "vh"] → prepend "v" → ["vhv", "vvh"]
// Final: ["hhv", "hvh", "vhv", "vvh"] → C(2,1) = 2 paths for each branch ✓
//
// ------------------------------------------------------------
// 🧠 Revision Questions
// ------------------------------------------------------------
// Q1. Why is total paths = C(m+n, m)?
// → Total moves needed = m downs + n rights = (m+n) moves
// → Question: "In how many ways can we arrange m 'v's and n 'h's?"
// → Answer: Choose m positions out of (m+n) for 'v' = C(m+n, m)
// → Example: (0,0)→(2,2) needs 2v + 2h = C(4,2) = 6 arrangements
//
// Q2. What if diagonal moves allowed?
// → Add third choice: diagonal (sr+1, sc+1)
// → More paths possible (exponentially more)
// → Code change:
//
// ArrayList<String> pathsAfterDStep = getMazePaths(sr+1, sc+1, dr, dc);
// for (String path : pathsAfterDStep) {
// allPaths.add("d" + path); // diagonal move
// }
//
// Q3. What if we can move in variable steps (1,2,3... steps at once)?
// → Use loop instead of single recursive call
//
// for (int step = 1; step <= dc - sc; step++) {
// ArrayList<String> paths = getMazePaths(sr, sc+step, dr, dc);
// for (String path : paths) {
// allPaths.add("h" + step + path); // e.g., "h2" = 2 steps right
// }
// }
// // Same for vertical
//
// Q4. How to count paths instead of generating them?
// → Much simpler! Just return count
//
// int countMazePaths(int sr, int sc, int dr, int dc) {
// if (sr > dr || sc > dc) return 0; // Invalid
// if (sr == dr && sc == dc) return 1; // One path found
//
// int hPaths = countMazePaths(sr, sc+1, dr, dc); // Right
// int vPaths = countMazePaths(sr+1, sc, dr, dc); // Down
//
// return hPaths + vPaths; // Total = sum of both choices
// }
//
// ------------------------------------------------------------
// 🔥 Key Insights:
// ------------------------------------------------------------
// 1. **This is a Combinatorics problem disguised as recursion**
// - Finding arrangements of 'm' and 'n' items
// - Recursion naturally generates all combinations
//
// 2. **Binary choice at each step**
// - Right OR Down (not both simultaneously)
// - Similar to: Include/Exclude, 0/1 decisions
//
// 3. **Path building during backtracking**
// - Empty string at base case
// - Prepend moves as recursion unwinds
// - Forward recursion = exploring, backward = building
//
// 4. **Optimization opportunity**
// - Counting paths: O(m*n) with DP (much faster!)
// - Generating paths: Must visit all O(C(m+n,m)) paths
//
// 5. **Pattern recognition**:
// - Similar to: Unique Paths (LeetCode 62)
// - Same concept: Robot moving in grid
// - Extension: Unique Paths II (with obstacles)
//
// 💡 Interview Tip:
// Mention: "This has a mathematical solution C(m+n, m), but recursion
// generates the actual paths. For just counting, DP is optimal."
// ------------------------------------------------------------