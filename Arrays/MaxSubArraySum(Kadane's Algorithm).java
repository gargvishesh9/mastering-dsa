/**
 * MaxSubArraySumusingKadaneAlgorithm
 *
 * Problem: Find the maximum subarray sum in a given array.
 * 
 * Approaches Covered:
 *  1. Classic Kadane's Algorithm (works if there is at least one non-negative number)
 *  2. Improved Kadane's Algorithm (handles all cases, including when all numbers are negative)
 *
 * Time Complexity: O(n)  → Each element is visited once.
 * Space Complexity: O(1) → Only a few extra variables are used.
 */

public class MaxSubArraySumusingKadaneAlgorithm {

    public static void main(String[] args) {
        int [] arr1 = {1, -2, 6, -1, 3};    // mixed case
        int [] arr2 = {-2, -3, -1, -4};     // all negative case

        System.out.println("=== Using Classic Kadane's ===");
        System.out.println("Array 1 Max SubArray Sum: " + kadaneClassic(arr1));
        System.out.println("Array 2 Max SubArray Sum: " + kadaneClassic(arr2)); // ❌ wrong in all-negative case

        System.out.println("\n=== Using Improved Kadane's ===");
        System.out.println("Array 1 Max SubArray Sum: " + kadaneImproved(arr1));
        System.out.println("Array 2 Max SubArray Sum: " + kadaneImproved(arr2)); // ✅ correct even in all-negative
    }

    /**
     * Classic Kadane's Algorithm
     *
     * Idea:
     *  - Keep a running sum (currSum).
     *  - If currSum ever drops below 0, reset it to 0 (since a negative sum will not help in building a max subarray).
     *  - Track the maximum sum seen so far (maxSum).
     *
     * Limitation:
     *  - If all elements are negative, this will incorrectly return 0
     *    instead of the largest negative number.
     */
    public static int kadaneClassic(int[] arr) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : arr) {
            currSum += num;

            if (currSum < 0) {
                currSum = 0;  // reset since negative sum is not helpful
            }
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    /**
     * Improved Kadane's Algorithm (Handles All Cases)
     *
     * Idea:
     *  - Instead of resetting to 0, compare:
     *      currSum = Math.max(currentElement, currSum + currentElement)
     *    → Either start a new subarray from current element, or continue extending the previous subarray.
     *  - Always update maxSum with the best seen so far.
     *
     * Advantage:
     *  - Works for both cases:
     *      a) Mixed positives and negatives
     *      b) All negative numbers (returns the largest negative instead of 0)
     */
    public static int kadaneImproved(int[] arr) {
        int currSum = 0;
        int maxSum = arr[0];   // initialize with first element (important for all-negative arrays)

        for (int num : arr) {
            currSum = Math.max(num, currSum + num);  // start new or extend subarray
            maxSum = Math.max(maxSum, currSum);      // update global maximum
        }
        return maxSum;
    }
}
