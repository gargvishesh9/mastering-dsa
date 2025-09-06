
# 🔄 Reverse a Linked List in Java

Reversing a **singly linked list** means flipping the direction of all the links (`next` pointers) so the last node becomes the new head.

---

## ✅ Full Code (Iterative + Recursive)

```java
package LinkedList;

public class ReverseALinkedList {

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

    // Iterative Reversal
    public void reverseIterative() {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;   // 1. Save next node
            curr.next = prev;   // 2. Reverse link
            prev = curr;        // 3. Move prev forward
            curr = next;        // 4. Move curr forward
        }

        head = prev; // Update head to new first node
    }

    // Recursive Reversal Helper
    private Node reverseRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseRecursive(head.next);
        head.next.next = head; // reverse link
        head.next = null;      // break old link
        return newHead;
    }

    // Wrapper function for recursive reversal
    public void reverseRecursive() {
        head = reverseRecursive(head);
    }

    public static void main(String[] args) {
        ReverseALinkedList ll = new ReverseALinkedList();
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);

        System.out.println("Original Linked List:");
        ll.print();

        System.out.println("\nIterative Reversal:");
        ll.reverseIterative();
        ll.print();

        System.out.println("\nRecursive Reversal:");
        ll.reverseRecursive();
        ll.print();

        System.out.println("\nSize of LL = " + size);
    }
}
```

---

## 🧠 Iterative Approach (Step by Step)

We use **3 pointers**:

* `prev` → previous node (`null` at start)
* `curr` → current node (`head` initially)
* `next` → saves the next node before breaking the link

### Example: `1 → 2 → 3 → null`

#### Step 0 (Initial)

```
head -> 1 -> 2 -> 3 -> null
prev = null
curr = 1
```

#### Step 1

```
Break & reverse:
1 -> null    2 -> 3 -> null
prev = 1
curr = 2
```

#### Step 2

```
2 -> 1 -> null    3 -> null
prev = 2
curr = 3
```

#### Step 3

```
3 -> 2 -> 1 -> null
prev = 3
curr = null (stop)
```

✅ Final head points to `3`.

---

## 🧠 Recursive Approach (Step by Step)

We keep going to the **last node**, then while backtracking, reverse the links.

### Example: `1 → 2 → 3 → null`

1. Recursive call keeps going until `3` (base case).
2. On backtracking:

   * `2.next.next = 2` (makes `3 → 2`)
   * `2.next = null` (break old link)
3. Then `1 → 2` becomes `2 → 1` after same process.

✅ Final: `3 → 2 → 1 → null`.

---

## 📊 Complexity

* **Time Complexity:** O(n) (visit each node once)
* **Space Complexity (Iterative):** O(1)
* **Space Complexity (Recursive):** O(n) (stack space)

---


