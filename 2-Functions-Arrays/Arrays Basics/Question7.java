
import java.util.*;

// Question No. 7
// Rotate an array by k elements

// hint: use the value as the index
// store the index in the new array

public class Question7 {
  public static void reverse(int[] arr, int first, int last) {
    while (first < last) {
      int temp = arr[first];
      arr[first] = arr[last];
      arr[last] = temp;

      first++;
      last--;
    }
  }

  public static void rotateArray(int[] arr, int k) {
    int n = arr.length;

    k = k % n;
    if(k < 0) {
      k += n;
    }

    reverse(arr, 0, n - 1);
    reverse(arr, 0, k - 1);
    reverse(arr, k, n - 1);
  }

  

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter size of first array: ");
    int n = sc.nextInt();

    System.out.print("Enter k: ");
    int k = sc.nextInt();

    int[] arr = new int[n];
    System.out.print("Enter elements for first array: ");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    rotateArray(arr, k);
    System.out.println("Resultant array: " + Arrays.toString(arr));

    sc.close();
  }
}

