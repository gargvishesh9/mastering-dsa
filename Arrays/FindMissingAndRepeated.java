// Problem: Find Missing and Repeated Number in an n x n Matrix
// ------------------------------------------------------------
//
// You are given an n x n matrix containing numbers from 1 to n^2,
// but one number is repeated and one number is missing.
// Task: Return [repeated, missing].
//
// Example:
// Input: [[1,3],[2,2]]
// Output: [2,4]
//
// ------------------------------------------------------------

import java.util.*;

public class FindMissingAndRepeated {

    // ---------------- Brute Force Approach ----------------
    // Time: O(n^4) because we use ArrayList.contains() inside loops.
    // Space: O(n^2) for temp list.
    public static int[] bruteForce(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] result = new int[2]; // [repeated, missing]

        HashSet<Integer> seen = new HashSet<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 1; i <= n * n; i++) {
            temp.add(i);
        }

        // Step 1: Detect repeated number
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (seen.contains(matrix[i][j])) {
                    result[0] = matrix[i][j]; // repeated
                } else {
                    seen.add(matrix[i][j]);
                }
            }
        }

        // Step 2: Find missing number
        for (int i = 1; i <= n * n; i++) {
            if (!seen.contains(i)) {
                result[1] = i;
                break;
            }
        }

        return result;
    }

    // ---------------- Optimized Approach ----------------
    // Time: O(n^2)
    // Space: O(n^2) (boolean array, but faster than HashSet)
    public static int[] optimized(int[][] matrix) {
        int n = matrix.length;
        int size = n * n;

        int[] result = new int[2]; // result[0] = repeated, result[1] = missing
        boolean[] seen = new boolean[size + 1]; // index = number, true if already seen

        // Step 1: Traverse matrix and mark numbers
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                if (seen[val]) {
                    result[0] = val; // repeated
                }
                seen[val] = true;
            }
        }

        // Step 2: Find missing number
        for (int i = 1; i <= size; i++) {
            if (!seen[i]) {
                result[1] = i;
                break;
            }
        }

        return result;
    }

    // ---------------- Dry Run Example ----------------
    /*
       Input:
       matrix = [[1,3],
                 [2,2]]

       n = 2
       size = 4
       seen = [false, false, false, false, false]  // index 0 unused

       Traverse:
       val=1 -> seen[1]=true
       val=3 -> seen[3]=true
       val=2 -> seen[2]=true
       val=2 -> seen[2] already true => repeated=2

       After traversal:
       seen = [false, true, true, true, false]

       Missing check:
       i=1 -> true
       i=2 -> true
       i=3 -> true
       i=4 -> false => missing=4

       Output: [2,4]
    */

    // ---------------- Main Method ----------------
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3},
            {2, 2}
        };

        System.out.println("Brute Force: " + Arrays.toString(bruteForce(matrix)));
        System.out.println("Optimized: " + Arrays.toString(optimized(matrix)));
    }
}
