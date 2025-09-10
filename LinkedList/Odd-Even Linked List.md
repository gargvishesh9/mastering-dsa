

---

# 📝 Notes: Odd-Even Linked List

---

## 📌 Problem Statement

Given the `head` of a singly linked list, group **all odd-indexed nodes together** followed by the **even-indexed nodes**, and return the new head.

* **Indexing starts at 1** (1st node = odd, 2nd = even).
* Must be done **in-place** with **O(1)** extra space.
* Order of nodes within odd/even groups must stay the same.

---

## 💡 Approach / Logic

1. **Edge Case:**

   * If list has `0` or `1` nodes → return as-is.

2. **Pointers Setup:**

   * `odd = head` → tracks current odd node
   * `even = head.next` → tracks current even node
   * `evenHead = even` → store head of even list (to connect later)

3. **Rearrange:**

   * While `even != null && even.next != null`:

     * Link current `odd` to next odd: `odd.next = even.next`
     * Move `odd = odd.next`
     * Link current `even` to next even: `even.next = odd.next`
     * Move `even = even.next`

4. **Attach even list at the end:**

   * `odd.next = evenHead`

---

## ✅ Correct Code

```java
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // Save start of even list

        while (even != null && even.next != null) {
            odd.next = even.next;   // link odd to next odd
            odd = odd.next;         // move odd forward

            even.next = odd.next;   // link even to next even
            even = even.next;       // move even forward
        }

        odd.next = evenHead; // attach even list at the end
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

---

**Step-by-step:**

* **\[init]**

  * odd = 1, even = 2, evenHead = 2

* **\[iter1]**

  * odd.next = 3 → odd = 3
  * even.next = 4 → even = 4

  List looks like: `1 -> 3 -> 4 -> 5` and evenHead = 2 → `2 -> 4 -> 5`

* **\[iter2]**

  * odd.next = 5 → odd = 5
  * even.next = null → even = null (stop)

---

**\[attach]**

* odd.next = evenHead (2)

---

**Output:**

```
[1 -> 3 -> 5 -> 2 -> 4]
```

---

## ⚙️ Edge Case 1: Single Node

**Input:** `[1]` → Output: `[1]`

---

## ⚙️ Edge Case 2: Two Nodes

**Input:** `[1 -> 2]` → Output: `[1 -> 2]` (no change)

---

## 🔑 Key Takeaways

* **Odd-even list ≠ separate values** → We rearrange **by position** not by value.
* Keep a pointer to the start of even list (`evenHead`).
* Rearrange links carefully to avoid losing nodes.
* Works in **O(n)** time and **O(1)** space.


