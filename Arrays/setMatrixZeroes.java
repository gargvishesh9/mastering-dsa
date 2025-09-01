// GitHub Style Code for "Set Matrix Zeroes"
// Approaches:
// 1. Brute Force (Using extra matrix)
// 2. HashSet / HashMap approach (Storing zero positions)

import java.util.*;

public class setMatrixZeroes {
    public static void main(String[] args) {
        // Example input
        int[][] matrix1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] matrix2 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        // Run Brute Force
        System.out.println("Brute Force Output:");
        setZeroesBruteForce(matrix1);
        for (int[] row : matrix1) {
            System.out.println(Arrays.toString(row));
        }

        // Run HashMap Approach
        System.out.println("\nHashMap Output:");
        setZeroesHash(matrix2);
        for (int[] row : matrix2) {
            System.out.println(Arrays.toString(row));
        }
    }

    // ---------------- BRUTE FORCE APPROACH ----------------
    // Idea: Use a copy of the matrix, update in copy, then overwrite
    // Time: O(n*m), Space: O(n*m)
    public static void setZeroesBruteForce(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Make a copy
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            copy[i] = Arrays.copyOf(matrix[i], m);
        }

        // Traverse original, update copy
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // Set entire row and col in copy
                    for (int k = 0; k < m; k++) {
                        copy[i][k] = 0;
                    }
                    for (int k = 0; k < n; k++) {
                        copy[k][j] = 0;
                    }
                }
            }
        }

        // Copy back
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.copyOf(copy[i], m);
        }
    }

    /*
    Dry Run (Brute Force):
    Input:
    1 1 1
    1 0 1
    1 1 1

    At (1,1) = 0
    → Set row 1 to [0,0,0]
    → Set col 1 → (0,1)=0, (1,1)=0, (2,1)=0

    Final Output:
    1 0 1
    0 0 0
    1 0 1
    */


    // ---------------- HASHSET / HASHMAP APPROACH ----------------
    // Idea: Store row and column indices where zeros appear
    // Time: O(n*m), Space: O(n+m)
    public static void setZeroesHash(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();

        // Step 1: Record zero positions
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        // Step 2: Zero out rows
        for (int r : rows) {
            for (int j = 0; j < m; j++) {
                matrix[r][j] = 0;
            }
        }

        // Step 3: Zero out columns
        for (int c : cols) {
            for (int i = 0; i < n; i++) {
                matrix[i][c] = 0;
            }
        }
    }

    /*
    Dry Run (HashSet):
    Input:
    1 1 1
    1 0 1
    1 1 1

    Step 1: Found 0 at (1,1)
    rows = {1}, cols = {1}

    Step 2: Zero out row 1 → [0,0,0]
    Step 3: Zero out col 1 → (0,1)=0, (1,1)=0, (2,1)=0

    Final Output:
    1 0 1
    0 0 0
    1 0 1
    */
}
