public class StringCompression {

    // Function to compress a string by replacing consecutive repeating characters 
    // with the character followed by its count
    public static String compress(String str) {
        int n = str.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int count = 1;

            // Count consecutive characters
            while (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }

            // Append character
            result.append(str.charAt(i));

            // Append count only if > 1
            if (count > 1) {
                result.append(count);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str1 = "aaabbbccddeeef";
        String str2 = "aabbcc";
        String str3 = "abcd";
        String str4 = "zzzzzzzz";

        System.out.println("Original: " + str1 + " → Compressed: " + compress(str1));
        System.out.println("Original: " + str2 + " → Compressed: " + compress(str2));
        System.out.println("Original: " + str3 + " → Compressed: " + compress(str3));
        System.out.println("Original: " + str4 + " → Compressed: " + compress(str4));
    }
}

/*
-------------------------------
📘 Dry Run Example

Input: "aaabbbccddeeef"

Step 1: i=0 → 'a'
   count consecutive → "aaa" → count=3
   Append: "a3"

Step 2: i=3 → 'b'
   count consecutive → "bbb" → count=3
   Append: "b3"

Step 3: i=6 → 'c'
   count consecutive → "cc" → count=2
   Append: "c2"

Step 4: i=8 → 'd'
   count consecutive → "dd" → count=2
   Append: "d2"

Step 5: i=10 → 'e'
   count consecutive → "eee" → count=3
   Append: "e3"

Step 6: i=13 → 'f'
   count=1
   Append: "f"

✅ Final Output: "a3b3c2d2e3f"

-------------------------------

📌 Explanation:
- Traverse the string character by character.
- Count consecutive duplicates using a `while` loop.
- Append the character.
- Append count only if `count > 1`.

Example:
- "aabbcc" → "a2b2c2"
- "abcd" → "abcd"
- "zzzzzzzz" → "z8"

⏱ Time Complexity: O(n) → single pass through string  
📦 Space Complexity: O(n) → for result string  

-------------------------------
*/
