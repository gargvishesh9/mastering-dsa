

# 🔄 Reorder List (LeetCode 143)

## 📝 Problem Statement

Given the head of a singly linked list, reorder the list in the following pattern:

```
L0 → L1 → … → Ln-1 → Ln
```

should become:

```
L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
```

You **must do this in-place**, without altering the node values (only pointers).

---

## 💡 Approach: Split → Reverse → Merge

### 🔑 Key Idea

1. **Find the Middle:** Split list into two halves.
2. **Reverse Second Half:** Reverse the right half of the list.
3. **Merge:** Alternate nodes from the first and reversed second half.

---

### 💻 Code Implementation

```java
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1️⃣ Find the middle of the list
        ListNode mid = findMid(head);

        // 2️⃣ Reverse the second half
        ListNode hs = reverseLL(mid);

        // 3️⃣ Merge two halves alternately
        ListNode hf = head;
        while (hf != null && hs != null) {
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }

        // 4️⃣ Ensure the last node points to null
        if (hf != null) hf.next = null;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseLL(ListNode head) {
        ListNode prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev; // new head of reversed list
    }
}
```

---

## 🔎 Step-by-Step Dry Run

### Example Input

```
1 → 2 → 3 → 4 → 5
```

---

### **Step 1: Find Middle**

`findMid()` → returns node with value `3`.

| First Half | Second Half |
| ---------- | ----------- |
| `1 → 2 →`  | `3 → 4 → 5` |

---

### **Step 2: Reverse Second Half**

Reverse `3 → 4 → 5` → becomes `5 → 4 → 3`.

| First Half | Reversed Second Half |
| ---------- | -------------------- |
| `1 → 2`    | `5 → 4 → 3`          |

---

### **Step 3: Merge Alternately**

Merge nodes one by one:

* Pick `1` (hf), then `5` (hs)
* Pick `2`, then `4`
* Pick `3` last (since hs becomes null)

Result:

```
1 → 5 → 2 → 4 → 3
```

---

## ⏱️ Complexity Analysis

| Operation               | Time   | Space  |
| ----------------------- | ------ | ------ |
| **Find Mid**            | `O(n)` | `O(1)` |
| **Reverse Second Half** | `O(n)` | `O(1)` |
| **Merge Halves**        | `O(n)` | `O(1)` |
| **Overall**             | `O(n)` | `O(1)` |

---

## ✅ Key Points to Remember

* `findMid()` uses **fast & slow pointer** to locate the middle node.
* `reverseLL()` is a standard iterative reversal of a linked list.
* Always **set `hf.next = null`** at the end to avoid cycles.

