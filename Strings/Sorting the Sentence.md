
# 1859. Sorting the Sentence

## Problem
Given a string `s` containing words with numbers at the end (1-indexed), return the sentence sorted according to the numbers.

**Example:**
```

Input: s = "is2 sentence4 This1 a3"
Output: "This is a a sentence"

````

---

## Correct Solution

```java
class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");             // Split sentence into words
        String[] result = new String[words.length]; // Array to hold words in correct order
        StringBuilder t = new StringBuilder();

        for (String temp : words) {
            int ind = temp.charAt(temp.length() - 1) - '1'; // Convert number char to 0-based index
            result[ind] = temp.substring(0, temp.length() - 1); // Remove number and store
        }

        for (int i = 0; i < result.length; i++) {
            t.append(result[i]);
            if (i != result.length - 1) t.append(" "); // Avoid trailing space
        }

        return t.toString();
    }
}
````

---

## Notes

* **Split the sentence**: `s.split(" ")` breaks the string into words.
* **Index conversion**: `'1'` → 0, `'2'` → 1, etc. (`ch - '1'`).
* **Remove number**: `substring(0, temp.length()-1)` removes the digit at the end.
* **Build final sentence**: use `StringBuilder` and add spaces **between words only**.
* **Time Complexity**: O(n) – iterate through each word once.
* **Space Complexity**: O(n) – extra array to store words in order.

---

### Example Walkthrough

Input: `"is2 sentence4 This1 a3"`

1. Split: `["is2","sentence4","This1","a3"]`
2. Place in array using index (`ch-'1`):

   ```
   result[0] = "This"
   result[1] = "is"
   result[2] = "a"
   result[3] = "sentence"
   ```
3. Join → `"This is a sentence"` ✅

```

