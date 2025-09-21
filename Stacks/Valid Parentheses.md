
# 🧩 Valid Parentheses – Notes

### 📌 Problem Statement
Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['`, and `']'`,  
determine if the input string is **valid**.

A string is **valid** if:
1. Open brackets are closed by the same type of brackets.
2. Open brackets are closed in the correct order.
3. Every closing bracket has a corresponding opening bracket.

---

### 🛠️ Approach – Using Stack (LIFO)
We use a **stack** because it works on **Last-In-First-Out (LIFO)** order:  
the most recent opening bracket must be closed first.

**Steps:**
1. **Iterate** through the string one character at a time.
2. **Push** every opening bracket `(`, `{`, `[` onto the stack.
3. On every closing bracket `)`, `}`, `]`:
   - If stack is empty → **return false** (no matching opening bracket).
   - Pop from the stack and check if the popped element matches the current closing bracket:
     - `(` should match `)`
     - `{` should match `}`
     - `[` should match `]`
   - If it does not match → **return false**.
4. After the loop, if the stack is **empty** → all brackets matched → return `true`,  
   else return `false` (unmatched opening brackets remain).

---

### 💻 Code Implementation

```java
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> temp = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // Push opening brackets
            if (ch == '(' || ch == '[' || ch == '{') {
                temp.push(ch);
            } 
            // Handle closing brackets
            else {
                if (temp.isEmpty()) return false; // No opening bracket available
                
                char top = temp.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{')) {
                    return false; // Mismatched pair
                }
            }
        }
        
        return temp.isEmpty(); // true if all matched
    }
}
````

---

### 🧠 Dry Run Example

#### Example Input:

`s = "({[]})"`

| Step | Character | Stack (Before) | Action     | Stack (After) |
| ---- | --------- | -------------- | ---------- | ------------- |
| 1    | `(`       | \[]            | push       | \[(]          |
| 2    | `{`       | \[(]           | push       | \[(, {]       |
| 3    | `[`       | \[(, {]        | push       | \[(, {, \[]   |
| 4    | `]`       | \[(, {, \[]    | pop `[` ✔️ | \[(, {]       |
| 5    | `}`       | \[(, {]        | pop `{` ✔️ | \[(]          |
| 6    | `)`       | \[(]           | pop `(` ✔️ | \[]           |

✅ Stack is empty → **Valid String**

---

### ⏳ Complexity Analysis

| Complexity | Explanation                                                                        |
| ---------- | ---------------------------------------------------------------------------------- |
| **Time**   | **O(n)** – we process each character exactly once (push or pop is O(1))            |
| **Space**  | **O(n)** – worst case, all characters are opening brackets and stored in the stack |

---

### ⚠️ Common Mistakes

* ❌ Using `.equals()` on `char` (use `==` instead).
* ❌ Forgetting to check for empty stack before popping.
* ❌ Not checking if stack is empty at the end (unmatched openings left behind).

---

### 📝 Key Takeaways

* Stack is perfect for problems involving **matching pairs**.
* Always check `isEmpty()` before popping to avoid runtime errors.
* At the end of traversal, **stack must be empty** for the string to be valid.

```

