

# 📌 Stack Implementation using Java Collections Framework

## 📖 Overview

This program demonstrates how to use the **`Stack` class** provided in the **Java Collections Framework (JCF)**.
The `Stack` class internally uses **Vector** to store elements and provides all stack operations out of the box.

---

## 🛠 Code

```java
package Stacks;

import java.util.Stack;

public class StackB {

    public static void main(String[] args) {
        // ✅ Create a stack of integers
        Stack<Integer> s = new Stack<>();

        // ✅ Push elements
        s.push(1);
        s.push(2);
        s.push(3);

        // ✅ Pop elements while stack is not empty
        while (!s.isEmpty()) {
            System.out.println(s.peek()); // print top element
            s.pop();                      // remove top element
        }
    }
}
```

---

## 🧠 Logic & Explanation

### **1️⃣ Using `java.util.Stack`**

* `Stack` is a **generic class** that supports any data type (`Stack<Integer>`, `Stack<String>`, etc.).
* It is a **synchronized class** (thread-safe).
* We do not have to manually implement `push`, `pop`, or `peek` — all are built-in methods.

---

### **2️⃣ Important Methods**

| Method             | Description                                                                              |
| ------------------ | ---------------------------------------------------------------------------------------- |
| `push(E item)`     | Pushes an item onto the top of the stack.                                                |
| `pop()`            | Removes and returns the item at the top. Throws `EmptyStackException` if stack is empty. |
| `peek()`           | Returns the top item **without** removing it.                                            |
| `isEmpty()`        | Returns `true` if stack is empty, otherwise `false`.                                     |
| `search(Object o)` | Returns 1-based position of object from top of stack.                                    |

---

## 🧾 Dry Run

| Operation | Stack State (Top → Bottom) | Output |
| --------- | -------------------------- | ------ |
| push(1)   | 1                          |        |
| push(2)   | 2 → 1                      |        |
| push(3)   | 3 → 2 → 1                  |        |
| peek()    | 3 → 2 → 1                  | 3      |
| pop()     | 2 → 1                      |        |
| peek()    | 2 → 1                      | 2      |
| pop()     | 1                          |        |
| peek()    | 1                          | 1      |
| pop()     | (empty)                    |        |

✅ **Final Output:**

```
3
2
1
```

---

## 📊 Complexity Analysis

| Operation | Time Complexity | Space Complexity |
| --------- | --------------- | ---------------- |
| Push      | O(1)            | O(1)             |
| Pop       | O(1)            | O(1)             |
| Peek      | O(1)            | O(1)             |

---

## ✅ Advantages of Using JCF Stack

* No need to implement stack manually.
* Thread-safe (synchronized).
* Easy to use and reliable.
* Part of core Java (no external libraries required).

---

## ⚠️ Limitations

* Since it is synchronized, it might be slightly slower in **single-threaded programs** compared to non-synchronized alternatives.
* For **modern applications**, `ArrayDeque` is often preferred over `Stack` for better performance (non-synchronized).

---

