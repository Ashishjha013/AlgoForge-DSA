public class Question9 {
  // Question 9: Print array using recursion
  public static void printArrUsingRec(int arr[], int idx, int n) {
    if (idx == n) {
      return;
    }

    System.out.print(arr[idx] + ", ");
    printArrUsingRec(arr, idx + 1, n);
  }

  // Question 10: Print array in reverse
  public static void printReverseArrUsingRec(int arr[], int idx) {
    if (idx == arr.length) {
      return;
    }

    printReverseArrUsingRec(arr, idx + 1);
    System.out.print(arr[idx] + ", ");
  }

  // Question 11: Find max element in array using recusrion
  public static int findMaxInArrUsingRecur(int arr[], int n) {
    if (n == 1) {
      return arr[0];
    }

    int max = findMaxInArrUsingRecur(arr, n - 1);
    return Math.max(arr[n - 1], max);
  }

  // Question 11: Find max element in array using recusrion
  public static void main(String[] args) {
    int arr[] = { 4, 8, 12, 33, 16, 20 };
    // int n = arr.length;

    printReverseArrUsingRec(arr, 0);
  }
}
