
# 🧠 Problem: Long Pressed Name

You are given two strings:

* `name` → the original name your friend intended to type
* `typed` → the actual string typed on the keyboard

Sometimes, characters might be **long-pressed**, meaning a character could appear more than once.

Return **true** if `typed` can be formed from `name` considering possible long presses, otherwise return **false**.

---

## ✅ Approach

We use **two pointers** (`i` for `name`, `j` for `typed`) and iterate over `typed`.

### Steps:

1. **Match characters**

   * If `name[i] == typed[j]`, move both pointers (`i++`, `j++`).

2. **Handle long press**

   * If characters don't match, check if `typed[j]` is **same as previous `typed[j-1]`** → increment `j` (skip this extra character).

3. **Mismatch Case**

   * If neither condition is satisfied, return `false`.

4. **Check Completion**

   * After loop ends, check if `i == name.length()`.
   * If not, some characters of `name` are not matched → return `false`.

---

## 💻 Code

```java
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0; // Pointer for 'name'
        int j = 0; // Pointer for 'typed'

        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                // Characters match, move both
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                // Long press detected, move only 'j'
                j++;
            } else {
                // Neither match nor long press -> invalid
                return false;
            }
        }

        // All characters in 'name' should be matched
        return i == name.length();
    }
}
```

---

## 🕒 Complexity

| Complexity | Analysis                                                   |
| ---------- | ---------------------------------------------------------- |
| **Time**   | `O(n + m)` where `n = name.length()`, `m = typed.length()` |
| **Space**  | `O(1)` (uses only two pointers)                            |

---

## 🧩 Example Dry Run

**Input:**
`name = "alex", typed = "aaleex"`

| i (name) | j (typed) | name[i] | typed[j] | Action                                |
| -------- | --------- | ------- | -------- | ------------------------------------- |
| 0        | 0         | a       | a        | ✅ Match → i=1, j=1                    |
| 1        | 1         | l       | a        | ❌ No match → check long press → ✅ j=2 |
| 1        | 2         | l       | l        | ✅ Match → i=2, j=3                    |
| 2        | 3         | e       | e        | ✅ Match → i=3, j=4                    |
| 3        | 4         | x       | e        | ❌ No match → check long press → ✅ j=5 |
| 3        | 5         | x       | x        | ✅ Match → i=4, j=6                    |

✅ **i == name.length() → return true**


