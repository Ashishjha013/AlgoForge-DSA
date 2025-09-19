// Question No. 3
// Find the first and last occurrence of a target number in a sorted array.

// hint: Use two binary searches: one to find the first occurrence and another to find the last occurrence.
// For the first occurrence, if the middle element is equal to the target, move the end pointer to mid - 1.
// For the last occurrence, if the middle element is equal to the target, move the start

public class Question3 {
  public static int[] findOccurrences(int[] arr, int target) {
    int n = arr.length;
    int si = 0, ei = n - 1;

    int firstIndex = -1;

    // Finding first occurrence
    while (si <= ei) {
      int mid = (si + ei) / 2;

      if (arr[mid] == target) {
        firstIndex = mid;
        ei = mid - 1;
      } else if (arr[mid] < target) {
        si = mid + 1;
      } else {
        ei = mid - 1;
      }
    }

    int lastIndex = -1;
    si = 0;
    ei = n - 1;

    // Finding last occurrence
    while (si <= ei) {
      int mid = (si + ei) / 2;

      if (arr[mid] == target) {
        lastIndex = mid;
        si = mid + 1;
      } else if (arr[mid] < target) {
        si = mid + 1;
      } else {
        ei = mid - 1;
      }
    }

    return new int[] { firstIndex, lastIndex };
  }

  public static void main(String[] args) {
    int[] arr = { 1, 3, 3, 3, 5, 5, 5, 5, 8, 11, 13, 13, 19, };
    int target = 7;

    int[] firstLast = findOccurrences(arr, target);
    System.out.println("First index is: " + firstLast[0]);
    System.out.println("Last index is: " + firstLast[1]);

  }
}
