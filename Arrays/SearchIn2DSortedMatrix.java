import java.util.Scanner;

public class SearchIn2DMatrix {

    // 1. Brute Force Approach
    // Time Complexity: O(n*m), Space Complexity: O(1)
    public static boolean bruteForceSearch(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Check each element one by one
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == target) {
                    return true; // Found target
                }
            }
        }
        return false; // Not found
    }

    // 2. Staircase Search (Optimized)
    // Start from top-right corner and eliminate row/column
    // Time Complexity: O(n + m), Space Complexity: O(1)
    public static boolean staircaseSearch(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;         // start at first row
        int col = cols - 1;  // start at last column (top-right)

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true; // Found
            } else if (matrix[row][col] > target) {
                col--; // Eliminate current column
            } else {
                row++; // Eliminate current row
            }
        }
        return false; // Not found
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Example Input
        // Matrix: [[1,4,7,11],[2,5,8,12],[3,6,9,16],[10,13,14,17]]
        System.out.print("Enter rows: ");
        int n = sc.nextInt();
        System.out.print("Enter cols: ");
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];
        System.out.println("Enter matrix elements row-wise (sorted):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter target to search: ");
        int target = sc.nextInt();

        // Brute Force
        boolean bruteResult = bruteForceSearch(matrix, target);
        System.out.println("Brute Force Result: " + bruteResult);

        // Staircase Search
        boolean staircaseResult = staircaseSearch(matrix, target);
        System.out.println("Staircase Search Result: " + staircaseResult);

        sc.close();
    }
}

/*
------------------- DRY RUN (Staircase Search) -------------------
Matrix:
[
  [1,  4,  7, 11],
  [2,  5,  8, 12],
  [3,  6,  9, 16],
  [10,13, 14,17]
]

Target = 9

Step 1: Start at top-right → (0,3) = 11
         11 > 9 → move left
Step 2: Now at (0,2) = 7
         7 < 9 → move down
Step 3: Now at (1,2) = 8
         8 < 9 → move down
Step 4: Now at (2,2) = 9
         Found target ✅

Answer: true
---------------------------------------------------------------
*/
