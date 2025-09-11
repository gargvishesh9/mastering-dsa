
# 📘 Intersection of Two Linked Lists

## 📝 Problem Statement

Given the heads of two singly linked lists `headA` and `headB`, return the **node where the two lists intersect**.
If the two linked lists have no intersection, return `null`.

Intersection is based on **reference equality** — not just value equality.

---

## 📊 Example

```
List A: 4 → 1
              ↘
                8 → 4 → 5
              ↗
List B: 5 → 6 → 1
```

✅ Output: Node with value **8** (same memory reference).

---

## ❌ Brute Force Solution

### 🧠 Idea

For every node in List A, traverse List B and check if there is a common node reference.

### ⏱ Complexity

* **Time:** `O(M × N)` (nested loops)
* **Space:** `O(1)`

### 💻 Code

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        for (ListNode a = headA; a != null; a = a.next) {
            for (ListNode b = headB; b != null; b = b.next) {
                if (a == b) { // check reference equality
                    return a;  // intersection found
                }
            }
        }
        return null; // no intersection
    }
}
```

### 🏃‍♂️ Dry Run

| a (List A) | b (List B) | a==b?              | Result        |
| ---------- | ---------- | ------------------ | ------------- |
| 4          | 5          | ❌                  | continue      |
| 4          | 6          | ❌                  | continue      |
| 4          | 1          | ❌                  | continue      |
| 4          | 8          | ❌                  | continue      |
| 4          | 4          | ❌ (different node) | continue      |
| ...        | ...        | ...                | ...           |
| 1          | 8          | ✅                  | return node 8 |

✅ **Intersection Found**

---

## ✅ Optimal Solution – Two Pointer Technique

### 🧠 Idea

Use two pointers `pA` and `pB` starting at `headA` and `headB`.
Move them one step at a time.
When a pointer reaches the end, redirect it to the **other list’s head**.

Eventually, either:

* They meet at the intersection node OR
* Both become `null` → no intersection

### ⏱ Complexity

* **Time:** `O(M + N)`
* **Space:** `O(1)` (no extra memory used)

### 💻 Code

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            // when reaching end of one list, switch to the other
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }

        return pA; // either intersection node OR null
    }
}
```

---

### 🏃‍♂️ Dry Run

| Step | pA                         | pB                         | Comment                           |
| ---- | -------------------------- | -------------------------- | --------------------------------- |
| 1    | 4                          | 5                          | start                             |
| 2    | 1                          | 6                          | move                              |
| 3    | 8                          | 1                          | move                              |
| 4    | 4                          | 8                          | move                              |
| 5    | 5                          | 4                          | move                              |
| 6    | null → 5 (switch to headB) | 5                          | move                              |
| 7    | 6                          | null → 4 (switch to headA) | move                              |
| 8    | 1                          | 1                          | same value, but not same node yet |
| 9    | **8**                      | **8**                      | 🎉 meet → intersection found      |

---

### 🎯 Key Insight

* Both pointers traverse exactly **lenA + lenB** nodes.
* This guarantees they align at intersection or both finish with `null`.

---

## ⚠️ Important Note

Intersection is about **reference**, not value.

Example of **No Intersection but Same Values**:

```
List A: 1 → 2 → 3
List B: 1 → 2 → 3
```

Different node objects → **No intersection**.
Algorithm correctly returns `null`.

---

## 📌 Summary Table

| Approach           | Time Complexity | Space | Notes                               |
| ------------------ | --------------- | ----- | ----------------------------------- |
| **Brute Force**    | O(M × N)        | O(1)  | Simple but very slow                |
| **Two Pointers** ✅ | O(M + N)        | O(1)  | Best approach – elegant & efficient |

---

