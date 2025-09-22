
# 📌 Next Greater Element — Complete Notes

## 1️⃣ Normal Next Greater Element (Right Side)

### Problem

For each element, find the next greater element to its **right**.
If no such element exists → `-1`.

---

### Optimal Approach (Using Stack — O(N))

```java
import java.util.*;

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= arr[i]) {
                s.pop();
            }
            result.add(s.isEmpty() ? -1 : s.peek());
            s.push(arr[i]);
        }

        Collections.reverse(result);
        return result;
    }
}
```

### Dry Run Example

For `arr = [4, 5, 2, 25]`
Result → `[5, 25, 25, -1]`

---

## 2️⃣ Next Greater Element II (Circular Array)

### Problem

Array is **circular**, meaning:

* After the last element, you can continue searching from the first element.
* Return next greater element for every index, or `-1`.

---

### Key Idea (Two Pass Traversal)

* **We loop from `2*n - 1` down to `0`.**
* Use `i % n` to wrap around and access correct index.
* **First pass (i ≥ n):** just fill stack (don’t update result).
* **Second pass (i < n):** fill result array using the stack.

---

### Code (Optimal)

```java
import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // default

        for (int i = 2 * n - 1; i >= 0; i--) {
            int curr = arr[i % n];

            while (!s.isEmpty() && s.peek() <= curr) {
                s.pop();
            }

            if (i < n && !s.isEmpty()) { 
                result[i] = s.peek();
            }

            s.push(curr);
        }
        return result;
    }
}
```

---

### Dry Run Table (arr = \[1, 2, 1])

| i | i % n | curr | Stack Before | Pop?       | Update result? | result\[i]    | Stack After |
| - | ----- | ---- | ------------ | ---------- | -------------- | ------------- | ----------- |
| 5 | 2     | 1    | \[]          | No         | ❌ (i≥n)        | -             | \[1]        |
| 4 | 1     | 2    | \[1]         | pop1       | ❌ (i≥n)        | -             | \[2]        |
| 3 | 0     | 1    | \[2]         | No         | ❌ (i≥n)        | -             | \[2, 1]     |
| 2 | 2     | 1    | \[2, 1]      | pop1       | ✅ (i< n)       | result\[2]=2  | \[2, 1]     |
| 1 | 1     | 2    | \[2, 1]      | pop1, pop2 | ✅              | result\[1]=-1 | \[2]        |
| 0 | 0     | 1    | \[2]         | No         | ✅ (i< n)       | result\[0]=2  | \[2, 1]     |

Final `result = [2, -1, 2] ✅`

---

### Visual Representation

```
  (circular view)
       2
      ↑ ↓
   1 →   → 1
result: [2, -1, 2]
```

(See diagram above to visualize wraparound arrows and results.)

---

### Complexity

* **Time:** O(2N) → O(N)
* **Space:** O(N) (stack + result array)

---

### 🔑 Takeaways

✅ Use `i % n` for circular traversal.
✅ Fill stack first (i ≥ n), compute result only when i < n.
✅ Default result = `-1` to handle no greater element.


