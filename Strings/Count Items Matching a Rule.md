
# 1773. Count Items Matching a Rule

## Problem
Given a list of items, where each item is a list of `[type, color, name]`, count how many items match a given rule.  
A rule consists of `ruleKey` (`"type"`, `"color"`, or `"name"`) and `ruleValue`.

---

## My Original Solution (6ms, beats 25%)

```java
class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for (int i = 0; i < items.size(); i++) {
            if (ruleKey.equals("type") && items.get(i).get(0).equals(ruleValue)) {
                count++;
            } else if (ruleKey.equals("color") && items.get(i).get(1).equals(ruleValue)) {
                count++;
            } else if (ruleKey.equals("name") && items.get(i).get(2).equals(ruleValue)) {
                count++;
            }
        }
        return count;
    }
}
````

### Notes

* Works perfectly.
* Loops through each item and checks the ruleKey inside the loop.
* Slightly slower because `ruleKey.equals(...)` is checked multiple times for every item.

---

## Optimized Solution (faster, cleaner)

```java
class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = 0;
        if (ruleKey.equals("color")) index = 1;
        else if (ruleKey.equals("name")) index = 2;

        int count = 0;
        for (List<String> item : items) {
            if (item.get(index).equals(ruleValue)) {
                count++;
            }
        }

        return count;
    }
}
```

### Notes

* Determine the **index of the attribute once** before the loop.
* Loop through items using **for-each** to reduce repeated `get(i)` calls.
* Faster because it avoids repeated string comparisons inside the loop.
* Cleaner and more readable.

```

