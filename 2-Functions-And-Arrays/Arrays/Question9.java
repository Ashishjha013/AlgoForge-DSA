// Question No. 9
// Print all subarrays

// hint: use three nested loops
// i: starting index
// j: ending index
// k: current index

import java.util.*;

public class Question9 {
  public static void subArrays(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      System.out.println("------------");
      for (int j = i; j < n; j++) {
        // print subarray from i to j
        for (int k = i; k <= j; k++) {
          System.out.print(arr[k] + " ");
        }
        System.out.println();
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter size of array: ");
    int n = sc.nextInt();

    int[] arr = new int[n];
    System.out.print("Enter elements for array: ");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    subArrays(arr);

    sc.close();
  }
}
