
### 1768. Merge Strings Alternately

**Difficulty:** Easy

**Problem:**
Given two strings `word1` and `word2`, merge them alternately. If one string is longer, append the remaining characters at the end.

---

### Approach 1: Two Pointers (Simple & Efficient)

* Use pointers `i` and `j` for `word1` and `word2`.
* Iterate while either string has characters remaining:

  * Append `word1[i]` if `i < word1.length()`
  * Append `word2[j]` if `j < word2.length()`
* Return the combined string.

**Time Complexity:** `O(n + m)`
**Space Complexity:** `O(n + m)`

**Java Implementation:**

```java
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;
        int n = word1.length(), m = word2.length();

        while(i < n || j < m) {
            if(i < n) result.append(word1.charAt(i++));
            if(j < m) result.append(word2.charAt(j++));
        }

        return result.toString();
    }
}
```

---

### Approach 2: Using `for` loop up to `minLength`

* Merge characters up to the **shorter string’s length**.
* Append the remaining part of the longer string afterward.

**Java Implementation:**

```java
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int n = word1.length(), m = word2.length();
        int minLen = Math.min(n, m);

        for(int i = 0; i < minLen; i++) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
        }

        if(n > minLen) result.append(word1.substring(minLen));
        if(m > minLen) result.append(word2.substring(minLen));

        return result.toString();
    }
}
```

**Time Complexity:** `O(n + m)`
**Space Complexity:** `O(n + m)`

---

### Dry Run Example:

Input: `"ab"`, `"pqrs"`

| Step | i | j | result     |
| ---- | - | - | ---------- |
| 1    | 0 | 0 | `"a"`      |
| 2    | 1 | 0 | `"ap"`     |
| 3    | 1 | 1 | `"apb"`    |
| 4    | 2 | 1 | `"apbq"`   |
| 5    | 2 | 2 | `"apbqr"`  |
| 6    | 2 | 3 | `"apbqrs"` |

✅ Final result: `"apbqrs"`

---

### Notes:

* Handles strings of **different lengths** automatically.
* Works even if one string is **empty**: returns the other string.
* Preferred approach: **Two pointers** – simpler and avoids substring creation.

---

