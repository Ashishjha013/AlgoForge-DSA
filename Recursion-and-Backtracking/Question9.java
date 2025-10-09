// Question 10:
// Print array in reverse

// hint: base case -> if idx == arr.length -> return

public class Question9 {
  public static void printReversedArr(int arr[], int idx) {
    if (idx == arr.length) {
      return;
    }

    printReversedArr(arr, idx + 1);
    System.out.print(arr[idx] + ", ");
  }

  // Main function
  public static void main(String[] args) {
    int arr[] = { 4, 8, 12, 33, 16, 20 };
    System.out.println("Array elements in reverse order are: ");
    printReversedArr(arr, 0);
  }
}
