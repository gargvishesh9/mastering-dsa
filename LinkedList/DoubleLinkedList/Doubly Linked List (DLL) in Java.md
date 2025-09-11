

# 📘 Doubly Linked List (DLL) in Java

## 📝 What is a Doubly Linked List?

A **Doubly Linked List (DLL)** is a data structure where each node contains:

* `val` → data stored in the node
* `next` → reference to the next node
* `prev` → reference to the previous node

This allows **bidirectional traversal**: forward and backward.

---

## 🏗 Node Structure

Each node has three parts:

1. **Data (val)** → Stores the value
2. **Next** → Pointer to the next node
3. **Prev** → Pointer to the previous node

```java
private class Node {
    int val;
    Node next;
    Node prev;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next, Node prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
```

---

## 🔧 Creating a Doubly Linked List

```java
public class DoubleLinkedList {
    private Node head;
}
```

Here, `head` points to the first node of the DLL.
Initially, it is `null` because the list is empty.

---

## ➕ Insert at Beginning (`insertFirst`)

### 🧠 Logic

1. Create a new node with the given value.
2. Point `newNode.next` to the current `head`.
3. Set `newNode.prev = null` (because it will become the first node).
4. If list is not empty, set `head.prev = newNode`.
5. Move `head` pointer to the new node.

### 💻 Code

```java
public void insertFirst(int val) {
    Node node = new Node(val);
    node.next = head;
    node.prev = null;
    if (head != null) {
        head.prev = node;
    }
    head = node;
}
```

---

## 👀 Display List (Forward + Reverse)

### 🧠 Logic (Forward)

* Start from `head` and traverse until `node == null`.
* Print `node.val`.
* Keep track of the **last node** (for reverse printing).

### 🧠 Logic (Reverse)

* Start from `last` node.
* Traverse backward using `prev` until `null`.
* Print `node.val`.

### 💻 Code

```java
public void display() {
    Node node = head;
    Node last = null;

    // Forward traversal
    while (node != null) {
        System.out.print(node.val + "->");
        last = node; // keep track of last node
        node = node.next;
    }
    System.out.println("END");

    // Reverse traversal
    System.out.println("Print in Reverse");
    while (last != null) {
        System.out.print(last.val + "->");
        last = last.prev;
    }
    System.out.println("START");
}
```

---

## 🏃‍♂️ Example Run

### Main Method:

```java
public static void main(String[] args) {
    DoubleLinkedList dll = new DoubleLinkedList();
    dll.insertFirst(4);
    dll.insertFirst(3);
    dll.insertFirst(2);
    dll.insertFirst(1);
    dll.display();
}
```

---

### Output:

```
1->2->3->4->END
Print in Reverse
4->3->2->1->START
```

---

## 🖼 Visualization

### After Insertions:

```
null <- 1 <-> 2 <-> 3 <-> 4 -> null
```

### Traversal:

* **Forward:** Head → Tail → END
* **Reverse:** Tail → Head → START

---

## 📌 Summary Table

| Operation           | Time Complexity | Space Complexity |
| ------------------- | --------------- | ---------------- |
| Insert at Beginning | O(1)            | O(1)             |
| Display Forward     | O(N)            | O(1)             |
| Display Reverse     | O(N)            | O(1)             |

✅ **DLL allows quick insertion at head and easy traversal in both directions.**

---

