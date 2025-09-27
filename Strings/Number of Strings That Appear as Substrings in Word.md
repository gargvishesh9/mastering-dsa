
# 1967. Number of Strings That Appear as Substrings in Word

## Problem
Given an array of strings `patterns` and a string `word`, return the number of strings in `patterns` that exist as a **substring** in `word`.

**Example:**
```

Input: patterns = ["a","abc","bc","d"], word = "abc"
Output: 3
Explanation:

* "a" appears in "abc"
* "abc" appears in "abc"
* "bc" appears in "abc"
* "d" does not appear

````

---

## Solution

```java
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (int i = 0; i < patterns.length; i++) {
            if (word.contains(patterns[i])) {  // check if substring exists
                count++;
            }
        }
        return count;
    }
}
````

---

## Key Points

* **`String.contains()`** → checks if a substring exists in a string, returns `true` or `false`.
* **Iterate through all patterns** and increment count whenever found.
* **Time Complexity:** O(n * m)

  * `n` = number of patterns
  * `m` = average length of `word` (because `contains()` is O(m) worst case)
* **Space Complexity:** O(1)

---

## Example Walkthrough

```
patterns = ["a", "abc", "bc", "d"]
word = "abc"

"a"   → found → count = 1
"abc" → found → count = 2
"bc"  → found → count = 3
"d"   → not found

Answer = 3
```

```


