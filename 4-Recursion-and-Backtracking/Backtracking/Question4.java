// ------------------------------------------------------------
// 🧮 Question 4: Knight's Tour Problem
// ------------------------------------------------------------
// 🧩 Find a sequence of knight moves that visits every square on chessboard exactly once
// 🔑 Backtracking + Chess Knight Moves - explore all 8 possible L-shaped moves
// 💡 Try each of 8 knight moves, mark visited, recurse, backtrack if dead-end
//
// Pattern: Backtracking on 2D Grid (Knight's Tour / Hamiltonian Path)
// Level: 🔴 Hard | Classic Chess Problem
// Tags: #Backtracking #ChessKnight #HamiltonianPath #GraphTraversal
// ------------------------------------------------------------

public class Question4 {

  // WHY: Utility to display current board state
  // WHAT: Print 2D array showing knight's path with step numbers
  // HOW: Nested loops iterate through board, print each cell value
  public static void printBoard(int[][] board) {
    for (int[] row : board) {
      for (int cell : row) {
        System.out.print(cell + " "); // Print step number (0 = unvisited)
      }
      System.out.println();
    }
    System.out.println(); // Extra line for separation between solutions
  }

  // WHY: Core recursive function to explore knight's tour
  // WHAT: Try to visit all board squares using valid knight moves
  // HOW: Mark current square, try all 8 moves, backtrack if no solution
  public static void knightTour(int row, int col, int[][] board, int currentStep) {
    int n = board.length; // Number of rows
    int m = board[0].length; // Number of columns

    // WHY: Boundary and validity checks - ensure move is legal
    // WHAT: Check if position is out of bounds OR already visited
    // HOW: Multiple conditions combined - any violation returns immediately
    if (row < 0 || col < 0 || row >= n || col >= m // Out of bounds
        || board[row][col] != 0) { // Already visited (!=0)
      return; // Invalid move, backtrack
    }

    // WHY: Success condition - visited all squares
    // WHAT: If currentStep equals total squares, found complete tour
    // HOW: n*m = total squares on board, currentStep tracks visited count
    if (currentStep == n * m) {
      board[row][col] = currentStep; // Mark last square
      printBoard(board); // Print complete solution
      board[row][col] = 0; // Backtrack for other solutions
      return;
    }

    // WHY: Mark current square as visited with step number
    // WHAT: Set board[row][col] = currentStep (shows visit order)
    // HOW: Step 1, 2, 3... shows the sequence of knight's path
    board[row][col] = currentStep;

    // WHY: Try all 8 possible knight moves (L-shaped: 2+1 or 1+2)
    // WHAT: Knight can move in 8 directions from current position
    // HOW: Each call explores one of the 8 L-shaped moves

    // Knight's 8 possible moves (clockwise from top-left):
    // ↑2 ←1 ↑2 →1
    // 🠔 🠖
    // ←1 ↑2 →1 ↑2
    // ♞ (Knight at center)
    // ←1 ↓2 →1 ↓2
    // 🠔 🠖
    // ↓2 ←1 ↓2 →1

    knightTour(row - 2, col - 1, board, currentStep + 1); // Move 1: Up 2, Left 1
    knightTour(row - 2, col + 1, board, currentStep + 1); // Move 2: Up 2, Right 1
    knightTour(row - 1, col + 2, board, currentStep + 1); // Move 3: Up 1, Right 2
    knightTour(row + 1, col + 2, board, currentStep + 1); // Move 4: Down 1, Right 2
    knightTour(row + 2, col + 1, board, currentStep + 1); // Move 5: Down 2, Right 1
    knightTour(row + 2, col - 1, board, currentStep + 1); // Move 6: Down 2, Left 1
    knightTour(row + 1, col - 2, board, currentStep + 1); // Move 7: Down 1, Left 2
    knightTour(row - 1, col - 2, board, currentStep + 1); // Move 8: Up 1, Left 2

    // WHY: BACKTRACKING - unmark square to try different paths
    // WHAT: Reset board[row][col] = 0 (mark as unvisited)
    // HOW: Allows other paths to use this square in different order
    board[row][col] = 0; // Backtrack - unmark for alternate tours
  }

  public static void main(String[] args) {
    int[][] board = new int[8][8]; // Standard 8×8 chessboard
    knightTour(2, 3, board, 1); // Start at position (2,3), step 1
    // Note: Starting position (2,3) chosen arbitrarily
    // Different starting positions may have different solution counts
  }
}

// ------------------------------------------------------------
// ⚡ COMPLEXITY ANALYSIS
// ------------------------------------------------------------
// Time: O(8^(n*m)) - Worst case: 8 choices per square, n*m squares
// In practice: Much better due to constraint pruning (visited check)
// Space: O(n*m) - Board storage + O(n*m) recursion depth
//
// Note: Knight's tour is NP-complete! No polynomial solution known
// For 8×8 board: ~10^51 possible paths (but most pruned early)
//
// ------------------------------------------------------------
// 🎯 PATTERN: Hamiltonian Path on Chess Board
// 🗣️ Interview: "Use backtracking to explore all 8 knight moves. Mark square
// with step number, try all moves recursively, backtrack if
// dead-end. Success when visited all n*m squares."
//
// ------------------------------------------------------------
// 🧠 Visual Example - Knight's Move Pattern
// ------------------------------------------------------------
//
// Knight at center (♞) can move to 8 positions (numbered):
//
// ┌───┬───┬───┬───┬───┐
// │ │ 1 │ │ 2 │ │
// ├───┼───┼───┼───┼───┤
// │ 8 │ │ │ │ 3 │
// ├───┼───┼───┼───┼───┤
// │ │ │ ♞ │ │ │ (Knight at center)
// ├───┼───┼───┼───┼───┤
// │ 7 │ │ │ │ 4 │
// ├───┼───┼───┼───┼───┤
// │ │ 6 │ │ 5 │ │
// └───┴───┴───┴───┴───┘
//
// Each move is L-shaped: 2 squares in one direction + 1 square perpendicular
//
// Move offsets: (row, col)
// 1: (-2, -1) 2: (-2, +1)
// 3: (-1, +2) 4: (+1, +2)
// 5: (+2, +1) 6: (+2, -1)
// 7: (+1, -2) 8: (-1, -2)
//
// ------------------------------------------------------------
// 🧠 Sample Solution Path (5×5 board starting at 0,0)
// ------------------------------------------------------------
//
// One possible Knight's Tour:
// ┌────┬────┬────┬────┬────┐
// │ 1 │ 14 │ 9 │ 20 │ 3 │ Step 1 starts at (0,0)
// ├────┼────┼────┼────┼────┤
// │ 8 │ 19 │ 2 │ 15 │ 10 │ Step 2 moves to (2,1)
// ├────┼────┼────┼────┼────┤
// │ 13 │ 24 │ 21 │ 4 │ 17 │ Step 3 moves to (0,4)
// ├────┼────┼────┼────┼────┤
// │ 18 │ 7 │ 12 │ 25 │ 16 │ ...and so on
// ├────┼────┼────┼────┼────┤
// │ 23 │ 6 │ 5 │ 22 │ 11 │ Step 25 completes tour
// └────┴────┴────┴────┴────┘
//
// This shows a valid Hamiltonian path visiting all 25 squares once!
//
// ------------------------------------------------------------
// 🧠 Backtracking Example - Partial Execution
// ------------------------------------------------------------
//
// Starting at (0,0), step 1:
//
// board[0][0] = 1 (mark as visited)
// Try Move 1: (-2,-1) → (-2,-1) out of bounds → return
// Try Move 2: (-2,+1) → (-2,1) out of bounds → return
// Try Move 3: (-1,+2) → (-1,2) out of bounds → return
// Try Move 4: (+1,+2) → (1,2) valid! → recurse
//
// At (1,2), step 2:
// board[1][2] = 2
// Try Move 1: (-1,1) → (0,1) valid! → recurse
//
// At (0,1), step 3:
// board[0][1] = 3
// Try all 8 moves... (recursion continues)
//
// If dead-end reached:
// board[0][1] = 0 (backtrack - unmark)
// return
//
// Try next move from (1,2)...
// If all moves fail from (1,2):
// board[1][2] = 0 (backtrack)
// return
//
// Try Move 5 from (0,0)... and so on
//
// Eventually finds complete tour OR exhausts all possibilities
//
// ------------------------------------------------------------
// 🧠 REVISION QUESTIONS
// ------------------------------------------------------------
//
// Q1. Why check board[row][col] != 0 instead of a separate visited array?
// → Space optimization: board itself tracks visited (0 = unvisited)
// → Step numbers (1,2,3...) show visit order AND mark visited
// → Dual purpose: tracking path AND preventing revisits
//
// Q2. Why is this problem computationally hard?
// → Hamiltonian path problem (visit all vertices once)
// → NP-complete: No known polynomial-time algorithm
// → For 8×8 board: ~10^51 theoretical paths (most pruned)
// → Larger boards become intractable very quickly
//
// Q3. How to optimize / find solution faster?
// → **Warnsdorff's Heuristic**: Always move to square with fewest onward moves
// → Reduces backtracking dramatically
// → Not guaranteed to find solution, but much faster when it does
//
// int countOnwardMoves(int row, int col, int[][] board) {
// int count = 0;
//  Check all 8 moves, count valid unvisited squares
// for (each of 8 knight moves) {
// if (isValid && board[newRow][newCol] == 0) count++;
// }
// return count;
// }
//
//  Then choose move with minimum onward moves
//
// Q4. What if we want to count tours instead of printing?
//
// int countKnightTours(int row, int col, int[][] board, int step) {
//  ... same boundary checks
//
// if (step == n * m) {
// board[row][col] = step;
// int count = 1; // Found one tour
// board[row][col] = 0;
// return count;
// }
//
// board[row][col] = step;
// int totalTours = 0;
//
//  Sum tours from all 8 moves
// totalTours += countKnightTours(row-2, col-1, board, step+1);
//  ... repeat for all 8 moves
//
// board[row][col] = 0;
// return totalTours;
// }
//
// Q5. Can knight return to starting square (closed tour)?
// → Yes! Called "closed knight's tour" or "knight's cycle"
// → Modify success condition:
//
// if (step == n*m) {
//  Check if current position can reach starting position
// if (isValidKnightMove(row, col, startRow, startCol)) {
//  Found closed tour!
// }
// }
//
// ------------------------------------------------------------
// 🔥 KEY INSIGHTS
// ------------------------------------------------------------
//
// 1. **Classic Hamiltonian Path Problem**
// - Visit every vertex (square) exactly once
// - Knight's moves define the graph edges
// - NP-complete: computationally difficult
//
// 2. **8-way branching factor**
// - Unlike N-Queens (N branches) or Flood Fill (4 branches)
// - Each square has up to 8 choices
// - Early pruning critical for performance
//
// 3. **Board as visited tracker**
// - Clever use: 0 = unvisited, 1-64 = step number
// - No need for separate boolean[][] visited
// - Step numbers show the actual path sequence
//
// 4. **Starting position matters**
// - Corner squares: Only 2 possible first moves
// - Center squares: Up to 8 possible first moves
// - Some starting positions have 0 solutions!
//
// 5. **Optimization techniques**:
// - Warnsdorff's Heuristic (greedy choice of next move)
// - Divide and conquer approaches
// - Bit manipulation for visited tracking
// - Neural network heuristics (modern approach)
//
// 6. **Real-world applications**:
// - Puzzle solving
// - Robot path planning
// - Network routing optimization
// - DNA sequencing (similar graph problems)
//
// 7. **Similar problems**:
// - N-Queens (different constraint pattern)
// - Sudoku (constraint satisfaction)
// - Rat in Maze (4 moves, not 8)
// - Traveling Salesman (visit all cities)
//
// 💡 Interview Strategy:
// "Knight's Tour is a Hamiltonian path on a chessboard graph. I'll use
// backtracking to try all 8 knight moves from each position. Mark squares
// with step numbers (serves as visited check), recurse until all squares
// visited or dead-end. Backtrack by unmarking. This is NP-complete, so
// optimizations like Warnsdorff's heuristic help in practice."
//
// 🎯 Fun Fact: On an 8×8 board, there are approximately
// 26,534,728,821,064 closed knight's tours!
// ------------------------------------------------------------