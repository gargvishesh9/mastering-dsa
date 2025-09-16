

# 📘 Sorting a Linked List – Recursive vs Iterative Merge Sort

## 📝 Problem

Sort a singly linked list in ascending order.

---

## ✅ **Approach 1: Recursive Merge Sort (Your Approach)**

### 🔑 Key Steps

1. **Base Case:**
   If `head == null || head.next == null`, return `head`.
2. **Find Midpoint:**
   Use slow & fast pointers to find the middle node.
3. **Split List:**
   Break the list into two halves.
4. **Recursive Calls:**
   Sort each half recursively.
5. **Merge:**
   Merge two sorted halves into one sorted list.

---

### 💻 Code

```java
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = getMid(head);
        ListNode rightHead = mid.next;
        mid.next = null; // break the list

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        return merge(left, right);
    }

    ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        tail.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
}
```

---

### ⏱️ Complexity

| Aspect    | Complexity                                                              |
| --------- | ----------------------------------------------------------------------- |
| **Time**  | `O(n log n)` (each split halves the list, merge takes `O(n)` per level) |
| **Space** | `O(log n)` (recursion stack frames)                                     |

---

### ✅ Pros

* **Readable & clean.**
* Easy to write and understand.
* Works well for most interview scenarios.

### ⚠️ Cons

* Uses recursion → risk of `StackOverflowError` for very large lists.
* Slightly slower (extra function calls + stack memory overhead).

---

## ✅ **Approach 2: Iterative Bottom-Up Merge Sort (Optimized)**

### 🔑 Key Idea

* Avoid recursion by **iteratively merging sublists** of increasing size (`1 → 2 → 4 → ...`).
* Continue until sublist size ≥ total length.

---

### 💻 Code

```java
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        int length = getLength(head);
        ListNode dummy = new ListNode(0, head);

        for (int size = 1; size < length; size *= 2) {
            ListNode curr = dummy.next;
            ListNode tail = dummy;

            while (curr != null) {
                ListNode left = curr;
                ListNode right = split(left, size);
                curr = split(right, size);

                tail.next = merge(left, right);
                while (tail.next != null) tail = tail.next;
            }
        }
        return dummy.next;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    private ListNode split(ListNode head, int size) {
        for (int i = 1; head != null && i < size; i++) head = head.next;
        if (head == null) return null;
        ListNode second = head.next;
        head.next = null;
        return second;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
```

---

### ⏱️ Complexity

| Aspect    | Complexity                               |
| --------- | ---------------------------------------- |
| **Time**  | `O(n log n)`                             |
| **Space** | `O(1)` (no recursion, only few pointers) |

---

### ✅ Pros

* **No recursion → no stack overflow risk.**
* Faster (beats 90%+ submissions on LeetCode).
* Memory efficient.

### ⚠️ Cons

* Code is harder to read & write.
* More pointer manipulations → higher chance of bugs.

---

## 📊 Summary Table

| Approach                  | Time         | Space      | Readability | Performance |
| ------------------------- | ------------ | ---------- | ----------- | ----------- |
| **Recursive**             | `O(n log n)` | `O(log n)` | ⭐⭐⭐⭐        | ⭐⭐          |
| **Iterative (Bottom-Up)** | `O(n log n)` | `O(1)`     | ⭐⭐          | ⭐⭐⭐⭐        |

---

### 🎯 Recommendation

* **Interview / Learning** → Use **recursive** (clear & simple).
* **Production / Competitive Coding** → Use **iterative** (faster & more memory efficient).


