

# 📌 Stack Implementation using ArrayList (Java)

## 📖 Overview

This program demonstrates how to **implement a stack data structure using `ArrayList`** in Java.
The stack follows the **LIFO (Last In, First Out)** principle, meaning the most recently added element is the first one to be removed.

---

## 🛠 Code

```java
package Stacks;

import java.util.ArrayList;

public class StackB {

    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();

        // ✅ Check if stack is empty
        public static boolean isEmpty() {
            return list.isEmpty();
        }

        // ✅ Push operation (adds element to top of stack)
        public static void push(int data) {
            list.add(data);
        }

        // ✅ Pop operation (removes and returns top element)
        public static int pop() {
            if (isEmpty()) {
                return -1; // indicates stack is empty
            }
            int top = list.getLast();  // ✅ get last element
            list.removeLast();         // ✅ remove last element
            return top;
        }

        // ✅ Peek operation (returns top element without removing it)
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.getLast();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek()); // print top element
            s.pop();                      // remove top element
        }
    }
}
```

---

## 🧠 Logic & Explanation

### **1️⃣ Using `ArrayList` as Storage**

* The `ArrayList<Integer>` acts as the underlying container for the stack.
* We add elements at the **end** (top of stack) and remove them from the end.

### **2️⃣ Methods**

* **`isEmpty()`** → returns `true` if the list is empty.
* **`push(data)`** → appends `data` to the end of `list`.
* **`pop()`** → removes and returns the last element.

  * Returns `-1` if stack is empty.
* **`peek()`** → returns the last element without removing it.

  * Returns `-1` if stack is empty.

### **3️⃣ Main Execution Flow**

* Push `1`, `2`, `3` into the stack.
* While stack is not empty:

  * Print the **top element** (peek).
  * Remove the top element (pop).

---

## 🧾 Dry Run

| Operation | Stack State (`list`) | Output |
| --------- | -------------------- | ------ |
| push(1)   | \[1]                 |        |
| push(2)   | \[1, 2]              |        |
| push(3)   | \[1, 2, 3]           |        |
| peek()    | \[1, 2, 3]           | 3      |
| pop()     | \[1, 2]              |        |
| peek()    | \[1, 2]              | 2      |
| pop()     | \[1]                 |        |
| peek()    | \[1]                 | 1      |
| pop()     | \[]                  |        |

✅ **Final Output:**

```
3
2
1
```

---

## ⚠️ Important Points

* `list.getLast()` and `list.removeLast()` are available from **Java 21** (or newer).
  If using an older version of Java, replace with:

  ```java
  int top = list.get(list.size() - 1);
  list.remove(list.size() - 1);
  ```
* Time Complexity:

  * **Push, Pop, Peek:** O(1) (because `ArrayList` supports fast end operations)
  * **Space Complexity:** O(n)

---


