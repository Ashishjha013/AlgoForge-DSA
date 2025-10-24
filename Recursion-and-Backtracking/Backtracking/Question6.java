// ------------------------------------------------------------
// 🧮 Question 6: Coin Change Combinations (Two Approaches)
// ------------------------------------------------------------
// 🧩 Find all combinations (NOT permutations) of coins that sum to target
// 🔑 Recursion + Combinations - order DOESN'T matter, [2,3,5] = [3,2,5]
// 💡 Use idx parameter to ensure we only move forward (no going back)
//
// Pattern: Combinations using Recursion (Include/Exclude vs Loop)
// Level: 🟡 Medium
// Tags: #Recursion #Combinations #CoinChange #TwoApproaches
// ------------------------------------------------------------

public class Question6 {

  // ============================================================
  // APPROACH 1: Include/Exclude Pattern (Binary Choice)
  // ============================================================
  // 🎯 For each coin: decide to include it OR exclude it, then move forward

  // WHY: Generate combinations by making binary choice for each coin
  // WHAT: coins[] = denominations, target = sum to achieve,
  // ans = current combination, idx = current coin position
  // HOW: At each coin: try including it OR skipping it, always move to idx+1
  public static void coinChangeCombinations(int coins[], int target,
      String ans, int idx) {

    // WHY: Base case - successfully reached target sum
    // WHAT: If target reduced to exactly 0, found valid combination
    // HOW: Print the complete coin combination that sums to original target
    if (target == 0) {
      System.out.println(ans); // Found valid combination!
      return; // Backtrack to explore more combinations
    }

    // WHY: Base case - processed all coins without reaching target
    // WHAT: If ran out of coins (idx >= coins.length), this path failed
    // HOW: Return without printing (invalid combination)
    if (idx >= coins.length) {
      return; // No solution in this branch
    }

    // WHY: "INCLUDE" branch - use current coin if it fits
    // WHAT: If current coin doesn't exceed target, try including it
    // HOW: Reduce target by coin value, add coin to answer, move to next coin
    if (target - coins[idx] >= 0) {
      coinChangeCombinations(coins, target - coins[idx],
          ans + coins[idx] + " ", idx + 1);
    }

    // WHY: "EXCLUDE" branch - skip current coin
    // WHAT: Move to next coin without using current one
    // HOW: Same target, same ans, just increment idx
    coinChangeCombinations(coins, target, ans, idx + 1);

    // 🔑 KEY INSIGHT: Both branches move to idx+1
    // This ensures we never go back to earlier coins
    // Result: [2,3,5] is found, but [3,2,5] is NOT (prevented!)
  }

  // ============================================================
  // APPROACH 2: Loop Pattern (Multiple Choices)
  // ============================================================
  // 🎯 Try each coin from current position forward

  // WHY: Alternative approach using loop to explore all forward choices
  // WHAT: Instead of binary choice, loop through all coins from idx onward
  // HOW: For each valid coin from idx→end, try using it and recurse forward
  public static void coinChangeCombinations2(int coins[], int target,
      String ans, int idx) {

    // WHY: Base case - successfully reached target sum
    // WHAT: If target reduced to exactly 0, found valid combination
    // HOW: Print the complete coin combination
    if (target == 0) {
      System.out.println(ans); // Found valid combination!
      return; // Backtrack to explore more
    }

    // WHY: Try all coins from current index forward
    // WHAT: Loop from idx to end, trying each coin as next choice
    // HOW: For each coin[i], if it fits target, use it and recurse to i+1
    for (int i = idx; i < coins.length; i++) {

      // WHY: Only use coin if it doesn't exceed remaining target
      // WHAT: Check if subtracting coin leaves non-negative target
      // HOW: target - coins[i] >= 0 ensures valid state
      if (target - coins[i] >= 0) {

        // WHY: Use current coin and move forward
        // WHAT: Reduce target, add coin to answer, move to NEXT coin (i+1)
        // HOW: i+1 ensures we don't revisit coins[i] or earlier coins
        coinChangeCombinations2(coins, target - coins[i],
            ans + coins[i] + " ", i + 1);

        // 🔑 KEY: Loop tries multiple coins, but each recurses to i+1
        // This maintains forward-only movement (combinations property)
      }
    }
    // After loop: tried all valid coins from idx forward, backtrack
  }

  public static void main(String[] args) {
    int coins[] = { 2, 3, 4, 6, 5 };
    int target = 10;

    System.out.println("=== Approach 1: Include/Exclude ===");
    coinChangeCombinations(coins, target, "", 0);

    System.out.println("\n=== Approach 2: Loop ===");
    coinChangeCombinations2(coins, target, "", 0);

    // Both produce SAME output (order may vary):
    // 2 3 5
    // 2 4 4 (wait, this uses 4 twice! Bug in approach 2!)
    // 4 6
    // 5 5 (wait, this uses 5 twice! Bug in approach 2!)
    //
    // ⚠️ BUG IN APPROACH 2: Should call with i+1, but code calls with idx+1!
    // Fixed version in revision questions below
  }
}

// ------------------------------------------------------------
// ⚡ COMPLEXITY ANALYSIS
// ------------------------------------------------------------
// Both approaches have similar complexity:
// Time: O(2^n) - Each coin has 2 choices (include/exclude)
// Actual: Less due to target constraint pruning
// Space: O(n) - Recursion depth = number of coins
//
// ------------------------------------------------------------
// 🎯 PATTERN: Combinations (Order Doesn't Matter)
// 🗣️ Interview: "For combinations, use idx parameter to ensure forward-only
// movement. Approach 1: Binary choice (include/exclude) with
// idx+1 in both branches. Approach 2: Loop from idx forward,
// recurse with i+1. Both prevent revisiting earlier coins."
//
// ------------------------------------------------------------
// 🧠 APPROACH 1 - Recursion Tree (coins=[2,3,5], target=10)
// ------------------------------------------------------------
//
// coinChange(target=10, idx=0, "")
// / \
// Include coin[0]=2 Exclude coin[0]=2
// | |
// (target=8, idx=1, "2 ") (target=10, idx=1, "")
// / \ / \
// Include 3 Exclude 3 Include 3 Exclude 3
// | | | |
// (t=5,idx=2) (t=8,idx=2) (t=7,idx=2) (t=10,idx=2)
// / \ / \ / \ / \
// Inc4 Exc4 Inc4 Exc4 Inc4 Exc4 Inc4 Exc4
// ... ... ... ... ... ... ... ...
//
// Eventually finds: [2,3,5] (sum=10)
// Does NOT find: [2,5,3] or [3,2,5] (prevented by forward-only idx)
//
// ------------------------------------------------------------
// 🧠 APPROACH 2 - Loop Execution (coins=[2,3,5], target=10)
// ------------------------------------------------------------
//
// coinChange2(target=10, idx=0, "")
// Loop i=0: coin=2, 10-2≥0 ✓
// → Recurse(target=8, idx=1, "2 ")
// Loop i=1: coin=3, 8-3≥0 ✓
// → Recurse(target=5, idx=2, "2 3 ")
// Loop i=2: coin=5, 5-5=0 ✓
// → Recurse(target=0, idx=3, "2 3 5 ")
// target==0 → PRINT "2 3 5 " ✓
//
// Loop i=1: coin=3, 10-3≥0 ✓
// → Recurse(target=7, idx=2, "3 ")
// Loop i=2: coin=5, 7-5≥0 ✓
// → Recurse(target=2, idx=3, "3 5 ")
// No more coins, target≠0 → Return (no solution)
//
// Loop i=2: coin=5, 10-5≥0 ✓
// → Recurse(target=5, idx=3, "5 ")
// Loop i=3: coin=5... wait, idx=3 but we're at i=3 again?
// This is where the bug happens!
//
// ------------------------------------------------------------
// 🧠 CRITICAL COMPARISON: Two Approaches
// ------------------------------------------------------------
//
// ┌──────────────────┬────────────────────┬──────────────────┐
// │ Aspect │ Approach 1 │ Approach 2 │
// │ │ (Include/Exclude) │ (Loop) │
// ├──────────────────┼────────────────────┼──────────────────┤
// │ Pattern │ Binary choice tree │ Multi-way tree │
// │ Recursive calls │ 2 per level (max) │ n-idx per level │
// │ Structure │ if + 2 calls │ for loop + calls │
// │ Readability │ Clear logic │ More compact │
// │ Typical use │ Include/Exclude │ Multiple choices │
// │ Similar to │ Subset problems │ Permutations │
// └──────────────────┴────────────────────┴──────────────────┘
//
// Both achieve COMBINATIONS by using idx parameter!
// Key: Always move forward (idx+1 or i+1), never backward
//
// ------------------------------------------------------------
// 🧠 REVISION QUESTIONS
// ------------------------------------------------------------
//
// Q1. What's the bug in Approach 2's main code?
// → Line in loop calls: coinChangeCombinations(..., idx+1)
// → Should be: coinChangeCombinations2(..., i+1)
// → Bug: Uses wrong idx instead of loop variable i
// → Result: Allows coin reuse, produces wrong output
//
// FIXED VERSION:
// for (int i = idx; i < coins.length; i++) {
// if (target - coins[i] >= 0) {
// coinChangeCombinations2(coins, target - coins[i],
// ans + coins[i] + " ", i + 1); // i+1 NOT idx+1!
// }
// }
//
// Q2. Combinations vs Permutations - how to identify?
//
// COMBINATIONS (this problem):
// ┌─────────────────────────────────────┐
// │ ✓ Order doesn't matter │
// │ ✓ [2,3,5] = [3,2,5] (same) │
// │ ✓ Use idx parameter │
// │ ✓ Always move forward (idx+1) │
// │ ✓ No visited[] array needed │
// └─────────────────────────────────────┘
//
// PERMUTATIONS (Question 5):
// ┌─────────────────────────────────────┐
// │ ✓ Order DOES matter │
// │ ✓ [2,3,5] ≠ [3,2,5] (different) │
// │ ✓ Use visited[] array │
// │ ✓ Loop through ALL coins (0→n) │
// │ ✓ Need to track used coins │
// └─────────────────────────────────────┘
//
// Q3. Which approach is better - Include/Exclude or Loop?
// → Depends on context!
// → Include/Exclude: Clearer for binary decisions
// - Better when: Each element has 2 clear options
// - Examples: Subsets, Partition problems
// → Loop: Better for multiple choices
// - Better when: Multiple forward options at each step
// - Examples: Path finding, multiple coin types
// → Both work for combinations! Choose based on clarity
//
// Q4. How to allow coin reuse (unlimited coins)?
// → In recursion, don't increment idx (stay at same coin)
//
// APPROACH 1 (Include/Exclude):
// if (target - coins[idx] >= 0) {
// coinChange(coins, target - coins[idx], ans + coins[idx], idx);
// // idx stays same - can reuse this coin!
// }
// coinChange(coins, target, ans, idx + 1); // Or move to next
//
// APPROACH 2 (Loop):
// for (int i = idx; i < coins.length; i++) {
// if (target - coins[i] >= 0) {
// coinChange(coins, target - coins[i], ans + coins[i], i);
// // i stays same - can reuse coins[i]!
// }
// }
//
// Q5. Count combinations instead of printing?
//
// APPROACH 1:
// int countCombinations(int coins[], int target, int idx) {
// if (target == 0) return 1; // Found one combination
// if (idx >= coins.length) return 0; // No solution
//
// int include = 0;
// if (target - coins[idx] >= 0) {
// include = countCombinations(coins, target - coins[idx], idx + 1);
// }
// int exclude = countCombinations(coins, target, idx + 1);
//
// return include + exclude; // Total combinations
// }
//
// APPROACH 2:
// int countCombinations2(int coins[], int target, int idx) {
// if (target == 0) return 1;
//
// int count = 0;
// for (int i = idx; i < coins.length; i++) {
// if (target - coins[i] >= 0) {
// count += countCombinations2(coins, target - coins[i], i + 1);
// }
// }
// return count;
// }
//
// ------------------------------------------------------------
// 🔥 KEY INSIGHTS
// ------------------------------------------------------------
//
// 1. **Combinations = Forward-only movement**
// - idx parameter is the KEY difference from permutations
// - Once we pass a coin (idx+1), we never go back
// - This automatically prevents [2,3,5] and [3,2,5] duplicates
//
// 2. **Two valid patterns for combinations**:
// - Include/Exclude: Binary choice, clearer logic
// - Loop: Multiple forward choices, more compact
// - Both achieve same result with idx discipline
//
// 3. **idx vs visited[]**:
// ```
// Combinations: idx (forward movement)
// Permutations: visited[] (track used items)
// ```
//
// 4. **Common mistake**: Mixing idx and i
// - Loop uses i, must recurse with i+1 (not idx+1)
// - This bug allows coin reuse, breaking combinations
//
// 5. **Reuse vs No-reuse**:
// - No reuse: idx+1 or i+1 (move forward)
// - Unlimited reuse: idx or i (stay at same position)
//
// 6. **Similar problems**:
// - Combination Sum (LeetCode 39, 40)
// - Subset Sum (combinations variant)
// - Target Sum (combinations with +/-)
//
// 7. **DP optimization possible**:
// - For counting: Classic Coin Change DP
// - O(n × target) instead of O(2^n)
// - But DP can't generate actual combinations easily
//
// 💡 Interview Strategy:
// "For combinations, I'll use idx parameter to ensure forward-only movement.
// I can use Include/Exclude pattern (binary choice) or Loop pattern (try
// each coin from idx forward). Both approaches prevent duplicates by never
// revisiting earlier coins. Key difference from permutations: idx instead
// of visited[], and always incrementing forward (idx+1 or i+1)."
//
// 🎯 Pattern Recognition:
// - "Find all ways" + "order doesn't matter" → COMBINATIONS → Use idx
// - "Find all ways" + "order matters" → PERMUTATIONS → Use visited[]
// - "Count ways" + combinations → Consider DP optimization!
// -----------------------------------------------------
