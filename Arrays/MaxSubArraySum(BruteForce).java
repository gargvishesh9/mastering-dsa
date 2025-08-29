/**
 * Program to find the Maximum Subarray Sum (Brute Force Approach).
 *
 * Example:
 * Input: {1, 2, 3, 4}
 * Subarrays and their sums:
 * 1  -> Sum = 1
 * 1 2  -> Sum = 3
 * 1 2 3  -> Sum = 6
 * 1 2 3 4  -> Sum = 10
 * ...
 * Maximum Subarray Sum = 10
 *
 * Time Complexity: O(n^3)
 *   -> Three nested loops:
 *      - First loop selects start index
 *      - Second loop selects end index
 *      - Third loop calculates the sum of subarray (start..end)
 * Space Complexity: O(1)
 *   -> Only a few variables used.
 */
public class MaxSubArraySum {

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6};

        // Function call to compute max subarray sum
        int max = maxSubArraySum(arr);

        System.out.println("Max SubArray sum is " + max);
    }

    /**
     * Function to compute Maximum Subarray Sum using brute force
     * @param arr input array of integers
     * @return maximum subarray sum
     */
    public static int maxSubArraySum(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE; // stores overall maximum sum

        // Outer loop picks starting index
        for (int i = 0; i < n; i++) {
            int start = i;

            // Middle loop picks ending index
            for (int j = i; j < n; j++) {
                int end = j;
                int sum = 0; // sum of subarray (start..end)

                // Inner loop calculates sum of elements from start to end
                for (int k = start; k <= end; k++) {
                    sum = sum + arr[k];
                    // update maxSum if current sum is greater
                    if (sum > maxSum) {
                        maxSum = sum;
                    }
                    // print each element of the subarray
                    System.out.print(arr[k] + " ");
                }

                // print subarray sum
                System.out.print(" Sum is " + sum);
                System.out.println();
            }
            System.out.println();
        }

        return maxSum; // return overall maximum subarray sum
    }
}
