// ------------------------------------------------------------
// 🧮 Question 5: Coin Change Permutations (With Repetition)
// ------------------------------------------------------------
// 🧩 Find all permutations of coins that sum to target (each coin used once)
// 🔑 Backtracking + Permutations - try each coin, mark used, backtrack
// 💡 At each step, try all unused coins that don't exceed remaining target
//
// Pattern: Backtracking + Permutations (Order Matters)
// Level: 🟡 Medium
// Tags: #Backtracking #Permutations #CoinChange #Recursion
// ------------------------------------------------------------

public class Question5 {

  // WHY: Generate all permutations (different orderings) summing to target
  // WHAT: coins[] = available denominations, target = sum to achieve,
  // visited[] = tracks which coins already used in current permutation,
  // ans = current sequence of coins chosen
  // HOW: Try each unused coin, mark it, recurse with reduced target, backtrack
  public static void coinChangePermutations(int coins[], int target,
      boolean visited[], String ans) {

    // WHY: Base case - successfully reached target sum
    // WHAT: If target reduced to exactly 0, found valid permutation
    // HOW: Print the complete coin sequence that sums to original target
    if (target == 0) {
      System.out.println(ans); // Found valid permutation!
      return; // Backtrack to find more permutations
    }

    // WHY: Try each coin as next choice in permutation
    // WHAT: Loop through all coins to explore different orderings
    // HOW: For each coin, check if it's available and fits remaining target
    for (int i = 0; i < coins.length; i++) {

      // WHY: Check if coin can be used in current state
      // WHAT: Coin must be: (1) not already used, AND (2) not exceed target
      // HOW: !visited[i] ensures coin available, target-coins[i]>=0 ensures valid
      if (!visited[i] && target - coins[i] >= 0) {

        // WHY: Mark coin as used in current permutation
        // WHAT: Set visited[i] = true to prevent reusing same coin
        // HOW: This coin now unavailable for deeper recursion levels
        visited[i] = true;

        // WHY: Recurse with this coin chosen
        // WHAT: Reduce target by coin value, append coin to answer string
        // HOW: target - coins[i] = new remaining target to achieve
        coinChangePermutations(coins, target - coins[i], visited,
            ans + coins[i] + " ");

        // WHY: BACKTRACKING - unmark coin after exploring this branch
        // WHAT: Reset visited[i] = false to make coin available again
        // HOW: Allows other permutations to use this coin in different position
        visited[i] = false; // Backtrack - coin available for other orderings
      }
    }
    // After loop: tried all coins from current state, backtrack to previous level
  }

  public static void main(String[] args) {
    int coins[] = { 2, 3, 4, 6, 5 };
    int target = 10;
    boolean visited[] = new boolean[coins.length]; // Track used coins
    coinChangePermutations(coins, target, visited, "");

    // Sample Output (different orderings of same coins):
    // 2 3 5
    // 2 5 3
    // 3 2 5
    // 3 5 2
    // 4 6
    // 5 2 3
    // 5 3 2
    // 6 4
    // Note: "2 3 5" and "3 2 5" are DIFFERENT permutations!
  }
}

// ------------------------------------------------------------
// ⚡ COMPLEXITY ANALYSIS
// ------------------------------------------------------------
// Time: O(n! * n) - For each permutation (~n!), loop through n coins
// Actual: Less due to target constraint pruning
// Space: O(n) - Visited array + recursion depth (max n coins used)
//
// ------------------------------------------------------------
// 🎯 PATTERN: Permutations with Constraints (Backtracking)
// 🗣️ Interview: "Generate permutations by trying each unused coin at each
// step.
// Mark coin as used, recurse with reduced target, then backtrack
// by unmarking. This explores all orderings that sum to target."
//
// ------------------------------------------------------------
// 🧠 Visual Example - coins=[2,3,5], target=10
// ------------------------------------------------------------
//
// Recursion Tree (partial):
//
// coinChange(target=10, visited=[F,F,F], "")
// / | \
// Choose 2 Choose 3 Choose 5
// visited[0]=T visited[1]=T visited[2]=T
// | | |
// (target=8, "2 ") (target=7, "3 ") (target=5, "5 ")
// / | \ / | \ / | \
// [1]=T [2]=T X [0]=T [2]=T X [0]=T [1]=T X
// | | | | | |
// (t=5, (t=3, (t=5, (t=2, (t=3, (t=2,
// "2 3 ") "2 5 ") "3 2") "3 5") "5 2") "5 3")
// | | | | | |
// [2]=T [1]=T [2]=T [0]=T [1]=T [0]=T
// | | | | | |
// (t=0, (t=0, (t=0, (t=0, (t=0, (t=0,
// "2 3 5")"2 5 3") "3 2 5")"3 5 2") "5 2 3")"5 3 2")
// PRINT PRINT PRINT PRINT PRINT PRINT
//
// All 6 permutations of [2,3,5] that sum to 10!
//
// ------------------------------------------------------------
// 🧠 Execution Trace - Step by Step
// ------------------------------------------------------------
//
// Call 1: coinChange(target=10, visited=[F,F,F,F,F], "")
// Loop i=0: coin=2, not visited, 10-2≥0 ✓
// visited[0]=true → [T,F,F,F,F]
// Recurse with target=8, ans="2 "
//
// Call 2: coinChange(target=8, visited=[T,F,F,F,F], "2 ")
// Loop i=0: visited, skip
// Loop i=1: coin=3, not visited, 8-3≥0 ✓
// visited[1]=true → [T,T,F,F,F]
// Recurse with target=5, ans="2 3 "
//
// Call 3: coinChange(target=5, visited=[T,T,F,F,F], "2 3 ")
// Loop i=0,1: visited, skip
// Loop i=2: coin=4, not visited, but 5-4=1, can't reach 0 later
// Loop i=3: coin=6, not visited, but 5-6<0 ✗
// Loop i=4: coin=5, not visited, 5-5=0 ✓
// visited[4]=true → [T,T,F,F,T]
// Recurse with target=0, ans="2 3 5 "
//
// Call 4: target==0 → PRINT "2 3 5 " ✓
// Return
//
// visited[4]=false → [T,T,F,F,F] (backtrack)
// Return
//
// visited[1]=false → [T,F,F,F,F] (backtrack)
//
// Loop i=2: coin=4, try this path...
// Loop i=3: coin=6, try this path...
// Loop i=4: coin=5, try this path (finds "2 5 3")...
// Return
//
// visited[0]=false → [F,F,F,F,F] (backtrack)
//
// Loop i=1: coin=3, try entire branch (finds "3 2 5", "3 5 2")...
// Loop i=2: coin=4, try entire branch (finds "4 6")...
// ... and so on
//
// ------------------------------------------------------------
// 🧠 COMPARISON: Permutations vs Combinations
// ------------------------------------------------------------
//
// ┌─────────────────┬──────────────────┬──────────────────┐
// │ Aspect │ PERMUTATIONS │ COMBINATIONS │
// │ │ (This Problem) │ (Different) │
// ├─────────────────┼──────────────────┼──────────────────┤
// │ Order matters? │ YES ✓ │ NO │
// │ Example │ [2,3,5] ≠ [3,2,5]│ [2,3,5] = [3,2,5]│
// │ Tracking │ visited[] array │ Start index │
// │ Loop │ All coins (0→n) │ From idx forward │
// │ Output count │ More (n! based) │ Less (C(n,k)) │
// │ Use case │ "Orderings" │ "Selections" │
// └─────────────────┴──────────────────┴──────────────────┘
//
// This problem: PERMUTATIONS (order matters!)
// - "2 3 5" is different from "3 2 5"
// - Need visited[] to prevent reusing same coin
//
// For COMBINATIONS version:
// void coinChangeCombinations(int coins[], int idx, int target, String ans) {
// if (target == 0) { print(ans); return; }
// for (int i = idx; i < coins.length; i++) { // Start from idx!
// if (target - coins[i] >= 0) {
// coinChangeCombinations(coins, i+1, target-coins[i], ans+coins[i]);
// }
// }
// }
// No visited[] needed - idx ensures we only go forward!
//
// ------------------------------------------------------------
// 🧠 REVISION QUESTIONS
// ------------------------------------------------------------
//
// Q1. Why do we need visited[] array?
// → Prevents using same coin multiple times in one permutation
// → Example: Without visited, could get "2 2 2 2 2" for target=10
// → Each coin can be used at most ONCE per permutation
// → visited[i]=true means "coin i already used in current sequence"
//
// Q2. Why does order matter in this problem?
// → Problem asks for PERMUTATIONS, not combinations
// → "2 then 3" is different path than "3 then 2"
// → Real-world: Order of transactions, sequence of operations
// → Output includes all orderings: [2,3,5], [2,5,3], [3,2,5]...
//
// Q3. How to modify for combinations (order doesn't matter)?
// → Remove visited[] array
// → Add idx parameter to track starting position
// → Loop from idx forward (prevents going back to earlier coins)
// → See comparison table above for full code
//
// Q4. What if coins CAN be reused unlimited times?
// → Don't mark as visited (no visited[] needed)
// → Allows same coin multiple times
//
// void coinChangeUnlimited(int coins[], int target, String ans) {
// if (target == 0) { print(ans); return; }
// for (int i = 0; i < coins.length; i++) {
// if (target - coins[i] >= 0) {
// coinChangeUnlimited(coins, target-coins[i], ans+coins[i]);
// // No visited tracking - coin stays available!
// }
// }
// }
//
// Q5. How to count permutations instead of printing?
//
// int countPermutations(int coins[], int target, boolean visited[]) {
// if (target == 0) return 1; // Found one permutation
//
// int count = 0;
// for (int i = 0; i < coins.length; i++) {
// if (!visited[i] && target - coins[i] >= 0) {
// visited[i] = true;
// count += countPermutations(coins, target-coins[i], visited);
// visited[i] = false; // Backtrack
// }
// }
// return count;
// }
//
// ------------------------------------------------------------
// 🔥 KEY INSIGHTS
// ------------------------------------------------------------
//
// 1. **Permutations = Order Matters**
// - [2,3,5] ≠ [3,2,5] (different sequences)
// - Need visited[] to track used coins
// - Loop through ALL coins (0 to n) at each level
//
// 2. **visited[] prevents coin reuse**
// - Each coin used at most once per permutation
// - Mark true when choosing, false when backtracking
// - Critical difference from unlimited coins problem
//
// 3. **Backtracking pattern**:
// ```
// for each choice:
// if valid:
// make choice (mark visited)
// recurse
// unmake choice (unmark visited) ← BACKTRACK
// ```
//
// 4. **Pruning optimization**
// - Check `target - coins[i] >= 0` before recursing
// - Prevents exploring impossible branches
// - Reduces search space significantly
//
// 5. **Loop at each level vs Binary choice**
// - Include/Exclude: 2 recursive calls per level
// - This problem: Loop with n calls per level
// - More branching = more possible solutions
//
// 6. **Similar problems**:
// - String Permutations (swap-based or visited-based)
// - N-Queens (try each column, mark used)
// - Sudoku (try each digit, mark constraints)
// - Subset Sum Permutations (same pattern!)
//
// 7. **Real-world applications**:
// - Currency exchange sequences
// - Task scheduling orderings
// - Manufacturing process sequences
// - Recipe ingredient ordering
//
// 💡 Interview Strategy:
// "This is a permutations problem where order matters. I'll use backtracking
// with a visited[] array to track used coins. At each step, try all unused
// coins that fit remaining target. Mark coin as used, recurse, then backtrack
// by unmarking. This explores all valid orderings. For combinations (order
// doesn't matter), I'd use an index parameter instead of visited[]."
//
// 🎯 Pattern Recognition:
// - See visited[] array → Think PERMUTATIONS
// - See idx parameter → Think COMBINATIONS
// - See both → Hybrid problem (permutations with constraints)
// ------------------------------------------------------------
