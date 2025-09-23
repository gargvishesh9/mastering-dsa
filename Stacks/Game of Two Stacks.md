

# 🎮 Game of Two Stacks – Step-by-Step Visual

**Input:**

```
X = 10
A = [4, 2, 4, 6, 1]
B = [2, 1, 8, 5]
```

---

### 🟢 Step 1 → Take from A until sum ≤ X

```
sum = 0, i = 0, j = 0

A: [4, 2, 4, 6, 1]
    ^
B: [2, 1, 8, 5]
    ^

Take A[0] = 4 → sum=4 → i=1 ✅
```

---

```
sum = 4, i = 1, j = 0

A: [4, 2, 4, 6, 1]
       ^
B: [2, 1, 8, 5]
    ^

Take A[1] = 2 → sum=6 → i=2 ✅
```

---

```
sum = 6, i = 2, j = 0

A: [4, 2, 4, 6, 1]
          ^
B: [2, 1, 8, 5]
    ^

Take A[2] = 4 → sum=10 → i=3 ✅
```

---

```
sum = 10, i = 3, j = 0

A: [4, 2, 4, 6, 1]
             ^
B: [2, 1, 8, 5]
    ^

Next A[3]=6 → would make sum=16 ❌ → STOP taking from A
```

✅ **Current picks:** `A(4, 2, 4)`
✅ **Current maxCount = 3**

---

### 🟡 Step 2 → Start Taking from B

```
Take B[0] = 2 → sum=12 ❌
Overflow → remove last A[i-1]=4
```

---

```
After removal:
sum = 8, i = 2, j = 1 ✅

A: [4, 2, 4, 6, 1]
       ^
B: [2, 1, 8, 5]
       ^

Current picks: A(4, 2), B(2)
maxCount = i+j = 3
```

---

```
Take B[1] = 1 → sum=9 ✅
j=2

A: [4, 2, 4, 6, 1]
       ^
B: [2, 1, 8, 5]
          ^

Current picks: A(4, 2), B(2, 1)
maxCount = i+j = 4 ✅ (BEST SO FAR)
```

---

```
Take B[2] = 8 → sum=17 ❌
Overflow → remove last A[i-1]=2 → sum=15 ❌
Again remove last A[i-1]=4 → sum=11 ❌
i=0 (no more A left)
```

Still `sum > 10` → can't take this B element → STOP.

✅ **Final maxCount = 4**

---

### 🔑 Final Answer

**Maximum elements = 4 → A: 4, 2 | B: 2, 1**

---

## 🔎 Summary Table

| Step                  | i | j | sum | Picks         | maxCount      |
| --------------------- | - | - | --- | ------------- | ------------- |
| Start                 | 0 | 0 | 0   | -             | 0             |
| Take A\[0]            | 1 | 0 | 4   | A(4)          | 1             |
| Take A\[1]            | 2 | 0 | 6   | A(4,2)        | 2             |
| Take A\[2]            | 3 | 0 | 10  | A(4,2,4)      | 3             |
| Take B\[0] → overflow | 2 | 1 | 8   | A(4,2),B(2)   | 3             |
| Take B\[1]            | 2 | 2 | 9   | A(4,2),B(2,1) | **4**         |
| Take B\[2] → overflow | 0 | 3 | 11  | -             | 4 (unchanged) |

---

✅ This step-by-step view shows **i and j moving** like pointers, and how we "undo" A when sum exceeds X.


