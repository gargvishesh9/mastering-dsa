

# ☄️ Asteroid Collision – Stack Solution (Java)

## 📝 Problem

We are given an array `asteroids`, where each integer represents an asteroid moving along a 1D line.

* Positive value → moving **right**
* Negative value → moving **left**
  When two asteroids collide:
* The **smaller one explodes**
* If they are equal in size, **both explode**
* Asteroids moving in the same direction never collide

Return the state of asteroids after all collisions.

---

## 💡 Intuition

This is a **simulation problem** where collisions can cascade — one asteroid can trigger multiple explosions.
Key insight:

> **Only possible collision happens if top of stack is moving right and current asteroid is moving left.**

We use a **stack** to maintain the asteroids that survived so far:

* Push freely if stack is empty or no collision is possible
* When a collision is possible, pop until:

  * The top asteroid is destroyed, OR
  * The current asteroid is destroyed, OR
  * No more collisions are possible

---

## 🛠️ Algorithm

1. Initialize an empty stack `s`.
2. Iterate through `asteroids`:

   * Use a `boolean alive = true` to track whether the current asteroid survives.
   * While `alive` and `collision is possible`:

     * Compare sizes (`abs()`).
     * Pop smaller asteroid and continue if current still survives.
     * If equal size → pop top, mark `alive = false`.
     * If top is bigger → mark `alive = false`.
   * If `alive` after all collisions, push current asteroid.
3. Convert stack to result array.

---

## 🧑‍💻 Code (Java)

```java
import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();

        for (int a : asteroids) {
            boolean alive = true;

            // Collision only possible if top > 0 (right-moving) and a < 0 (left-moving)
            while (alive && a < 0 && !s.isEmpty() && s.peek() > 0) {
                int top = s.peek();

                if (Math.abs(top) < Math.abs(a)) {
                    s.pop(); // top explodes, check again
                } else if (Math.abs(top) == Math.abs(a)) {
                    s.pop(); // both explode
                    alive = false;
                } else {
                    // top is bigger, current asteroid destroyed
                    alive = false;
                }
            }

            if (alive) {
                s.push(a);
            }
        }

        int[] result = new int[s.size()];
        for (int i = s.size() - 1; i >= 0; i--) {
            result[i] = s.pop();
        }

        return result;
    }
}
```

---

## 🔍 Example Dry Run

Input:

```text
asteroids = [5, 10, -5]
```

| Step | Current | Stack Before | Action                 | Stack After |
| ---- | ------- | ------------ | ---------------------- | ----------- |
| 1    | `5`     | []           | push                   | [5]         |
| 2    | `10`    | [5]          | push                   | [5, 10]     |
| 3    | `-5`    | [5, 10]      | 10 vs -5 → 10 survives | [5, 10]     |

Result → `[5, 10]`

---

## ⏱️ Complexity

| Complexity | Value                                                |
| ---------- | ---------------------------------------------------- |
| **Time**   | `O(n)` (each asteroid is pushed/popped at most once) |
| **Space**  | `O(n)` (stack for survivors)                         |

---

## 🎯 Key Takeaways

* **Stack + While Loop** = Perfect for collision chain simulation
* **alive flag** keeps code clean (decides whether to push)
* Very similar to other monotonic stack problems (Next Greater Element, Remove K Digits)

