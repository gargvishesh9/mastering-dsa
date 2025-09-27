
# 1704. Determine if String Halves Are Alike

## Problem
Given a string `s` of even length, split it into two halves. Return `true` if both halves contain the **same number of vowels**. Vowels are `a, e, i, o, u` (case-insensitive).

---

## Correct Solution

```java
class Solution {

    public boolean halvesAreAlike(String s) {
        String firstHalf = s.substring(0, s.length()/2);
        String secondHalf = s.substring(s.length()/2);

        return countVowels(firstHalf) == countVowels(secondHalf);
    }

    private int countVowels(String str){
        int count = 0;
        for(char ch : str.toCharArray()){
            if(isVowel(ch)) count++;
        }
        return count;
    }

    private boolean isVowel(char ch){
        ch = Character.toLowerCase(ch); // Convert to lowercase for uniformity
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
````

---

## Notes

* **Split string correctly**:

  ```java
  firstHalf = s.substring(0, s.length()/2);
  secondHalf = s.substring(s.length()/2);
  ```
* **Vowel check**: convert to lowercase once, then compare with 5 vowels.
* **Time Complexity**: O(n), iterate through all characters once.
* **Space Complexity**: O(n), for substring and char arrays.

---

### Example

```
Input: s = "book"
First half: "bo" → 1 vowel
Second half: "ok" → 1 vowel
Output: true
```

