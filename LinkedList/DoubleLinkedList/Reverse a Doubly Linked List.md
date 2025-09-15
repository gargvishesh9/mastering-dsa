# 🔄 Reverse a Doubly Linked List

## 📌 Problem Statement
Given the `head` of a **doubly linked list**, reverse it and return the new head.

---

## 🧩 Approach

We reverse the links of each node one by one:

1. **Traverse the list** using a `curr` pointer.
2. For each node:
   - Save the next node (`next = curr.next`)
   - Reverse the links:
     - `curr.next = prev`
     - `curr.prev = next`
   - Move `prev` and `curr` forward.
3. At the end, `prev` will be the **new head** of the reversed list.

---

## 🧠 Dry Run Example

**Input List:**  
`1 <-> 2 <-> 3 <-> 4`

| Step | `curr` | `next` | Operation                                    | List State (Links Reversed So Far) |
|------|--------|--------|---------------------------------------------|----------------------------------|
| 1    | 1      | 2      | `1.next = null`, `1.prev = 2`              | `1 <- null`                      |
| 2    | 2      | 3      | `2.next = 1`, `2.prev = 3`                 | `2 <-> 1`                        |
| 3    | 3      | 4      | `3.next = 2`, `3.prev = 4`                 | `3 <-> 2 <-> 1`                  |
| 4    | 4      | null   | `4.next = 3`, `4.prev = null`              | `4 <-> 3 <-> 2 <-> 1` ✅          |

**Output:**  
`4 <-> 3 <-> 2 <-> 1` (Head = 4)

---

## 💻 Code Implementation (Java)

```java
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class Solution {
    public Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;  // Store next node
            curr.next = prev;  // Reverse next pointer
            curr.prev = next;  // Reverse prev pointer
            
            prev = curr;       // Move prev forward
            curr = next;       // Move curr forward
        }

        head = prev; // New head after reversal
        return head;
    }
}
