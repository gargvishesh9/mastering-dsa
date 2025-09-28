
# 🧠 Problem: Valid Palindrome II

Given a string `s`, return **true** if `s` can become a palindrome after deleting **at most one character**.

---

## ✅ Correct Approach

We use **two pointers** (`i` and `j`) to check characters from both ends:

### Steps

1. Move `i` and `j` inward while `s.charAt(i) == s.charAt(j)`.
2. When a mismatch occurs:

   * Try **skipping the left character** (`i+1` to `j`)
   * Or try **skipping the right character** (`i` to `j-1`)
   * If either substring is a palindrome → return `true`.
3. If no mismatches are found → return `true`.

---

## 💻 Fixed Code

```java
class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                // Skip either i or j and check palindrome
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
        }

        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
```

---

## 🕒 Complexity

| Complexity | Analysis                                   |
| ---------- | ------------------------------------------ |
| **Time**   | `O(n)` – we check the string at most twice |
| **Space**  | `O(1)` – uses only pointers                |

---

## 🧩 Example Dry Run

**Input:**
`s = "abca"`

| i | j | s[i] | s[j] | Action                            |
| - | - | ---- | ---- | --------------------------------- |
| 0 | 3 | a    | a    | ✅ Move both → i=1, j=2            |
| 1 | 2 | b    | c    | ❌ Mismatch → Check two cases:     |
|   |   |      |      | ① Skip `b` → `"aca"` ✅ Palindrome |
|   |   |      |      | ② Skip `c` → `"aba"` ✅ Palindrome |

✅ At least one is palindrome → return **true**.

---

## ⚠️ Edge Cases

* `"aba"` → already a palindrome → **true**
* `"ab"` → remove one char → `"a"` or `"b"` → **true**
* `"abc"` → cannot be palindrome with only one deletion → **false**


