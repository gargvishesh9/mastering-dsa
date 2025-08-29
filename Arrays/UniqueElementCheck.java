import java.util.HashSet;

/**
 * Problem: Contains Duplicate (LeetCode 217)
 *
 * Given an integer array nums, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 *
 * Constraints:
 *   1 <= nums.length <= 10^5
 *   -10^9 <= nums[i] <= 10^9
 *
 * Approaches:
 *
 * 1. Brute Force:
 *    - Compare every element with every other element.
 *    - Time: O(n^2), Space: O(1)
 *
 * 2. Optimized Approach using HashSet:
 *    - Use a HashSet to track seen elements.
 *    - If we encounter an element already in the set, return true.
 *    - Otherwise, add it to the set.
 *    - Time: O(n), Space: O(n)
 */
public class UniqueElementCheck {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};  // No duplicates → should return false
        boolean areDuplicates = checkDuplicates(arr);
        System.out.println("Contains Duplicates? " + areDuplicates);

        int[] arr2 = {1, 2, 3, 1}; // Contains duplicate 1 → should return true
        System.out.println("Contains Duplicates? " + checkDuplicates(arr2));
    }

    public static boolean checkDuplicates(int[] arr) {
        int n = arr.length;

        // ---------------- Brute Force ----------------
        // Compare every pair → O(n^2)
        /*
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    return true; // Duplicate found
                }
            }
        }
        return false; // No duplicates
        */

        // ---------------- Optimized Approach ----------------
        // Use HashSet → O(n) time, O(n) space
        HashSet<Integer> seen = new HashSet<>(arr.length);
        for (int num : arr) {
            if (seen.contains(num)) {
                return true; // Duplicate found
            } else {
                seen.add(num); // First time seeing this element
            }
        }
        return false; // No duplicates
    }
}
