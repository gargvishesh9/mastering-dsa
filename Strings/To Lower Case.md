
# 709. To Lower Case

## Problem
Given a string `s`, convert all uppercase letters to lowercase without affecting other characters.

---

## Correct Solution

```java
class Solution {
    public String toLowerCase(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int asc = s.charAt(i);
            if (asc >= 65 && asc <= 90) {          // Uppercase letters
                result.append((char)(asc + 32));   // Convert to lowercase
            } else {
                result.append((char)asc);          // Keep other characters unchanged
            }
        }
        return result.toString();
    }
}
````

---

## Notes

* ASCII Values:

  * `'A'`–`'Z'` → 65–90
  * `'a'`–`'z'` → 97–122
  * Difference between uppercase and lowercase: 32

* **Key Fixes**

  1. Use `&&` to check the range: `asc >= 65 && asc <= 90`.
  2. Add 32 **before casting** to char: `(char)(asc + 32)`.
  3. Do not use `(char)asc + 32`, as it appends the integer value as a string.

* **Time Complexity:** O(n), iterate through each character once.

* **Space Complexity:** O(n), for the `StringBuilder`.

* **Alternative (simpler):**

```java
return s.toLowerCase();
```

