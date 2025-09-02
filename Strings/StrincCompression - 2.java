
import java.util.Arrays;

/**
 * Problem: String Compression (LeetCode style)
 *
 * Given an array of characters chars, compress it in-place.
 * The length after compression must be returned.
 *
 * Compression rule:
 * - Consecutive repeating characters are replaced by the character followed by the count.
 * - If the count is 1, do not write the count.
 *
 * Example:
 * Input: chars = ['a','a','b','b','c','c','c']
 * Output: ['a','2','b','2','c','3'], return length = 6
 *
 * Constraints:
 * - 1 <= chars.length <= 1000
 * - chars[i] is a lowercase English letter, uppercase letter, or digit.
 * - Must use only constant extra space for in-place solution (excluding variables).
 */

public class StringCompression {

    /**
     * Approach 1: Using StringBuilder (easy to understand)
     * Note: Not strictly constant space, uses extra StringBuilder.
     */
    public static int compressWithStringBuilder(char[] chars) {
        StringBuilder temp = new StringBuilder();

        // Build compressed string
        for (int i = 0; i < chars.length; i++) {
            int count = 1;

            while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }

            temp.append(chars[i]);

            if (count > 1) {
                temp.append(count);
            }
        }

        // Copy back into original array
        for (int i = 0; i < temp.length(); i++) {
            chars[i] = temp.charAt(i);
        }

        return temp.length();
    }

    /**
     * Approach 2: Fully in-place, memory-efficient
     * Constant extra space O(1)
     */
    public static int compressInPlace(char[] chars) {
        int write = 0; // next write position in array

        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            int count = 1;

            // Count consecutive characters
            while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }

            // Write the character
            chars[write++] = current;

            // Write the count if > 1
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }

    public static void main(String[] args) {
        char[] chars1 = {'a','a','b','b','c','c','c'};
        char[] chars2 = Arrays.copyOf(chars1, chars1.length); // copy for second approach

        // Run Approach 1
        int len1 = compressWithStringBuilder(chars1);
        System.out.println("Using StringBuilder: " + Arrays.toString(Arrays.copyOf(chars1, len1)));

        // Run Approach 2
        int len2 = compressInPlace(chars2);
        System.out.println("In-place efficient: " + Arrays.toString(Arrays.copyOf(chars2, len2)));

        // Dry run explanation for input ['a','a','b','b','c','c','c']
        System.out.println("\nDry Run Explanation:");
        System.out.println("Input: ['a','a','b','b','c','c','c']");
        System.out.println("Step 1: Count consecutive 'a' = 2, write 'a','2'");
        System.out.println("Step 2: Count consecutive 'b' = 2, write 'b','2'");
        System.out.println("Step 3: Count consecutive 'c' = 3, write 'c','3'");
        System.out.println("Final compressed array: ['a','2','b','2','c','3'], length = 6");
    }
}
