
# 🗑️ Delete N Nodes After M Nodes of a Linked List

## 📌 Problem Statement
Given the `head` of a **singly linked list**, traverse it and:
- **Skip M nodes**, then  
- **Delete the next N nodes**,  
- Repeat this process until the end of the list.

Return the modified list.

---

## 🧩 Approach

### Algorithm
1. Create a pointer `curr` to traverse the list.
2. **Skip M nodes:**  
   - Move `curr` forward `M-1` times (because `curr` is already at the first node).
3. If `curr` becomes `null`, stop (no more nodes left).
4. **Delete N nodes:**
   - Start from `curr.next` and move forward `N` times, unlinking nodes.
   - After deleting N nodes, link `curr.next` to the next remaining node.
5. Continue until we reach the end.

---

## 💻 Code Implementation (Java)

```java
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    public Node deleteNAfterM(Node head, int M, int N) {
        Node curr = head;

        while (curr != null) {
            // 1️⃣ Skip M nodes
            for (int i = 1; i < M && curr != null; i++) {
                curr = curr.next;
            }

            // If we've reached the end, break
            if (curr == null) break;

            // 2️⃣ Delete N nodes after M nodes
            Node temp = curr.next;
            for (int i = 0; i < N && temp != null; i++) {
                temp = temp.next; // move temp N steps ahead
            }

            // Link the current node to the next remaining node
            curr.next = temp;

            // Move curr forward to repeat process
            curr = temp;
        }

        return head;
    }
}
````

---

## 🧠 Dry Run Example

**Input:**
`1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8`
`M = 2, N = 2`

| Step | Action                                             | Resulting List               |
| ---- | -------------------------------------------------- | ---------------------------- |
| 1    | Skip 2 nodes (`1, 2`), delete next 2 (`3, 4`)      | `1 -> 2 -> 5 -> 6 -> 7 -> 8` |
| 2    | Skip next 2 nodes (`5, 6`), delete next 2 (`7, 8`) | `1 -> 2 -> 5 -> 6`           |

**Output:**
`1 -> 2 -> 5 -> 6`

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n)` → We traverse all nodes once.
* **Space Complexity:** `O(1)` → No extra space used (only pointers).

---

## 🎯 Key Points to Remember

* Carefully handle **edge cases**:

  * When `M = 0` → delete all nodes in blocks of `N`.
  * When `N = 0` → no deletion happens.
  * When list length is smaller than M or N.
* Always check for `curr != null` before skipping or deleting nodes.

---

```

---
