

## 📝 Problem Statement

Given a valid IPv4 IP address, return a **defanged version** of that IP address.
A defanged IP address replaces every period `"."` with `"[.]"`.

**Example:**

```text
Input:  "1.1.1.1"
Output: "1[.]1[.]1[.]1"
```

---

## 💡 Intuition

We need to create a new string where every `.` is replaced with `[.]`.
Instead of using `String.replace()`, we can **manually build the string** using a `StringBuilder`.

---

## 🛠 Approach

1. Convert the string into a char array using `toCharArray()`.
2. Iterate through each character:

   * If it is `.`, append `"[.]"` to the result.
   * Otherwise, append the character as is.
3. Return the final `StringBuilder` as a string.

---

## 💻 Code (Java)

```java
class Solution {
    public String defangIPaddr(String address) {
        StringBuilder result = new StringBuilder();

        for (char ch : address.toCharArray()) {
            if (ch == '.') {
                result.append("[.]");
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
```

---

## 🧠 Dry Run

Example: `address = "1.1.1.1"`

| Character | Action       | Result          |
| --------- | ------------ | --------------- |
| `1`       | Append       | `1`             |
| `.`       | Append `[.]` | `1[.]`          |
| `1`       | Append       | `1[.]1`         |
| `.`       | Append `[.]` | `1[.]1[.]`      |
| `1`       | Append       | `1[.]1[.]1`     |
| `.`       | Append `[.]` | `1[.]1[.]1[.]`  |
| `1`       | Append       | `1[.]1[.]1[.]1` |

✅ Final Answer → `"1[.]1[.]1[.]1"`

---

## ⏱ Complexity Analysis

* **Time Complexity:** `O(n)` → iterate through all characters once.
* **Space Complexity:** `O(n)` → `StringBuilder` stores the result.


