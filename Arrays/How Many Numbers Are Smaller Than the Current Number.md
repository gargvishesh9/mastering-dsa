

# 🔢 1365. How Many Numbers Are Smaller Than the Current Number

## 📌 Problem

Given an array `nums`, return an array `result` where `result[i]` is the number of elements in `nums` that are **smaller than `nums[i]`**.

---

## 💡 Approach – Sort & Map

### 🔑 Idea

1. Make a **copy** of `nums` and sort it.
2. For each number, store its **first index** in the sorted array → that index = count of smaller numbers.
3. Build result using this map.

---

## ✅ Code

```java
import java.util.*;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();  // Step 1: Copy array
        Arrays.sort(sorted);          // Step 2: Sort array

        Map<Integer, Integer> firstIndex = new HashMap<>();

        // Step 3: Store first occurrence index of each number
        for (int i = 0; i < n; i++) {
            firstIndex.putIfAbsent(sorted[i], i);
        }

        // Step 4: Build result using map
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = firstIndex.get(nums[i]);
        }

        return result;
    }
}
```

---

## 🏃 Dry Run

**Input:**
`nums = [8, 1, 2, 2, 3]`

### Step 1 – Clone & Sort

`sorted = [1, 2, 2, 3, 8]`

### Step 2 – Build firstIndex map

| i | sorted[i] | firstIndex                   |
| - | --------- | ---------------------------- |
| 0 | 1         | {1 → 0}                      |
| 1 | 2         | {1 → 0, 2 → 1}               |
| 2 | 2         | (already present, skip)      |
| 3 | 3         | {1 → 0, 2 → 1, 3 → 3}        |
| 4 | 8         | {1 → 0, 2 → 1, 3 → 3, 8 → 4} |

### Step 3 – Build result

| nums[i] | firstIndex.get(nums[i]) | result[i] |
| ------- | ----------------------- | --------- |
| 8       | 4                       | 4         |
| 1       | 0                       | 0         |
| 2       | 1                       | 1         |
| 2       | 1                       | 1         |
| 3       | 3                       | 3         |

**Output:**
`[4, 0, 1, 1, 3] ✅`

---

## ⏱ Complexity

* **Time Complexity:** `O(n log n)` → due to sorting
* **Space Complexity:** `O(n)` → extra array + map

