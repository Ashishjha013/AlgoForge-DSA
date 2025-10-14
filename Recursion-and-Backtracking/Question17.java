
import java.util.*;

public class Question17 {
  public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
    if (sr > dr || sc > dc) {
      return new ArrayList<>();
    }
    if (sr == dr && sc == dc) {
      ArrayList<String> baseArr = new ArrayList<>();
      baseArr.add("");
      return baseArr;
    }

    ArrayList<String> pathsAfterHStep = getMazePaths(sr, sc + 1, dr, dc);
    ArrayList<String> pathsAfterVStep = getMazePaths(sr + 1, sc, dr, dc);

    ArrayList<String> allPaths = new ArrayList<>();

    for (String path : pathsAfterHStep) {
      allPaths.add("v" + path);
    }
    for (String path : pathsAfterVStep) {
      allPaths.add("h" + path);
    }
    return allPaths;
  }

  // Main Function
  public static void main(String[] args) {
    ArrayList<String> ans = getMazePaths(0, 0, 2, 2);
    System.out.println(ans);
  }
}
