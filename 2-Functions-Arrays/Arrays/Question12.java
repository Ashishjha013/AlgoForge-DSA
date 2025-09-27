// Question No. 12
// Find the maximum sum of a subarray in a given integer array.

// hint: Use two nested loops to consider all subarrays
// and keep track of the maximum sum found.

import java.util.*;

public class Question12 {
  public static void subArrays(int[] arr) {
    int n = arr.length;

    int maxSum = Integer.MIN_VALUE;
    int meh = 0;
    int si = 0, ei = 0; // current subarray start (temp) and best end
    int tempStart = 0; // start index for the current running subarray

    for (int i = 0; i < n; i++) {
      meh += arr[i];

      if (meh > maxSum) {
        maxSum = meh;
        si = tempStart;
        ei = i;
      }

      if (meh < 0) {
        meh = 0;
        tempStart = i + 1;
      }
    }

    // Print results
    System.out.println("Maximum Subarray Sum = " + maxSum);
    System.out.println("Start Index = " + si);
    System.out.println("End Index = " + ei);
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
