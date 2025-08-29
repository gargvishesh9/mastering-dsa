/**
 * Program to print all unique pairs in an array.
 * 
 * Example:
 * Input: {1, 2, 3, 4, 5}
 * Output:
 * (1,2)(1,3)(1,4)(1,5)
 * (2,3)(2,4)(2,5)
 * (3,4)(3,5)
 * (4,5)
 * Total pairs formed are 10
 *
 * Time Complexity: O(n^2) 
 *   -> Two nested loops are used (i, j), so for n elements, number of iterations = n*(n-1)/2 ~ O(n^2).
 * Space Complexity: O(1)
 *   -> We are not using any extra space that grows with input size (only a few variables).
 */
public class PairsInArray {

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5};

        // Function call to generate pairs
        makePairs(arr);
    }

    /**
     * Function to print all unique pairs of an array
     * 
     * @param arr input array of integers
     */
    public static void makePairs(int[] arr) {
        int n = arr.length;
        int totalPairs = 0;  // counter to track number of pairs formed

        // Outer loop picks the first element of the pair
        for (int i = 0; i < n; i++) {
            int num = arr[i];  // current element

            // Inner loop picks the second element of the pair
            for (int j = i + 1; j < n; j++) {
                // Print the pair (num, arr[j])
                System.out.print("(" + num + "," + arr[j] + ")");
                totalPairs++; // increment total pairs count
            }

            // Move to next line after printing all pairs starting with arr[i]
            System.out.println();
        }

        // Print the total number of pairs formed
        System.out.println("Total pairs formed are " + totalPairs);
    }
}
