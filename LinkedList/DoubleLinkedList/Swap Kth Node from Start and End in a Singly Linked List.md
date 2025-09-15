
# 🔄 Swap Kth Node from Start and End in a Singly Linked List

## 📌 Problem Statement
Given the head of a singly linked list and an integer `k`,  
swap the values of the `k`th node from the start and the `k`th node from the end.  
Return the head of the modified list.

---

## 🧩 Approaches

We can solve this problem in **three ways**:

---

## 1️⃣ Array-Based Approach (Extra Space)

### Idea
- Copy all node values into an array.
- Swap `kth` from start and `kth` from end.
- Copy array values back into the linked list.

### Code
```java
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        // Step 1: Count size
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // Step 2: Copy values into array
        int[] arr = new int[size];
        temp = head;
        int i = 0;
        while (temp != null) {
            arr[i++] = temp.val;
            temp = temp.next;
        }

        // Step 3: Swap kth elements
        int startIndex = k - 1;
        int endIndex = size - k;
        int t = arr[startIndex];
        arr[startIndex] = arr[endIndex];
        arr[endIndex] = t;

        // Step 4: Copy values back into list
        temp = head;
        i = 0;
        while (temp != null) {
            temp.val = arr[i++];
            temp = temp.next;
        }

        return head;
    }
}
````

**Complexity:**

* **Time:** `O(n)` (two traversals)
* **Space:** `O(n)` (array storage)

---

## 2️⃣ Two-Pass Optimal Approach (O(1) Space)

### Idea

* Find list length.
* Traverse again to find:

  * `kthFromStart` → kth node from start
  * `kthFromEnd` → (length - k + 1)th node from start
* Swap their values.

### Code

```java
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        // Step 1: Find length
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // Step 2: Find kth node from start
        ListNode first = head;
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        // Step 3: Find kth node from end
        ListNode second = head;
        for (int i = 1; i < size - k + 1; i++) {
            second = second.next;
        }

        // Step 4: Swap values
        int t = first.val;
        first.val = second.val;
        second.val = t;

        return head;
    }
}
```

**Complexity:**

* **Time:** `O(n)` (two passes)
* **Space:** `O(1)` (no extra storage)

---

## 3️⃣ One-Pass Optimal Approach (Two Pointers)

### Idea

* Move `first` pointer to kth node from start.
* Store it as `kthFromStart`.
* Then move `first` to end while moving `second` from head.
* When `first` reaches end, `second` will be kth from end.
* Swap their values.

### Code

```java
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;
        ListNode second = head;
        ListNode kthFromStart = null;

        // Step 1: Move 'first' k-1 steps ahead
        for (int i = 1; i < k; i++) {
            first = first.next;
        }
        kthFromStart = first;

        // Step 2: Move both 'first' and 'second' till 'first' reaches last node
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        // Now 'second' is kth from end
        ListNode kthFromEnd = second;

        // Step 3: Swap values
        int t = kthFromStart.val;
        kthFromStart.val = kthFromEnd.val;
        kthFromEnd.val = t;

        return head;
    }
}
```

**Complexity:**

* **Time:** `O(n)` (one traversal) ✅
* **Space:** `O(1)` ✅

---

## 🧠 Dry Run Example

Input:
`head = [1, 2, 3, 4, 5], k = 2`

| Approach | k-th from Start | k-th from End | Output            |
| -------- | --------------- | ------------- | ----------------- |
| Array    | 2               | 4             | `[1, 4, 3, 2, 5]` |
| Two-Pass | 2               | 4             | `[1, 4, 3, 2, 5]` |
| One-Pass | 2               | 4             | `[1, 4, 3, 2, 5]` |

All give **same result** ✅

---

## 📌 Edge Cases

* `k = 1` → swaps head and last node.
* `k = length` → swaps last and head node (same as above).
* `kthFromStart == kthFromEnd` → no change needed (middle node in odd-length list).
* Empty list or `k > length` → return list as-is.

---

## 🎯 Recommendation

* ✅ **Use One-Pass Approach in Interviews** → clean, optimal, and shows pointer mastery.
* Use Array-Based Approach only for learning/debugging (extra space used).

---

```

