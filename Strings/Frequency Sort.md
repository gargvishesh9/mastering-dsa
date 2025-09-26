
# 🔢 Frequency Sort (Java – HashMap + Sorting)

## 📝 Problem

Given a string `s`, **sort the characters in descending order of frequency**.

* Characters with higher frequency come first.
* Characters with the same frequency can appear in any order.

**Example:**

```text
Input:  "tree"
Output: "eert" or "eetr"
```

---

## 💡 Intuition

1. Count how many times each character appears → use a `HashMap<Character, Integer>`.
2. Sort characters **by frequency descending**.
3. Build the result string by appending each character `frequency` times.

---

## 🛠️ Algorithm (Step-by-Step)

1. **Count frequencies**

```java
HashMap<Character,Integer> temp = new HashMap<>();
for(char ch : s.toCharArray()){
    temp.put(ch, temp.getOrDefault(ch, 0) + 1);
}
```

2. **Convert map entries to list** (so we can sort by frequency)

```java
List<Map.Entry<Character,Integer>> listt = new ArrayList<>(temp.entrySet());
```

3. **Sort list by frequency descending**

```java
listt.sort((a,b) -> b.getValue() - a.getValue());
```

* `a` and `b` are `Map.Entry<Character,Integer>` objects
* `b.getValue() - a.getValue()` ensures **highest frequency first**

4. **Build the result string**

```java
StringBuilder res = new StringBuilder();
for(Map.Entry<Character,Integer> m : listt){
    char ch = m.getKey();
    int freq = m.getValue();
    for (int i = 0; i < freq; i++) {
        res.append(ch);
    }
}
```

5. **Return the result**

```java
return res.toString();
```

---

## 💻 Full Java Code

```java
import java.util.*;

class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> temp = new HashMap<>();
        for(char ch : s.toCharArray()){
            temp.put(ch, temp.getOrDefault(ch, 0) + 1);
        }

        List<Map.Entry<Character,Integer>> listt = new ArrayList<>(temp.entrySet());
        listt.sort((a,b) -> b.getValue() - a.getValue());

        StringBuilder res = new StringBuilder();
        for(Map.Entry<Character,Integer> m : listt){
            char ch = m.getKey();
            int freq = m.getValue();
            for (int i = 0; i < freq; i++) {
                res.append(ch);
            }
        }

        return res.toString();
    }
}
```

---

## 📊 Example Dry Run

Input: `"tree"`

| Step              | Map Entry             | Sorted List           | Result String |
| ----------------- | --------------------- | --------------------- | ------------- |
| Count frequencies | `{t=1, r=1, e=2}`     | —                     | —             |
| Convert to list   | `[(t,1),(r,1),(e,2)]` | —                     | —             |
| Sort descending   | —                     | `[(e,2),(t,1),(r,1)]` | —             |
| Build result      | —                     | —                     | `"eetr"`      |

---

## ⏱️ Complexity

| Operation                                         | Time       | Space                    |
| ------------------------------------------------- | ---------- | ------------------------ |
| Count frequencies                                 | O(n)       | O(k) (unique characters) |
| Sorting                                           | O(k log k) | O(k)                     |
| Build string                                      | O(n)       | O(n)                     |
| **Overall** → O(n + k log k) time, O(n + k) space |            |                          |

---

## ✅ Key Points

* `HashMap` → counts frequencies
* `List<Map.Entry>` → allows sorting by value
* `StringBuilder` → efficiently builds the result
* Sorting by `b.getValue() - a.getValue()` → ensures **descending frequency**

---


