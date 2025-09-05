
```java
/*
======================================================
Problem: Remove Outermost Parentheses
======================================================

You are given a valid parentheses string s.
A valid parentheses string is either:
 - "()", or
 - s1 + s2, where s1 and s2 are valid parentheses strings, or
 - "(" + s1 + ")", where s1 is a valid parentheses string.

A primitive valid parentheses string is one that cannot be split into
smaller non-empty valid parentheses strings.

Your task:
Remove the outermost parentheses from every primitive substring of s.

------------------------------------------------------
Example:
Input:  s = "(()())(())"
Output: "()()()"

Explanation:
 - Primitive 1: "(()())" → remove outermost → "()()"
 - Primitive 2: "(())"   → remove outermost → "()"
Final Result = "()()()"

------------------------------------------------------
Constraints:
 - 1 <= s.length <= 10^5
 - s[i] is either '(' or ')'
 - s is a valid parentheses string
======================================================

Time Complexity Analysis:
------------------------------------------------------
- We iterate through the string once (O(n)), where n = length of s.
- Each character is processed in O(1) time.
- Hence, total time complexity = O(n).

Space Complexity Analysis:
------------------------------------------------------
- We use a StringBuilder to build the result (O(n) in worst case).
- A single integer `opened` is used (O(1)).
- Hence, space complexity = O(n).

======================================================
*/

class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int opened = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (opened > 0) {
                    result.append(c); // not outermost
                }
                opened++;
            } else {
                opened--;
                if (opened > 0) {
                    result.append(c); // not outermost
                }
            }
        }
        return result.toString();
    }

    // Driver method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        String[] tests = {
            "(()())(())", 
            "(()())(())(()(()))", 
            "()()", 
            "((()))"
        };

        for (String test : tests) {
            System.out.println("Input:    " + test);
            System.out.println("Output:   " + sol.removeOuterParentheses(test));
            System.out.println("------------------------------------");
        }
    }
}

/*
======================================================
Dry Run (Character by Character) for first test
======================================================

Input: "(()())(())"

opened = 0, result = ""

1. c = '(' → opened = 0 → OUTERMOST → skip → opened=1, result=""
2. c = '(' → opened=1>0 → append '(' → opened=2, result="("
3. c = ')' → opened=1>0 → append ')' → opened=1, result="()"
4. c = '(' → opened=1>0 → append '(' → opened=2, result="()("
5. c = ')' → opened=1>0 → append ')' → opened=1, result="()()"
6. c = ')' → opened=0 → OUTERMOST → skip → result="()()"

✅ First primitive "(()())" → "()()"

7. c = '(' → opened=0 → OUTERMOST → skip → opened=1, result="()()"
8. c = '(' → opened=1>0 → append '(' → opened=2, result="()()("
9. c = ')' → opened=1>0 → append ')' → opened=1, result="()()()"
10. c = ')' → opened=0 → OUTERMOST → skip → result="()()()"

✅ Second primitive "(())" → "()"

------------------------------------------------------
Final Result: "()()()"
======================================================

Other Test Cases:
------------------------------------------------------
Input:  "(()())(())" 
Output: "()()()"

Input:  "(()())(())(()(()))"
Output: "()()()()(())"

Input:  "()()"
Output: ""   (each primitive is just "()", after removing outermost → "")

Input:  "((()))"
Output: "(())"   (remove first and last only)
======================================================
*/
```


