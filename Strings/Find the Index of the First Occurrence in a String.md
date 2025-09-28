# 📌 LeetCode 28 — Find the Index of the First Occurrence in a String

## 📝 Problem

Given two strings `haystack` and `needle`, return the **index of the first occurrence** of `needle` in `haystack`, or `-1` if `needle` is not part of `haystack`.

---

## 💡 Approach (Simple / Brute Force)

* Iterate over all possible starting indices in `haystack` where `needle` could fit.
* For each starting index `i`, compare characters one by one.
* If full match is found → return `i`.
* If no match is found after checking all positions → return `-1`.

---

## 🖊️ Code (Java)

```java
class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == m) return i; // Found full match
        }

        return -1;
    }
}
```

---

## ⏱️ Complexity

* **Time Complexity:** `O((n - m + 1) * m)` → Worst case, we compare `m` characters for each possible starting index.
* **Space Complexity:** `O(1)` → No extra data structures used.


