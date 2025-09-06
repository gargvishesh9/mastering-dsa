

# 🧾 Find and Delete Nth Node from End in Linked List

Deleting the **Nth node from the end** of a singly linked list is a common linked list interview question.

---

## ✅ Full Code

```java
package LinkedList;

public class FindAndDeleteNthNodeFromEnd {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size; // to maintain size of LL

    // Add node at beginning
    public void addFirst(int data) {
        size++;
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Add node at end
    public void addLast(int data) {
        size++;
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // Print Linked List
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Function to delete Nth node from end
    public void findAndDeleteNthNodeFromEnd(int n) {
        // Step 1: Count total size
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        // Step 2: Handle edge cases
        if (size == 0) {
            System.out.println("LL is empty");
            return;
        }

        // If we want to delete head (nth = size)
        if (n == size) {
            head = head.next;
            return;
        }

        // Step 3: Traverse to node before target
        int i = 1;
        Node prev = head;
        while (i < size - n) {
            prev = prev.next;
            i++;
        }

        // Step 4: Delete target node
        prev.next = prev.next.next;
    }

    public static void main(String[] args) {
        FindAndDeleteNthNodeFromEnd ll = new FindAndDeleteNthNodeFromEnd();
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);

        System.out.println("Original Linked List:");
        ll.print();

        ll.findAndDeleteNthNodeFromEnd(3);

        System.out.println("After deleting 3rd node from end:");
        ll.print();

        System.out.println("Size of LL = " + size);
    }
}
```

---

## 🧠 Logic Explanation

1. **Count length of Linked List**

   * Traverse the entire list once to calculate `size`.

2. **Find which node to delete**

   * The **Nth node from end** = `(size - n + 1)`th node from beginning.
   * So we need to stop at `(size - n)`th node to update its pointer.

3. **Handle edge cases**

   * If `n == size`, we must delete the `head`.
   * If list is empty, nothing to delete.

4. **Relink nodes**

   * Skip the target node by updating `prev.next = prev.next.next`.

---

## 🏃‍♂️ Dry Run

### Input:

```
LL = 1 → 2 → 3 → 4 → 5 → null
n = 3
```

### Step 1: Count size

```
size = 5
```

### Step 2: Target position

```
Nth from end = 3
=> (size - n + 1) = (5 - 3 + 1) = 3rd from start
=> Need to delete node with value 3
```

### Step 3: Traverse to (size - n)th node

```
(size - n) = (5 - 3) = 2
So stop at 2nd node (value = 2)
```

### Step 4: Delete node

```
Before: 2 → 3 → 4
After : 2 → 4
```

### Final List:

```
1 → 2 → 4 → 5 → null
```

---

## 📊 Complexity

* **Time Complexity:** O(n) (one traversal to count + one traversal to delete)
* **Space Complexity:** O(1)

---


