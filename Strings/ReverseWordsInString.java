// 📌 Reverse Words in a String (LeetCode #151)
//
// Problem:
// Given an input string s, reverse the order of the words.
//
// Approaches:
// 1. Using built-in methods (split + trim).
// 2. Using two-pointer traversal (no split).
//
// -------------------------------------------------------
// ✅ Approach 1: Method-Based (split + trim)
// -------------------------------------------------------

class SolutionWithMethods {
    public String reverseWords(String s) {
        // Remove leading/trailing spaces and split by multiple spaces
        String[] words = s.trim().split("\\s+");

        StringBuilder result = new StringBuilder();

        // Append words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) result.append(" "); // avoid trailing space
        }

        return result.toString();
    }
}

// -------------------------------------------------------
// ✅ Approach 2: Two-Pointer (No split, O(1) extra space)
// -------------------------------------------------------

class SolutionTwoPointer {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            // skip spaces
            while (i >= 0 && s.charAt(i) == ' ') i--;
            if (i < 0) break;

            int j = i;
            while (i >= 0 && s.charAt(i) != ' ') i--;

            // extract word
            result.append(s.substring(i + 1, j + 1));
            result.append(" ");
        }

        return result.toString().trim();
    }
}

// -------------------------------------------------------
// 🔹 Main Class to Test Both Approaches
// -------------------------------------------------------

public class ReverseWords {
    public static void main(String[] args) {
        String s = "  the   sky  is   blue  ";

        SolutionWithMethods sol1 = new SolutionWithMethods();
        SolutionTwoPointer sol2 = new SolutionTwoPointer();

        System.out.println("Input: \"" + s + "\"");
        System.out.println("Using Methods:   \"" + sol1.reverseWords(s) + "\"");
        System.out.println("Two-Pointer:     \"" + sol2.reverseWords(s) + "\"");
    }
}
