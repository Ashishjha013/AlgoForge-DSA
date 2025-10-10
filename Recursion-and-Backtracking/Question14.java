// Question 14:
// Get all the subsequences of a given string

// hint: Use a recursive function that builds subsequences by including or excluding each character of the string. Start with an empty subsequence and at each step, add the current character to the subsequence or skip it. Continue this process until all characters have been processed.

import java.util.*;

public class Question14 {
  public static ArrayList<String> getSubSequences(String str) {
    if (str.length() == 0) {
      ArrayList<String> baseAns = new ArrayList<>();
      baseAns.add("");
      return baseAns;
    }

    String smallerString = str.substring(1); // "bc"
    
    ArrayList<String> smallAns = getSubSequences(smallerString);

    char firstChar = str.charAt(0); // "a"

    ArrayList<String> allSubs = new ArrayList<>();
    // `a` will say no
    for (String s : smallAns) {
      allSubs.add(s);
    }
    // `a` will say yes
    for (String s : smallAns) {
      allSubs.add(firstChar + s);
    }

    return allSubs;
  }

  public static void main(String[] args) {
    String str = "abc";
    System.out.println("All subsequences of `" + str + "` are: ");
    ArrayList<String> ans = getSubSequences(str);
    System.out.println(ans);
  }
}
