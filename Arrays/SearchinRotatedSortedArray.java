/**
 * LeetCode 33: Search in Rotated Sorted Array
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Prevents integer overflow

            // Case 1: Found the target
            if (nums[mid] == target) {
                return mid;
            }

            // Case 2: Left half is sorted
            if (nums[low] <= nums[mid]) {
                // Check if target lies in the sorted left half
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1; // Move to left side
                } else {
                    low = mid + 1; // Move to right side
                }
            }
            // Case 3: Right half is sorted
            else {
                // Check if target lies in the sorted right half
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1; // Move to right side
                } else {
                    high = mid - 1; // Move to left side
                }
            }
        }

        // If not found
        return -1;
    }
}
