

# 📌 Reverse a String using Stack (Java)

## 📖 Overview

This program demonstrates how to **reverse a string** using a **stack**.
The stack’s **LIFO (Last In, First Out)** property makes it a natural fit for reversing the order of characters.

---

## 🛠 Code

```java
import java.util.Stack;

class Solution {
    public String reverse(String s) {
        Stack<Character> t = new Stack<>();

        // ✅ Step 1: Push all characters into the stack
        for (int i = 0; i < s.length(); i++) {
            t.push(s.charAt(i));
        }

        // ✅ Step 2: Pop characters to form reversed string
        StringBuilder result = new StringBuilder();
        while (!t.isEmpty()) {
            result.append(t.pop());
        }

        return result.toString();
    }
}
```

---

## 🧠 Logic & Explanation

### **Approach**

1. **Push Phase:** Iterate through the string and push every character onto the stack.
2. **Pop Phase:** Pop characters from the stack and append them to `StringBuilder`.
   (Since the last pushed character comes out first, we get the reversed order.)
3. **Return Result:** Convert `StringBuilder` to a string and return.

---

## 🧾 Dry Run Example

**Input:**
`s = "abcd"`

| Step     | Stack (Top → Bottom) | Action |
| -------- | -------------------- | ------ |
| Push 'a' | \[a]                 |        |
| Push 'b' | \[b, a]              |        |
| Push 'c' | \[c, b, a]           |        |
| Push 'd' | \[d, c, b, a]        |        |

**Pop Phase:**

| Pop     | Result |
| ------- | ------ |
| Pop 'd' | "d"    |
| Pop 'c' | "dc"   |
| Pop 'b' | "dcb"  |
| Pop 'a' | "dcba" |

✅ **Final Output:**
`"dcba"`

---

## 📊 Complexity Analysis

| Operation      | Time Complexity | Space Complexity |
| -------------- | --------------- | ---------------- |
| Reverse String | O(n)            | O(n)             |

Where `n` = number of characters in the string.

---

## 🔑 Key Takeaways

* **Stacks are perfect** for reversing order-based problems.
* Requires **extra memory** (O(n)) because we store all characters in the stack.
* Conceptual clarity: This is a fundamental exercise to understand **stack operations** and **LIFO behavior**.

