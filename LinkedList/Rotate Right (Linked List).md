

# 🌀 Rotate Right (Linked List)

### 📌 Problem Statement

Given the `head` of a singly linked list and an integer `k`, rotate the list to the right by `k` places.

---

### 🧠 Approach & Logic

1. **Edge Cases**

   * If `head == null` or `head.next == null`, rotation is not needed → return `head`.

2. **Find Length & Last Node**

   * Traverse the list to count `length` and get to the `tail` node (`curr`).
   * Connect `tail.next = head` to make the list circular.

3. **Normalize `k`**

   * Rotating `length` times results in the same list.
   * So, do `k = k % length` to keep `k` in range `[0, length)`.

4. **Find Breakpoint**

   * The new head will be at `(length - k)`th position from start.
   * Move a temporary pointer `steps = length - k - 1` steps forward (since `temp` starts at head).

5. **Break the Circle**

   * Set `head = temp.next` (new head)
   * Break the circular link: `temp.next = null`

---

### 📝 Code (Java)

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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head; // No rotation needed
        }

        // 1️⃣ Find length and tail
        ListNode curr = head;
        int length = 1;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        // 2️⃣ Connect tail to head (circular list)
        curr.next = head;

        // 3️⃣ Normalize k
        k = k % length; 
        int steps = length - k;

        // 4️⃣ Find new tail (steps - 1 moves)
        ListNode temp = head;
        for (int i = 1; i < steps; i++) {
            temp = temp.next;
        }

        // 5️⃣ Set new head & break the loop
        head = temp.next;
        temp.next = null;

        return head;
    }
}
```

---

### 🏃 Dry Run Example

**Input:**
`head = [1,2,3,4,5], k = 2`

**Step-by-step Execution:**

| Step | Action                                       | List                      |
| ---- | -------------------------------------------- | ------------------------- |
| 1    | Find length = 5, tail = 5                    | 1 → 2 → 3 → 4 → 5         |
| 2    | Connect tail to head (make circular)         | 1 → 2 → 3 → 4 → 5 → 1 ... |
| 3    | k = 2 % 5 = 2 → steps = 5 - 2 = 3            |                           |
| 4    | Move `temp` 2 steps (to node 3)              | temp at node 3            |
| 5    | `head = temp.next = 4`<br>`temp.next = null` | 4 → 5 → 1 → 2 → 3         |

✅ **Output:** `[4, 5, 1, 2, 3]`

---

### ⏱️ Complexity Analysis

* **Time Complexity:** `O(n)` — single traversal to find length + another partial traversal to break the circle.
* **Space Complexity:** `O(1)` — no extra data structures used.


