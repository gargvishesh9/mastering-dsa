/**
 * LargestElementIn2DArray.java
 *
 * Program to find the largest element in a 2D array (matrix).
 *
 * Approach:
 * 1. Take input for a 2D matrix from the user.
 * 2. Traverse through all elements of the matrix.
 * 3. Keep track of the maximum element encountered.
 * 4. Print the matrix and the largest element.
 *
 * Time Complexity: O(n * m)  (Every element is visited once)
 * Space Complexity: O(1)     (Only using a few extra variables)
 */

import java.util.Scanner;

public class LargestElementIn2DArray {

    public static void main(String[] args) {
        int[][] matrix = new int[3][3]; // fixed 3x3 matrix
        int n = matrix.length;
        int m = matrix[0].length;

        Scanner sc = new Scanner(System.in);

        // Input matrix elements
        System.out.println("Enter " + n * m + " elements for the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Print the matrix
        System.out.println("Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Find largest element
        int largest = LargestElement(matrix, n, m);
        System.out.println("Largest Element: " + largest);
    }

    /**
     * Function to find the largest element in a 2D array
     * @param matrix input 2D array
     * @param n number of rows
     * @param m number of columns
     * @return largest element found
     */
    public static int LargestElement(int[][] matrix, int n, int m) {
        int largest = Integer.MIN_VALUE; // start with very small value

        // Traverse the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] > largest) {
                    largest = matrix[i][j]; // update largest
                }
            }
        }
        return largest;
    }
}

/*
----------------------------------------------------
DRY RUN (Example Input)
----------------------------------------------------
Matrix Input (3x3):
  2   5   9
  1   7   3
  4   6   8

Step 1: Initialize largest = -∞

Row 1: [2   5   9]
  Compare 2 > -∞ → largest = 2
  Compare 5 > 2 → largest = 5
  Compare 9 > 5 → largest = 9

Row 2: [1   7   3]
  Compare 1 > 9 → NO
  Compare 7 > 9 → NO
  Compare 3 > 9 → NO
  (largest still = 9)

Row 3: [4   6   8]
  Compare 4 > 9 → NO
  Compare 6 > 9 → NO
  Compare 8 > 9 → NO
  (largest still = 9)

----------------------------------------------------
FINAL RESULT:
Largest Element = 9
----------------------------------------------------

Diagrammatic Representation:
Matrix:
[ 2   5   9 ]
[ 1   7   3 ]
[ 4   6   8 ]

Largest value found = 9
*/
