import java.util.ArrayList;
import java.util.List;

/**
 * Spiral Matrix traversal
 * 
 * Problem: Given an m x n matrix, return all elements of the matrix
 * in spiral order (clockwise).
 * 
 * Example:
 * Input:  [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * -----------------------------------------------------------------
 * DRY RUN EXAMPLE:
 * 
 * Matrix:
 * [
 *   [1,  2,  3,  4],
 *   [5,  6,  7,  8],
 *   [9, 10, 11, 12]
 * ]
 * 
 * Initial boundaries:
 *   startRow = 0, endRow = 2
 *   startCol = 0, endCol = 3
 * 
 * Iteration 1 (outer layer):
 *   Top row    → [1, 2, 3, 4]
 *   Right col  → [8, 12]
 *   Bottom row → [11, 10, 9]
 *   Left col   → [5]
 *   Result so far = [1,2,3,4,8,12,11,10,9,5]
 *   Shrink boundaries → startRow=1, endRow=1, startCol=1, endCol=2
 * 
 * Iteration 2 (inner layer):
 *   Top row    → [6, 7]
 *   Right col  → (none left)
 *   Bottom row → (skipped, single row)
 *   Left col   → (skipped, single col)
 *   Result = [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * Final Answer:
 *   [1,2,3,4,8,12,11,10,9,5,6,7]
 * -----------------------------------------------------------------
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();

        // Define boundaries of the current "layer"
        int startRow = 0, startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        // Continue until all layers are processed
        while (startRow <= endRow && startCol <= endCol) {

            // 1. Traverse top row (left → right)
            for (int i = startCol; i <= endCol; i++) {
                result.add(matrix[startRow][i]);
            }

            // 2. Traverse right column (top → bottom)
            for (int i = startRow + 1; i <= endRow; i++) {
                result.add(matrix[i][endCol]);
            }

            // 3. Traverse bottom row (right → left), only if more than one row remains
            if (startRow < endRow) {
                for (int i = endCol - 1; i >= startCol; i--) {
                    result.add(matrix[endRow][i]);
                }
            }

            // 4. Traverse left column (bottom → top), only if more than one column remains
            if (startCol < endCol) {
                for (int i = endRow - 1; i > startRow; i--) {
                    result.add(matrix[i][startCol]);
                }
            }

            // Shrink the boundaries inward
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return result;
    }

    // For quick local testing
    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();

        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        System.out.println(sm.spiralOrder(matrix));
        // Expected Output: [1,2,3,4,8,12,11,10,9,5,6,7]
    }
}
