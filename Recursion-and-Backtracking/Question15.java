// Question: 15
// Get keypad combinations

// hint: Use a recursive function that processes one digit at a time. For each digit, retrieve the corresponding letters from the mapping and append each letter to the combinations generated from the remaining digits. Start with an empty combination and build it up as you process each digit.

import java.util.*;

public class Question15 {
  static String[] lettersArray = { ",:", "<;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

  public static ArrayList<String> getKeypadCombinations(String str) {
    if(str.length() == 0) {
      ArrayList<String> baseAns = new ArrayList<>();;
      baseAns.add("");
      return baseAns;
    }

    String smallerString = str.substring(1);
    ArrayList<String> smallerAns = getKeypadCombinations(smallerString);

    ArrayList<String> myAns = new ArrayList<>();

    int firstDIgit = str.charAt(0) - '0';
    String letters = lettersArray[firstDIgit];

    for(int i=0; i<letters.length(); i++) {
      char letter = letters.charAt(i);

      for(String s : smallerAns) {
        myAns.add( letter + s);
      }
    }
    return myAns;
  }

  public static void main(String[] args) {
    String input = "84";
    ArrayList<String> combinations = getKeypadCombinations(input);
    System.out.println(combinations);
  }
}
