

# 📌 Linked List – Remove First & Remove Last

After learning how to **insert nodes** in a Linked List, we now extend the functionality to **remove nodes** from the start or end of the list.

---

## 🔹 1. Remove First Node

### Logic:

1. If `size == 0` → list is empty.
2. If `size == 1` → set both `head` and `tail` to `null`.
3. Otherwise → move `head` to the next node (`head = head.next`).
4. Decrease `size--`.

### Implementation:

```java
public void removeFirstFromLL() {
    if(size == 0) {
        System.out.println("LL is empty");
        return;
    } else if(size == 1) {
        head = tail = null;
        size = 0;
        return;
    }

    head = head.next; // move head to next node
    size--;
}
```

---

## 🔹 2. Remove Last Node

### Logic:

1. If `size == 0` → list is empty.
2. If `size == 1` → set both `head` and `tail` to `null`.
3. Otherwise →

   * Traverse the list till the **second last node** (`size-2`).
   * Set its `next` to `null`.
   * Update `tail` to this node.
4. Decrease `size--`.

### Implementation:

```java
public void removeLastFromLL() {
    if(size == 0) {
        System.out.println("LL is empty");
        return;
    } else if(size == 1) {
        head = tail = null;
        size = 0;
        return;
    }

    Node prev = head;
    for(int i = 0; i < size - 2; i++) {
        prev = prev.next; // move to second last node
    }

    prev.next = null; // unlink last node
    tail = prev;      // update tail
    size--;
}
```

---

## 🔹 3. Print Linked List

Same as before, traversing from `head` to `null`.

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

public class RemoveFirstorLastinLL {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size; // to maintain size of a LL

    public void addFirst(int data) {
        size++;
        Node newNode = new Node(data);

        if(head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        size++;
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

    public void removeFirstFromLL() {
        if(size == 0) {
            System.out.println("LL is empty");
            return;
        } else if(size == 1) {
            head = tail = null;
            size = 0;
            return;
        }

        head = head.next;
        size--;
    }

    public void removeLastFromLL() {
        if(size == 0) {
            System.out.println("LL is empty");
            return;
        } else if(size == 1) {
            head = tail = null;
            size = 0;
            return;
        }

        Node prev = head;
        for(int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        prev.next = null;
        tail = prev;
        size--;
    }

    public static void main(String[] args) {
        RemoveFirstorLastinLL ll = new RemoveFirstorLastinLL();
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.print();
        ll.removeFirstFromLL();
        ll.print();
        ll.removeLastFromLL();
        ll.print();
    }
}
```

---

## 🖼 Example Output

```
1->2->3->4->5->null
2->3->4->5->null
2->3->4->null
```

---


