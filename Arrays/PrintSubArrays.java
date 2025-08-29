/**
 * Program to print all subarrays of a given array.
 *
 * Example:
 * Input: {1, 2, 3}
 * Output:
 * 1
 * 12
 * 123
 *
 * 2
 * 23
 *
 * 3
 * Total subarrays are 6
 *
 * Time Complexity: O(n^3)
 *   -> Three nested loops:
 *      - First loop picks start index
 *      - Second loop picks end index
 *      - Third loop prints elements between start and end
 * Space Complexity: O(1)
 *   -> No extra space apart from a few variables.
 */
public class PrintSubArrays {

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6};

        // Function call to print all subarrays
        printSubArrays(arr);
    }

    /**
     * Function to print all possible subarrays of an array
     * @param arr input array of integers
     */
    public static void printSubArrays(int[] arr) {
        int n = arr.length;
        int totSubarrays = 0;  // counter to track number of subarrays

        // Outer loop picks starting index
        for (int i = 0; i < n; i++) {
            int start = i;

            // Middle loop picks ending index
            for (int j = i; j < n; j++) {
                int end = j;

                // Inner loop prints elements between start and end
                for (int k = start; k <= end; k++) {
                    System.out.print(arr[k]);
                }

                totSubarrays++;  // count this subarray
                System.out.println(); // move to new line after printing subarray
            }

            // Extra line for readability (after each new "start")
            System.out.println();
        }

        // Print total number of subarrays
        System.out.println("Total subarrays are " + totSubarrays);
    }
}
