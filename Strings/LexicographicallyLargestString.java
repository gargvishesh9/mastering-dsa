public class LexicographicallyLargest {

    // Function to find the lexicographically largest string
    public static String findLargestString(String[] arr) {
        if (arr == null || arr.length == 0) return "";

        String largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // Compare current string with the largest found so far
            if (arr[i].compareTo(largest) > 0) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        String[] arr1 = {"apple", "banana", "orange", "mango"};
        String[] arr2 = {"zebra", "alpha", "beta", "yak"};

        System.out.println("Largest string in arr1: " + findLargestString(arr1));
        System.out.println("Largest string in arr2: " + findLargestString(arr2));
    }
}

/*
-------------------------------
📘 Dry Run Example

Example 1: arr = {"apple", "banana", "orange", "mango"}
Step 1: largest = "apple"
Step 2: compare "banana" > "apple" → true → largest = "banana"
Step 3: compare "orange" > "banana" → true → largest = "orange"
Step 4: compare "mango" > "orange" → false → largest stays "orange"

✅ Result: "orange"

Example 2: arr = {"zebra", "alpha", "beta", "yak"}
Step 1: largest = "zebra"
Step 2: compare "alpha" > "zebra" → false
Step 3: compare "beta" > "zebra" → false
Step 4: compare "yak" > "zebra" → false

✅ Result: "zebra"
-------------------------------

📌 Explanation:
- Lexicographical order is dictionary order (like compareTo in Java).
- Iterate through the array, keep track of the largest string using `compareTo`.
- If current string is greater than the largest → update largest.

⏱ Time Complexity: O(n * m) → n = number of strings, m = average string length
📦 Space Complexity: O(1)
-------------------------------
*/
