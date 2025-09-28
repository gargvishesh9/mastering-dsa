
# 🏛 Roman to Integer

## 📌 Problem
Convert a Roman numeral string `s` into its integer value.

### Example
Input:  
`s = "MCMXCIV"`

Output:  
`1994`

---

## 💡 Approach: Forward Traversal (Left → Right)

1. Create a map for symbol → value.
2. Traverse the string from **left to right**.
3. For each character:
   - If current value < next value → **subtract** it from result.
   - Else → **add** it to result.

---

## 🧠 Intuition
- Normally Roman numerals are additive.
- When a smaller numeral appears **before** a larger one, we treat it as **subtractive**.

---

## 📝 Code

```java
class Solution {
    public int romanToInt(String s) {
        // Step 1: Create a map for symbol values
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        // Step 2: Traverse from left to right
        for (int i = 0; i < s.length(); i++) {
            int curr = map.get(s.charAt(i));

            // If next value is bigger, subtract current value
            if (i + 1 < s.length() && curr < map.get(s.charAt(i + 1))) {
                result -= curr;
            } else {
                result += curr;
            }
        }

        return result;
    }
}
````

---

## 🔍 Dry Run (Example: `MCMXCIV`)

| i | s[i] | curr | next   | Condition  | Action | result |
| - | ---- | ---- | ------ | ---------- | ------ | ------ |
| 0 | M    | 1000 | C=100  | 1000<100 ❌ | +1000  | 1000   |
| 1 | C    | 100  | M=1000 | 100<1000 ✅ | -100   | 900    |
| 2 | M    | 1000 | X=10   | 1000<10 ❌  | +1000  | 1900   |
| 3 | X    | 10   | C=100  | 10<100 ✅   | -10    | 1890   |
| 4 | C    | 100  | I=1    | 100<1 ❌    | +100   | 1990   |
| 5 | I    | 1    | V=5    | 1<5 ✅      | -1     | 1989   |
| 6 | V    | 5    | -      | -          | +5     | 1994 ✅ |

✅ Final Answer = **1994**

---

## ⏱ Complexity

* **Time:** `O(n)` (scan string once)
* **Space:** `O(1)` (map size is constant: 7)

---

## 🎯 Key Takeaways

* Simple left-to-right traversal with a **lookahead check**.
* Clean & efficient for this problem.
* Works for all valid Roman numerals.


