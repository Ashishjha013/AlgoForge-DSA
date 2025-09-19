
import java.util.*;

// Question No. 4
// Add two arrays

// hint: use a loop to iterate through the elements
// because the arrays are of the same size

public class Question5 {
  public static int[] sumOfTwoArrays(int[] arr1, int[] arr2) {
    int n1 = arr1.length;
    int n2 = arr2.length;

    int resSize = Math.max(n1, n2) + 1;
    int[] result = new int[resSize];

    int i = arr1.length - 1;
    int j = arr2.length - 1;
    int k = result.length - 1;

    int carry = 0;

    while(k >= 0) {
      int csum = 0;

      if(i >= 0) {
        csum += arr1[i];
      }
      if(j >= 0) {
        csum += arr2[j];
      }
      csum += carry;

      if(csum > 9) {
        csum = csum % 10;
        carry = 1;
      } else {
        carry = 0;
      }

      result[k] = csum;
      i--;
      j--;
      k--;
    }

    return result; 
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter size of first array: ");
    int n1 = sc.nextInt();

    System.out.println("Enter size of second array: ");
    int n2 = sc.nextInt();

    int[] arr1 = new int[n1];
    int[] arr2 = new int[n2];
    System.out.println("Enter elements for first array: ");
    for (int i = 0; i < n1; i++) {
      arr1[i] = sc.nextInt();
    }

    System.out.println("Enter elements for second array: ");
    for (int i = 0; i < n2; i++) {
      arr2[i] = sc.nextInt();
    }

    int[] result = sumOfTwoArrays(arr1, arr2);
    System.out.println("Resultant array: " + Arrays.toString(result));

    sc.close();
  }
}
