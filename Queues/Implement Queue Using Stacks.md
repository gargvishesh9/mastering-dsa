

# 📚 Implement Queue Using Stacks

This repository demonstrates **two ways** to implement a **queue (FIFO)** using **two stacks** in Java.
A stack is LIFO (Last-In-First-Out), so we use two stacks to reverse order and simulate queue behavior.

---

## 🧠 Concept

We maintain **two stacks**:

* `first` → main stack
* `second` → helper stack

Depending on implementation, we either make **push efficient** or **pop efficient**.

---

## ✅ Version 1 – Add Efficient (**Push O(1)**)

```java
class MyQueue {
    // Add efficient (push O(1))
    // Remove inefficient (pop O(n))
    Stack<Integer> first = new Stack<>();
    Stack<Integer> second = new Stack<>();

    public MyQueue() { }

    public void push(int x) {
        first.push(x); // O(1)
    }

    public int pop() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        int removed = second.pop();
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        return removed;
    }

    public int peek() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        int peeked = second.peek();
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        return peeked;
    }

    public boolean empty() {
        return first.isEmpty();
    }
}
```

### ⏱ Complexity

| Operation | Time Complexity | Explanation                                   |
| --------- | --------------- | --------------------------------------------- |
| `push()`  | **O(1)**        | Direct push to `first`                        |
| `pop()`   | **O(n)**        | Transfer to `second`, pop, then transfer back |
| `peek()`  | **O(n)**        | Similar to pop but without removal            |
| `empty()` | **O(1)**        | Just check if `first` is empty                |

---

### 🔄 Dry Run Example

#### Operation Sequence:

`push(10), push(20), push(30), pop()`

| Step | first (top→bottom) | second (top→bottom) | Operation                                |
| ---- | ------------------ | ------------------- | ---------------------------------------- |
| 1    | 10                 |                     | push(10)                                 |
| 2    | 20, 10             |                     | push(20)                                 |
| 3    | 30, 20, 10         |                     | push(30)                                 |
| 4    |                    | 10, 20, 30          | transfer all to `second` (reverse order) |
| 5    |                    | 20, 30              | pop from `second` → **removes 10**       |
| 6    | 30, 20             |                     | transfer back to `first`                 |

✅ Output → `10` (FIFO order maintained)

---

## ✅ Version 2 – Remove Efficient (**Pop O(1)**)

```java
class MyQueue {
    // Remove efficient (pop O(1))
    // Add inefficient (push O(n))
    Stack<Integer> first = new Stack<>();
    Stack<Integer> second = new Stack<>();

    public MyQueue() { }

    public void push(int x) {
        // Move everything to second
        while (!first.isEmpty()) {
            second.push(first.pop());
        }

        // Push new element
        first.push(x);

        // Move back to first
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
    }

    public int pop() {
        return first.pop(); // O(1)
    }

    public int peek() {
        return first.peek(); // O(1)
    }

    public boolean empty() {
        return first.isEmpty();
    }
}
```

### ⏱ Complexity

| Operation | Time Complexity | Explanation                                 |
| --------- | --------------- | ------------------------------------------- |
| `push()`  | **O(n)**        | Move all elements twice to keep queue order |
| `pop()`   | **O(1)**        | Direct pop from `first`                     |
| `peek()`  | **O(1)**        | Direct peek from `first`                    |
| `empty()` | **O(1)**        | Check if `first` is empty                   |

---

### 🔄 Dry Run Example

#### Operation Sequence:

`push(10), push(20), push(30), pop()`

| Step | first (top→bottom) | second (top→bottom) | Operation                                        |
| ---- | ------------------ | ------------------- | ------------------------------------------------ |
| 1    | 10                 |                     | push(10)                                         |
| 2    | 10, 20             |                     | push(20) (internally moves, then restores order) |
| 3    | 10, 20, 30         |                     | push(30) (same process)                          |
| 4    | 20, 30             |                     | pop() directly removes **10**                    |

✅ Output → `10` (FIFO order maintained)

---

## 📊 Comparison

| Feature           | Version 1 (Push O(1))            | Version 2 (Pop O(1))             |
| ----------------- | -------------------------------- | -------------------------------- |
| **Push**          | ✅ O(1) Fast                      | ❌ O(n) Slow                      |
| **Pop/Peek**      | ❌ O(n) Slow                      | ✅ O(1) Fast                      |
| **Best Use Case** | Frequent `push`, rare `pop/peek` | Frequent `pop/peek`, rare `push` |
| **Memory**        | Same (2 stacks)                  | Same (2 stacks)                  |

---

## 🧪 Example Usage

```java
MyQueue obj = new MyQueue();
obj.push(10);
obj.push(20);
obj.push(30);

System.out.println(obj.peek());  // 10
System.out.println(obj.pop());   // 10
System.out.println(obj.pop());   // 20
System.out.println(obj.empty()); // false


