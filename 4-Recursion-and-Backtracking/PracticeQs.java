import java.util.*;

public class PracticeQs {

  public static ArrayList<String> getSubSequences(String str) {
    if (str.length() == 0) {
      ArrayList<String> baseAns = new ArrayList<>();
      baseAns.add("");
      return baseAns;
    }

    String smallerString = str.substring(1);
    ArrayList<String> smallAns = getSubSequences(smallerString);

    char firstChar = str.charAt(0);

    ArrayList<String> allSubs = new ArrayList<>();

    for (String s : smallAns) {
      allSubs.add(s);
    }

    for (String s : smallAns) {
      allSubs.add(firstChar + s);
    }

    return allSubs;
  }

  static String[] lettersArray = {
      ",:", // 0 (not typically used)
      "<;", // 1 (not typically used)
      "abc", // 2
      "def", // 3
      "ghi", // 4
      "jkl", // 5
      "mno", // 6
      "pqrs", // 7
      "tuv", // 8
      "wxyz" // 9
  };

  public static ArrayList<String> getKeyPadCombinations(String str) {
    if (str.length() == 0) {
      ArrayList<String> baseAns = new ArrayList<>();
      baseAns.add("");
      return baseAns;
    }

    String smallerString = str.substring(1);
    ArrayList<String> smallAns = getKeyPadCombinations(smallerString);

    int firstDigit = str.charAt(0) - '0';
    String letters = lettersArray[firstDigit];

    ArrayList<String> ans = new ArrayList<>();

    for (int i = 0; i < letters.length(); i++) {
      char letter = letters.charAt(i);

      for (String s : smallAns) {
        ans.add(s + letter);
      }
    }
    return ans;
  }

  public static ArrayList<String> getStairPaths(int n) {
    if (n < 0) {
      return new ArrayList<>();
    }
    if (n == 0) {
      ArrayList<String> baseAns = new ArrayList<>();
      baseAns.add("");
      return baseAns;
    }

    ArrayList<String> pathAfterOneStep = getStairPaths(n - 1);
    ArrayList<String> pathAfterTwoStep = getStairPaths(n - 2);
    ArrayList<String> pathAfterThreeStep = getStairPaths(n - 3);

    ArrayList<String> allPaths = new ArrayList<>();

    for (String path : pathAfterOneStep) {
      allPaths.add("1" + path);
    }
    for (String path : pathAfterTwoStep) {
      allPaths.add("2" + path);
    }
    for (String path : pathAfterThreeStep) {
      allPaths.add("3" + path);
    }

    return allPaths;
  }

  public static void printSubSequences(String str, String ssf) {
    if (str.length() == 0) {
      System.out.print(ssf + ", ");
      return;
    }

    char firstChar = str.charAt(0);
    String smallerString = str.substring(1);

    printSubSequences(smallerString, ssf); // first char say no
    printSubSequences(smallerString, ssf + firstChar); // first char say yes
  }

  public static void keyPadComb(String str, String ssf) {
    if (str.length() == 0) {
      System.out.print(ssf + ", ");
      return;
    }

    String smallerString = str.substring(1);
    int firstDigit = str.charAt(0) - '0';
    String letters = lettersArray[firstDigit];

    for (int i = 0; i < letters.length(); i++) {
      char letter = letters.charAt(i);

      printSubSequences(smallerString, ssf + letter);
    }
  }

  public static void printStairs(int n, String str) {
    if (n < 0) {
      return;
    }
    if (n == 0) {
      System.out.print(str + ", ");
      return;
    }

    printStairs(n - 1, str + "1");
    printStairs(n - 2, str + "2");
    printStairs(n - 3, str + "3");
  }

  public static void printMazePathWithJumps(int sr, int sc, int dr, int dc, String str) {
    if (sr > dr || sc > dc) {
      return;
    }
    if (sr == dr && sc == dc) {
      System.out.print(str + ", ");
      return;
    }

    // Horizontal Jumps
    for (int jump = 1; jump <= dc - sc; jump++) {
      printMazePathWithJumps(sr, sc + jump, dr, dc, str + "h" + jump);
    }
    // Vertical Jumps
    for (int jump = 1; jump <= dr - sr; jump++) {
      printMazePathWithJumps(sr + jump, sc, dr, dc, str + "h" + jump);
    }
  }

  public static char digitToChar(int digit) {
    return (char) (digit - 1 + 'a');
  }

  public static void printencoding(String str, String asf) {
    if (str.length() == 0) {
      System.out.println(asf);
      return;
    }

    int firstDigit = str.charAt(0) - '0';

    if (firstDigit == 0) {
      return;
    }

    cChar firstChar = digitToChar(firstDigit);
    String smallerString = str.substring(1);

    printencoding(smallerString, asf + firstChar);

    if (str.length() >= 2) {
      String first2Chars = str.substring(firstDigit);

      if (first2Chars.length() <= 26) {
        char secondChar = digitToChar(Integer.parseInt(first2Chars));
        String smallerString2 = str.substring(2);

        printencoding(smallerString2, asf + secondChar);
      }
    }
  }

  public static void main(String[] args) {
    // String str = "abc";
    // ArrayList<String> ans = getSubSequences(str);
    // System.out.println("All subsequences of `" + str + "` are: ");
    // System.out.println(ans);

    // String str = "84";
    // ArrayList<String> ans2 = getKeyPadCombinations(str);
    // System.out.println("All Keypad Combinations of `" + str + "` are: ");
    // System.out.println(ans2);

    // int stairs = 4;
    // ArrayList<String> ans = getStairPaths(stairs);
    // System.out.println(ans);

    // printSubSequences("abc", "");

    // keyPadComb("84", "");

    // printStairs(4, "");

    // printMazePathWithJumps(0, 0, 2, 2, "");

    printEncoding("124", "");
  }
}
