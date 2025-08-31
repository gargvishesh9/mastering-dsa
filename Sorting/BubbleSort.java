/**
 * Bubble Sort Algorithm
 * Time Complexity: O(n^2) in the worst case
 * Space Complexity: O(1)
 * Optimized with early exit if no swaps occur
 */
class Solution {
    public void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int turns = 0; turns < n - 1; turns++) {
            boolean swapped = false; // flag to track swaps

            for (int j = 0; j < n - 1 - turns; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no swaps happened, array is already sorted
            if (!swapped) break;
        }
    }
}
