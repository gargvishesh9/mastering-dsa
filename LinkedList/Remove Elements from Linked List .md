

# 🧹 Remove Elements from Linked List

## 📝 Problem Statement

Given the `head` of a singly linked list and an integer `val`,
remove **all nodes** from the list that have `ListNode.val == val`,
and return the new head.

---

## 🧠 Approach

### 1️⃣ Handle Leading Nodes

If the head node itself has `val`, we need to move the `head` forward until `head.val != val`.

### 2️⃣ Traverse & Remove

Use a pointer `temp` to traverse:

* If `temp.next.val == val`, **skip that node** by doing `temp.next = temp.next.next`.
* Otherwise, move forward: `temp = temp.next`.

This approach guarantees:

* We remove **all matching nodes**.
* We don’t lose track of the list because we only skip links when we find a match.

---

## 🖼 Example & Diagram

### Input:

```
head = 1 → 2 → 6 → 3 → 6 → 4 → 6 → 5
val  = 6
```

### Steps:

1. **Head doesn't match**, so start traversal from 1.
2. 2's next = 6 → delete → 2 → 3.
3. 3's next = 6 → delete → 3 → 4.
4. 4's next = 6 → delete → 4 → 5.

### Output:

```
1 → 2 → 3 → 4 → 5
```

---

## 💻 Code Implementation (Java)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // 1. Remove matching nodes from the beginning
        while (head != null && head.val == val) {
            head = head.next;
        }

        // 2. Traverse and remove subsequent nodes
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next; // skip the node
            } else {
                temp = temp.next; // move forward
            }
        }

        return head;
    }
}
```

---

## 🏃‍♂️ Dry Run Table

| Step | temp | temp.next | Action               |
| ---: | ---- | --------- | -------------------- |
|    1 | 1    | 2         | move                 |
|    2 | 2    | **6**     | delete → temp.next=3 |
|    3 | 2    | 3         | move                 |
|    4 | 3    | **6**     | delete → temp.next=4 |
|    5 | 3    | 4         | move                 |
|    6 | 4    | **6**     | delete → temp.next=5 |
|    7 | 4    | 5         | move                 |
|    8 | 5    | null      | end                  |

✅ Final List: `1 → 2 → 3 → 4 → 5`

---

## ⏱ Complexity

| Complexity | Analysis                                |
| ---------- | --------------------------------------- |
| **Time**   | **O(N)** — Single traversal of the list |
| **Space**  | **O(1)** — No extra memory used         |

---

## 📌 Key Notes

* Always handle **head node separately**, because removing head means updating `head`.
* Don’t forget to **move `temp` forward** when you don’t delete — otherwise infinite loop risk.
* Works even if:

  * The list is empty.
  * All nodes have the value to remove.
  * There is no node with that value.

---
