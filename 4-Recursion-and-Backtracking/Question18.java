// ------------------------------------------------------------
// 🧮 Question 18: Get All Maze Paths With Variable Jumps
// ------------------------------------------------------------
// 🧩 Find all paths from (sr,sc) to (dr,dc) using variable-sized horizontal/vertical jumps
// 🔑 Recursion + Multiple Choices - at each cell, try all possible jump sizes
// 💡 For each direction, loop through all valid jump sizes (1 to remaining distance)
//
// Pattern: Recursion + Path Generation (Grid with Multiple Steps)
// Level: 🟡 Medium
// Tags: #Recursion #PathFinding #Grid #MultipleChoices
// ------------------------------------------------------------

import java.util.ArrayList;

public class Question18 {

  // WHY: Parameters define current position and destination
  // WHAT: sr,sc = current row,col; dr,dc = destination row,col
  // HOW: From current cell, can jump 1,2,3... steps horizontally or vertically
  public static ArrayList<String> getMazePathsWithJumps(int sr, int sc, int dr, int dc) {

    // WHY: Base case - reached destination successfully
    // WHAT: When at destination, return list with empty string (one valid path)
    // HOW: Empty string will be prefixed with jump moves during backtracking
    if (sr == dr && sc == dc) {
      ArrayList<String> baseAns = new ArrayList<>();
      baseAns.add(""); // One path: no more jumps needed
      return baseAns;
    }

    // WHY: Collect all paths from all possible jump choices
    // WHAT: Final result containing paths from horizontal AND vertical jumps
    // HOW: Will be populated by loops exploring different jump sizes
    ArrayList<String> ans = new ArrayList<>();

    // ========== HORIZONTAL JUMPS ==========
    // WHY: Try all possible horizontal jump sizes from current position
    // WHAT: Loop from 1 to maximum possible jumps (remaining horizontal distance)
    // HOW: dc - sc = remaining columns to reach destination
    for (int jump = 1; jump <= dc - sc; jump++) {

      // WHY: Get all paths after making this specific horizontal jump
      // WHAT: Recursively solve from new position (sr, sc+jump)
      // HOW: sc+jump = new column after jumping 'jump' steps right
      ArrayList<String> pathsAfterHJumps = getMazePathsWithJumps(sr, sc + jump, dr, dc);

      // WHY: Prepend current jump to all paths from recursive result
      // WHAT: For each path after this jump, add "h{jump}" at beginning
      // HOW: "h2" + "v1h1" = "h2v1h1" (jumped 2 right, then 1 down, then 1 right)
      for (String path : pathsAfterHJumps) {
        ans.add("h" + jump + path); // e.g., "h1", "h2", "h3" etc.
      }
    }

    // ========== VERTICAL JUMPS ==========
    // WHY: Try all possible vertical jump sizes from current position
    // WHAT: Loop from 1 to maximum possible jumps (remaining vertical distance)
    // HOW: dr - sr = remaining rows to reach destination
    for (int jump = 1; jump <= dr - sr; jump++) {

      // WHY: Get all paths after making this specific vertical jump
      // WHAT: Recursively solve from new position (sr+jump, sc)
      // HOW: sr+jump = new row after jumping 'jump' steps down
      ArrayList<String> pathsAfterVJumps = getMazePathsWithJumps(sr + jump, sc, dr, dc);

      // WHY: Prepend current jump to all paths from recursive result
      // WHAT: For each path after this jump, add "v{jump}" at beginning
      // HOW: "v2" + "h2" = "v2h2" (jumped 2 down, then 2 right)
      for (String path : pathsAfterVJumps) {
        ans.add("v" + jump + path); // e.g., "v1", "v2", "v3" etc.
      }
    }

    return ans; // Return all paths combining all jump choices
  }

  public static void main(String[] args) {
    ArrayList<String> ans = getMazePathsWithJumps(0, 0, 2, 2);
    System.out.println(ans);
    // Sample Output: [h1h1v1v1, h1h1v2, h1v1h1v1, h1v1v1h1, h1v2h1, h2v1v1, h2v2,
    // ...]
    // Many more paths than Question 17 due to variable jumps!
  }
}

// ------------------------------------------------------------
// ⚡ Complexity Analysis
// ------------------------------------------------------------
// Time: O(k^(m+n)) where k = max(m,n) - k choices per cell, depth = m+n
// Space: O(k^(m+n)) - Store all possible paths + O(m+n) recursion depth
// Where m = dr-sr (rows), n = dc-sc (cols)
//
// Much larger than Question 17 because each cell has MORE choices!
// Q17: 2 choices per cell (h or v)
// Q18: up to (m+n) choices per cell (h1,h2,...,hn, v1,v2,...,vm)
//
// ------------------------------------------------------------
// 🎯 Pattern: Path Generation with Variable Steps
// 🗣️ Interview: "At each cell, try all possible jump sizes in both directions.
// For horizontal, loop 1 to remaining cols. For vertical, loop 1 to
// remaining rows. Recursively get paths from new position, prepend jump."
//
// ------------------------------------------------------------
// 🧠 Visual Example (0,0) to (2,2):
// ------------------------------------------------------------
//
// Grid (S=start, E=end):
// ┌───┬───┬───┐
// │ S │ │ │ Row 0
// ├───┼───┼───┤
// │ │ │ │ Row 1
// ├───┼───┼───┤
// │ │ │ E │ Row 2
// └───┴───┴───┘
// C0 C1 C2
//
// From (0,0), possible first moves:
// Horizontal jumps: h1→(0,1), h2→(0,2)
// Vertical jumps: v1→(1,0), v2→(2,0)
//
// Sample paths:
// 1. h2v2 → jump 2 right to (0,2), then 2 down to (2,2) ✓
// 2. v2h2 → jump 2 down to (2,0), then 2 right to (2,2) ✓
// 3. h1v1h1v1 → jump 1 right, 1 down, 1 right, 1 down ✓
// 4. h1v2h1 → jump 1 right, 2 down, 1 right ✓
// ... many more combinations!
//
// Key insight: Can reach destination in fewer moves with larger jumps
// OR take many small steps → exponentially more paths!
//
// ------------------------------------------------------------
// 🧠 Recursion Tree (0,0) to (1,1) - First Level:
// ------------------------------------------------------------
//
// getMazePathsWithJumps(0,0)
// / | \
// h1(0,1) h2(0,2) v1(1,0) v2(2,0)
// | (invalid) | (invalid)
// getMazePaths out of bounds getMazePaths out of bounds
// (0,1) (1,0)
// / \ / \
// h1(0,2) v1(1,1) h1(1,1) v1(2,0)
// invalid BASE BASE invalid
// [""] [""]
//
// Backtracking from (0,1):
// - v1 branch returns [""] → prepend "v1" → ["v1"]
// - From (0,0): prepend "h1" → ["h1v1"]
//
// Backtracking from (1,0):
// - h1 branch returns [""] → prepend "h1" → ["h1"]
// - From (0,0): prepend "v1" → ["v1h1"]
//
// Final includes: ["h1v1", "v1h1", ...] (many more paths than Q17!)
//
// ------------------------------------------------------------
// 🧠 Comparison: Question 17 vs Question 18
// ------------------------------------------------------------
//
// ┌──────────────────┬─────────────────┬──────────────────────┐
// │ Aspect │ Q17 (Fixed) │ Q18 (Jumps) │
// ├──────────────────┼─────────────────┼──────────────────────┤
// │ Move size │ Always 1 step │ Variable (1,2,3...) │
// │ Choices per cell │ 2 (h or v) │ ~(m+n) choices │
// │ Total paths │ C(m+n, m) │ Exponentially more │
// │ Shortest path │ Always m+n │ Can be less (jumps!) │
// │ Example (0,0)→ │ 6 paths │ 15+ paths │
// │ (2,2) │ │ │
// └──────────────────┴─────────────────┴──────────────────────┘
//
// Q17 example: hhvv, hvhv, hvvh, vhhv, vhvh, vvhh (6 total)
// Q18 includes: h2v2, v2h2, h1h1v2, h2v1v1, ... (many more!)
//
// ------------------------------------------------------------
// 🧠 Revision Questions
// ------------------------------------------------------------
// Q1. Why are there MORE paths in Q18 than Q17?
// → More choices per cell! Instead of 2 (h,v), we have:
// - Horizontal: up to 'n' choices (h1, h2, ..., hn)
// - Vertical: up to 'm' choices (v1, v2, ..., vm)
// → Example: From (0,0) in 3×3 grid:
// Q17: 2 choices (h1 or v1)
// Q18: 5 choices (h1, h2, h3, v1, v2, v3)
//
// Q2. How to add diagonal jumps?
// → Add third loop for diagonal (both sr and sc change)
//
// for (int jump = 1; jump <= Math.min(dr-sr, dc-sc); jump++) {
// ArrayList<String> pathsAfterDJumps =
// getMazePathsWithJumps(sr+jump, sc+jump, dr, dc);
// for (String path : pathsAfterDJumps) {
// ans.add("d" + jump + path); // diagonal jump
// }
// }
//
// Q3. How to find only the SHORTEST path?
// → Track path length, return only minimum-length paths
// → OR use BFS (better for shortest path finding)
// → With jumps, shortest = minimum number of moves
// Example: (0,0)→(2,2) shortest = 2 moves (h2v2 or v2h2)
//
// Q4. Count paths instead of generating?
// → Much simpler! Just count recursively
//
// int countMazePathsWithJumps(int sr, int sc, int dr, int dc) {
// if (sr == dr && sc == dc) return 1;
//
// int totalPaths = 0;
//
// // Count horizontal jumps
// for (int jump = 1; jump <= dc - sc; jump++) {
// totalPaths += countMazePathsWithJumps(sr, sc+jump, dr, dc);
// }
//
// // Count vertical jumps
// for (int jump = 1; jump <= dr - sr; jump++) {
// totalPaths += countMazePathsWithJumps(sr+jump, sc, dr, dc);
// }
//
// return totalPaths;
// }
//
// ------------------------------------------------------------
// 🔥 Key Insights:
// ------------------------------------------------------------
// 1. **Loop = Multiple Choices**
// - Q17: Binary choice (if-else or two calls)
// - Q18: Multiple choices (loop with variable jump size)
// - Pattern: Use loop when number of choices varies
//
// 2. **Jump size = Parameter in recursion**
// - Must try ALL valid jump sizes (1 to max)
// - Each jump size creates a separate recursive branch
//
// 3. **Exponential explosion**
// - More choices → exponentially more paths
// - Q17: 2^(m+n) roughly
// - Q18: k^(m+n) where k can be large
//
// 4. **Shortest path advantage**
// - With jumps, can reach destination faster
// - Minimum moves can be much less than m+n
// - Example: (0,0)→(10,10) with Q17 = 20 moves
// with Q18 = 2 moves (h10, v10)
//
// 5. **Pattern variations**:
// - Chess Knight moves (fixed pattern of jumps)
// - Minimum Path Sum with jumps
// - Frog Jump (LeetCode 403) - similar concept
//
// 💡 Interview Strategy:
// "I'll use loops to try all valid jump sizes in each direction. Each jump
// size creates a recursive branch. This explores all combinations of
// variable-sized moves. Trade-off: more paths found but higher complexity."
// ------------------------------------------------------------