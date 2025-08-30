public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        // Optimized solution using 2 pointers
        int maxWaterOptimized = containerWithMw(height);
        System.out.println("Max water (Optimized) = " + maxWaterOptimized);

        // Brute force solution
        int maxWaterBrute = containerWithMwBrute(height);
        System.out.println("Max water (Brute Force) = " + maxWaterBrute);
    }

    // ✅ Optimized Approach (Two Pointer Method)
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static int containerWithMw(int[] height) {
        int n = height.length;

        int lp = 0;           // left pointer at start
        int rp = n - 1;       // right pointer at end
        int maxWater = 0;     // store maximum water found so far

        // Move two pointers towards each other
        while (lp < rp) {
            // Width between the two lines
            int width = rp - lp;

            // Height will be limited by the shorter line
            int h = Math.min(height[lp], height[rp]);

            // Calculate water stored = width * height
            int currentWater = width * h;

            // Update maximum water if current is greater
            maxWater = Math.max(maxWater, currentWater);

            // Move the pointer pointing to the shorter line,
            // because moving the taller one won’t help increase area
            if (height[lp] < height[rp]) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }

    // ✅ Brute Force Approach
    // Check all pairs of lines and calculate water
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static int containerWithMwBrute(int[] height) {
        int n = height.length;
        int maxWater = 0;

        // Pick every pair of lines (i, j)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Width = distance between lines
                int width = j - i;

                // Height = minimum of the two lines
                int h = Math.min(height[i], height[j]);

                // Water stored between i and j
                int currentWater = width * h;

                // Update maxWater
                maxWater = Math.max(maxWater, currentWater);
            }
        }
        return maxWater;
    }
}
