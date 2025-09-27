
# 657. Robot Return to Origin

## Problem
You are given a string `moves` representing moves of a robot starting from the origin `(0, 0)`.

- `'L'` → move left (x - 1)  
- `'R'` → move right (x + 1)  
- `'U'` → move up (y + 1)  
- `'D'` → move down (y - 1)  

Return `true` if the robot returns to the origin after completing all moves.

---

## Solution

```java
class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;

        for (char ch : moves.toCharArray()) {
            if (ch == 'L') {
                x = x - 1;
            } else if (ch == 'R') {
                x = x + 1;
            } else if (ch == 'U') {
                y = y + 1;
            } else {  // ch == 'D'
                y = y - 1;
            }
        }

        return x == 0 && y == 0;
    }
}
````

---

## Key Points

* Maintain `(x, y)` coordinates.
* Increment/decrement `x` for horizontal moves, `y` for vertical moves.
* If `(x, y)` returns to `(0, 0)`, robot ends at origin.

---

## Complexity

* **Time Complexity:** O(n), iterate once over moves.
* **Space Complexity:** O(1), use only two variables.

---

## Example Walkthrough

```
Input: moves = "UD"
Start: x=0, y=0

'U' → y=1
'D' → y=0

Final: x=0, y=0 → returns true ✅
```

```


