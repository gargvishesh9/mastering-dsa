

# 📌 Linked List – Insert in Middle & Size Function

We already know how to **add at the beginning** and **add at the end** of a Linked List.
Now let’s extend our Linked List implementation with two new concepts:

---

## 🔹 1. Size of Linked List

We maintain a **`size` variable** to track the number of nodes in the list.

### Why keep size?

* Allows **O(1)** retrieval of list size.
* Useful for operations like inserting at a given index or validation.

### Implementation:

```java
public static int size; // keeps track of LL size
```

* Every time we **insert a node** (addFirst, addLast, addInMiddle), we increment `size++`.
* On **deletion** (if implemented), we would decrement `size--`.

---

## 🔹 2. Insert in the Middle

### Problem:

Add a node at a specific **index** (not just at the head or tail).

### Steps:

1. If `index == 0`, call `addFirst(data)`.
2. Traverse the list until the position **just before** the target index.
3. Create a new node and link it properly:

   * `newNode.next = temp.next;`
   * `temp.next = newNode;`
4. Increment the `size`.

### Implementation:

```java
public void addInMiddle(int index, int data) {
    if(index == 0) {
        addFirst(data);
        return;
    }

    Node newNode = new Node(data);
    Node temp = head;
    size++;
    int i = 0;

    // move temp to node at (index - 1)
    while(i < index - 1) {
        temp = temp.next;
        i++;
    }

    // insert newNode in between
    newNode.next = temp.next;
    temp.next = newNode;
}
```

---

## 🔹 3. Print Linked List

Just like before, we traverse from `head` to `null`:

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

public class AddInMiddleOfLL {

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

    public void addInMiddle(int index, int data) {
        if(index == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        size++;
        int i = 0;

        while(i < index - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static void main(String[] args) {
        AddInMiddleOfLL ll = new AddInMiddleOfLL();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.addInMiddle(2, 3);
        ll.print();
        System.out.println("Size of the LL is " + size);
    }
}
```

---

## 🖼 Example Output

```
1->2->3->4->5->null
Size of the LL is 5
```

---

