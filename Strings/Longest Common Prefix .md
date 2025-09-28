
# 14. Longest Common Prefix 

**Difficulty:** Easy
**Topics:** Strings, Array

---

## 🧠 Problem

Given an array of strings `strs`, find the **longest common prefix**.
Return `""` if no common prefix exists.

---

## 1️⃣ Horizontal Scanning (Manual Comparison)

**Idea:** Start with the first string as prefix and shrink it comparing with each string.

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = commonPrefix(prefix, strs[i]);
            if (prefix.isEmpty()) return "";
        }
        return prefix;
    }

    private String commonPrefix(String a, String b) {
        int len = Math.min(a.length(), b.length()), index = 0;
        while (index < len && a.charAt(index) == b.charAt(index)) index++;
        return a.substring(0, index);
    }
}
```

* **Time:** O(N * M), N = number of strings, M = length of shortest string
* **Space:** O(1)

---

## 2️⃣ Vertical Scanning

**Idea:** Compare characters column-wise across all strings until mismatch.

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
```

* **Time:** O(N * M)
* **Space:** O(1)

---

## 3️⃣ Sorting + Compare First & Last

**Idea:** After sorting, common prefix of first and last string is the prefix for all.

```java
import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        Arrays.sort(strs);
        String first = strs[0], last = strs[strs.length - 1];
        int i = 0;
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) i++;
        return first.substring(0, i);
    }
}
```

* **Time:** O(N log N + M) (sorting + compare first & last)
* **Space:** O(1)

---

## ⚡ Key Notes

* Horizontal & Vertical scanning → O(N * M), faster for small arrays.
* Sorting → useful if strings are long or need lexicographical properties.
* Always **check edge cases**: empty array, array with one string, no common prefix.

---
