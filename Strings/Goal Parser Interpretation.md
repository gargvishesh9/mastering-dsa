
# Goal Parser Interpretation – Java Solutions

### Problem

Interpret a command string `s` where:

* `"G"` → `"G"`
* `"()"` → `"o"`
* `"(al)"` → `"al"`

Return the interpreted string.

---

## 1️⃣ Your Original Solution

```java
class Solution {
    public String interpret(String s) {
        StringBuilder result = new StringBuilder();
  
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' && s.charAt(i+1) == ')'){
               result.append("o");
               i = i+1;
            } else if(s.charAt(i) == '(' && s.charAt(i+1) == 'a'){
                result.append("al");
                i = i+3;
            } else {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
```

**Notes:**

* ✅ Works correctly for the problem constraints.
* ⚠️ Risk of `StringIndexOutOfBoundsException` if `i+1` or `i+3` exceed string length.
* ✅ Efficient using `StringBuilder`.

---

## 2️⃣ Safe Version with Index Checks

```java
class Solution {
    public String interpret(String s) {
        StringBuilder result = new StringBuilder();
  
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
                result.append("o");
                i++; // skip next character
            } else if (i + 3 < s.length() && s.charAt(i) == '(' && s.charAt(i + 1) == 'a') {
                result.append("al");
                i += 3; // skip next 3 characters
            } else {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
```

**Notes:**

* ✅ Safe: prevents index out-of-bounds errors.
* ✅ Keeps your logic but adds proper bounds checking.

---

## 3️⃣ Clean While-Loop Version

```java
class Solution {
    public String interpret(String s) {
        StringBuilder result = new StringBuilder();
        
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                if (s.charAt(i + 1) == ')') {
                    result.append("o");
                    i += 2; // skip "()"
                } else {
                    result.append("al");
                    i += 4; // skip "(al)"
                }
            } else {
                result.append(s.charAt(i)); // "G"
                i++;
            }
        }
        
        return result.toString();
    }
}
```

**Notes:**

* ✅ Very readable; no repeated `else if`.
* ✅ Logic is clear: check `"()"`, else check `"(al)"`, else append char.

---

## 4️⃣ One-Liner `replace` Version

```java
class Solution {
    public String interpret(String s) {
        return s.replace("()", "o").replace("(al)", "al");
    }
}
```

**Notes:**

* ✅ Extremely concise and readable.
* ✅ Safe: no manual index management.
* ⚠️ Slightly less performant for huge strings (creates intermediate strings), but perfect for LeetCode constraints.

---

**💡 Summary:**

* Use **your original solution** for practice with indices.
* Use **safe version** if worried about index errors.
* Use **while-loop version** for readability.
* Use **one-liner `replace` version** for simplicity and clean code.

---


