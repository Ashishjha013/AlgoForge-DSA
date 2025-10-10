// Question 3: Find the Exit Point of a Matrix
// --------------------------------------------
// Pattern: Simulation / Direction Control in a Matrix
// Level: Basic → Medium
// Tags: #Matrix #Direction #Simulation #WhileLoop

/*
Problem Statement:
------------------
You are given a binary matrix (0s and 1s).
Start from the top-left corner (0,0) facing East (right).
Whenever you encounter a 0, keep moving in the same direction.
Whenever you encounter a 1, turn 90° clockwise and then move forward.

You need to find the "exit point" — the cell where you move out of the matrix.
*/

/*
Directions Mapping (dir values):
--------------------------------
0 → East (Right)
1 → South (Down)
2 → West (Left)
3 → North (Up)
*/

public class Question3 {

  public static void findExitPoint(int[][] mat) {
    int n = mat.length; // number of rows
    int m = mat[0].length; // number of columns

    int row = 0, col = 0; // starting position
    int dir = 0; // 0 = East

    while (row >= 0 && row < n && col >= 0 && col < m) {
      // Update direction if current cell = 1
      if (mat[row][col] == 1) {
        dir = (dir + 1) % 4; // Turn 90° clockwise
        mat[row][col] = 0; // Optional: mark visited (avoid infinite loops)
      }

      // Move in the current direction
      if (dir == 0) {
        col++; // Move right
      } else if (dir == 1) {
        row++; // Move down
      } else if (dir == 2) {
        col--; // Move left
      } else {
        row--; // Move up
      }
    }

    // Step back to last valid position (inside matrix)
    if (dir == 0) {
      col--; // moved right → step left
    } else if (dir == 1) {
      row--; // moved down → step up
    } else if (dir == 2) {
      col++; // moved left → step right
    } else {
      row++; // moved up → step down
    }

    System.out.println("Exit Point: (" + row + ", " + col + ")");
  }

  public static void main(String[] args) {
    int[][] binaryMatrix = {
        { 0, 0, 0, 1, 0, 0 },
        { 0, 1, 0, 0, 0, 0 },
        { 1, 0, 1, 0, 1, 0 },
        { 0, 1, 0, 1, 1, 0 },
        { 0, 0, 0, 0, 0, 1 }
    };

    findExitPoint(binaryMatrix);
  }
}

/*
 * 🧭 Key Takeaways:
 * -----------------
 * 1. Use (dir + 1) % 4 to rotate directions cyclically (0→1→2→3→0).
 * 2. Always step back one move when you go out of bounds.
 * 3. Typical pattern: Matrix traversal + direction simulation.
 * 4. Time Complexity: O(n × m)
 * 
 * 🧠 Quick Questions:
 * -------------------
 * 1. What happens if you don’t step back after exiting the while loop?
 * 2. Can this be modified to return the *path* taken before exit?
 * 3. How can you handle infinite loops if matrix values keep changing
 * dynamically?
 */
