// Question 11:
// Find max element in array using recusrion

// hint: compare last element with max of rest of the array

public class Question10 {
  public static int findMax(int arr[], int idx) {
    if (idx == arr.length) {
      return idx;
    }

    int smallAns = findMax(arr, idx + 1);
    int max = Math.max(smallAns, arr[idx]);
    return max;
  }
  public static void main(String[] args) {
    int arr[] = { 4, 8, 12, 33, 16, 20 };

    System.out.println(findMax(arr, 0));
  }
}
