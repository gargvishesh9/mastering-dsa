
# 📌 Linked List – Search (Iterative & Recursive)

Searching in a Linked List means finding whether a given **key** (value) exists and if yes, at **which index**.

Unlike arrays, Linked List does **not** provide direct access by index, so searching takes **O(n)** time.

---

## 🔹 1. Iterative Search

We traverse the list node by node until we find the key or reach the end.

### Steps:

1. Start from `head`.
2. Keep an `index` counter (starting at `0`).
3. At each step:

   * If `temp.data == key` → return index.
   * Else move `temp = temp.next`.
4. If traversal ends, key not found.

### Implementation:

```java
public void searchInLLIterative(int key) {
    Node temp = head;
    int index = 0;

    while(temp != null) {
        if(temp.data == key) {
            System.out.println(key + " found at index " + index);
            return;
        }
        temp = temp.next;
        index++;
    }

    System.out.println(key + " not found");
}
```

---

## 🔹 2. Recursive Search

Here we use recursion to check each node.

### Steps:

1. Base case: If `head == null` → return `-1` (not found).
2. If `head.data == key` → return `0`.
3. Recur for the rest of the list → `recursiveHelper(head.next, key)`.
4. If recursive result is `-1` → not found.
5. Otherwise add `+1` to adjust index as recursion unwinds.

### Implementation:

```java
public void searchInLLRecursive(int key) {
    int index = recursiveHelper(head, key);

    if(index == -1) {
        System.out.println("Either LL is empty or key not found");
    } else {
        System.out.println(key + " found at index " + index);
    }
}

public int recursiveHelper(Node head, int key) {
    if(head == null) {
        return -1; // not found
    }

    if(head.data == key) {
        return 0; // found at this node
    }

    int idx = recursiveHelper(head.next, key);

    if(idx == -1) {
        return -1; // not found in rest of list
    }

    return idx + 1; // add offset while backtracking
}
```

---

## 🔹 3. Diagram – Searching in Linked List

Suppose we have the Linked List:

```
Head → 1 → 2 → 3 → 4 → 5 → null
```

Searching for **key = 3 (Iterative)**:

```
Step 0: temp points at 1 (index 0) → not equal
Step 1: temp points at 2 (index 1) → not equal
Step 2: temp points at 3 (index 2) → MATCH ✅
```

Diagram:

```
[Head] → [1|next] → [2|next] → [3|next] → [4|next] → [5|null]
                               ↑
                             Found here (index 2)
```

---

## 🚀 Full Code

```java
package LinkedList;

public class SearchInLL {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

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

    // Iterative Search
    public void searchInLLIterative(int key) {
        Node temp = head;
        int index = 0;

        while(temp != null) {
            if(temp.data == key) {
                System.out.println(key + " found at index " + index);
                return;
            }
            temp = temp.next;
            index++;
        }

        System.out.println(key + " not found");
    }

    // Recursive Search
    public void searchInLLRecursive(int key) {
        int index = recursiveHelper(head, key);

        if(index == -1) {
            System.out.println("Either LL is empty or key not found");
        } else {
            System.out.println(key + " found at index " + index);
        }
    }

    public int recursiveHelper(Node head, int key) {
        if(head == null) {
            return -1;
        }

        if(head.data == key) {
            return 0;
        }

        int idx = recursiveHelper(head.next, key);

        if(idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public static void main(String[] args) {
        SearchInLL ll = new SearchInLL();
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.print();
        System.out.println("Size of the LL is " + size);

        ll.searchInLLIterative(3);
        ll.searchInLLRecursive(10);
    }
}
```

---

## 🖼 Example Output

```
1->2->3->4->5->null
Size of the LL is 5
3 found at index 2
Either LL is empty or key not found
```


