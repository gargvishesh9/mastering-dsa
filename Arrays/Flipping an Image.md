
# 832. Flipping an Image

**Problem:**

* Given an `n x n` binary matrix `image`.
* First, *flip horizontally* → reverse each row.
* Then, *invert* → replace `0 → 1`, `1 → 0`.
* Return the modified image.

---

## 🔑 Approach 1 – Two Step (Your Version)

* Step 1: Reverse each row (flip horizontally).
* Step 2: Invert all elements.
* Works fine, but does two passes per row.

```java
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;

        for (int i = 0; i < n; i++) {
            // Step 1: Flip horizontally
            for (int j = 0; j < n / 2; j++) {
                int temp = image[i][j];
                image[i][j] = image[i][n - 1 - j];
                image[i][n - 1 - j] = temp;
            }

            // Step 2: Invert
            for (int j = 0; j < n; j++) {
                image[i][j] ^= 1; // XOR with 1 flips 0 ↔ 1
            }
        }

        return image;
    }
}
```

⏱ Time: `O(n²)`
📦 Space: `O(1)`

---

## 🔑 Approach 2 – Optimized (One Pass with Two Pointers)

* Do **flip and invert together**.
* Use two pointers `left` and `right`.
* While swapping, immediately invert (`^1`).
* Cuts work in half, faster in practice.

```java
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;

        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;

            while (left <= right) {
                int temp = image[i][left] ^ 1;
                image[i][left] = image[i][right] ^ 1;
                image[i][right] = temp;

                left++;
                right--;
            }
        }

        return image;
    }
}
```

⏱ Time: `O(n²)` (but fewer operations per row).
📦 Space: `O(1)`

---

## 🚀 Dry Run Example

Input:

```
image = [[1,1,0],
         [1,0,1],
         [0,0,0]]
```

* Flip row1: `[1,1,0] → [0,1,1]`
* Invert row1: `[0,1,1] → [1,0,0]`
* Similarly for other rows.

Final output:

```
[[1,0,0],
 [0,1,0],
 [1,1,1]]
```

---

✅ Both are correct.

* **Approach 1:** cleaner, easier to understand.
* **Approach 2:** faster in practice (beats ~90%+ submissions).


