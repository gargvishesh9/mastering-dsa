
# 📌 Insert Element at Bottom of a Stack (Java)

## 📖 Overview

This program demonstrates how to **insert an element at the bottom of a stack** using **recursion**.
Normally, `Stack` only allows operations at the **top** (LIFO).
But with recursion, we can temporarily pop elements, insert the new element at the bottom, and then push back the popped elements.

---

## 🛠 Code

```java
// User function Template for Java
import java.util.Stack;

class Solution {
    public Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        // ✅ Base Case: If stack is empty, just push x
        if (st.isEmpty()) {
            st.push(x);
            return st;
        }

        // ✅ Step 1: Pop the top element
        int top = st.pop();

        // ✅ Step 2: Recursively insert x at bottom of smaller stack
        insertAtBottom(st, x);

        // ✅ Step 3: Push the popped element back on top
        st.push(top);

        return st;
    }
}
```

---

## 🧠 Logic & Explanation

### **1️⃣ Problem**

* Normally we can only `push`/`pop` at the top of a stack.
* To insert at the bottom, we need to:

  1. Remove all elements (recursively).
  2. Insert the new element when stack becomes empty.
  3. Push all removed elements back in order.

---

### **2️⃣ Steps (Recursive Approach)**

1. **Base Case:**
   If stack is empty → push `x` (this becomes the bottom element).
2. **Recursive Case:**

   * Pop the top element and store it.
   * Recursively call `insertAtBottom` for the remaining stack.
   * Push the stored element back.

---

## 🧾 Dry Run Example

**Input Stack:**
Top → `[3, 2, 1]` (where `3` is top)
`x = 0`

### **Execution Flow**

| Step | Stack State (Top → Bottom) | Action               |
| ---- | -------------------------- | -------------------- |
| 1    | \[3, 2, 1]                 | Pop 3 → Recurse      |
| 2    | \[2, 1]                    | Pop 2 → Recurse      |
| 3    | \[1]                       | Pop 1 → Recurse      |
| 4    | \[]                        | Stack empty → Push 0 |
| 5    | \[0]                       | Push 1 back          |
| 6    | \[1, 0]                    | Push 2 back          |
| 7    | \[2, 1, 0]                 | Push 3 back          |

**Final Stack:**
Top → `[3, 2, 1, 0]` ✅

---

## 📊 Complexity Analysis

| Operation        | Time Complexity | Space Complexity                   |
| ---------------- | --------------- | ---------------------------------- |
| Insert at Bottom | O(n)            | O(n) (due to recursion call stack) |

Where `n` = number of elements in the stack.

---

## 🧠 Key Concepts Learned

* **Recursion with stack** allows us to temporarily remove elements and rebuild stack in desired order.
* We do **not** use extra data structures — recursion call stack handles temporary storage.
* Useful in problems like:

  * Reversing a stack
  * Modifying stack contents at a specific position

---

