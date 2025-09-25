

# 🔢 402. Remove K Digits (Java – Stack Solution)

> **Problem:**
> Given a string `num` representing a non-negative integer and an integer `k`,
> remove exactly `k` digits from `num` so that the new number is the smallest possible.
> Return the result as a string (no leading zeros except `"0"`).

---

## 🧠 Approach – Monotonic Stack

We want the **smallest possible number**, so we remove digits that are **larger than the next digit** when we still have `k` removals left.
This naturally suggests using a **monotonic increasing stack**:

* Traverse each digit in `num`
* While `stack.top > current_digit` and `k > 0`, pop from stack (removing a bigger digit)
* Push the current digit to stack
* After traversal, if `k > 0`, pop remaining digits from the end
* Build final string from stack, reverse it (because we pop), and strip leading zeros

---

## 💻 Code Implementation

```java
import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        
        for (char digit : num.toCharArray()) {
            while (!st.isEmpty() && k > 0 && st.peek() > digit) {
                st.pop();
                k--;
            }
            st.push(digit);
        }
        
        // Remove remaining digits from end if needed
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        
        // Build the result (reverse because we pop from stack)
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();
        
        // Remove leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
```

---

## 📊 Dry Run

**Input:**
`num = "1432219", k = 3`

| Step | Digit | Stack Before | Action                 | Stack After  | k |
| ---- | ----- | ------------ | ---------------------- | ------------ | - |
| 1    | `1`   | []           | push                   | [1]          | 3 |
| 2    | `4`   | [1]          | push                   | [1, 4]       | 3 |
| 3    | `3`   | [1, 4]       | pop 4 (4 > 3) + push 3 | [1, 3]       | 2 |
| 4    | `2`   | [1, 3]       | pop 3 (3 > 2) + push 2 | [1, 2]       | 1 |
| 5    | `2`   | [1, 2]       | push                   | [1, 2, 2]    | 1 |
| 6    | `1`   | [1, 2, 2]    | pop 2 (2 > 1) + push 1 | [1, 2, 1]    | 0 |
| 7    | `9`   | [1, 2, 1]    | push                   | [1, 2, 1, 9] | 0 |

**Result:** `"1219"` ✅

---

## ⏱️ Complexity

| Operation              | Time     | Space    |
| ---------------------- | -------- | -------- |
| Build stack            | **O(n)** | **O(n)** |
| Remove k digits        | O(k)     | –        |
| Build + reverse result | O(n)     | –        |

**Overall:**
**Time → O(n)**
**Space → O(n)**

---

## 📝 Notes

* **Stack is perfect** here since we only compare with last chosen digit.
* Must reverse at the end because we popped in reverse order.
* Must strip leading zeros before returning final result.
* If result becomes empty, return `"0"`.

---

