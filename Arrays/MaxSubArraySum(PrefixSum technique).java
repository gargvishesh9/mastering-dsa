/**
 * Program to find the Maximum Subarray Sum using Prefix Sum Optimization.
 *
 * Logic:
 * 1. Build a prefix sum array where prefSum[i] = sum of elements from arr[0]..arr[i].
 * 2. For every possible subarray (start..end):
 *      - Compute subarray sum in O(1) using:
 *        sum = (start == 0) ? prefSum[end] : prefSum[end] - prefSum[start-1]
 * 3. Keep track of the maximum sum found.
 *
 * This reduces time complexity from O(n^3) (brute force) to O(n^2).
 *
 * Example:
 * Input: {1, -2, 6, -1, 3}
 * Output:
 * Subarray [1] -> Sum = 1
 * Subarray [1, -2] -> Sum = -1
 * ...
 * Max SubArray Sum is 8
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n) (for prefix sum array)
 */
public class MaxSubArraySumUsingPrefixSum {

    public static void main(String[] args) {
        int [] arr = {1, -2, 6, -1, 3};

        // Function call to compute max subarray sum
        int max = maxSubArraySum(arr);

        System.out.println("\n✅ Max SubArray sum is " + max);
    }

    public static int maxSubArraySum(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        // Step 1: Build Prefix Sum Array
        int [] prefSum = new int[n];
        prefSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefSum[i] = prefSum[i - 1] + arr[i];
        }

        // Step 2: Iterate over all subarrays using (start, end)
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {

                // Subarray sum using prefix array in O(1)
                int sum = (start == 0) ? prefSum[end] : prefSum[end] - prefSum[start - 1];

                // Update maximum sum
                if (sum > maxSum) {
                    maxSum = sum;
                }

                // Print subarray with its sum for clarity
                System.out.print("Subarray [");
                for (int k = start; k <= end; k++) {
                    System.out.print(arr[k]);
                    if (k < end) System.out.print(", ");
                }
                System.out.println("] -> Sum = " + sum);
            }
            System.out.println();
        }

        return maxSum;
    }
}
