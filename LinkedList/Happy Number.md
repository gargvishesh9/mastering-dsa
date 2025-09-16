
# 😊 Happy Number Problem (Floyd’s Cycle Detection)

## 📌 Problem Statement
Write an algorithm to determine if a number `n` is **happy**.  
A number is called happy if:
1. Replace the number by the sum of the squares of its digits.
2. Repeat the process until the number becomes `1` (where it stays).
3. If it loops endlessly in a cycle that does not include `1`, it is not a happy number.

Return `true` if `n` is a happy number, `false` otherwise.

---

## 🧩 Approach (Floyd’s Cycle Detection)

### Key Insight
- The sequence of numbers will **either reach 1 (happy)** or **enter a cycle (unhappy)**.
- We can detect cycles using **Floyd's Tortoise & Hare Algorithm** (slow/fast pointer technique):
  - `slow` moves **one step** at a time.
  - `fast` moves **two steps** at a time.
  - If they ever meet at a number other than `1`, a cycle exists → number is not happy.

---

## 🧠 Algorithm Steps

1. Initialize:
   - `slow = n`
   - `fast = n`
2. **Loop until slow meets fast:**
   - Move `slow` by 1 step → `slow = findSquare(slow)`
   - Move `fast` by 2 steps → `fast = findSquare(findSquare(fast))`
3. **Exit condition:**
   - If `slow == 1`, return `true` (happy number).
   - If `slow == fast` (but not 1), return `false` (cycle found).

---

## 💻 Code Implementation (Java)

```java
class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);                 // move one step
            fast = findSquare(findSquare(fast));     // move two steps
        } while (slow != fast);

        return slow == 1;
    }

    private int findSquare(int n) {
        int ans = 0;
        while (n > 0) {
            int rem = n % 10;
            ans += rem * rem;
            n = n / 10;
        }
        return ans;
    }
}
````

---

## ⏱️ Complexity Analysis

* **Time Complexity:**

  * `O(log n)` per step to compute sum of squares (because number of digits ≈ log₁₀(n))
  * Runs until cycle or 1 detected → worst case `O(steps)` where steps is small (bounded by cycle length).
* **Space Complexity:** `O(1)` → only two integer variables used.

---

## 🧠 Dry Run Example

### Example 1: n = 19 (Happy Number)

| Step | slow (1-step) | fast (2-steps) | Comment                        |
| ---- | ------------- | -------------- | ------------------------------ |
| 1    | 82            | 68             | both move                      |
| 2    | 68            | 100            | fast moves twice               |
| 3    | 100           | 1              | fast reaches 1                 |
| 4    | 1             | 1              | slow reaches 1 → return true ✅ |

---

### Example 2: n = 2 (Unhappy Number)

| Step                                                          | slow | fast | Comment      |
| ------------------------------------------------------------- | ---- | ---- | ------------ |
| 1                                                             | 4    | 16   | move forward |
| 2                                                             | 16   | 37   |              |
| ...                                                           | ...  | ...  | continues    |
| Eventually slow = fast at 4 → cycle detected → return false ❌ |      |      |              |

---

## 🎯 Key Points to Remember

* **No HashSet needed** (saves space) → use Floyd’s algorithm for cycle detection.
* `findSquare()` is a helper function that computes sum of squares of digits.
* Works for **any positive integer**.
* Stops as soon as `slow == 1` (happy number) or `slow == fast` (cycle detected).

---

## 📌 Visualization

```
Example n = 19

19 → (1²+9²)=82 → (8²+2²)=68 → 100 → 1 ✅
```

If the sequence repeats (like for n = 2):

```
2 → 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 → ... (cycle ❌)
```

---

✅ **This solution is optimal and commonly asked in interviews (LeetCode #202).**

```

---
