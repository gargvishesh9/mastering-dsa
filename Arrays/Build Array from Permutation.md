
# 🔢 Build Array from Permutation

## 📌 Problem
Given a **0-indexed array** `nums` of length `n`, where `nums` is a permutation of numbers from `0` to `n - 1`.  
Construct an array `ans` where:
```

ans[i] = nums[nums[i]]

````
and return `ans`.

---

## 💡 Approach
- Create a new array `tmp` of same size.
- For each index `i`, set `tmp[i] = nums[nums[i]]`.
- Return `tmp`.

---

## 📝 Code

```java
class Solution {
    public int[] buildArray(int[] nums) {
        int[] tmp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[nums[i]];
        }

        return tmp;
    }
}
````

---

## 🔍 Dry Run

Example: `nums = [0, 2, 1, 5, 3, 4]`

| i | nums[i] | nums[nums[i]] | tmp[i] |
| - | ------- | ------------- | ------ |
| 0 | 0       | nums[0]=0     | 0      |
| 1 | 2       | nums[2]=1     | 1      |
| 2 | 1       | nums[1]=2     | 2      |
| 3 | 5       | nums[5]=4     | 4      |
| 4 | 3       | nums[3]=5     | 5      |
| 5 | 4       | nums[4]=3     | 3      |

✅ Final Answer → `tmp = [0, 1, 2, 4, 5, 3]`

---

## ⏱ Complexity

* **Time:** `O(n)` (one loop through array)
* **Space:** `O(n)` (extra array `tmp` used)

---

## 🎯 Key Points

* Very straightforward problem — just index twice.
* No tricky edge cases since `nums` is guaranteed to be a permutation.
* **Follow-up:** Can be solved **in-place** using clever math (storing two values in one index).

