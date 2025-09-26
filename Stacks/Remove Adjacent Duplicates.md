
# 🧹 Remove Adjacent Duplicates – Stack Approach (Java)

## 📝 Problem

Given a string `s`, **remove all adjacent duplicates** repeatedly until no duplicates remain.

**Example:**

```text
Input: "abbaca"
Output: "ca"
```

---

## 💡 Intuition

* Use a **stack** to keep track of characters that **haven’t been removed yet**.
* Traverse the string:

  * If the top of the stack is the same as current char → pop both (remove duplicate).
  * Else → push current char.
* After processing, the stack contains the remaining characters.

---

## 🛠️ Algorithm (Your Logic)

1. **Initialize stack**

```java
Stack<Character> st = new Stack<>();
```

2. **Traverse string**

```java
for (char ch : s.toCharArray()) {
    if (!st.isEmpty()) {
        if (ch == st.peek()) { // adjacent duplicate found
            st.pop();
            continue;          // skip push
        }
    }
    st.push(ch);               // push if no duplicate
}
```

3. **Build result string**

```java
StringBuilder res = new StringBuilder();
for (char ch : st) {
    res.append(ch);
}
return res.toString();
```

---

## 💻 Full Java Code

```java
import java.util.*;

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!st.isEmpty()) {
                if (ch == st.peek()) {
                    st.pop();
                    continue; // your original continue logic
                }
            }
            st.push(ch);
        }

        StringBuilder res = new StringBuilder();
        for (char ch : st) {
            res.append(ch);
        }

        return res.toString();
    }
}
```

---

## 🔍 Example Dry Run

Input: `"abbaca"`

| Step | Character | Stack | Action           |
| ---- | --------- | ----- | ---------------- |
| a    | a         | [a]   | push             |
| b    | b         | [a,b] | push             |
| b    | b         | [a]   | pop (remove b,b) |
| a    | a         | []    | pop (remove a,a) |
| c    | c         | [c]   | push             |
| a    | a         | [c,a] | push             |

Output → `"ca"` ✅

---

## ⏱️ Complexity

| Operation                           | Time | Space        |
| ----------------------------------- | ---- | ------------ |
| Traverse string                     | O(n) | O(n) (stack) |
| Build result                        | O(n) | O(n)         |
| **Overall** → O(n) time, O(n) space |      |              |

---

### ✅ Key Notes

* Your original `continue` works — just skips pushing when a duplicate is removed.
* Stack must be **`Character`**, not `Integer`.
* `StringBuilder` efficiently converts stack to string.

