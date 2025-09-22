
# Duplicate Parentheses – Stack Approach

## Problem Statement

Check if a given expression contains **duplicate parentheses**.

* **Duplicate parentheses** are redundant parentheses that enclose nothing or a single expression unnecessarily.
* Return `true` if duplicates exist, else `false`.

**Example:**

```java
Input: ((a+b)) 
Output: true   // Duplicate around "a+b"

Input: (a+(b)/c) 
Output: false
```

---

## Approach

1. Use a **stack** to process characters of the expression.
2. Traverse the expression:

   * If the character is **not ')'**, push it to the stack.
   * If the character is **')'**, do the following:

     1. Count characters inside the parentheses until `'('` is found.
     2. If **count < 1**, it means the parentheses are empty or duplicate → return `true`.
     3. Otherwise, pop the `'('` and continue.
3. If the traversal ends without finding duplicates, return `false`.

**Key idea:**

* Redundant parentheses are detected when there’s nothing (or just a single element) between `'('` and `')'`.

---

## Code

```java
import java.util.*;

public class Solution {

    public static boolean duplicateParanthesis(String expr) {
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if(ch == ')') {
                int count = 0;

                // Count characters inside parentheses
                while(!s.isEmpty() && s.peek() != '(') {
                    s.pop();
                    count++;
                }

                // If no characters between '(',')' → duplicate
                if(count < 1) {
                    return true;
                } else {
                    s.pop(); // pop '('
                }

            } else {
                s.push(ch); // push other characters
            }
        }

        return false;
    }
}
```

---

## Dry Run

**Input:** `"((a+b))"`

**Step 1 – Push characters:**

* Stack: `[`(`, `(`, `a`, `+`, `b`]`

**Step 2 – Encounter `)`**:

* Pop until `'('`: `b`, `+`, `a` → count = 3 → pop `'('`
* Stack now: `[`(`]`

**Step 3 – Encounter `)` again**:

* Pop until `'('`: nothing inside → count = 0 → **duplicate detected → return true**

---

## Complexity Analysis

* **Time Complexity:** `O(n)` – each character is pushed/popped at most once.
* **Space Complexity:** `O(n)` – stack may store all characters in worst case.

---

✅ This approach efficiently detects duplicate parentheses using a stack and character counting.

---


