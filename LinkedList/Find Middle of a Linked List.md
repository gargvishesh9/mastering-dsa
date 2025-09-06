
# Find Middle of a Linked List

## Problem
Given the `head` of a singly linked list, return **the middle node** of the linked list.  
If there are two middle nodes, return the **second middle node**.

---

## Approach 1: Two-pass Method (Counting Size)

### Logic
1. Traverse the linked list once to count the total number of nodes (`size`).
2. Compute the middle index as `size / 2`.
   - For odd size → exact middle.
   - For even size → second middle (as required).
3. Traverse the list again until reaching the middle index and return that node.

### Code
```java
public ListNode middleNodeTwoPass(ListNode head) {
    // Step 1: Count the size of the linked list
    int size = 0;
    ListNode temp = head;
    while (temp != null) {
        temp = temp.next;
        size++;
    }

    // Step 2: Find the middle index
    int middleIndex = size / 2;

    // Step 3: Traverse again to reach the middle
    int i = 0;
    ListNode curr = head;
    while (i < middleIndex) {
        curr = curr.next;
        i++;
    }

    return curr;
}
````

### Dry Run Example

List: `1 → 2 → 3 → 4 → 5`

* Size = 5
* Middle index = 5 / 2 = 2
* Move 2 steps → node `3` ✅

List: `1 → 2 → 3 → 4 → 5 → 6`

* Size = 6
* Middle index = 6 / 2 = 3
* Move 3 steps → node `4` ✅

### Complexity

* **Time:** O(n) (two traversals)
* **Space:** O(1)

---

## Approach 2: Fast & Slow Pointers (One-pass)

### Logic

* Use two pointers:

  * `slow` moves **1 step** at a time.
  * `fast` moves **2 steps** at a time.
* When `fast` reaches the end (`null`), `slow` will be at the middle.

### Code

```java
public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;       // move one step
        fast = fast.next.next;  // move two steps
    }

    return slow; // slow now points to middle
}
```

### Dry Run Example

**Odd case (5 nodes): 1 → 2 → 3 → 4 → 5**

* Start: slow=1, fast=1
* Step 1: slow=2, fast=3
* Step 2: slow=3, fast=5 → stop → return `3` ✅

**Even case (6 nodes): 1 → 2 → 3 → 4 → 5 → 6**

* Start: slow=1, fast=1
* Step 1: slow=2, fast=3
* Step 2: slow=3, fast=5
* Step 3: slow=4, fast=null → stop → return `4` ✅

### Complexity

* **Time:** O(n) (single traversal)
* **Space:** O(1)

---

## Comparison of Approaches

| Approach              | Traversals | Space | Notes                                   |
| --------------------- | ---------- | ----- | --------------------------------------- |
| Two-pass (count size) | 2          | O(1)  | Easier to understand, but slower        |
| Fast & Slow pointers  | 1          | O(1)  | More efficient, preferred in interviews |

---

## Conclusion

* Both methods are correct.
* **Fast & Slow pointer** method is cleaner, more efficient, and the recommended solution for interviews and real-world usage.

```


