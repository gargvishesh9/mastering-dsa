

# 🎯 1389. Create Target Array in the Given Order

## 📌 Problem

You are given two integer arrays `nums` and `index`.
Your task is to create `target` array following these rules:

* Start with an empty array `target`.
* Iterate over `nums[i]` and `index[i]`.
* Insert `nums[i]` at position `index[i]` in `target`.

Return the `target` array after processing all pairs `(nums[i], index[i])`.

---

## 💡 Approach

We can use a **dynamic list** because inserting at arbitrary positions is easier with `ArrayList`.
At the end, convert the list back to an array.

---

## ✅ Code

```java
import java.util.*;

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]); // insert nums[i] at index[i]
        }

        // Convert List<Integer> to int[]
        int[] target = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            target[i] = list.get(i);
        }

        return target;
    }
}
```

---

## 🏃 Dry Run

**Input:**
`nums = [0, 1, 2, 3, 4]`
`index = [0, 1, 2, 2, 1]`

| Step | i | nums[i] | index[i] | Action              | target after step |
| ---- | - | ------- | -------- | ------------------- | ----------------- |
| 1    | 0 | 0       | 0        | Insert 0 at index 0 | [0]               |
| 2    | 1 | 1       | 1        | Insert 1 at index 1 | [0, 1]            |
| 3    | 2 | 2       | 2        | Insert 2 at index 2 | [0, 1, 2]         |
| 4    | 3 | 3       | 2        | Insert 3 at index 2 | [0, 1, 3, 2]      |
| 5    | 4 | 4       | 1        | Insert 4 at index 1 | [0, 4, 1, 3, 2]   |

**Output:**
`[0, 4, 1, 3, 2] ✅`

---

## ⏱ Complexity

* **Time Complexity:** `O(n²)` (because `ArrayList.add(index, value)` shifts elements, costing `O(n)` in worst case)
* **Space Complexity:** `O(n)` (extra list used)

