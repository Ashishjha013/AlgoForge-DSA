// Question No. 6
// Reverse an array

// hint: use two pointers
// swap elements until the pointers meet

import java.util.*;

public class Question6 {
  public static void reverseArray(int[] arr) {
    int first = 0, last = arr.length - 1;

    while (first < last) {
      int temp = arr[first];
      arr[last] = arr[first];
      arr[first] = temp;

      first++;
      last--;
    }
  }

  public static int[] reverseArray2(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n / 2; i++) {
      int temp = arr[i];
      arr[i] = arr[n - 1 - i];
      arr[n - 1 - i] = temp;
    }

    return arr;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter size of first array: ");
    int n = sc.nextInt();

    int[] arr = new int[n];
    System.out.println("Enter elements for first array: ");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    reverseArray(arr);
    System.out.println("Resultant array: " + Arrays.toString(arr));

    sc.close();
  }
}
