/**
 * Problem: Remove all occurrences of a substring from a string.
 *
 * Approaches:
 * 1. Brute Force (using String methods like replace/contains)
 * 2. Optimized (incrementally build result with StringBuilder)
 */

public class RemoveOccurrences {

    // --------------------------------------------------
    // Approach 1: Brute Force using replace()
    // --------------------------------------------------
    // Idea:
    // Keep removing `part` as long as it exists in `s`.
    // Simple, but inefficient because every replacement creates a new string.
    // Time Complexity: O(n * m) to O(n^2), where n = length of s, m = length of part
    // Space Complexity: O(n) due to new string creations
    public static String removeOccurrencesBrute(String s, String part) {
        while (s.contains(part)) {
            s = s.replaceFirst(part, ""); // remove first occurrence
        }
        return s;
    }

    // --------------------------------------------------
    // Approach 2: Optimized using StringBuilder
    // --------------------------------------------------
    // Idea:
    // Build the result character by character.
    // After adding each character, check if the last `part.length()` chars match `part`.
    // If yes, delete them immediately.
    // Time Complexity: O(n * m), but much faster in practice
    // Space Complexity: O(n) for StringBuilder
    public static String removeOccurrencesOptimized(String s, String part) {
        StringBuilder res = new StringBuilder();
        int n = part.length();

        for (char c : s.toCharArray()) {
            res.append(c);

            // Check if result ends with part
            if (res.length() >= n && res.substring(res.length() - n).equals(part)) {
                res.delete(res.length() - n, res.length());
            }
        }
        return res.toString();
    }

    // --------------------------------------------------
    // Main for testing both approaches
    // --------------------------------------------------
    public static void main(String[] args) {
        String s = "daabcbaabcbc";
        String part = "abc";

        System.out.println("Original: " + s + ", Part: " + part);

        // Brute force
        String bruteResult = removeOccurrencesBrute(s, part);
        System.out.println("Brute Force Result: " + bruteResult);

        // Optimized
        String optResult = removeOccurrencesOptimized(s, part);
        System.out.println("Optimized Result: " + optResult);

        // Dry run example (Optimized)
        System.out.println("\nDry Run of Optimized Approach:");
        StringBuilder res = new StringBuilder();
        int n = part.length();
        for (char c : s.toCharArray()) {
            res.append(c);
            System.out.print("After adding '" + c + "': " + res);
            if (res.length() >= n && res.substring(res.length() - n).equals(part)) {
                res.delete(res.length() - n, res.length());
                System.out.print("  <-- removed '" + part + "'");
            }
            System.out.println();
        }
        System.out.println("Final Result: " + res.toString());
    }
}
