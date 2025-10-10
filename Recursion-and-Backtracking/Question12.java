// Question 12:
// Given an array of integers and a target value, find the last index of the target value in the array using recursion.

// hint: Use a recursive function that checks each element of the array starting from the first index. Recursively call the function for the next index until the end of the array is reached. If the current element matches the target value and no further occurrences are found, return the current index.

public class Question12 {
  public static int lastIndex(int arr[], int idx, int target) {
    if (idx == arr.length) {
      return -1;
    }

    int furtherFirstIndex = lastIndex(arr, idx + 1, target);
    if (furtherFirstIndex == -1 && target == arr[idx]) {
      return idx;
    } else {
      return furtherFirstIndex;
    }
  }

  // Main function
  public static void main(String[] args) {
    int arr[] = { 10, 19, 4, 3, 4, 4, 5, 6, 8 };
    int target = 4;
    int lastIdx = lastIndex(arr, 0, target);
    if (lastIdx != -1) {
      System.out.println("Last index of " + target + " is: " + lastIdx);
    } else {
      System.out.println(target + " not found in the array.");
    }
  }
}
