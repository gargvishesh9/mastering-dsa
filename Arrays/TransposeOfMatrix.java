import java.util.Scanner;

public class TransposeMatrix {

    // 1. Brute Force Approach
    // Works for any rectangular matrix (n x m)
    // Time: O(n*m), Space: O(n*m)
    public static int[][] bruteForceTranspose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transpose = new int[cols][rows]; // dimensions swapped

        // Fill transpose
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    // 2. In-place Transpose (only for square matrices n x n)
    // Time: O(n^2), Space: O(1)
    public static void inPlaceTranspose(int[][] matrix) {
        int n = matrix.length;

        // Swap elements across diagonal
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    // Helper to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Example: [[1,2,3],[4,5,6]]
        System.out.print("Enter rows: ");
        int n = sc.nextInt();
        System.out.print("Enter cols: ");
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];
        System.out.println("Enter matrix elements row-wise:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        // Brute Force Transpose
        int[][] transpose = bruteForceTranspose(matrix);
        System.out.println("\nTranspose using Brute Force:");
        printMatrix(transpose);

        // In-place Transpose (only works if square)
        if (n == m) {
            inPlaceTranspose(matrix);
            System.out.println("\nTranspose using In-place Method:");
            printMatrix(matrix);
        } else {
            System.out.println("\nIn-place Transpose not possible (matrix is not square).");
        }

        sc.close();
    }
}

/*
------------------- DRY RUN -------------------
Matrix:
[
  [1, 2, 3],
  [4, 5, 6]
]

Brute Force Transpose:

Step 1: transpose[0][0] = matrix[0][0] = 1
Step 2: transpose[1][0] = matrix[0][1] = 2
Step 3: transpose[2][0] = matrix[0][2] = 3
Step 4: transpose[0][1] = matrix[1][0] = 4
Step 5: transpose[1][1] = matrix[1][1] = 5
Step 6: transpose[2][1] = matrix[1][2] = 6

Transpose:
[
  [1, 4],
  [2, 5],
  [3, 6]
]

In-place Transpose (only for square matrix, say 3x3):
Swap elements above diagonal with below diagonal.
Example:
matrix[0][1] ↔ matrix[1][0],
matrix[0][2] ↔ matrix[2][0],
matrix[1][2] ↔ matrix[2][1].

------------------------------------------------
*/
