// Homework
// Question No. 10
// Subtract two arrays

// hint: use a loop to iterate through the elements

import java.util.*;

public class Question10 {
  public static int[] subtractArrays(int[] arr1, int[] arr2) {
    int n1 = arr1.length, n2 = arr2.length;
    int resSize = Math.max(n1, n2);

    int[] result = new int[resSize];

    int i = arr1.length - 1, j = arr2.length - 1;
    int k = result.length - 1;

    int borrow = 0;
    while (k >= 0) {
      int csub = 0;

      int a = (i >= 0) ? arr1[i] : 0;
      int b = (j >= 0) ? arr2[j] : 0;

      csub = a - b - borrow;

      if (csub < 0) {
        csub += 10;
        borrow = 1;
      } else {
        borrow = 0;
      }

      result[k] = csub;
      i--;
      j--;
      k--;
    }

    return result;
  }

  public static void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter size of first array: ");
    int n1 = sc.nextInt();
    System.out.print("Enter size of second array: ");
    int n2 = sc.nextInt();

    int[] arr1 = new int[n1];
    System.out.print("Enter elements for first array: ");
    for (int i = 0; i < n1; i++) {
      arr1[i] = sc.nextInt();
    }

    int[] arr2 = new int[n2];
    System.out.print("Enter elements for second array: ");
    for (int i = 0; i < n2; i++) {
      arr2[i] = sc.nextInt();
    }

    int[] result = subtractArrays(arr1, arr2);
    System.out.print("Resultant array: ");
    printArray(result);

    sc.close();
  }
}
