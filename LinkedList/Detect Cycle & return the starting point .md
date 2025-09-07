
# 🔄 Detect Cycle Start in Linked List (LeetCode 142)

## 📌 Problem
Given the head of a linked list, return the **node where the cycle begins**.  
If there is no cycle, return `null`.

---

## ✅ Floyd’s Algorithm (Two Steps)

### Step 1: Detect Cycle
- Use **slow** (1 step) and **fast** (2 steps).
- If they meet → a cycle exists.
- If `fast` reaches `null` → no cycle.

### Step 2: Find Cycle Start
- Reset **slow = head**.
- Keep **fast** at meeting point.
- Move both one step at a time.
- The node where they meet = **cycle start**.

---

## 🧩 Code Implementation

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // cycle found
                // Step 2: Find start of cycle
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // cycle entry
            }
        }
        return null; // no cycle
    }
}
````

---

## 🔎 Example Walkthrough with Diagram

Input:

```
head = [3,2,0,-4], pos = 1
```

List with cycle:

```
3 → 2 → 0 → -4
    ↑       ↓
    ← ← ← ←
```

---

### Phase 1: Detect meeting point

* slow moves 1 step, fast moves 2 steps:

```
Step 1: slow=3, fast=0
Step 2: slow=2, fast=-4
Step 3: slow=0, fast=0 ✅ meet inside cycle
```

---

### Phase 2: Find start of cycle

Reset `slow = head (3)`, keep `fast = 0`.

```
slow = 3, fast = 0
→ move one step each

Step 1: slow=2, fast=-4
Step 2: slow=0, fast=2
Step 3: slow=-4, fast=0
Step 4: slow=2, fast=2 ✅ meet at node 2
```

So the cycle starts at **node with value 2**.

---

## 🧮 Why it Works? (Math Proof)

Let:

* `a` = distance from head to cycle start
* `b` = distance from cycle start to meeting point
* `c` = remaining cycle length

At meeting:

```
slow = a + b
fast = a + b + n(b+c)   (n cycles)
```

Since fast = 2 × slow:

```
a + b + n(b+c) = 2(a + b)
⇒ a = n(b+c) - b
```

This means:

* Distance from head to cycle start (`a`)
* Equals distance from meeting point to cycle start (`cycle length - b`)

Thus, moving **slow from head** and **fast from meeting point** will make them meet exactly at the **cycle start**.

---

## 📊 Complexity

* **Time:** O(n)
* **Space:** O(1)

---

## 💡 Intuition (Runner Analogy)

Imagine a circular track:

* A **slow runner** moves 1 step.
* A **fast runner** moves 2 steps.
* If there’s a loop, the fast one eventually laps the slow one.
* Reset slow to the start line, and now both move equally → they will meet at the **start of the loop**.

```
