

# 📝 Problem: Minimum Add to Make Parentheses Valid

**LeetCode 921 — Min Add to Make Valid Parentheses**
Given a string `s` consisting of `'('` and `')'`, return the minimum number of parentheses you must add to make the string valid.

---

## 💡 Approach

We use a **stack** to track unmatched parentheses:

1. **Traverse the string character by character.**
2. If the character is `'('`, **push it to the stack** (it needs a closing match).
3. If the character is `')'`:

   * If the stack is not empty and the top is `'('`, pop it (we found a valid pair `()`).
   * Otherwise, push `')'` (it is unmatched and will require an opening `(` to fix later).
4. After traversing, **whatever remains in the stack is unmatched**, so its size equals the number of parentheses we must add.

---

## ✅ Code

```java
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(ch);
            }

            if (ch == ')') {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop(); // matched pair found
                } else {
                    st.push(ch); // unmatched ')'
                }
            }
        }

        return st.size(); // total unmatched '(' + ')'
    }
}
```

---

## ⏳ Dry Run Example

Input:
`s = "()))(("`

| i | ch | stack (top → right) | Action                 |
| - | -- | ------------------- | ---------------------- |
| 0 | (  | (                   | push '('               |
| 1 | )  | empty               | pop '(' (pair matched) |
| 2 | )  | )                   | push ')'               |
| 3 | )  | ))                  | push ')'               |
| 4 | (  | ))(                 | push '('               |
| 5 | (  | ))((                | push '('               |

At the end:

* Stack contains `))((` → 4 unmatched parentheses.
* **Answer = 4**

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n)`
  We traverse the string once, each character is pushed/popped at most once.
* **Space Complexity:** `O(n)`
  In the worst case (all `'('`), we push all characters into the stack.

---

## 🔑 Key Insight

The **stack size at the end = number of insertions required** to make the string valid.

