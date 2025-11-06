// ------------------------------------------------------------
// 🧮 Question 7: Coin Change - Unlimited Coins (Combinations)
// ------------------------------------------------------------
// 🧩 Find all combinations that sum to target using unlimited coins
// 🔑 Core Concept: Each coin can be used multiple times
// 💡 Pattern: Combinations with Repetition
//
// Level: 🟡 Medium
// Tags: #Recursion #Combinations #CoinChange
// ------------------------------------------------------------

public class Question7 {

  // ============================================================
  // APPROACH 1: Include/Exclude Pattern
  // ============================================================

  // WHY: Generate combinations where each coin can be reused
  // WHAT: coins = available denominations, idx = current coin,
  // tar = remaining target, asf = answer so far
  // HOW: Either use same coin again OR move to next coin
  public static void coinChangeCombinationsMultiple(int[] coins, int idx, int tar, String asf) {

    // WHY: Invalid state - overshot target
    // WHAT: If target becomes negative, this path failed
    // HOW: Return immediately to backtrack
    if (tar < 0)
      return;

    // WHY: Success - found valid combination
    // WHAT: Target reached exactly zero
    // HOW: Print the combination and backtrack
    if (tar == 0) {
      System.out.println(asf + ", ");
      return;
    }

    // WHY: No more coins available
    // WHAT: Processed all coins but target not reached
    // HOW: Return to backtrack
    if (idx == coins.length)
      return;

    // WHY: "YES" - use current coin (can use again!)
    // WHAT: Include coins[idx] in combination
    // HOW: Stay at same idx (allows reuse), reduce target
    coinChangeCombinationsMultiple(coins, idx, tar - coins[idx], asf + coins[idx]);

    // WHY: "NO" - skip current coin, move to next
    // WHAT: Don't use coins[idx], try next coin
    // HOW: Move to idx+1, target stays same
    coinChangeCombinationsMultiple(coins, idx + 1, tar, asf);
  }

  // ============================================================
  // APPROACH 2: Loop Pattern
  // ============================================================

  // WHY: Alternative approach using loop
  // WHAT: Try each coin from idx forward, allowing reuse
  // HOW: Loop tries each coin, stays at same position for reuse
  public static void coinChangeCombinationsMultiple2(int[] coins, int idx, int tar, String asf) {

    // WHY: Invalid state check
    // WHAT: If target negative, stop this branch
    // HOW: Return immediately
    if (tar < 0)
      return;

    // WHY: Success - found valid combination
    // WHAT: Target reached exactly zero
    // HOW: Print the combination
    if (tar == 0) {
      System.out.println(asf);
      return;
    }

    // WHY: Try each coin from current position forward
    // WHAT: Loop from idx to end of coins array
    // HOW: For each coin, recurse staying at same position (allows reuse)
    for (int j = idx; j < coins.length; j++) {

      // WHY: Use coins[j] and allow it to be used again
      // WHAT: Stay at index j (not j+1), reduce target
      // HOW: Recursive call with same j allows unlimited reuse
      coinChangeCombinationsMultiple2(coins, j, tar - coins[j], asf + coins[j]);
    }
  }

  public static void main(String[] args) {
    int[] coins = { 2, 3, 4, 6, 5 };
    int target = 10;

    System.out.println("=== Approach 1: Include/Exclude ===");
    coinChangeCombinationsMultiple(coins, 0, target, "");

    System.out.println("\n=== Approach 2: Loop ===");
    coinChangeCombinationsMultiple2(coins, 0, target, "");

    // Sample Output: 2222, 23, 55, 244, etc.
    // Note: Coins can repeat! (2222 uses coin 2 four times)
  }
}

// ⚡ Time: O(target/min_coin) | Space: O(target/min_coin) recursion depth
// 🗣️ Interview: "For unlimited coins, stay at same index when using a coin.
// This allows reuse. Either include same coin again OR move next."

// ------------------------------------------------------------
// 🧠 TRACE: coins=[2,3], target=7, Approach 1
// ------------------------------------------------------------
// Start: idx=0, tar=7, asf=""
//
// Use coin[0]=2: idx=0, tar=5, asf="2"
// Use coin[0]=2: idx=0, tar=3, asf="22"
// Use coin[0]=2: idx=0, tar=1, asf="222"
// Use coin[0]=2: tar=-1 → return ✗
// Skip coin[0]: idx=1, tar=1, asf="222"
// Use coin[1]=3: tar=-2 → return ✗
// Skip coin[1]: idx=2 → return ✗
// Skip coin[0]: idx=1, tar=3, asf="22"
// Use coin[1]=3: tar=0 → PRINT "223" ✓
//
// Eventually finds: 223, 25, 34, 7 (if 7 in coins)

// ------------------------------------------------------------
// 🔑 KEY DIFFERENCE: Limited vs Unlimited
// ------------------------------------------------------------
//
// LIMITED (Question 6):
// coinChange(coins, idx+1, ...) // Move forward after use
// Each coin used at most once
// Example: [2,3,5] for target=10 → only "235", "325", etc.
//
// UNLIMITED (This Question):
// coinChange(coins, idx, ...) // Stay at same position
// Each coin can be reused
// Example: [2,3,5] for target=10 → "22222", "2222", "55", etc.
//
// Key: idx vs idx+1 when including coin!

// ------------------------------------------------------------
// 🧠 EDGE CASES
// ------------------------------------------------------------
// target=0: prints "" (empty combination)
// No solution: target=7, coins=[2,4] → nothing printed
// Single coin: coins=[5], target=15 → prints "555"
