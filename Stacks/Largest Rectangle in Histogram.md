
# 📊 Largest Rectangle in Histogram – Notes

### 📌 Problem Statement
Given an array `heights[]` representing the heights of bars in a histogram,  
return the **area of the largest rectangle** that can be formed.

---

### 🛠️ Approach – Next Smaller to Left & Right (NSL + NSR)

To find the largest rectangle for each bar, we need to know:
- **NSL** (Next Smaller to Left) → Index of the nearest bar to the left that is **smaller** than the current bar.
- **NSR** (Next Smaller to Right) → Index of the nearest bar to the right that is **smaller** than the current bar.

Then:
- **Width** of the largest rectangle that includes `heights[i]` = `NSR[i] - NSL[i] - 1`
- **Area** for that bar = `heights[i] * width`
- Answer = `max(area for all bars)`

---

### 💻 Code Implementation

```java
import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nsRight = new int[n]; // Next Smaller Right
        int[] nsLeft = new int[n];  // Next Smaller Left
        Stack<Integer> s = new Stack<>();

        // 1️⃣ Find Next Smaller to Right (NSR)
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            nsRight[i] = (s.isEmpty()) ? n : s.peek(); // if no smaller, take n
            s.push(i);
        }

        // Reset stack to reuse for NSL
        s = new Stack<>();

        // 2️⃣ Find Next Smaller to Left (NSL)
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            nsLeft[i] = (s.isEmpty()) ? -1 : s.peek(); // if no smaller, take -1
            s.push(i);
        }

        // 3️⃣ Calculate Max Area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = nsRight[i] - nsLeft[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
````

---

### 🧠 Dry Run Example

Input:
`heights = [2, 1, 5, 6, 2, 3]`

| i | heights\[i] | NSL (index) | NSR (index) | Width = NSR-NSL-1 | Area = h×width |
| - | ----------- | ----------- | ----------- | ----------------- | -------------- |
| 0 | 2           | -1          | 1           | 1                 | 2              |
| 1 | 1           | -1          | 6           | 6                 | 6              |
| 2 | 5           | 1           | 4           | 2                 | 10             |
| 3 | 6           | 2           | 4           | 1                 | 6              |
| 4 | 2           | 1           | 6           | 4                 | 8              |
| 5 | 3           | 4           | 6           | 1                 | 3              |

✅ **Max Area = 10**

---

### ⏳ Complexity Analysis

| Complexity | Explanation                                                                 |
| ---------- | --------------------------------------------------------------------------- |
| **Time**   | **O(n)** – Each element is pushed & popped from the stack at most once.     |
| **Space**  | **O(n)** – Arrays `nsLeft`, `nsRight` and stack store at most `n` elements. |

---

### ⚠️ Common Mistakes

* ❌ Forgetting to set `NSR[i] = n` when there is no smaller element on the right.
* ❌ Forgetting to set `NSL[i] = -1` when there is no smaller element on the left.
* ❌ Using `>` instead of `>=` in the while condition (breaks correctness for equal heights).

---

### 📝 Key Takeaways

* Use **monotonic stacks** to find NSL/NSR efficiently.
* Width is calculated as `NSR[i] - NSL[i] - 1`.
* Final answer is the **maximum area** among all bars.

```

