

### 605. Check if Binary String Has Only One Segment of 1's

**Difficulty:** Easy

**Problem:**
Given a binary string `s` (only `'0'` and `'1'`), return `true` if **all the `1`s form a single contiguous segment**, otherwise return `false`.

---

### Approach:

**1️⃣ Compact 1-pass method**

* Skip the first contiguous block of `1`s.
* After that, if any `1` appears, return `false` (multiple segments exist).
* Otherwise, return `true`.

**Time Complexity:** `O(n)` – single pass through the string
**Space Complexity:** `O(1)` – only integer counters

---

### Java Implementation:

```java
class Solution {
    public boolean checkOnesSegment(String s) {
        int i = 0;
        int n = s.length();

        // Skip initial 1's (first segment)
        while (i < n && s.charAt(i) == '1') i++;

        // After first segment, no more 1's should appear
        while (i < n) {
            if (s.charAt(i) == '1') return false;
            i++;
        }

        return true;
    }
}
```

---

### Dry Run Example:

Input: `"1110111"`

1. Skip first segment: `i` moves from 0 → 3
2. Check remaining: `s.charAt(4) = '1'` → return `false`

✅ Correct, as there are **two separate segments of 1s**.

---

### Notes:

* Handles edge cases:

  * `"0"` → `true` (no 1s, trivially one segment)
  * `"1111"` → `true` (all 1s are contiguous)
  * `"101"` → `false` (two segments of 1s)

---

