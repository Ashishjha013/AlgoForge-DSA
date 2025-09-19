
import java.util.*;

// Question No. 11
// Find the maximum subarray sum in an array

// hint: Use three nested loops to generate all subarrays
// and calculate their sums, keeping track of the maximum sum found.

public class Question11 {
  public static void subArrays(int[] arr) {
    int n = arr.length;

    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      int currSum = 0;
      for (int j = i; j < n; j++) {
        currSum += arr[j];
        maxSum = Math.max(maxSum, currSum);
      }
    }

    System.out.print("Maximum Subarray Sum: " + maxSum);
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
