// ------------------------------------------------------------
// 🧮 Question 8: Friends Pairing Problem
// ------------------------------------------------------------
// 🧩 Count ways to pair n friends (each can stay single or pair with another)
// 🔑 Core Concept: Recursion with two choices - single or pair
// 💡 Pattern: Combinatorics using Recursion
//
// Level: 🟡 Medium
// Tags: #Recursion #Combinatorics #DP
// ------------------------------------------------------------

public class Question8 {

  // WHY: Count total ways n friends can be arranged (single or paired)
  // WHAT: n = number of friends
  // HOW: Consider last friend - either stays single OR pairs with someone
  public static long countFriendsPairings(int n) {

    // WHY: Base cases - simple scenarios
    // WHAT: If 0 or 1 friend → 1 way, if 2 friends → 2 ways
    // HOW: n=0 or n=1 → 1 arrangement, n=2 → single-single OR paired
    if (n <= 2) {
      return n; // 0→0, 1→1, 2→2
    }

    // WHY: Choice 1 - last friend stays single
    // WHAT: If friend n stays alone, arrange remaining (n-1) friends
    // HOW: Recursively count arrangements for (n-1) friends
    long single = countFriendsPairings(n - 1);

    // WHY: Choice 2 - last friend pairs with someone
    // WHAT: If friend n pairs up, arrange remaining (n-2) friends
    // HOW: Recursively count arrangements for (n-2) friends
    long pairUp = countFriendsPairings(n - 2);

    // WHY: Calculate total arrangements
    // WHAT: Add both choices (single + pair with any of (n-1) others)
    // HOW: single + (n-1) * pairUp
    // (n-1) because friend n can pair with any of the (n-1) other friends
    long allPairings = single + (n - 1) * pairUp;

    return allPairings;
  }

  public static void main(String[] args) {
    int n = 4;
    long result = countFriendsPairings(n);
    System.out.println("Total pairings for " + n + " friends: " + result);
    // Output: 10
  }
}

// ⚡ Time: O(2^n) naive | Space: O(n) recursion depth
// 🗣️ Interview: "Last friend either stays single (n-1 remain) or pairs with
// any of (n-1) others (n-2 remain). Total = f(n-1) + (n-1)*f(n-2)"

// ------------------------------------------------------------
// 🧠 TRACE: n=4
// ------------------------------------------------------------
// countFriendsPairings(4)
// single = countFriendsPairings(3)
// single = countFriendsPairings(2) = 2
// pairUp = countFriendsPairings(1) = 1
// return 2 + (3-1)*1 = 2 + 2 = 4
//
// pairUp = countFriendsPairings(2) = 2
//
// return 4 + (4-1)*2 = 4 + 6 = 10 ✓

// ------------------------------------------------------------
// 🔑 KEY INSIGHT: Why (n-1) * pairUp?
// ------------------------------------------------------------
// Friend n can pair with ANY of the (n-1) other friends
// For each pairing choice, arrange remaining (n-2) friends
//
// Example n=4: {A, B, C, D}
// If D pairs with A: arrange {B, C} → f(2) ways
// If D pairs with B: arrange {A, C} → f(2) ways
// If D pairs with C: arrange {A, B} → f(2) ways
// Total: 3 * f(2) = (n-1) * f(n-2)

// ------------------------------------------------------------
// 🧠 MANUAL CALCULATION: n=3 → {A, B, C}
// ------------------------------------------------------------
// 1. All single: {A, B, C}
// 2. A-B paired, C single: {AB, C}
// 3. A-C paired, B single: {AC, B}
// 4. B-C paired, A single: {BC, A}
// Total: 4 ways ✓
//
// Using formula: f(3) = f(2) + 2*f(1) = 2 + 2*1 = 4 ✓

// ------------------------------------------------------------
// 🧠 EDGE CASES
// ------------------------------------------------------------
// n=0: 0 ways (no friends)
// n=1: 1 way (single friend)
// n=2: 2 ways (both single OR paired)