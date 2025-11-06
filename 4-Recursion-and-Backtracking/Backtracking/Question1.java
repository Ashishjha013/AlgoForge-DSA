// ------------------------------------------------------------
// 🧮 Question 1: Flood Fill - Find All Paths in Maze
// ------------------------------------------------------------
// 🧩 Find all paths from top-left to bottom-right in a maze with obstacles
// 🔑 Backtracking + DFS - explore all 4 directions, mark visited, backtrack
// 💡 Try each direction (t,l,d,r), mark visited to avoid cycles, unmark when backtrack
//
// Pattern: Backtracking on 2D Grid (Flood Fill)
// Level: 🟡 Medium
// Tags: #Backtracking #DFS #Matrix #PathFinding #FloodFill
// ------------------------------------------------------------

public class Question1 {

  // WHY: Parameters track position, maze state, and path taken so far
  // WHAT: row,col = current position, mat = maze (0=open, 1=obstacle),
  // visited = cells already in current path, psf = path so far as string
  // HOW: Recursively explore all 4 directions from current cell
  public static void floodFill(int row, int col, int[][] mat, boolean[][] visited,
      int n, int m, String psf) {

    // WHY: Boundary + validity checks - prevent invalid moves
    // WHAT: Check if move is out of bounds, hits obstacle, or revisits cell
    // HOW: Multiple conditions combined with OR - any one fails = invalid move
    if (row < 0 || col < 0 || row >= n || col >= m // Out of bounds
        || mat[row][col] == 1 // Hit obstacle (wall)
        || visited[row][col] == true) { // Already in current path
      return; // Invalid move, backtrack immediately
    }

    // WHY: Success condition - reached destination
    // WHAT: If at bottom-right corner, we found a valid path
    // HOW: Check if row == last row AND col == last column
    if (row == n - 1 && col == m - 1) {
      System.out.println(psf); // Print the complete path
      return; // Path complete, backtrack to find more paths
    }

    // WHY: Mark current cell as part of current path
    // WHAT: Set visited[row][col] = true to prevent revisiting in this path
    // HOW: This prevents infinite loops (going back to same cell)
    visited[row][col] = true; // Mark as visited

    // WHY: Explore all 4 directions from current cell
    // WHAT: Try moving top, left, down, right (t, l, d, r)
    // HOW: Recursive calls with updated position and path string

    floodFill(row - 1, col, mat, visited, n, m, psf + "t"); // Top (row-1)
    floodFill(row, col - 1, mat, visited, n, m, psf + "l"); // Left (col-1)
    floodFill(row + 1, col, mat, visited, n, m, psf + "d"); // Down (row+1)
    floodFill(row, col + 1, mat, visited, n, m, psf + "r"); // Right (col+1)

    // WHY: BACKTRACKING - unmark cell for alternate paths
    // WHAT: Reset visited[row][col] = false when returning
    // HOW: This allows other paths to use this cell
    visited[row][col] = false; // Backtrack - unmark for other paths
  }

  public static void main(String[] args) {
    // 0 = open cell, 1 = obstacle/wall
    int[][] mat = {
        { 0, 0, 0, 0, 0, 0 },
        { 0, 1, 0, 1, 1, 0 },
        { 0, 0, 0, 0, 0, 0 },
        { 0, 1, 0, 1, 1, 0 },
        { 0, 1, 0, 1, 1, 0 },
        { 0, 0, 0, 1, 1, 0 }
    };

    int n = mat.length; // Number of rows
    int m = mat[0].length; // Number of columns
    boolean[][] visited = new boolean[n][m]; // Track visited cells

    floodFill(0, 0, mat, visited, n, m, ""); // Start from (0,0) with empty path
  }
}

// ------------------------------------------------------------
// ⚡ Complexity Analysis
// ------------------------------------------------------------
// Time: O(4^(n*m)) - Each cell has 4 choices, worst case explores all
// Space: O(n*m) - Visited array + recursion stack depth
//
// ------------------------------------------------------------
// 🎯 Pattern: Backtracking on 2D Grid (Flood Fill / DFS)
// 🗣️ Interview: "Use DFS to explore all 4 directions. Mark cell as visited,
// recurse in all directions, then backtrack by unmarking.
// This finds all valid paths from source to destination."
//
// ------------------------------------------------------------
// 🧠 Visual Execution Example (3x3 maze):
// ------------------------------------------------------------
//
// Maze (S=start, E=end, 1=obstacle):
// ┌───┬───┬───┐
// │ S │ 0 │ 0 │
// ├───┼───┼───┤
// │ 0 │ 1 │ 0 │
// ├───┼───┼───┤
// │ 0 │ 0 │ E │
// └───┴───┴───┘
//
// Path 1: S → right → right → down → down = "rrdd"
// Path 2: S → down → down → right → right = "ddrr"
// Path 3: S → down → right → down → right = "drdr"
//
// Key Insight: At each cell, try all 4 directions
// visited[][] prevents cycles within one path
// Backtracking allows cell reuse across different paths
//
// ------------------------------------------------------------
// 🧠 Detailed Trace for First Path:
// ------------------------------------------------------------
//
// Call 1: floodFill(0,0, ..., "")
// visited[0][0] = true
// Try top(-1,0) → out of bounds, return
// Try left(0,-1) → out of bounds, return
// Try down(1,0) → valid, recurse
//
// Call 2: floodFill(1,0, ..., "d")
// visited[1][0] = true
// Try top(0,0) → already visited, return
// Try left(1,-1) → out of bounds, return
// Try down(2,0) → valid, recurse
//
// Call 3: floodFill(2,0, ..., "dd")
// visited[2][0] = true
// Try top(1,0) → already visited, return
// Try left(2,-1) → out of bounds, return
// Try down(3,0) → out of bounds, return
// Try right(2,1) → valid, recurse
//
// ... continues until reaching (n-1, m-1)
//
// When found: Print path and return
// visited[2][0] = false (backtrack)
//
// visited[1][0] = false (backtrack)
//
// Try right(0,1) → valid, recurse (explores different path)
// ...
// visited[0][0] = false (backtrack)
//
// ------------------------------------------------------------
// 🔥 Why Backtracking is Critical:
// ------------------------------------------------------------
//
// WITHOUT backtracking (no `visited[row][col] = false`):
// ❌ Once a cell is marked visited, it's unavailable for ALL paths
// ❌ Would only find ONE path, not all paths
//
// WITH backtracking:
// ✅ Cell marked visited only for CURRENT path exploration
// ✅ When returning, unmark allows OTHER paths to use it
// ✅ Example: Cell (1,1) used in path "drr" can also be used in "rrd"
//
// Think of it like:
// - visited[i][j] = true → "I'm using this cell RIGHT NOW"
// - visited[i][j] = false → "Done with this cell, others can use it"
//
// ------------------------------------------------------------
// 🧠 Revision Questions
// ------------------------------------------------------------
// Q1. Why do we need visited[][] array?
// → Prevents infinite loops (cycling back to same cell in current path)
// → Example: Without it, could go right→left→right→left forever
// → visited[][] tracks "cells in current exploration path"
//
// Q2. What if we DON'T backtrack (skip visited[row][col] = false)?
// → Only finds ONE path (first complete path discovered)
// → Other paths can't reuse cells from first path
// → visited[][] becomes "globally used cells" instead of "current path cells"
//
// Q3. Can we solve without visited array?
// → NO for this approach! Would create infinite loops
// → Alternative: Modify mat[][] directly (change 0→1, then 1→0 on backtrack)
// → But visited[][] is cleaner and doesn't modify input
//
// Q4. What if we only want to count paths, not print them?
// → Change return type to int
// → At destination: return 1 (found one path)
// → At each cell: return sum of all 4 direction results
//
// int countPaths(int row, int col, ...) {
// // ... same boundary checks, return 0 instead of return
// if (row == n-1 && col == m-1) return 1; // Found path
// visited[row][col] = true;
// int count = countPaths(row-1,col,...) + countPaths(row,col-1,...)
// + countPaths(row+1,col,...) + countPaths(row,col+1,...);
// visited[row][col] = false;
// return count;
// }
//
// ------------------------------------------------------------
// 🔥 Key Insights:
// ------------------------------------------------------------
// 1. **Flood Fill = DFS on 4-directional grid**
// - Explores all possible paths systematically
//
// 2. **visited[][] = "cells in current path"** (not globally used)
// - Mark when entering cell
// - Unmark when leaving cell (backtracking)
//
// 3. **Backtracking enables multiple path finding**
// - Without it: finds only one path
// - With it: finds all possible paths
//
// 4. **Pattern variations**:
// - Rat in Maze (LeetCode similar problems)
// - N-Queens (different grid, same backtracking idea)
// - Word Search (LeetCode 79)
// - Number of Islands (no backtracking needed)
//
// 💡 Interview Strategy:
// "I'll use DFS with backtracking. Mark cells as visited during exploration
// to prevent cycles. After exploring all directions from a cell, unmark it
// so alternate paths can use it. This systematically finds all valid paths."
// ------------------------------------------------------------