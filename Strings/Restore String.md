

# 📝 Restore String – Notes

**Problem:**
Given a string `s` and an integer array `indices`, return a new string where the `i`-th character of `s` is placed at position `indices[i]`.

---

## 💡 Key Idea

We need to **rearrange characters** from `s` into their correct positions based on `indices`.
Use either:

* `char[]` (best choice for efficiency), or
* `StringBuilder` (but must initialize it properly before using `setCharAt`).

---

## ⚠️ Common Mistake

`StringBuilder ans = new StringBuilder();` creates an **empty builder**.
Calling `ans.setCharAt(index, char)` will throw **`StringIndexOutOfBoundsException`**
because there are no characters yet at that index.

---

## ✅ Correct Approach (Using `char[]`)

```java
class Solution {
    public String restoreString(String s, int[] indices) {
        char[] ans = new char[s.length()];

        for (int i = 0; i < indices.length; i++) {
            ans[indices[i]] = s.charAt(i);  // place each char at its correct index
        }

        return new String(ans);
    }
}
```

---

## 🧠 Dry Run Example

**Input:**
`s = "code"`
`indices = [3, 1, 2, 0]`

| i | s.charAt(i) | indices[i] | ans (after step) |
| - | ----------- | ---------- | ---------------- |
| 0 | 'c'         | 3          | `___c`           |
| 1 | 'o'         | 1          | `_o_c`           |
| 2 | 'd'         | 2          | `_odc`           |
| 3 | 'e'         | 0          | `eodc`           |

**Output:** `"eodc"`

---

## ⏱️ Complexity

* **Time:** `O(n)` – single pass through string
* **Space:** `O(n)` – char array of size `n`


