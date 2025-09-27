
# 557. Reverse Words in a String III

## Problem
Given a string `s`, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

**Example:**
```

Input:  s = "Let's code"
Output: "s'teL edoc"

````

---

## Your Approach (Two-Step Reverse)

```java
class Solution {
    public String reverseWords(String s) {
        StringBuilder temp = new StringBuilder();

        // Step 1: Reverse the entire string
        for (int i = s.length() - 1; i >= 0; i--) {
            temp.append(s.charAt(i));
        }

        // Step 2: Split the reversed string
        String[] result = temp.toString().split(" ");

        // Step 3: Reverse word order back
        temp = new StringBuilder();
        for (int i = result.length - 1; i >= 0; i--) {
            temp.append(result[i]);
            if (i != 0) {
                temp.append(" ");
            }
        }

        return temp.toString();
    }
}
````

### Analysis

✅ **Pros:**

* Works in many cases by double reversing (whole string + word order).

❌ **Cons:**

* More steps than needed (reverse whole string, split, then reverse words back).
* Harder to read for interviewers — overcomplicates a simple task.

---

## Cleaner Approach (Recommended)

```java
class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            result.append(new StringBuilder(words[i]).reverse()); // reverse each word
            if (i != words.length - 1) {
                result.append(" "); // add space between words
            }
        }

        return result.toString();
    }
}
```

### Why This Is Better

* Directly reverses each word — no extra reversing or reordering needed.
* Clear and interviewer-friendly.
* Time Complexity: **O(n)**
* Space Complexity: **O(n)**

---

## Example Walkthrough

Input:

```
"Let's code"
```

Steps:

1. Split → ["Let's", "code"]
2. Reverse each word → ["s'teL", "edoc"]
3. Join with spaces → `"s'teL edoc"`

Output:

```
"s'teL edoc"
```


