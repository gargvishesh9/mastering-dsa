
# 🍬 1431. Kids With the Greatest Number of Candies

## 📌 Problem

You are given:

* `candies[i]`: number of candies each kid has
* `extraCandies`: number of extra candies you can give

For each kid, check if giving them **all** `extraCandies` will make them have **the greatest number of candies** among all kids.
Return a list of `Boolean` values (`true` or `false`) for each kid.

---

## 💡 Approach (Two-Pass Solution)

1. **Pass 1 → Find maxCandies:**

   * Loop through `candies` and keep track of the largest value.

2. **Pass 2 → Build result:**

   * For each kid, check if `candies[i] + extraCandies >= maxCandies`.
   * If true → add `true` to result list.
   * Otherwise → add `false`.

---

## ✅ Your Code

```java
import java.util.*;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> result = new ArrayList<>();
        
        // Step 1: Find maximum candies
        int maxCandies = Integer.MIN_VALUE;
        for (int i = 0; i < candies.length; i++) {
            maxCandies = Math.max(maxCandies, candies[i]);
        }

        // Step 2: Check each kid
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maxCandies) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
}
```

---

## 🏃 Dry Run

**Input:**
`candies = [2, 3, 5, 1, 3], extraCandies = 3`

| Step   | i     | candies[i] | maxCandies | candies[i] + extraCandies | ≥ maxCandies? | result                          |
| ------ | ----- | ---------- | ---------- | ------------------------- | ------------- | ------------------------------- |
| Pass 1 | 0 → 4 | —          | **5**      | —                         | —             | —                               |
| Pass 2 | 0     | 2          | 5          | 5                         | ✅             | [true]                          |
| Pass 2 | 1     | 3          | 5          | 6                         | ✅             | [true, true]                    |
| Pass 2 | 2     | 5          | 5          | 8                         | ✅             | [true, true, true]              |
| Pass 2 | 3     | 1          | 5          | 4                         | ❌             | [true, true, true, false]       |
| Pass 2 | 4     | 3          | 5          | 6                         | ✅             | [true, true, true, false, true] |

**Output:**
`[true, true, true, false, true] ✅`

---

## ⏱ Complexity

* **Time Complexity:** `O(n)` (two simple passes but still linear)
* **Space Complexity:** `O(n)` (result list)

