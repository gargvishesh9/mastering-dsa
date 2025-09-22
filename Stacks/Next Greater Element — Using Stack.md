# 📌 Next Greater Element — Using Stack

### 📝 **Problem Statement**

Given an array `arr[]`, for each element find the **next greater element** to its right.
If no such element exists, store `-1`.

**Example:**
Input: `arr = [4, 5, 2, 25]`
Output: `result = [5, 25, 25, -1]`

---

### 💡 **Brute Force Approach (O(N²))**

* For each element, look to the right until you find a bigger element.
* Store it, or `-1` if not found.

**Code (for understanding):**

```java
ArrayList<Integer> result = new ArrayList<>();
for (int i = 0; i < arr.length; i++) {
    int nextGreater = -1;
    for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] > arr[i]) {
            nextGreater = arr[j];
            break;
        }
    }
    result.add(nextGreater);
}
```

⛔ **Drawback:**
Nested loop ⇒ **O(N²)** — very slow for big arrays.

---

### ⚡ **Optimal Approach — Using Stack (O(N))**

**Idea:**
We traverse **right-to-left** and use a **stack** to keep track of "potential next greater elements".

* **Step 1:** Start from last element (rightmost).
* **Step 2:** Pop from stack until top is greater than current element.
* **Step 3:** If stack is empty → no next greater → add `-1`.
* **Step 4:** Otherwise, top of stack is the next greater element.
* **Step 5:** Push current element into stack.

---

### ✅ **Code (Beginner Friendly — Using Stack)**

```java
import java.util.*;

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;

        for (int i = n - 1; i >= 0; i--) {
            // Pop smaller or equal elements
            while (!s.isEmpty() && s.peek() <= arr[i]) {
                s.pop();
            }

            // Add next greater element
            if (s.isEmpty()) {
                result.add(-1);
            } else {
                result.add(s.peek());
            }

            // Push current element to stack
            s.push(arr[i]);
        }

        // Reverse result as we traversed from right-to-left
        Collections.reverse(result);
        return result;
    }
}
```

---

### 🔍 **Dry Run Example**

**Input:**
`arr = [4, 5, 2, 25]`

| i | arr\[i] | Stack Before | Pop?  | Next Greater | Stack After |
| - | ------- | ------------ | ----- | ------------ | ----------- |
| 3 | 25      | \[]          | -     | -1           | \[25]       |
| 2 | 2       | \[25]        | No    | 25           | \[25, 2]    |
| 1 | 5       | \[25, 2]     | Pop 2 | 25           | \[25, 5]    |
| 0 | 4       | \[25, 5]     | No    | 5            | \[25, 5, 4] |

After reverse → **`[5, 25, 25, -1]` ✅**

---

### 🧠 **Complexity**

* **Time:** `O(N)` (each element pushed + popped at most once)
* **Space:** `O(N)` (stack + result)

---

### 🎯 **Key Takeaways**

✅ Use **stack** to eliminate nested loops.
✅ Always check `!stack.isEmpty()` before `peek()`/`pop()`.
✅ Push **element values** (not indices).
✅ Reverse the result if traversing from right-to-left.

---

