
# Next Greater Element I – Stack & HashMap Approach

## Problem Statement

Given two arrays `nums1` and `nums2`:

* `nums1` is a subset of `nums2`.
* For each element in `nums1`, find the **next greater element** in `nums2`.
* If no such element exists, return `-1`.

**Example:**

```java
nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
```

---

## Approach

We use a **monotonic stack** and a **HashMap**:

1. Traverse `nums2` from **right to left**.
2. Maintain a stack of elements for which we haven’t found a next greater element yet.
3. For each `nums2[i]`:

   * Pop elements from the stack smaller than `nums2[i]`.
   * If the stack is not empty after popping, the top of the stack is the **next greater element**.
   * Otherwise, the next greater element is `-1`.
   * Store this mapping in a HashMap for **O(1) lookup** later.
4. For each element in `nums1`, retrieve its next greater element from the HashMap.

---

## Code

```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> temp = new HashMap<>();
        Stack<Integer> s = new Stack<>();

        int n= nums2.length;
        for(int i=n-1;i>=0;i--){
          
          // Pop elements smaller than current
          while(!s.isEmpty() && s.peek()<nums2[i]){
            s.pop();
          }

          // Map current element to next greater or -1
          if(!s.isEmpty()){
            temp.put(nums2[i],s.peek());
          }else{
            temp.put(nums2[i],-1);
          }
         
          // Push current element for future comparisons
          s.push(nums2[i]);
        }

        // Build result for nums1 using hashmap
        int[] result = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
           result[i] = temp.get(nums1[i]);
        }

        return result;
    }
}
```

---

## Dry Run

**Input:**

```java
nums1 = [4,1,2], nums2 = [1,3,4,2]
```

**Step 1 – Build HashMap using Stack**

| i | nums2\[i] | Stack after processing | Map (nums2\[i] -> next greater) |
| - | --------- | ---------------------- | ------------------------------- |
| 3 | 2         | \[2]                   | {2: -1}                         |
| 2 | 4         | \[4]                   | {2: -1, 4: -1}                  |
| 1 | 3         | \[4,3]                 | {2: -1, 3:4, 4:-1}              |
| 0 | 1         | \[4,3,1]               | {1:3, 2:-1, 3:4, 4:-1}          |

**Step 2 – Build result for nums1**

* `4` → `-1`
* `1` → `3`
* `2` → `-1`

**Output:** `[-1, 3, -1]`

---

## Complexity Analysis

* **Time Complexity:** `O(n + m)`

  * `n` = length of `nums2`, `m` = length of `nums1`
  * Each element is pushed and popped from the stack at most once.
* **Space Complexity:** `O(n)`

  * Stack + HashMap storing mappings for `nums2`.

---

✅ This approach is efficient and uses a **monotonic decreasing stack** to achieve linear time complexity.

---

