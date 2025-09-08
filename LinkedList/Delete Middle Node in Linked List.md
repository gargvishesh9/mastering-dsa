

# 📝 Notes: Delete Middle Node in Linked List

---

## 📌 Problem Statement

Given the `head` of a linked list, delete the **middle node**, and return the head of the modified list.

* If there are **two middle nodes**, delete the **second** one.
* If the list has only **one node**, return `null`.

---

## 💡 Approach / Logic

1. **Use Two-Pointer Technique** (Slow & Fast):

   * Slow pointer → moves **1 step** at a time
   * Fast pointer → moves **2 steps** at a time

2. By the time `fast` reaches the end, `slow` will be at the **middle**.

3. Maintain a `prev` pointer (node just before `slow`) so we can delete `slow`:

   ```java
   prev.next = slow.next;
   ```

4. Edge case:

   * If the list has **1 node**, return `null`.

---

## ✅ Correct Code

```java
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // Edge case: only one node
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Move slow and fast pointers
        while (fast != null && fast.next != null) {
            prev = slow;           // store node before slow
            slow = slow.next;      // move slow by 1
            fast = fast.next.next; // move fast by 2
        }

        // Delete middle node
        prev.next = slow.next;

        return head;
    }
}
```

---

## ⚙️ Dry Run (Normal Case)

**Input:**

```
[1 -> 2 -> 3 -> 4 -> 5]
```

**Steps:**

* **\[init]** slow = 1, fast = 1, prev = null
* **\[iter1]** prev = 1, slow = 2, fast = 3
* **\[iter2]** prev = 2, slow = 3, fast = 5
* **\[stop]** fast.next == null → exit
* **\[delete]** prev.next = slow\.next → remove node `3`

**Output:**

```
[1 -> 2 -> 4 -> 5]
```

---

## ⚙️ Edge Case 1: Single Node

**Input:**

```
[1]
```

**Steps:**

* head.next == null → return null

**Output:**

```
[]
```

---

## ⚙️ Edge Case 2: Two Nodes

**Input:**

```
[1 -> 2]
```

**Steps:**

* slow = 1, fast = 1
* After loop: prev = 1, slow = 2
* Delete slow (2)

**Output:**

```
[1]
```

---

## ⚙️ Edge Case 3: Even Length List

**Input:**

```
[1 -> 2 -> 3 -> 4]
```

**Steps:**

* iter1 → prev = 1, slow = 2, fast = 3
* iter2 → prev = 2, slow = 3, fast = null
* stop → delete slow (3)

**Output:**

```
[1 -> 2 -> 4]
```

---

## 🔑 Key Takeaways

* **Slow-Fast pointer** is the go-to trick for middle-element problems.
* Always handle **edge case: one node**.
* Update `prev.next` to **skip the middle node**.


