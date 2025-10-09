// Question 8:
// Print array elements using recursion

// hint: base case -> if idx == arr.length -> return

public class Question8 {
  // Print array elements (using "Recursion")
  public static void printArr(int arr[], int idx) {
    if (idx == arr.length) {
      return;
    }
    System.out.print(arr[idx] + " ");
    printArr(arr, idx + 1);
  }
  // Main function
  public static void main(String[] args) {
    int arr[] = { 4, 8, 12, 33, 16, 20 };
    System.out.println("Array elements are: ");
    printArr(arr, 0);
  }
}
