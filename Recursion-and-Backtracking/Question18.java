import java.util.ArrayList;

public class Question18 {
  public static ArrayList<String> getMazePathsWithJumps(int sr, int sc, int dr, int dc) {
    if (sr == dr && sc == dc) {
      ArrayList<String> baseAns = new ArrayList<>();
      baseAns.add("");
      return baseAns;
    }

    ArrayList<String> ans = new ArrayList<>();

    // Horizontal Jumps
    for (int jump = 1; jump <= dc - sc; jump++) {
      ArrayList<String> pathsAfterHJumps = getMazePathsWithJumps(sr, sc + jump, dr, dc);
      
      for (String path : pathsAfterHJumps) {
        ans.add("h" + jump + path);
      }
    }
    // Vertical Jumps
    for (int jump = 1; jump <= dr - sr; jump++) {
      ArrayList<String> pathsAfterVJumps = getMazePathsWithJumps(sr + jump, sc, dr, dc);

      for (String path : pathsAfterVJumps) {
        ans.add("v" + jump + path);
      }
    }
    return ans;
  }

  // Main Function
  public static void main(String[] args) {
    ArrayList<String> ans = getMazePathsWithJumps(0, 0, 2, 2);
    System.out.println(ans);
  }
}
