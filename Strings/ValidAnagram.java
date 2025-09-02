import java.util.*;

/**
 * Problem: Check if two strings are anagrams
 * 
 * Definition:
 * An anagram is a word formed by rearranging the letters of another word.
 * Example: "listen" → "silent"
 * 
 * Constraints:
 * - Both strings contain only characters (no special restriction).
 * - Case-sensitive (can modify easily for case-insensitive).
 * 
 * We will explore 4 approaches:
 * 1. Brute Force using contains()
 * 2. Sorting both strings
 * 3. HashMap frequency counter
 * 4. Frequency Array (optimized for 'a'-'z')
 */
public class ValidAnagram {

    // -----------------------------------------------------------------
    // 1. Brute Force Approach (contains + deletion)
    // -----------------------------------------------------------------
    public static boolean isAnagramBruteForce(String s, String t) {
        if (s.length() != t.length()) return false;

        StringBuilder temp = new StringBuilder(t);
        for (char c : s.toCharArray()) {
            int idx = temp.indexOf(String.valueOf(c));
            if (idx == -1) return false; // char not found
            temp.deleteCharAt(idx); // remove matched char
        }
        return temp.length() == 0;
    }
    /*
     * Dry Run: s = "cat", t = "tac"
     * i=0 → 'c' found at idx=2 → delete → temp="ta"
     * i=1 → 'a' found at idx=1 → delete → temp="t"
     * i=2 → 't' found at idx=0 → delete → temp=""
     * Final temp="" → return true
     */

    // -----------------------------------------------------------------
    // 2. Sorting Approach
    // -----------------------------------------------------------------
    public static boolean isAnagramSorting(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }
    /*
     * Dry Run: s = "rat", t = "tar"
     * a[] = ['a','r','t']
     * b[] = ['a','r','t']
     * Arrays.equals → true
     */

    // -----------------------------------------------------------------
    // 3. HashMap Frequency Counter
    // -----------------------------------------------------------------
    public static boolean isAnagramHashMap(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!freq.containsKey(c)) return false;
            freq.put(c, freq.get(c) - 1);
            if (freq.get(c) == 0) freq.remove(c);
        }

        return freq.isEmpty();
    }
    /*
     * Dry Run: s = "listen", t = "silent"
     * freq after s: {l=1,i=1,s=1,t=1,e=1,n=1}
     * Loop t:
     * 's' → freq[s]=0 → remove
     * 'i' → freq[i]=0 → remove
     * 'l' → freq[l]=0 → remove
     * 'e' → freq[e]=0 → remove
     * 'n' → freq[n]=0 → remove
     * 't' → freq[t]=0 → remove
     * freq empty → return true
     */

    // -----------------------------------------------------------------
    // 4. Frequency Array (Optimized for lowercase 'a'-'z')
    // -----------------------------------------------------------------
    public static boolean isAnagramFrequencyArray(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            freq[c - 'a']--;
        }
        for (int count : freq) {
            if (count != 0) return false;
        }
        return true;
    }
    /*
     * Dry Run: s = "aabb", t = "baba"
     * After s: freq = [2,2,0,...]  // a=2, b=2
     * After t: freq = [0,0,0,...]  // balanced
     * All zero → return true
     */

    // -----------------------------------------------------------------
    // MAIN for testing
    // -----------------------------------------------------------------
    public static void main(String[] args) {
        String s = "listen";
        String t = "silent";

        System.out.println("Brute Force: " + isAnagramBruteForce(s, t));
        System.out.println("Sorting: " + isAnagramSorting(s, t));
        System.out.println("HashMap: " + isAnagramHashMap(s, t));
        System.out.println("Frequency Array: " + isAnagramFrequencyArray(s, t));
    }
}

/**
 * ----------------------------
 * TIME & SPACE COMPLEXITY
 * ----------------------------
 * 1. Brute Force:
 *    - Time: O(n^2) (StringBuilder delete is O(n))
 *    - Space: O(n) for StringBuilder
 *
 * 2. Sorting:
 *    - Time: O(n log n)
 *    - Space: O(n) (char arrays)
 *
 * 3. HashMap:
 *    - Time: O(n)
 *    - Space: O(1) (bounded by 26 chars if lowercase, else O(k) unique chars)
 *
 * 4. Frequency Array:
 *    - Time: O(n)
 *    - Space: O(1) (fixed array of 26)
 *
 * Best Choice:
 * - If input only lowercase → Frequency Array
 * - If Unicode allowed → HashMap
 */
