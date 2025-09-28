
# ➕ Running Sum of 1D Array

## 📌 Problem
Given an array `nums`, return an array `sum` where:
```

sum[i] = nums[0] + nums[1] + ... + nums[i]

````

### Example
Input:  
`nums = [1,2,3,4]`  

Output:  
`[1,3,6,10]`  

---

## 💡 Approach
- Initialize `sum[0] = nums[0]`.
- For each `i` from 1 to n-1:
  - `sum[i] = sum[i-1] + nums[i]`
- Return `sum`.

---

## 📝 Code

```java
class Solution {
    public int[] runningSum(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }

        return sum;
    }
}
````

---

## 🔍 Dry Run

Example: `nums = [1,2,3,4]`

| i | nums[i] | sum[i-1] | sum[i] |
| - | ------- | -------- | ------ |
| 0 | 1       | —        | 1      |
| 1 | 2       | 1        | 3      |
| 2 | 3       | 3        | 6      |
| 3 | 4       | 6        | 10     |

✅ Final Answer → `[1,3,6,10]`

---

## ⏱ Complexity

* **Time:** `O(n)`
* **Space:** `O(n)` (can also do **in-place** in `nums` for O(1) extra space)

---

## 🎯 Key Points

* Each element depends on **previous cumulative sum**.
* Always **initialize the first element** before starting the loop.
* Straightforward problem but good for practicing **prefix sums**.

```

