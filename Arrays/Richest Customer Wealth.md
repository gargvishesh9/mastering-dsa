
# 💰 Richest Customer Wealth

## 📌 Problem
Given a 2D array `accounts` where `accounts[i][j]` is the amount of money the i-th customer has in the j-th bank account, return the **maximum wealth** among all customers.  
- Wealth of a customer = sum of money in all their accounts.

### Example
Input:  
`accounts = [[1,2,3],[3,2,1]]`  
Output: `6`  

---

## 💡 Approach
- Initialize `maxWealth = 0`.
- Loop through each customer:
  - Sum all their account balances.
  - Update `maxWealth` if this sum is greater.
- Return `maxWealth`.

---

## 📝 Code

```java
int maxWealth = 0;

for (int i = 0; i < accounts.length; i++) {
    int sum = 0;
    for (int j = 0; j < accounts[i].length; j++) {
        sum += accounts[i][j];
    }
    maxWealth = Math.max(maxWealth, sum);
}

return maxWealth;
````

---

## ⏱ Complexity

* **Time:** `O(m*n)` (m = number of customers, n = number of accounts)
* **Space:** `O(1)` (no extra space used)

---

## 🎯 Key Points

* Simple **2D array traversal** problem.
* Use `Math.max` to update maximum efficiently.
* Can be solved **in-place** without extra arrays.

```


