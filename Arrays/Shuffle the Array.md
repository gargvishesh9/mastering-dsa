
# 🃏 1470. Shuffle the Array

## 📌 Problem

Given an array `nums` of `2n` elements in the form `[x1,x2,...,xn,y1,y2,...,yn]`, return the array in the form `[x1,y1,x2,y2,...,xn,yn]`.

---

## 💡 Approach

We use **two pointers**:

* `i` → starts at index `0` (first half of array)
* `j` → starts at index `n` (second half of array)
  We keep inserting alternately into a `result` array until all elements are used.

---

## ✅ Code

```java
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        int i = 0;   // pointer for first half
        int j = n;   // pointer for second half
        int k = 0;   // pointer for result array

        while (i < n && j < 2 * n) {
            result[k++] = nums[i++]; // pick from first half
            result[k++] = nums[j++]; // pick from second half
        }

        return result;
    }
}
```

---

## 🏃 Dry Run

**Input:**
`nums = [2, 5, 1, 3, 4, 7], n = 3`

| Step  | i | j | k | result[] after step |
| ----- | - | - | - | ------------------- |
| Start | 0 | 3 | 0 | [_, _, _, _, _, _]  |
| 1     | 1 | 3 | 1 | [2, _, _, _, _, _]  |
| 2     | 1 | 4 | 2 | [2, 3, _, _, _, _]  |
| 3     | 2 | 4 | 3 | [2, 3, 5, _, _, _]  |
| 4     | 2 | 5 | 4 | [2, 3, 5, 4, _, _]  |
| 5     | 3 | 5 | 5 | [2, 3, 5, 4, 1, _]  |
| 6     | 3 | 6 | 6 | [2, 3, 5, 4, 1, 7]  |

**Output:**
`[2, 3, 5, 4, 1, 7] ✅`

---

## ⏱ Complexity

* **Time Complexity:** `O(n)` → single pass through the array.
* **Space Complexity:** `O(2n)` → we use an extra array for result.

