
import java.util.*;

// Quetion No. 1
// Find the span of an array

// hint: use a linear scan to find min and max
// because the array is unsorted

class Question2 {
  public static int spanOfArray(int[] arr) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
      if (arr[i] < min) {
        min = arr[i];
      }
    }

    int span = max - min;
    return span;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter size of array: ");
    int n = sc.nextInt();

    int[] arr = new int[n];

    System.out.println("Enter elements: ");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    int span = 0;

    span = spanOfArray(arr);
    System.out.println("Span of the array is: " + span);

    sc.close();
  }
}
