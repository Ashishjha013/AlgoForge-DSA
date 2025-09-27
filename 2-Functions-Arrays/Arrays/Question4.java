// Question No. 4
// Create a bar chart from an array of integers

// hint: use a nested loop to print the chart

import java.util.*;

public class Question4 {
  public static void printBuilding(int[] heights) {
    int n = heights.length;
    int maxHeight = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      int currBuildingHeight = heights[i];

      maxHeight = Math.max(maxHeight, currBuildingHeight);
    }

    int currFloor = maxHeight;

    while (currFloor > 0) {
      // Go to every building and check if currFloor
      // for that building exists or not
      for (int i = 0; i < n; i++) {
        int currBuildingHeight = heights[i];

        if (currFloor <= currBuildingHeight) {
          System.out.print("* ");
        } else {
          System.out.print("  ");
        }
      }

      // Prepare for next line
      System.out.println();
      currFloor--;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter size of array: ");
    int n = sc.nextInt();

    System.out.print("Enter elements for array: ");
    int heights[] = new int[n];
    for (int i = 0; i < n; i++) {
      heights[i] = sc.nextInt();
    }

    System.out.println("Building representation:");
    printBuilding(heights);

    sc.close();
  }
}
