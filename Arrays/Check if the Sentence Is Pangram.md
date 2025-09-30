

# 📘 1832. Check if the Sentence Is Pangram

## 📌 Problem

A **pangram** is a sentence where **every letter of the English alphabet** (`'a'` to `'z'`) appears **at least once**.

Given a string `sentence` (only lowercase English letters), return:

* `true` if it’s a pangram
* `false` otherwise

---

## 💡 Approach

* Use a boolean array of size `26` to track which letters have been seen.
* Convert each character to its index: `c - 'a'`.
* Mark that position as `true`.
* After processing all characters, check if all entries are `true`.
* If yes → pangram, else → not a pangram.

---

## ✅ Code (Boolean Array)

```java
class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] seen = new boolean[26];

        for (char c : sentence.toCharArray()) {
            seen[c - 'a'] = true; // mark letter as seen
        }

        // check if all 26 letters are present
        for (boolean val : seen) {
            if (!val) return false;
        }

        return true;
    }
}
```

---

## 🏃 Dry Run

**Input:**
`sentence = "thequickbrownfoxjumpsoverthelazydog"`

**Steps:**

* Iterate characters, mark them in `seen[]`.
* After loop, all 26 positions = `true`.

**Output:**
`true ✅`

---

## ⏱ Complexity

* **Time:** `O(n)` (scan sentence once + check 26 letters)
* **Space:** `O(26)` → constant

---

## ✅ Alternate (Set Approach)

```java
import java.util.*;

class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();

        for (char c : sentence.toCharArray()) {
            set.add(c);
        }

        return set.size() == 26;
    }
}
```

---

⚡ **Key Insight:**

* Boolean array is faster and memory-efficient.
* Set approach is simpler to write.

