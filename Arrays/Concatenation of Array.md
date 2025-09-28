
# 🔁 Concatenation of Array

## 📌 Problem
Given an integer array `nums` of length `n`, construct an array `ans` of length `2n` where:
```

ans[i] = nums[i]
ans[i + n] = nums[i]

````
for `0 <= i < n`.  
Return `ans`.

---

## 💡 Approach (Optimized)
- Create a new array `tmp` of size `2 * n`.
- Use **one loop** to copy `nums[i]` into both `tmp[i]` and `tmp[i + n]`.

---

## 📝 Code (Optimized)

```java
class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[2 * n];

        for (int i = 0; i < n; i++) {
            tmp[i] = nums[i];       // First half
            tmp[i + n] = nums[i];   // Second half
        }

        return tmp;
    }
}
````

---

## 🔍 Dry Run

Example: `nums = [1, 2, 1]`

| i | nums[i] | tmp[i] | tmp[i+n] |
| - | ------- | ------ | -------- |
| 0 | 1       | 1      | 1        |
| 1 | 2       | 2      | 2        |
| 2 | 1       | 1      | 1        |

✅ Final Answer → `tmp = [1, 2, 1, 1, 2, 1]`

---

## ⏱ Complexity

* **Time:** `O(n)` (one loop only ✅)
* **Space:** `O(n)` (new array of size `2n`)

---

## 🎯 Key Points

* One loop is **more concise** and avoids unnecessary duplication.
* Perfect solution for interview coding rounds — minimal and clean.

