/**
 * TrappedRainwater Problem
 *
 * Given an elevation map (array where each element represents height of a bar),
 * compute how much water can be trapped between the bars after it rains.
 *
 * Intuition:
 *  - At each index, the amount of trapped water depends on the minimum of:
 *      → tallest bar on the left
 *      → tallest bar on the right
 *  - Water trapped at index = min(leftMax, rightMax) - height[index]
 *
 * Example:
 *  height = [4, 2, 0, 6, 3, 2, 5]
 *
 *  leftMax  = [4, 4, 4, 6, 6, 6, 6]
 *  rightMax = [6, 6, 6, 6, 5, 5, 5]
 *
 *  Water at index i = min(leftMax[i], rightMax[i]) - height[i]
 *
 * Time Complexity: O(n)   (two passes for leftMax & rightMax + one pass for water)
 * Space Complexity: O(n)  (two extra arrays)
 */

public class TrappedRainwater {

    public static void main(String[] args) {
        int[] height = {4, 2, 0, 6, 3, 2, 5};
        int trappedRw = trappedRainwater(height);
        System.out.println("Trapped Rain water is " + trappedRw); // Expected: 9
    }

    public static int trappedRainwater(int[] height) {
        int n = height.length;
        int trappedRainWater = 0;

        // STEP 1: Build leftMax array
        // leftMax[i] = tallest bar from (0...i)
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // STEP 2: Build rightMax array
        // rightMax[i] = tallest bar from (i...n-1)
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // STEP 3: Calculate trapped water at each index
        for (int i = 0; i < n; i++) {
            // water level is governed by the smaller side (bottle-neck effect)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);

            // trapped water = water level - bar height
            trappedRainWater += waterLevel - height[i];
        }

        return trappedRainWater;
    }
}
