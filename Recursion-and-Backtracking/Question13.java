// Question 13:
// Given an array of integers and a target value, find all index of the target value in the array using recursion.

// hint: Use a recursive function that checks each element of the array starting from the first index. If the current element matches the target value, add the current index to a list. Recursively call the function for the next index until the end of the array is reached.

import java.util.Arrays;

public class Question13 {
  // fsf: Found so Far
  public static int[] findAllIndices(int arr[], int target, int idx, int fsf) {
    if (idx == arr.length) {
      int baseArray[] = new int[fsf];
      return baseArray;
    }

    int ans[];
    if (arr[idx] == target) {
      ans = findAllIndices(arr, target, idx + 1, fsf + 1);
    } else {
      ans = findAllIndices(arr, target, idx + 1, fsf);
    }

    // fill answer array
    if (arr[idx] == target) {
      ans[fsf] = idx;
    }
    return ans;
  }

  // Main function
  public static void main(String[] args) {
    int arr[] = { 10, 19, 4, 3, 5, 4, 4, 6 };
    int target = 4;
    int ans[] = findAllIndices(arr, target, 0, 0);
    System.out.println("All indices of target: ");
    System.out.println(Arrays.toString(ans));
  }
}
