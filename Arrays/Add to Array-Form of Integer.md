

# 989. Add to Array-Form of Integer

### 📌 Problem

* You are given an array `num` representing a **non-negative integer**:

  ```
  num = [1,2,0,0] → represents 1200
  ```
* You are also given an integer `k`.
* Return the **array-form** of the integer `num + k`.

---

## 💡 Approach

* We **cannot convert `num` to an integer directly** because it may be very large.
* Solution: process **digit by digit from the least significant**:

1. Start from the **last index** of `num`.
2. Add the current digit of `num` to `k`.
3. The **last digit** of `k` (`k % 10`) is the current digit of the result.
4. Update `k` = `k / 10` (carry for next iteration).
5. Continue until all digits of `num` are processed and `k` becomes 0.
6. Reverse the result list at the end to get correct order.

---

## ✅ Code

```java
import java.util.*;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int i = num.length - 1;

        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i]; // add current digit
            }

            res.add(k % 10); // current digit of result
            k /= 10;         // carry
            i--;
        }

        Collections.reverse(res); // reverse to get correct order
        return res;
    }
}
```

---

## 🏃 Dry Run

**Input:**

```
num = [2,7,4], k = 181
```

Step by step:

| i | num[i] | k before mod | k%10 | res (before reverse) |
| - | ------ | ------------ | ---- | -------------------- |
| 2 | 4      | 185          | 5    | [5]                  |
| 1 | 7      | 18+7=25      | 5    | [5,5]                |
| 0 | 2      | 2+2=4        | 4    | [5,5,4]              |

Reverse → `[4,5,5]` ✅

---

## ⏱ Complexity

* **Time:** `O(max(n, log10 k))` → iterate over digits of `num` and remaining `k`.
* **Space:** `O(n + log10 k)` → for result list.

---

⚡ **Key Insight:**

* Adding `k` to `num` is like **manual addition** in elementary school — process from least significant digit with carry.
* No need to convert the full array to an integer.

