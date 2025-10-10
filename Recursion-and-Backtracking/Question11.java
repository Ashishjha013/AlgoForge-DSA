// Question 11:
// Given an array of integers and a target value, find the first index of the target value in the array using recursion.

// hint: Use a recursive function that checks each element of the array starting from the first index. If the current element matches the target value, return the current index. If not, recursively call the function for the next index until the end of the array is reached.


public class Question11 {
  public static int firstIndex(int arr[], int idx, int target) {
    if (idx == arr.length) {
      return -1;
    }

    int furtherFirstIndex = firstIndex(arr, idx + 1, target);
    if (target == arr[idx]) {
      return idx;
    } else {
      return furtherFirstIndex;
    }
  }
  // Optimized version
  public static int firstIndex2(int arr[], int idx, int target) {
    if (idx == arr.length) {
      return -1;
    }

    int furtherFirstIndex = firstIndex(arr, idx + 1, target);
    if (target == arr[idx]) {
      return idx;
    } else {
      return furtherFirstIndex;
    }
  }

  // Main function
  public static void main(String[] args) {
    int arr[] = { 4, 8, 12, 33, 16, 20, 12 };
    int target = 12;
    int firstIdx = firstIndex(arr, 0, target);
    if (firstIdx != -1) {
      System.out.println("First index of " + target + " is: " + firstIdx);
    } else {
      System.out.println(target + " not found in the array.");
    }
  }
}
