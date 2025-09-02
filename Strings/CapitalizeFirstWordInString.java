public class CapitalizeFirstWordInString {

    // Function to capitalize the first character of each word in a sentence
    public static String capitalize(String sentence) {
        int n = sentence.length();
        StringBuilder result = new StringBuilder();

        boolean capitalizeNext = true; // flag to check when to capitalize

        for (int i = 0; i < n; i++) {
            char ch = sentence.charAt(i);

            if (Character.isLetter(ch) && capitalizeNext) {
                // Capitalize this letter
                result.append(Character.toUpperCase(ch));
                capitalizeNext = false;
            } else {
                result.append(ch);
            }

            // If current char is a space, next non-space char should be capitalized
            if (ch == ' ') {
                capitalizeNext = true;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String sentence1 = "hello, my name is vishesh";
        String sentence2 = "java is awesome";
        String sentence3 = "   multiple   spaces here";
        String sentence4 = "a test-with punctuation! words";

        System.out.println("Original: " + sentence1);
        System.out.println("Capitalized: " + capitalize(sentence1));

        System.out.println("\nOriginal: " + sentence2);
        System.out.println("Capitalized: " + capitalize(sentence2));

        System.out.println("\nOriginal: " + sentence3);
        System.out.println("Capitalized: " + capitalize(sentence3));

        System.out.println("\nOriginal: " + sentence4);
        System.out.println("Capitalized: " + capitalize(sentence4));
    }
}

/*
-------------------------------
📘 Dry Run Example

Input: "   multiple   spaces here"

Step 1: Start with flag = true
' ' → append → flag still true
' ' → append → flag still true
' ' → append → flag still true
'm' → flag true → capitalize → "M" → flag = false
'u','l','t','i','p','l','e' → normal
' ' → append, flag = true
' ' → append, flag = true
' ' → append, flag = true
's' → flag true → capitalize → "S"

✅ Final Output: "   Multiple   Spaces Here"

-------------------------------

📌 Explanation:
- Use a boolean flag `capitalizeNext` to decide when to capitalize.
- Initially `true` → so first valid letter is capitalized.
- After every space, reset flag to `true`.
- Handles:
  - Leading spaces
  - Multiple spaces
  - Punctuation like commas and exclamation marks

⏱ Time Complexity: O(n) → n = length of string  
📦 Space Complexity: O(n) → for result string  

-------------------------------
*/
