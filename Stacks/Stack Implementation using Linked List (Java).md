

# 📌 Stack Implementation using Linked List (Java)

## 📖 Overview

This program demonstrates how to **implement a stack data structure using a Linked List** in Java.
Unlike `ArrayList`, here we use a **linked structure** to store stack elements dynamically.
The stack still follows the **LIFO (Last In, First Out)** principle.

---

## 🛠 Code

```java
package Stacks;

public class StackB {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class Stack {
        static Node head = null;

        // ✅ Check if stack is empty
        public static boolean isEmpty() {
            return head == null;
        }

        // ✅ Push operation (insert at head)
        public static void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        // ✅ Pop operation (remove and return head element)
        public static int pop() {
            if (isEmpty()) {
                return -1; // indicates empty stack
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        // ✅ Peek operation (return head element without removing it)
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
```

---

## 🧠 Logic & Explanation

### **1️⃣ Node Structure**

Each `Node` contains:

* `data` → stores the value.
* `next` → reference to the next node in the stack.

### **2️⃣ Stack Operations**

* **`isEmpty()`** → checks if `head` is `null`.
* **`push(data)`** → creates a new node and inserts it at the head (top of stack).
* **`pop()`** → removes the head node and returns its value.
* **`peek()`** → returns the value of the head node without removing it.

Since we always add/remove elements from the **head**, operations are **O(1)**.

---

## 🧾 Dry Run

| Operation | Linked List (Top → Bottom) | Output |
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

## ⚠️ Important Points

* Unlike ArrayList, **Linked List does not need resizing**, so memory is dynamically allocated.
* Push/Pop operations are **always O(1)** because we insert/remove from the head.
* No risk of **index out of bounds** like in arrays.
* Memory overhead is slightly higher due to storing `next` references for each node.

---

## 📊 Complexity Analysis

| Operation | Time Complexity | Space Complexity  |
| --------- | --------------- | ----------------- |
| Push      | O(1)            | O(1) per new node |
| Pop       | O(1)            | O(1)              |
| Peek      | O(1)            | O(1)              |

---

