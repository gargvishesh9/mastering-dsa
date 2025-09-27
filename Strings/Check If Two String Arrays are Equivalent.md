
# 1662. Check If Two String Arrays are Equivalent

## Problem
Given two string arrays `word1` and `word2`, return `true` if the **concatenation** of the strings in `word1` is equal to the concatenation of strings in `word2`.

---

## Original Solution (Concatenate & Compare)

```java
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        for (String w : word1) {
            string1.append(w);
        }

        for (String w : word2) {
            string2.append(w);
        }

        return string1.toString().equals(string2.toString()); // Convert to string before comparing
    }
}
````

### Notes

* **Idea:** Concatenate each array into a single string and compare.
* **Time Complexity:** O(n + m), where n = total chars in `word1`, m = total chars in `word2`.
* **Space Complexity:** O(n + m) for the two concatenated strings.
* **Bug to watch:** `StringBuilder.equals()` checks reference, not content; always use `toString().equals()`.

---

## Optimized Solution (Two Pointers)

```java
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i1 = 0, j1 = 0; // i1 = word1 index, j1 = char index
        int i2 = 0, j2 = 0; // i2 = word2 index, j2 = char index

        while (i1 < word1.length && i2 < word2.length) {
            if (word1[i1].charAt(j1) != word2[i2].charAt(j2)) {
                return false;
            }

            j1++;
            j2++;

            if (j1 == word1[i1].length()) {
                i1++;
                j1 = 0;
            }
            if (j2 == word2[i2].length()) {
                i2++;
                j2 = 0;
            }
        }

        return i1 == word1.length && i2 == word2.length;
    }
}
```

### Notes

* **Idea:** Compare characters one by one using pointers.
* **Time Complexity:** O(n + m), same as original.
* **Space Complexity:** O(1), no extra strings created.
* Efficient for **very large arrays**.

---

### ✅ Takeaways

1. Your original solution is **completely fine** for most interview cases.
2. Always remember `StringBuilder.equals()` vs `String.equals()`.
3. Optimized pointer approach is just a **space-efficient alternative**.

```

