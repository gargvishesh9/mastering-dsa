
# 🧮 MinStack – Java Implementation

A **stack** that supports `push`, `pop`, `top`, and retrieving the **minimum element** in **O(1)** time.

---

## ✅ Problem Statement

Design a stack that supports:

* `push(val)` → Push element on top.
* `pop()` → Remove element from top.
* `top()` → Get top element.
* `getMin()` → Get minimum element in stack **in constant time**.

---

## 🧠 Approach

We use **two stacks**:

* `s` → stores all elements (normal stack)
* `minStack` → keeps track of minimums

### 🔑 Key Idea

Whenever we push a value:

* Always push to `s`
* Also push to `minStack` **only if** it is empty OR value ≤ current minimum

When popping:

* Pop from `s`
* If popped value is equal to `minStack.peek()`, pop from `minStack` as well

This ensures `minStack.peek()` always holds the current minimum.

---

## 💻 Code Implementation

```java
import java.util.Stack;

class MinStack {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {
    }
    
    public void push(int val) {
        s.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (!s.isEmpty()) {
            int removed = s.pop();
            if (removed == minStack.peek()) {
                minStack.pop();
            }
        }
    }
    
    public int top() {
        if (!s.isEmpty()) {
            return s.peek();
        }
        throw new RuntimeException("Stack is empty");
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
```

---

## 📊 Dry Run Example

| Operation | `s` (Main Stack) | `minStack` (Min Tracker) | `getMin()` |
| --------- | ---------------- | ------------------------ | ---------- |
| `push(5)` | [5]              | [5]                      | 5          |
| `push(3)` | [5, 3]           | [5, 3]                   | 3          |
| `push(7)` | [5, 3, 7]        | [5, 3]                   | 3          |
| `pop()`   | [5, 3]           | [5, 3]                   | 3          |
| `pop()`   | [5]              | [5]                      | 5          |

---

## ⏱️ Complexity

| Operation  | Time | Space |
| ---------- | ---- | ----- |
| `push()`   | O(1) | O(n)  |
| `pop()`    | O(1) | O(n)  |
| `top()`    | O(1) | O(1)  |
| `getMin()` | O(1) | O(1)  |

---

## 📝 Notes

* Using a second stack avoids scanning the entire stack for min each time.
* If duplicate minimum values exist, we store them multiple times in `minStack` to maintain correct state after popping.
* Throws `RuntimeException` if `top()` is called on an empty stack.


