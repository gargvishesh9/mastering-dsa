
# 📝 Length of Last Word

## 📌 Problem
Given a string `s` consisting of words and spaces, return the length of the last word in the string.

---

## 💡 Approach
- Start from the **end** of the string.
- **Skip all trailing spaces**.
- **Count characters** until you hit a space or reach the beginning.
- Return the count.

---

## 📝 Code

```java
class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;

        // Step 1: Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Step 2: Count last word characters
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}
````

---

## 🔍 Dry Run

Example: `s = "   Hello World   "`

| Step | i  | Char | Action | length |
| ---- | -- | ---- | ------ | ------ |
| 1    | 14 | ' '  | skip   | 0      |
| 1    | 13 | ' '  | skip   | 0      |
| 2    | 11 | 'd'  | count  | 1      |
| 2    | 10 | 'l'  | count  | 2      |
| 2    | 9  | 'r'  | count  | 3      |
| 2    | 8  | 'o'  | count  | 4      |
| 2    | 7  | 'W'  | count  | 5      |
| Stop | 6  | ' '  | break  | ✅      |

Result = **5**

---

## ⏱ Complexity

* **Time:** `O(n)` (at most we scan the entire string once)
* **Space:** `O(1)` (no extra memory used)

---

## 🎯 Key Points

* Works without creating new strings (`trim()` not needed).
* Efficient and interview-friendly approach.
* Clean and direct — handles trailing spaces naturally.

