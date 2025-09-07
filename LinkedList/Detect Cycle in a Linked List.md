
# 🔄 Detect Cycle in a Linked List

## 📌 Problem
Given the `head` of a linked list, determine if the linked list has a cycle in it.

- A cycle exists if a node can be reached again by continuously following the `next` pointer.
- Return **true** if there is a cycle, otherwise **false**.

---

## ✅ Approach 1: Using HashSet (Extra Space)
- Store visited nodes in a `HashSet`.
- If a node appears twice → cycle detected.
- Otherwise, if traversal ends (`null` reached) → no cycle.

### Code
```java
import java.util.HashSet;

public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        ListNode curr = head;

        while (curr != null) {
            if (visited.contains(curr)) {
                return true; // cycle found
            }
            visited.add(curr);
            curr = curr.next;
        }
        return false;
    }
}
````

### Dry Run (HashSet)

List: `1 → 2 → 3 → 4 → 2 (cycle back)`

* Step 1: visited = {1}
* Step 2: visited = {1, 2}
* Step 3: visited = {1, 2, 3}
* Step 4: visited = {1, 2, 3, 4}
* Next node is `2`, already in set → **cycle detected** ✅

### Complexity

* Time: **O(n)**
* Space: **O(n)** (storing nodes in the set)

---

## ✅ Approach 2: Floyd’s Cycle Detection (Tortoise & Hare) 🚀

* Use two pointers:

  * **slow** → 1 step
  * **fast** → 2 steps
* If they meet → cycle exists.
* If `fast` reaches `null` → no cycle.

### Code

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // cycle found
            }
        }
        return false; // no cycle
    }
}
```

### Dry Run (Floyd’s)

List: `1 → 2 → 3 → 4 → 2 (cycle back)`

* Step 1: slow=2, fast=3
* Step 2: slow=3, fast=2
* Step 3: slow=4, fast=4 ✅ meet → cycle exists

### Complexity

* Time: **O(n)**
* Space: **O(1)** (no extra memory)

---

## 🔎 Comparison

| Approach | Time | Space | Notes                               |
| -------- | ---- | ----- | ----------------------------------- |
| HashSet  | O(n) | O(n)  | Easy to implement, but extra memory |
| Floyd’s  | O(n) | O(1)  | Optimal, most used                  |

---

## 💡 Key Insight

* **HashSet** works by remembering visited nodes.
* **Floyd’s Algorithm** works by using two speeds — like two runners on a track, the fast one will eventually lap the slow one if a cycle exists.

---

