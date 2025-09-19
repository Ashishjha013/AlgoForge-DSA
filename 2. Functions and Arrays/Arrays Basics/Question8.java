
import java.util.*;

// Question No. 8
// Inverse an array

// hint: use the value as the index
// store the index in the new array

public class Question8 {
  public static int[] inverse(int[] arr) {
    int n = arr.length;
    
    int[] inv = new int[n];

    for(int i=0; i<n; i++) {
      inv[arr[i]] = i;
    }
    return inv;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter size of first array: ");
    int n = sc.nextInt();

    int[] arr = new int[n];
    System.out.print("Enter elements for first array: ");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    int[] inv = inverse(arr);
    System.out.println("Resultant array: " + Arrays.toString(inv));

    sc.close();
  }
}
