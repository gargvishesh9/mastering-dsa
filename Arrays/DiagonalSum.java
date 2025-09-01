/**
 * Matrix Diagonal Sum
 * 
 * Problem:
 * Given a square matrix, return the sum of its primary diagonal
 * (top-left → bottom-right) and secondary diagonal (top-right → bottom-left).
 * If the matrix has an odd size, the center element should only be counted once.
 * 
 * Example:
 * Input:
 * [
 *   [1, 2, 3],
 *   [4, 5, 6],
 *   [7, 8, 9]
 * ]
 * Output: 25
 * Explanation:
 * Primary diagonal = 1 + 5 + 9 = 15
 * Secondary diagonal = 3 + 5 + 7 = 15
 * But "5" is counted twice → subtract once → 15 + 15 - 5 = 25
 * 
 * -----------------------------------------------------------------
 * BRUTE FORCE APPROACH:
 * - Iterate over all elements.
 * - If (i == j), add to sum (primary diagonal).
 * - If (i + j == n - 1), add to sum (secondary diagonal).
 * - Make sure not to double count the center element.
 * Time: O(n^2), Space: O(1).
 * 
 * OPTIMIZED APPROACH:
 * - Loop only once (i = 0 → n-1).
 * - Add matrix[i][i] (primary).
 * - Add matrix[i][n-1-i] (secondary), but only if different from primary.
 * Time: O(n), Space: O(1).
 * 
 * -----------------------------------------------------------------
 * DRY RUN (n = 3):
 * Matrix:
 * [
 *   [1, 2, 3],
 *   [4, 5, 6],
 *   [7, 8, 9]
 * ]
 * 
 * Step 1: i=0 → sum = 1 (primary) + 3 (secondary) = 4
 * Step 2: i=1 → sum = 4 + 5 (primary) + (skip secondary, same cell) = 9
 * Step 3: i=2 → sum = 9 + 9 (primary) + 7 (secondary) = 25
 * 
 * Final Answer = 25
 * -----------------------------------------------------------------
 */

import java.util.*;

public class DiagonalSum {

    // ✅ Optimized O(n) approach
    public int diagonalSum(int[][] matrix) {
        int sum = 0;
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            // Primary diagonal
            sum += matrix[i][i];

            // Secondary diagonal (avoid double counting the middle cell)
            if (i != n - i - 1) {
                sum += matrix[i][n - 1 - i];
            }
        }
        return sum;
    }

    // ❌ Brute force O(n^2) approach
    public int diagonalSumBruteForce(int[][] matrix) {
        int sum = 0;
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Primary diagonal
                if (i == j) {
                    sum += matrix[i][j];
                }
                // Secondary diagonal
                else if (i + j == n - 1) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    // For quick local testing
    public static void main(String[] args) {
        DiagonalSum ds = new DiagonalSum();

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Optimized: " + ds.diagonalSum(matrix));       // Expected: 25
        System.out.println("BruteForce: " + ds.diagonalSumBruteForce(matrix)); // Expected: 25
    }
}
