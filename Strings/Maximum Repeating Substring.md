
# 1668. Maximum Repeating Substring

**Difficulty:** Easy
**Topics:** Strings, Substring

---

## 🧠 Problem

* Given strings `sequence` and `word`.
* Define **k-repeating**: `word` repeated k times (`word * k`) is a substring of `sequence`.
* Return the **maximum k**.
* If `word` is not in `sequence` → return 0.

**Example:**

```
sequence = "ababc", word = "ab" → "ab" repeats twice ("abab") → return 2
sequence = "ababc", word = "ba" → only once → return 1
```

---

## 1️⃣ Brute-Force: Repeated Concatenation

**Idea:**

1. Start with `k = 0`.
2. Keep appending `word` to itself.
3. Check if the repeated string exists in `sequence`.
4. Stop when it no longer exists, return last valid `k`.

```java
class Solution {
    public int maxRepeating(String sequence, String word) {
        int k = 0;
        StringBuilder repeated = new StringBuilder(word);

        while (sequence.contains(repeated.toString())) {
            k++;
            repeated.append(word); // repeat one more time
        }

        return k;
    }
}
```

**Complexity:**

* **Time:** O(N * M * K) → N = sequence length, M = word length, K = max repetitions
* **Space:** O(M * K) → for repeated string

---

## 2️⃣ Optimized: Sliding Window / Direct Counting

**Idea:**

1. Iterate through `sequence`.
2. At each index, count consecutive occurrences of `word`.
3. Keep track of **maximum count**.

```java
class Solution {
    public int maxRepeating(String sequence, String word) {
        int maxCount = 0;
        int n = sequence.length();
        int m = word.length();

        for (int i = 0; i <= n - m; i++) {
            int count = 0;
            int start = i;

            while (start + m <= n && sequence.substring(start, start + m).equals(word)) {
                count++;
                start += m;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
```

**Complexity:**

* **Time:** O(N * M) → N = sequence length, M = word length
* **Space:** O(1)

---

## 🔎 Example Dry Run

**Input:**

```
sequence = "ababcababc", word = "ab"
```

| Index | Substring | Count | MaxCount |
| ----- | --------- | ----- | -------- |
| 0     | "ab"      | 1     | 1        |
| 0-1   | "abab"    | 2     | 2 ✅      |
| 2     | "ab"      | 1     | 2        |
| 2-3   | "abab"    | 2     | 2 ✅      |

**Output:** 2

---

## ⚡ Notes

* **Brute-force approach** is simple but slower for large sequences.
* **Optimized approach** is preferred for interviews.
* Key idea: **slide a window of size `word.length()` and count consecutive matches**.

---

