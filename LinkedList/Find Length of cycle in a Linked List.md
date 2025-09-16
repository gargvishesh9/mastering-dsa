
# 🔄 Find Length of Loop in a Linked List

## 📌 Problem Statement
Given the head of a linked list, determine if a loop (cycle) exists.  
If it exists, return the **length of the loop**, otherwise return `0`.

---

## 🧩 Approach (Floyd’s Cycle Detection Algorithm)

### Idea
We use **Floyd's Tortoise and Hare Algorithm** (slow & fast pointers) to:
1. **Detect if a loop exists.**
2. **Count the number of nodes in the loop** when detected.

---

## 🧠 Algorithm Steps

1. **Initialize**  
   - `slow = head`  
   - `fast = head`

2. **Move Pointers**  
   - Move `slow` **1 step** at a time.  
   - Move `fast` **2 steps** at a time.  

3. **Detect Cycle**  
   - If `slow == fast`, a cycle exists.

4. **Find Length**  
   - Keep a temporary pointer `temp = slow`.  
   - Move `temp` around the cycle until it meets `slow` again.  
   - Count steps to get cycle length.

5. **No Cycle Case**  
   - If `fast` or `fast.next` becomes `null`, return `0`.

---

## 💻 Code Implementation (Java)

```java
/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        Node slow = head;
        Node fast = head;

        // Step 1: Detect loop using Floyd's Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // Cycle detected
                // Step 2: Count length of loop
                Node temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0; // No cycle found
    }
}
````

---

## ⏱️ Complexity Analysis

* **Time Complexity:**

  * `O(n)` → worst case (if no loop, we traverse entire list once)
  * Counting loop length takes `O(length of loop)` steps.

* **Space Complexity:**

  * `O(1)` → only two pointers used.

---

## 🧠 Dry Run Example

### Example 1: With Loop

**Input:**
`1 -> 2 -> 3 -> 4 -> 5 -> 3 (loop back to node 3)`

| Step | slow              | fast                              | Comment                        |
| ---- | ----------------- | --------------------------------- | ------------------------------ |
| 1    | 2                 | 3                                 | Move slow 1 step, fast 2 steps |
| 2    | 3                 | 5                                 |                                |
| 3    | 4                 | 4                                 | slow == fast → loop found      |
| 4    | Count loop length | → 3 nodes in loop (3 → 4 → 5 → 3) |                                |

**Output:** `3`

### Example 2: No Loop

**Input:**
`1 -> 2 -> 3 -> 4 -> null`

| Step | slow | fast | Comment                     |
| ---- | ---- | ---- | --------------------------- |
| 1    | 2    | 3    |                             |
| 2    | 3    | null | fast becomes null → no loop |

**Output:** `0`

---

## 🎯 Key Points to Remember

* **Floyd’s Cycle Detection** is optimal:

  * `O(1)` space, no extra data structures.
* Use `do...while` for counting loop length so at least one node is counted.
* If `fast` or `fast.next` becomes `null` → list is not cyclic.

---

## 📌 Visualization

```
Example: 1 -> 2 -> 3 -> 4 -> 5
                   ↑         |
                   └─────────┘

slow: moves one step at a time
fast: moves two steps at a time
They eventually meet inside the cycle
then we count loop length
```

---

✅ **This is the standard solution used in interviews for cycle detection & loop length.**

```


