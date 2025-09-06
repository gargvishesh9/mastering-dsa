
#  Delete Node in a Linked List

## 📌 Problem Statement
You are given **a node** in a singly linked list (not the head).  
Delete the given node from the linked list.  

- Each node contains: `val` and `next`.  
- The node to be deleted is **not the tail node**.  
- You are **not given access to the head** of the list.  

---

## 🔑 Key Idea
Normally, to delete a node, we would:
1. Find its **previous node**.
2. Set `prev.next = node.next`.

But since we **don’t have the head** (so no way to find `prev`), we can’t do this.

👉 Trick:  
- Copy the value of the **next node** into the current node.  
- Skip the next node by adjusting the pointer.  

Effectively, the given node takes the value of the next node, and the next node is removed.

---

## ✅ Solution (Java)
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) { this.val = val; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // Copy value from next node into current node
        node.val = node.next.val;

        // Skip the next node
        node.next = node.next.next;
    }
}
````

---

## 🧩 Example Dry Run

List:

```
4 → 5 → 1 → 9
```

Delete node: `5`

Steps:

1. Copy value from `next` → Node `5` becomes `1`.

   ```
   4 → 1 → 1 → 9
   ```
2. Skip the next node →

   ```
   4 → 1 → 9
   ```

✅ Node `5` effectively removed.

---

## ⏱ Complexity

* **Time:** O(1) (constant operations)
* **Space:** O(1)

---

## 📌 Notes

* This works only because the node is **not the tail**.
* If the node were the tail, this trick would fail (`node.next` is null).
* That’s why the problem guarantees the node to delete is **not the last one**.

---

## 🎯 Why is this a Medium Problem?

* The code is short and simple.
* The **tricky part** is realizing you cannot delete the node in the traditional way (since you don’t have head or prev).
* The real learning: sometimes we solve problems by **redefining the meaning of “deletion”** — here, by overwriting values.

```

