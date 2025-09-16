

# 🔄 Reverse Linked List Between `left` and `right`

## 📝 Problem

Given the head of a singly linked list and two integers `left` and `right` where `1 ≤ left ≤ right ≤ n`, reverse the nodes from position `left` to `right` **in one pass**.

---

## 💡 Approach: In-place Reversal with Pointers

### 🔑 Key Idea

We reverse only the portion between `left` and `right`, while carefully reconnecting:

* **Left Part** (unchanged)
* **Reversed Part**
* **Right Part** (unchanged)

---

### 💻 Code

```java
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head; // No need to reverse

        ListNode current = head;
        ListNode prev = null;

        // 1️⃣ Move `current` to the `left` position
        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        // Markers for reconnection
        ListNode last = prev;     // Node before `left`
        ListNode newEnd = current; // Will become the end of reversed sublist

        // 2️⃣ Reverse from left to right
        ListNode next = current.next;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) next = next.next;
        }

        // 3️⃣ Reconnect reversed part with left part
        if (last != null) {
            last.next = prev;
        } else {
            head = prev; // If reversing from head (left == 1)
        }

        // 4️⃣ Reconnect reversed part with right part
        newEnd.next = current;

        return head;
    }
}
```

---

## 🧠 Step-by-Step Dry Run

### Example

Input:

```
head = 1 → 2 → 3 → 4 → 5 → null
left = 2, right = 4
```

Goal:

```
1 → 4 → 3 → 2 → 5 → null
```

---

### **Step 1: Move to Left Position**

| Variable  | Value |
| --------- | ----- |
| `prev`    | 1     |
| `current` | 2     |

✅ `last = 1`, `newEnd = 2`

---

### **Step 2: Reverse Sublist (2,3,4)**

| Iteration | `current` | `prev` | `next` | List State                              |
| --------- | --------- | ------ | ------ | --------------------------------------- |
| i=0       | 2         | 1      | 3      | **2 → 1** (reversed partial), 3 → 4 → 5 |
| i=1       | 3         | 2      | 4      | **3 → 2 → 1**, 4 → 5                    |
| i=2       | 4         | 3      | 5      | **4 → 3 → 2 → 1**, 5                    |

✅ After loop:

* `prev` = 4 (head of reversed part)
* `current` = 5 (first node after reversed range)

---

### **Step 3: Reconnect Left Part**

```
last.next = prev
```

1 → **4 → 3 → 2**

---

### **Step 4: Reconnect Right Part**

```
newEnd.next = current
```

2 → 5 → null

---

### ✅ Final List

`1 → 4 → 3 → 2 → 5 → null`

---

## ⏱️ Complexity

| Aspect    | Complexity                              |
| --------- | --------------------------------------- |
| **Time**  | `O(n)` (one traversal + one reversal)   |
| **Space** | `O(1)` (in-place reversal, no extra DS) |

---

## 🎯 Key Points

* `last` keeps track of the node **before** the reversed section.
* `newEnd` is the **first node of the reversed section**, which becomes the end after reversal.
* We carefully reconnect:

  1. `last.next = prev` (connect left part)
  2. `newEnd.next = current` (connect right part)


