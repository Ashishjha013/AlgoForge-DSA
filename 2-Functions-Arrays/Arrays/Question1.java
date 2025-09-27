// Quetion No. 1
// Find number of elements greater than x

// hint: use a linear scan
// because the array is unsorted

import java.util.*;

class Question1 {
  public static int greatEle(int[] arr, int x, int count) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > x) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter size of array: ");
    int n = sc.nextInt();
    System.out.println("Enter key element: ");
    int x = sc.nextInt();

    int[] arr = new int[n];

    System.out.println("Enter elements: ");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    int count = 0;

    count = greatEle(arr, x, count);
    System.out.println("Count of elements greater than " + x + " is: " + count);

    sc.close();
  }
}
