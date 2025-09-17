# 📑 Reverse Nodes in k-Group 


Given the head of a singly linked list, reverse the nodes of the list **k at a time**, and return the modified list. If the number of nodes left is less than `k`, leave them as-is.

---

## 🧠 Approach — Iterative + Group Checking

1. **Count `k` nodes ahead:** Before each reversal, count if there are at least `k` nodes left. If not, stop.
2. **Reverse k nodes:** Use standard linked list reversal logic, but only for `k` nodes.
3. **Reconnect:** Connect the end of the previous group to the head of the reversed group.
4. **Continue:** Move to the next group until no k-sized group remains.

---

## 📝 Code (Java)

```java
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) return head;

        ListNode curr = head;
        ListNode prev = null;

        while (true) {
            // 1️⃣ Count if k nodes exist
            ListNode check = curr;
            int count = 0;
            while (check != null && count < k) {
                check = check.next;
                count++;
            }
            if (count < k) break;

            // 2️⃣ Save pointers before reversal
            ListNode last = prev;
            ListNode newEnd = curr;
            ListNode next = curr.next;

            // 3️⃣ Reverse k nodes
            for (int i = 0; curr != null && i < k; i++) {
                curr.next = prev;
                prev = curr;
                curr = next;
                if (next != null) next = next.next;
            }

            // 4️⃣ Connect reversed part to previous group
            if (last != null) last.next = prev;
            else head = prev;

            // 5️⃣ Connect end of reversed group to remaining list
            newEnd.next = curr;

            // 6️⃣ Prepare for next group
            if (curr == null) break;
            prev = newEnd;
        }

        return head;
    }
}
```

---

## 🔁 Dry Run Example

### Input:

```
head = 1 → 2 → 3 → 4 → 5
k = 3
```

### Step-by-Step Execution:

| Step | Action                                        | List State    |
| ---- | --------------------------------------------- | ------------- |
| 1    | Count 3 nodes → OK                            | 1→2→3→4→5     |
| 2    | Reverse first 3 nodes                         | **3→2→1**→4→5 |
| 3    | Connect end of first group to 4               | 3→2→1→4→5     |
| 4    | Count next 3 nodes → only 2 nodes left → Stop | 3→2→1→4→5     |

✅ Final Output: `3 → 2 → 1 → 4 → 5`

---

## 🖼️ Visual Diagram

```
Before:
head → 1 → 2 → 3 → 4 → 5

Reverse first k=3 group:
3 → 2 → 1    4 → 5
↑ head       ↑ remaining

Reconnect:
head → 3 → 2 → 1 → 4 → 5
```

---

## ⏱️ Complexity

* **Time:** `O(n)` → each node is visited at most twice.
* **Space:** `O(1)` → in-place reversal.

---

## 🗝️ Key Insights

* Always check if there are k nodes before reversing.
* `last` connects the previous part of the list.
* `newEnd` becomes the tail after reversal (important for reconnecting to remaining nodes).
* Breaking when `curr == null` ensures we don’t overrun the list.
