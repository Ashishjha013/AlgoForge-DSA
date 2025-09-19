// Question No. 1
// Implement binary search to find the index of a target number in a sorted array.

// hint: Use two pointers to represent the start and end of the search range.

public class Question1 {
  public static int binarySearch(int[] arr, int target) {
    int si = 0, ei = arr.length - 1;

    while (si <= ei) {
      int mid = si + (ei - si) / 2;

      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] < target) {
        si = mid + 1;
      } else {
        ei = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = { 3, 5, 6, 11, 14, 19, 28 };
    int target = 3;
    int result = binarySearch(arr, target);

    if (result != -1) {
      System.out.println("Number found at index: " + result);
    } else {
      System.out.println("Number not found.");
    }
  }
}
