
# ⛰️ 1732. Find the Highest Altitude

## 📌 Problem

You are given an integer array `gain` where:

* `gain[i]` represents the **net gain in altitude** between point `i` and `i+1`.

Starting altitude = `0`.
Return the **highest altitude** reached.

---

## 💡 Approach

* Use a variable `altitude` to track the current altitude.
* Start from `0`, add each `gain[i]` step by step.
* Track the **maximum altitude** seen so far.

---

## ✅ Code (Optimized O(1) Space)

```java
class Solution {
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int maxAltitude = 0;

        for (int g : gain) {
            altitude += g;
            maxAltitude = Math.max(maxAltitude, altitude);
        }

        return maxAltitude;
    }
}
```

---

## 🏃 Dry Run

**Input:**
`gain = [-5, 1, 5, 0, -7]`

| Step  | Gain | Altitude (after step) | Max |
| ----- | ---- | --------------------- | --- |
| Start | —    | 0                     | 0   |
| 1     | -5   | -5                    | 0   |
| 2     | 1    | -4                    | 0   |
| 3     | 5    | 1                     | 1   |
| 4     | 0    | 1                     | 1   |
| 5     | -7   | -6                    | 1   |

**Output:** `1 ✅`

---

## ⏱ Complexity

* **Time:** `O(n)` → single pass
* **Space:** `O(1)` → no extra array needed

---

⚡ **Key Insight:**
We don’t need to store all altitudes (`temp[]`). Just maintain:

* current `altitude`
* running `maxAltitude`


