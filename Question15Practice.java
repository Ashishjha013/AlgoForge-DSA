
import java.util.*;

public class Question15Practice {
  // Qs: Get Keypad Combinations
  static String[] lettersArray = { ",:", "<;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

  public static ArrayList<String> getKeyPadCombinations(String str) {
    if (str.length() == 0) {
      ArrayList<String> baseAns = new ArrayList<>();
      baseAns.add("");
      return baseAns;
    }

    String smallerString = str.substring(1);
    ArrayList<String> smallAns = getKeyPadCombinations(smallerString);

    ArrayList<String> myAns = new ArrayList<>();
    int firstDigit = str.charAt(0) - '0';

    String letters = lettersArray[firstDigit];
    for (int i = 0; i < letters.length(); i++) {
      char letter = letters.charAt(i);

      for (String s : smallAns) {
        myAns.add(letter + s);
      }
    }
    return myAns;
  }

  // Main Function
  public static void main(String[] args) {
    ArrayList<String> combinations = getKeyPadCombinations("84");
    System.out.println(combinations);
  }
}
