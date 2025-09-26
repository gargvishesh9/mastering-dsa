
# 🕒 933. Number of Recent Calls

## 📝 Problem

Implement a `RecentCounter` class that counts **the number of pings in the last 3000 milliseconds**.

* `RecentCounter.ping(t)` adds a ping at time `t` (in ms)
* Returns the **number of pings in the range `[t-3000, t]`**

**Example:**

```text
Input: ["RecentCounter", "ping", "ping", "ping", "ping"]
       [[], [1], [100], [3001], [3002]]
Output: [null, 1, 2, 3, 3]
```

---

## 💡 Intuition

* Only pings in the **last 3000 ms** matter.
* Older pings can be discarded.
* Use a **queue** to store timestamps in chronological order:

  * Add new ping at the back
  * Remove pings from the front if **older than t-3000**

---

## 🛠️ Approach

1. Initialize a queue:

```java
Queue<Integer> queue = new LinkedList<>();
```

2. On `ping(t)`:

* Add `t` to the queue
* Remove elements `< t-3000` from the front
* Return `queue.size()`

---

## 💻 Java Code

```java
import java.util.*;

class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t); // add new ping

        // remove old pings outside [t-3000, t]
        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size(); // number of recent calls
    }
}
```

---

## 🧠 Dry Run Example

Input: `[1, 100, 3001, 3002]`

| Ping t | Queue Before | Remove < t-3000 | Queue After     | Size |
| ------ | ------------ | --------------- | --------------- | ---- |
| 1      | []           | —               | [1]             | 1    |
| 100    | [1]          | —               | [1,100]         | 2    |
| 3001   | [1,100]      | remove 1        | [100,3001]      | 2    |
| 3002   | [100,3001]   | —               | [100,3001,3002] | 3    |

* Queue **always contains only pings in the last 3000ms**.

---

## ⏱️ Complexity

| Operation | Time           | Space                     |
| --------- | -------------- | ------------------------- |
| ping()    | O(1) amortized | O(n) (queue)              |
| Space     | O(n)           | n = pings in last 3000 ms |

---

## ✅ Key Points

* **Queue maintains chronological order**
* **Sliding window** → remove anything outside `[t-3000, t]`
* Efficient: each ping is **pushed once and popped once** → amortized O(1)
