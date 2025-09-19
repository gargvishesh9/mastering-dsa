

# 📌 Reverse a Stack using Recursion (Java)  

## 📖 Overview

This program demonstrates how to **reverse a stack** using **recursion**.
Instead of using another data structure, we rely only on the **call stack** and a helper function (`pushAtBottom`) to place elements at the bottom.

---

## 🛠 Code

```java
import java.util.Stack;

class Solution {
    public static void reverseStack(Stack<Integer> st) {
        // ✅ Base Case
        if (st.isEmpty()) {
            return;
        }

        // ✅ Step 1: Pop top element
        int top = st.pop();

        // ✅ Step 2: Reverse the remaining stack
        reverseStack(st);

        // ✅ Step 3: Insert popped element at the bottom
        pushAtBottom(st, top);
    }

    public static void pushAtBottom(Stack<Integer> s, int data) {
        // ✅ Base Case: If stack is empty, push element
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        // ✅ Pop element and recurse
        int top = s.pop();
        pushAtBottom(s, data);

        // ✅ Push back previously removed element
        s.push(top);
    }
}
```

---

## 🧠 Logic & Explanation

### **Key Idea**

* First **empty the stack completely** using recursion.
* Then insert each removed element **at the bottom** (instead of top).
* This reverses the order of elements as the recursion unwinds.

---

### **Step-by-Step Algorithm**

1. **reverseStack(Stack st)**

   * If stack is empty → return.
   * Pop the top element.
   * Recursively call `reverseStack(st)` to reverse remaining elements.
   * Insert popped element at bottom using `pushAtBottom`.

2. **pushAtBottom(Stack s, int data)**

   * If stack is empty → push `data` (it becomes the bottom element).
   * Otherwise:

     * Pop top element.
     * Recurse with remaining stack.
     * Push popped element back.

---

## 🧾 Dry Run Example

**Input Stack (Top → Bottom):**
`[4, 3, 2, 1]`

**Execution:**

1. Pop `4`, call `reverseStack` on `[3, 2, 1]`
2. Pop `3`, call `reverseStack` on `[2, 1]`
3. Pop `2`, call `reverseStack` on `[1]`
4. Pop `1`, call `reverseStack` on `[]` → base case hit
5. Start unwinding:

   * Insert `1` at bottom → `[1]`
   * Insert `2` at bottom → `[1, 2]`
   * Insert `3` at bottom → `[1, 2, 3]`
   * Insert `4` at bottom → `[1, 2, 3, 4]`

✅ **Final Reversed Stack:**
Top → `[1, 2, 3, 4]`

---

## 📊 Complexity Analysis

| Operation     | Time Complexity                                 | Space Complexity            |
| ------------- | ----------------------------------------------- | --------------------------- |
| Reverse Stack | O(n²) (due to repeated pushAtBottom operations) | O(n) (recursion call stack) |

Where `n` = number of elements in the stack.

---

## 🔑 Key Takeaways

* **No extra data structure** (like array or queue) is used — only recursion.
* This is a **classic interview question** to test recursion + stack understanding.
* `pushAtBottom` is a **reusable helper function** for other problems too (e.g., inserting element at bottom, sorting stack recursively).

---


