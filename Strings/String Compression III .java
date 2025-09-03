/**
 * LeetCode 3163 – String Compression III
 *
 * Problem:
 * Given a string word, compress it using the following algorithm:
 * - Begin with an empty string comp.
 * - While word is not empty, do:
 *     1. Remove a maximum length prefix of word made of a single character c repeating at most 9 times.
 *     2. Append the length of the prefix followed by c to comp.
 * - Return the string comp.
 *
 * Example:
 *   Input: word = "aaabbc"
 *   Output: "3a2b1c"
 *
 *   Input: word = "aaaaaaaaaaa"
 *   Output: "9a2a"
 *
 * Constraints:
 * - 1 <= word.length <= 2 * 10^5
 * - word consists only of lowercase English letters.
 */

class Solution {
    public String compressedString(String word) {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            int count = 1;

            // Count consecutive characters
            while (i + 1 < word.length() && word.charAt(i) == word.charAt(i + 1)) {
                count++;
                i++;
            }

            // Break into chunks of 9 if needed
            while (count > 9) {
                s.append(9).append(word.charAt(i));
                count -= 9;
            }

            // Append remaining count (1–9)
            s.append(count).append(word.charAt(i));
        }
        return s.toString();
    }
}

/*
 * -------------------------
 * Dry Run: "aaabbc"
 * -------------------------
 * Iteration 1: 'a'
 *   count = 3 → append "3a"
 * Iteration 2: 'b'
 *   count = 2 → append "2b"
 * Iteration 3: 'c'
 *   count = 1 → append "1c"
 * Final Output = "3a2b1c"
 *
 * -------------------------
 * Dry Run: "aaaaaaaaaaa" (11 a's)
 * -------------------------
 * Iteration 1: 'a'
 *   count = 11
 *   while(count > 9) → append "9a", count = 2
 *   append "2a"
 * Final Output = "9a2a"
 */
