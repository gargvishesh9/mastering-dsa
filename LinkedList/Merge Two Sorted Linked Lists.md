
# 🔗 Merge Two Sorted Linked Lists (LeetCode 21)

## 📌 Problem
Given two sorted linked lists `list1` and `list2`, merge them into one **sorted linked list** and return the head.

---

## ✅ Approach: Iterative (Dummy Node)
- Use a **dummy node** (`-1`) to simplify merging.  
- Compare nodes from both lists:
  - Attach the smaller node to the merged list.
  - Move forward in that list.
- Once one list is exhausted, attach the remaining nodes of the other list.
- Return `dummy.next` (skipping the placeholder `-1`).

---

### 🧩 Code
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedLL = new ListNode(-1); // dummy node
        ListNode temp = mergedLL;

        // Compare nodes
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        // Attach remaining nodes
        while (list1 != null) {
            temp.next = list1;
            list1 = list1.next;
            temp = temp.next;
        }
        while (list2 != null) {
            temp.next = list2;
            list2 = list2.next;
            temp = temp.next;
        }

        return mergedLL.next; // skip dummy
    }
}
````

---

## 🔎 Example Walkthrough

### Input

```
list1 = 1 → 2 → 4
list2 = 1 → 3 → 4
```

### Process

* Compare 1 and 1 → pick list1’s 1
* Compare 2 and 1 → pick list2’s 1
* Compare 2 and 3 → pick 2
* Compare 4 and 3 → pick 3
* Compare 4 and 4 → pick 4 (list1) → then 4 (list2)

### Output

```
1 → 1 → 2 → 3 → 4 → 4
```

---

## 📊 Complexity

* **Time:** O(n + m)
  (where n, m = lengths of list1, list2)
* **Space:** O(1)
  (in-place merge, only dummy node used)

---

## 💡 Key Insight

* Using a **dummy node** avoids handling edge cases for the head separately.
* You only move `temp` forward while attaching nodes.
* At the end, `dummy.next` points to the merged sorted list.

---
