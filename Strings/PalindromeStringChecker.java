public class PalindromeChecker {

    // Function to check if a string is a palindrome
    public static boolean isPalindrome(String s) {
        int n = s.length();

        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false; // mismatch found → not a palindrome
            }
        }
        return true; // no mismatches → palindrome
    }

    public static void main(String[] args) {
        String test1 = "racecar";
        String test2 = "hello";

        System.out.println(test1 + " is palindrome? " + isPalindrome(test1));
        System.out.println(test2 + " is palindrome? " + isPalindrome(test2));
    }
}

/*
-------------------------------
📘 Dry Run Example

Example 1: s = "racecar"
n = 7
Check characters:
i=0 → 'r' == 'r' → OK
i=1 → 'a' == 'a' → OK
i=2 → 'c' == 'c' → OK
i=3 → middle character, no need to check
Loop ends → return true

Example 2: s = "hello"
n = 5
Check characters:
i=0 → 'h' != 'o' → mismatch → return false
-------------------------------

📌 Explanation:
- Palindrome means the string reads the same forwards and backwards.
- We check characters from **start and end simultaneously**.
- If any mismatch occurs → return false immediately.
- If loop completes → string is a palindrome.

⏱ Time Complexity: O(n/2) → O(n)
📦 Space Complexity: O(1)
-------------------------------
*/
