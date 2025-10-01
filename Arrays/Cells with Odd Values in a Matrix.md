
# 1252. Cells with Odd Values in a Matrix

### 📌 Problem

* You have an `m x n` matrix initialized with **0s**.
* For each index `[ri, ci]` in `indices`:

  1. Increment **row `ri`** by `+1`.
  2. Increment **column `ci`** by `+1`.
* Return the number of cells with **odd values** after performing all operations.

---

## 🔎 Example

Input:

```
m = 2, n = 3
indices = [[0,1],[1,1]]
```

Steps:

```
Initial:
0 0 0
0 0 0

Apply [0,1]:
1 2 1
0 1 0

Apply [1,1]:
1 3 1
1 3 1
```

Final matrix:

```
1 3 1
1 3 1
```

Odd count = 6 ✅

---

## 💡 Approach 1 – Brute Force (Simulation)

* Create an `m x n` matrix.
* For each operation `[ri, ci]`:

  * Increment all elements in row `ri`.
  * Increment all elements in column `ci`.
* Count odd values.

```java
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];

        for (int[] index : indices) {
            int r = index[0], c = index[1];

            // Increment row
            for (int j = 0; j < n; j++) {
                matrix[r][j]++;
            }

            // Increment column
            for (int i = 0; i < m; i++) {
                matrix[i][c]++;
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] % 2 != 0) count++;
            }
        }

        return count;
    }
}
```

⏱ Time: `O(k*(m+n) + m*n)`
📦 Space: `O(m*n)`
(where `k = indices.length`)

---

## 💡 Approach 2 – Optimized (Row/Column Tracking)

* Instead of modifying the whole matrix, track increments separately:

  * `row[r]++` when row `r` is incremented.
  * `col[c]++` when column `c` is incremented.
* For each cell `(i, j)`, value = `row[i] + col[j]`.
* Check if odd.

```java
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] row = new int[m];
        int[] col = new int[n];

        for (int[] index : indices) {
            row[index[0]]++;
            col[index[1]]++;
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((row[i] + col[j]) % 2 != 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
```

⏱ Time: `O(m*n + k)`
📦 Space: `O(m+n)`

---

✅ Both work.

* **Brute force** → good for understanding.
* **Optimized** → avoids building full matrix.

