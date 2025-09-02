
//
// Problem:
// Given a string s, return true if it is a palindrome, considering only 
// alphanumeric characters and ignoring cases.
//
// Approaches:
// 1. Build a cleaned string and check with two pointers.
// 2. Optimized two-pointer without building a new string.
//
// Author: Vishesh Garg

public class ValidPalindrome {

    // -------------------------------
    // ✅ Approach 1: Build Cleaned String
    // -------------------------------
    public static boolean isPalindromeBuild(String s) {
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                c = Character.toLowerCase(c);
                temp.append(c);
            }
        }

        String st = temp.toString();
        int i = 0, j = st.length() - 1;

        while (i < j) {
            if (st.charAt(i) != st.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // -------------------------------
    // ✅ Approach 2: Optimized Two-Pointer
    // -------------------------------
    public static boolean isPalindromeOptimized(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // -------------------------------
    // 🔹 Main Method for Testing
    // -------------------------------
    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = " ";

        System.out.println("Approach 1:");
        System.out.println(s1 + " -> " + isPalindromeBuild(s1)); // true
        System.out.println(s2 + " -> " + isPalindromeBuild(s2)); // false
        System.out.println(s3 + " -> " + isPalindromeBuild(s3)); // true

        System.out.println("\nApproach 2:");
        System.out.println(s1 + " -> " + isPalindromeOptimized(s1)); // true
        System.out.println(s2 + " -> " + isPalindromeOptimized(s2)); // false
        System.out.println(s3 + " -> " + isPalindromeOptimized(s3)); // true
    }
}
