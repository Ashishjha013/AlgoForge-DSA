// Question No. 2
// Find the floor and ceil of a target number in a sorted array.

// hint: Use two pointers to represent the start and end of the search range.
// If the middle element is less than the target, update the floor and move the start pointer.
// If the middle element is greater than the target, update the ceil and move the end pointer.

public class Question2 {
  public static int[] findFloorAndCeil(int[] arr, int target) {
    int si = 0, ei = arr.length - 1;
    int ceil = Integer.MAX_VALUE, floor = Integer.MIN_VALUE;

    while (si <= ei) {
      int mid = si + (ei - si) / 2;

      if (arr[mid] == target) {
        floor = arr[mid];
        ceil = arr[mid];
        break;
      } else if (arr[mid] < target) {
        floor = arr[mid];
        si = mid + 1;
      } else {
        ceil = arr[mid];
        ei = mid - 1;
      }

    }

    return new int[] { floor, ceil };
  }

  public static void main(String[] args) {
    int[] arr = { 1, 7, 9, 13, 18, 23, 35 };
    int target = 20;

    int[] result = findFloorAndCeil(arr, target);
    System.out.println("Floor: " + result[0]);
    System.out.println("Ceil: " + result[1]);

  }
}
