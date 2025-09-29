
# 🔢 1512. Number of Good Pairs

## 📌 Problem

You are given an integer array `nums`.
A pair `(i, j)` is **good** if:

* `nums[i] == nums[j]`
* `i < j`

Return the total number of good pairs.

---

## 💡 Approach 1 – Brute Force (Two Loops)

### 🔑 Idea

Compare every pair `(i, j)` where `i < j`.
Increment `count` whenever `nums[i] == nums[j]`.

### ✅ Code

```java
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
```

### 🏃 Dry Run

**Input:** `nums = [1, 2, 3, 1, 1, 3]`

| i | j | nums[i] | nums[j] | Match? | count |
| - | - | ------- | ------- | ------ | ----- |
| 0 | 3 | 1       | 1       | ✅      | 1     |
| 0 | 4 | 1       | 1       | ✅      | 2     |
| 2 | 5 | 3       | 3       | ✅      | 3     |
| 3 | 4 | 1       | 1       | ✅      | 4     |

**Output:** `4 ✅`

### ⏱ Complexity

* **Time:** `O(n²)`
* **Space:** `O(1)`

---

## 💡 Approach 2 – Optimized (HashMap Counting)

### 🔑 Idea

Instead of comparing all pairs:

* Keep a running count of how many times each number has appeared.
* When we see a new occurrence of `num`, it forms pairs with all **previous occurrences**.
* Increment `count` by `freq[num]` before updating frequency.

### ✅ Code

```java
import java.util.*;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            if (freq.containsKey(num)) {
                count += freq.get(num); // pairs formed with previous occurrences
            }
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}
```

### 🏃 Dry Run

**Input:** `nums = [1, 2, 3, 1, 1, 3]`

| Step | num | freq[num] before | count increment | count after | freq[num] after |
| ---- | --- | ---------------- | --------------- | ----------- | --------------- |
| 1    | 1   | 0                | +0              | 0           | 1               |
| 2    | 2   | 0                | +0              | 0           | 1               |
| 3    | 3   | 0                | +0              | 0           | 1               |
| 4    | 1   | 1                | +1              | 1           | 2               |
| 5    | 1   | 2                | +2              | 3           | 3               |
| 6    | 3   | 1                | +1              | 4           | 2               |

**Output:** `4 ✅`

### ⏱ Complexity

* **Time:** `O(n)` → single pass
* **Space:** `O(n)` → hashmap for frequencies

---

## 🏆 Summary

| Approach        | Time    | Space  | Notes                                 |
| --------------- | ------- | ------ | ------------------------------------- |
| **Brute Force** | `O(n²)` | `O(1)` | Easy to write but slow for large `n`. |
| **Optimized**   | `O(n)`  | `O(n)` | Much faster; uses frequency counting. |

