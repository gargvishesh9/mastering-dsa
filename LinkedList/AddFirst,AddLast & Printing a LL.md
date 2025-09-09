

---

# Singly Linked List Basics in Java   

## 📌 Introduction to Linked List

A **Linked List** is a linear data structure in which elements (called **nodes**) are connected using pointers.
Each node contains:

* **Data** → the value stored in the node.
* **Next** → a reference (pointer) to the next node in the sequence.

Unlike arrays, Linked Lists:

* Do not require contiguous memory allocation.
* Have **dynamic size** (can grow/shrink easily).
* Allow efficient insertion and deletion (compared to arrays).

👉 In this implementation, we focus on **Singly Linked List** where each node points only to the next node.

---

## 📖 Structure of a Node

Each node has two parts:

```java
public static class Node {
    int data;   // stores the value
    Node next;  // stores the address of the next node

    public Node(int data) {
        this.data = data;
    }
}
```

---

## 🛠 Operations Implemented

We’ll implement **3 basic operations**:

1. **Add First** → Insert a node at the beginning.
2. **Add Last** → Insert a node at the end.
3. **Print** → Traverse and print all elements.

---

### 1️⃣ Add First

* Create a new node.
* If the list is empty, make both `head` and `tail` point to the new node.
* Otherwise, link the new node to the current `head` and update `head`.

```java
public void addFirst(int data) {
    Node newNode = new Node(data);

    if(head == null) {
        head = tail = newNode;
        return;
    }

    newNode.next = head; // link newNode to old head
    head = newNode;      // update head
}
```

---

### 2️⃣ Add Last

* Create a new node.
* If the list is empty, make both `head` and `tail` point to the new node.
* Otherwise, link the current `tail` to the new node and update `tail`.

```java
public void addLast(int data) {
    Node newNode = new Node(data);

    if(head == null) {
        head = tail = newNode;
        return;
    }

    tail.next = newNode; // link old tail to newNode
    tail = newNode;      // update tail
}
```

---

### 3️⃣ Print Linked List

Traverse the list from `head` to `null`, printing each node’s data.

```java
public void print() {
    Node temp = head;
    while(temp != null) {
        System.out.print(temp.data + "->");
        temp = temp.next;
    }
    System.out.println("null");
}
```

---

## 🚀 Full Code

```java
package LinkedList;

public class LinkedListBasics {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void print() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedListBasics ll = new LinkedListBasics();
        ll.print();
        ll.addFirst(2);
        ll.print();
        ll.addFirst(1);
        ll.print();
        ll.addLast(3);
        ll.print();
        ll.addLast(4);
        ll.print();
    }
}
```

---

## 🖼 Example Output

```
null
2->null
1->2->null
1->2->3->null
1->2->3->4->null
```

---
