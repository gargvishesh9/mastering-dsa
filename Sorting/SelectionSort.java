/**
 * SelectionSort.java
 *
 * Selection Sort Algorithm Implementation in Java
 *
 * Selection sort works by repeatedly finding the smallest element 
 * from the unsorted part of the array and swapping it with the first 
 * unsorted element.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)  (In-place sorting)
 */

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 3, 2}; // Input array
        selectionSort(arr); // Function call to sort

        // Print sorted array
        System.out.print("Sorted Array: ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    /**
     * Function to perform selection sort on an array
     * @param arr input array
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Outer loop runs n-1 times
        for (int i = 0; i < n - 1; i++) {
            int minPos = i; // Assume current index is minimum

            // Find index of the smallest element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minPos]) {
                    minPos = j; // Update minPos
                }
            }

            // Swap the found minimum element with element at index i
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }
}

/*
----------------------------------------------------
DRY RUN (Array: {5, 4, 1, 3, 2})
----------------------------------------------------

Iteration 1: i = 0
  Array: [5] 4 1 3 2
  Smallest found = 1 at index 2
  Swap → [1] 4 5 3 2

Iteration 2: i = 1
  Array: 1 [4] 5 3 2
  Smallest found = 2 at index 4
  Swap → 1 [2] 5 3 4

Iteration 3: i = 2
  Array: 1 2 [5] 3 4
  Smallest found = 3 at index 3
  Swap → 1 2 [3] 5 4

Iteration 4: i = 3
  Array: 1 2 3 [5] 4
  Smallest found = 4 at index 4
  Swap → 1 2 3 [4] 5

Final Sorted Array → {1, 2, 3, 4, 5}
----------------------------------------------------
*/
