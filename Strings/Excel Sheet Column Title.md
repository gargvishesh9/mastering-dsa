# 168. Excel Sheet Column Title

## Problem

Given an integer `columnNumber`, return its corresponding column title as it appears in an Excel sheet:

* `1 → A`
* `2 → B`
* …
* `26 → Z`
* `27 → AA`
* `28 → AB`

---

## Your Solution

```java
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // ✅ Adjust for 1-based indexing
            int remainder = columnNumber % 26; // ✅ Get last "digit" in base-26
            char ch = (char) ('A' + remainder); // ✅ Convert to letter
            result.append(ch);
            columnNumber = columnNumber / 26; // ✅ Move to next significant "digit"
        }

        return result.reverse().toString(); // ✅ Reverse because we built it backwards
    }
}
```

---

## Step-by-Step Dry Run

Let's dry run for **columnNumber = 701** (expected output → `"ZY"`).

| Step | columnNumber (start) | columnNumber-- | remainder (`% 26`) | char (`'A'+remainder`) | result (before reverse) | columnNumber after `/= 26` |
| ---- | -------------------- | -------------- | ------------------ | ---------------------- | ----------------------- | -------------------------- |
| 1    | 701                  | 700            | 700 % 26 = 24      | `'A'+24 → 'Y'`         | `"Y"`                   | 700 / 26 = 26              |
| 2    | 26                   | 25             | 25 % 26 = 25       | `'A'+25 → 'Z'`         | `"YZ"`                  | 25 / 26 = 0                |

Loop ends because `columnNumber = 0`.

Now we **reverse** → `"ZY"` ✅ correct answer.

---

## Example Outputs

| Input | Output  |
| ----- | ------- |
| 1     | `"A"`   |
| 26    | `"Z"`   |
| 27    | `"AA"`  |
| 28    | `"AB"`  |
| 701   | `"ZY"`  |
| 702   | `"ZZ"`  |
| 703   | `"AAA"` |

---

## Complexity

* **Time Complexity:** O(log₍₂₆₎ n) → number of characters in title
* **Space Complexity:** O(1) (ignoring result string)

---

## Key Takeaways

* `columnNumber--` is crucial to shift from **1-based indexing** to **0-based math**.
* `% 26` extracts last character (like last digit in base-26).
* Reverse at the end because we build from **right to left**.

