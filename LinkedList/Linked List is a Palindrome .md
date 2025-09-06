
# 🟦 Check if a Linked List is a Palindrome

## 📌 Problem Statement
Given the `head` of a singly linked list, determine whether the linked list is a **palindrome**.  

A linked list is a palindrome if the sequence of its node values reads the same forward and backward.

---

## 🔑 Key Idea
To check if a linked list is a palindrome:
1. **Find the middle** of the list using the **fast and slow pointer** method.
2. **Reverse the second half** of the list.
3. Compare the **first half** and the **reversed second half**.
   - If all values match → palindrome.  
   - Otherwise → not a palindrome.

---

## ✅ Solution (Java)
```java
public class CheckPallindromeLL {

    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Utility: add node at first
    public void addFirst(int data) {
        size++;
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Utility: print linked list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Step 1: Find middle of linked list
    public Node findMidOfLL() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // middle node
    }

    // Step 2 & 3: Reverse 2nd half and check palindrome
    public boolean checkPallindromeLL() {
        if (head == null || head.next == null) {
            return true; // empty or single-node list is palindrome
        }

        // Find middle
        Node mid = findMidOfLL();

        // Reverse 2nd half
        Node prev = null;
        Node curr = mid;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Compare first half and second half
        Node left = head;
        Node right = prev;
        while (right != null) {
            if (left.data != right.data) {
                return false; // mismatch found
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        CheckPallindromeLL ll = new CheckPallindromeLL();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(2);
        ll.print();

        System.out.println("Is Palindrome? " + ll.checkPallindromeLL());
    }
}
````

---

## 🧩 Example Dry Run

### Example 1

List:

```
1 → 2 → 2 → 1
```

Steps:

1. Find middle = `2` (second one).
2. Reverse second half → `1 → 2`.
   List looks like:

   ```
   1 → 2 | 1 → 2 (reversed part)
   ```
3. Compare halves:

   * Left: `1, 2`
   * Right: `1, 2`
     ✅ Palindrome.

---

### Example 2

List:

```
1 → 2 → 3
```

Steps:

1. Find middle = `2`.
2. Reverse second half → `3 → 2`.
3. Compare halves:

   * Left: `1, 2`
   * Right: `3, 2`
     ❌ Not a palindrome.

---

## ⏱ Complexity

* **Time:** O(n)

  * O(n) to find middle
  * O(n/2) to reverse half
  * O(n/2) to compare halves
* **Space:** O(1) (in-place operations)

---

## 📌 Notes

* Works for **even** and **odd** length lists.
* Original list will be **modified** (second half reversed).
* If needed, you can reverse the second half again to restore the list.

---


