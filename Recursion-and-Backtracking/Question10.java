// Question 11:
// Find max element in array using recusrion

// hint: compare last element with max of rest of the array

public class Question10 {
  public static int findMaxInArrUsingRecur(int arr[], int n) {
    if (n == 1) {
      return arr[0];
    }

    int max = findMaxInArrUsingRecur(arr, n - 1);
    return Math.max(arr[n - 1], max);
  }
  public static void main(String[] args) {
    int arr[] = { 4, 8, 12, 33, 16, 20 };
    int n = arr.length;

    System.out.println(findMaxInArrUsingRecur(arr, n));
  }
}
