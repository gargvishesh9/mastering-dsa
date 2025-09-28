
### 2000. Reverse Prefix of Word

**Difficulty:** Easy

**Problem:**
Given a string `word` and a character `ch`, **reverse the prefix of `word` up to and including the first occurrence of `ch`**.
If `ch` does not exist in `word`, return the original string.

---

## Approach 1: Original Method (with `reverseString`)

**Idea:**

* Iterate through `word` to find the first occurrence of `ch`.
* Reverse the prefix using a helper function `reverseString`.
* Append the remaining characters after the prefix.

**Time Complexity:** `O(n)`
**Space Complexity:** `O(n)` – for `StringBuilder`

**Java Implementation:**

```java
class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder result = new StringBuilder();
        boolean reversed = false;

        for(int i = 0; i < word.length(); i++) {
            if(!reversed && word.charAt(i) == ch){
                String reversedPrefix = reverseString(word.substring(0, i + 1));
                result.append(reversedPrefix);
                reversed = true; // reversed first prefix
            }
        }

        // append remaining characters after prefix
        if(reversed) {
            result.append(word.substring(result.length()));
        } else {
            return word; // ch not found
        }

        return result.toString();
    }

    String reverseString(String s) {
        StringBuilder temp = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) { // fixed index
            temp.append(s.charAt(i));
        }
        return temp.toString();
    }
}
```

**Dry Run Example:**

Input: `"abcdefd"`, `ch = 'd'`

* Prefix to reverse: `"abcd"` → `"dcba"`
* Append remaining: `"efd"`
* Output: `"dcbaefd"` ✅

---

## Approach 2: Optimized Version (No Helper)

**Idea:**

* Find the first occurrence of `ch` using `indexOf`.
* Reverse the prefix directly in a `StringBuilder`.
* Append the remaining string after `ch`.

**Time Complexity:** `O(n)`
**Space Complexity:** `O(n)`

**Java Implementation:**

```java
class Solution {
    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        if (idx == -1) return word; // char not found

        StringBuilder result = new StringBuilder();
        // Reverse prefix directly
        for (int i = idx; i >= 0; i--) {
            result.append(word.charAt(i));
        }

        // Append the remaining characters
        result.append(word.substring(idx + 1));

        return result.toString();
    }
}
```

**Dry Run Example:**

Input: `"abcdefd"`, `ch = 'd'`

* First occurrence index: `3`
* Reverse `"abcd"` → `"dcba"`
* Append remaining `"efd"` → `"dcbaefd"`

Output: `"dcbaefd"` ✅

---

### Notes:

* Both approaches handle the case where `ch` is **not present**.
* Approach 2 is **simpler, shorter, and avoids extra helper method**.
* Both have **O(n) time complexity** and **O(n) space** due to `StringBuilder`.

---

