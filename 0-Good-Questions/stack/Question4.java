// Question 4: Next Greater Element (NGE) using Stack - From Right Side
// Given an array, for each element find the next greater element to its right
// If no greater element exists, assign -1 for that position in the NGE array
// Example: Input: [9, 12, 6, 8, 7] => Output: [12, -1, 8, -1, -1]
// Approach: Use a stack to keep track of potential NGE candidates while traversing the array from right to left
// Time Complexity: O(n), Space Complexity: O(n)
// Reference: https://www.geeksforgeeks.org/next-greater-element/

import java.util.*;

public class Question4 {
  public static void nextGreaterElement(int arr[], int n) {
    // Initialize the Next Greater Element - (NGE) array and stack
    int nge[] = new int[n];
    Stack<Integer> st = new Stack<>();
  }

  // Function to print the NGE array
  public static void printArr(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  // Main function
  public static void main(String[] args) {
    int arr[] = { 9, 12, 6, 8, 7 };
    int n = arr.length;
    // Call the function to find NGE
    nextGreaterElement(arr, n);
    printArr(arr);
  }
}
