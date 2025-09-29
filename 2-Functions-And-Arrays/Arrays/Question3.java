// Question No. 3
// Search target element in array

// hint: linear search
// because the array is unsorted

import java.util.*;

class Question3 {
  public static int findInArray(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter size of array: ");
    int n = sc.nextInt();

    System.out.println("Enter the target: ");
    int target = sc.nextInt();

    int[] arr = new int[n];
    System.out.println("Enter elements: ");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    int index = findInArray(arr, target);
    System.out.println("Index of the target element is: " + index);

    sc.close();
  }
}
