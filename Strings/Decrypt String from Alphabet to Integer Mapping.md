
# 1309. Decrypt String from Alphabet to Integer Mapping

## Problem
Given a string `s` containing digits and `#`, decode it to lowercase English letters using these rules:

1. `'1'` → `'a'`, `'2'` → `'b'`, …, `'9'` → `'i'`  
2. `'10#'` → `'j'`, `'11#'` → `'k'`, …, `'26#'` → `'z'`  

Return the decoded string.  

**Example:**
```

Input: s = "10#11#12"
Output: "jkab"

````

---

## Solution

```java
class Solution {
    public String freqAlphabets(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            if (s.charAt(i) == '#') {
                // Take previous two digits
                int num = Integer.parseInt(s.substring(i-2, i));
                result.append((char) ('a' + num - 1)); // map to char
                i -= 3; // skip two digits and '#'
            } else {
                int num = s.charAt(i) - '0';            // convert char digit to int
                result.append((char) ('a' + num - 1));  // map to char
                i--;
            }
        }

        return result.reverse().toString(); // reverse because we processed from the end
    }
}
````

---

## Key Concepts

1. **Mapping numbers to letters**

```java
(char) ('a' + num - 1)
```

* Converts 1 → 'a', 2 → 'b', … 26 → 'z'
* `'a'` = ASCII 97; add `num - 1` to get correct letter.

2. **Convert char digit to integer**

```java
int num = s.charAt(i) - '0';
```

* `'0'`–`'9'` ASCII 48–57
* Subtracting `'0'` gives numeric value: `'3' - '0' = 3`.

3. **Why traverse from end**

* Easy to handle `#` cases which always follow two-digit numbers.

---

## Complexity

* **Time Complexity:** O(n), iterate through all characters once.
* **Space Complexity:** O(n), for the `StringBuilder`.

---

## Example Walkthrough

```
Input: "10#11#12"

i = 7 -> '2' → 'b'
i = 6 -> '1' → 'a'
i = 5 -> '#' → previous "11" → 'k'
i = 2 -> '#' → previous "10" → 'j'

Result before reverse: "bakj"
After reverse: "jkab"
```

```

