
# 🧩 Problem: Isomorphic Strings

Two strings `s` and `t` are isomorphic if the characters in `s` can be replaced to get `t`.

👉 Rules:
- Each character in `s` must map to exactly one character in `t`.
- No two characters in `s` can map to the same character in `t`.
- Order must be preserved.

Examples:
1. s = "egg", t = "add" → true
2. s = "foo", t = "bar" → false
3. s = "paper", t = "title" → true
*/

```java
class SolutionArray {
    // ---------- Approach 1: Arrays ----------
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (mapS[c1] == 0 && mapT[c2] == 0) {
                mapS[c1] = c2;
                mapT[c2] = c1;
            } else {
                if (mapS[c1] != c2 || mapT[c2] != c1) {
                    return false;
                }
            }
        }
        return true;
    }
}
```

```java
import java.util.HashMap;

class SolutionMap {
    // ---------- Approach 2: HashMaps ----------
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (mapS.containsKey(c1)) {
                if (mapS.get(c1) != c2) return false;
            } else {
                mapS.put(c1, c2);
            }

            if (mapT.containsKey(c2)) {
                if (mapT.get(c2) != c1) return false;
            } else {
                mapT.put(c2, c1);
            }
        }
        return true;
    }
}
```


# 📝 Dry Run

Example 1: s = "egg", t = "add"
- i=0: e → a (set mapping)
- i=1: g → d (set mapping)
- i=2: g → d (check, consistent)
✅ return true

Example 2: s = "foo", t = "bar"
- i=0: f → b (set mapping)
- i=1: o → a (set mapping)
- i=2: o → r (expected a, got r → conflict)
❌ return false

Example 3: s = "paper", t = "title"
- p → t
- a → i
- p → t (consistent)
- e → l
- r → e
✅ return true
*/
