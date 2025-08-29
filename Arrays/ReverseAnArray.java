public class ReverseAnArray {

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};

        // Reverse array using Brute Force approach
        int [] reversedArraybyBruteForce = reverseArrayByBruteForce(arr);
        System.out.println("reversedArraybyBruteForce");
        for (int num : reversedArraybyBruteForce) {
            System.out.print(num + " ");
        }

        System.out.println("");
        System.out.println("");
        System.out.println("");

        // Reverse array using Two Pointers approach (in-place)
        int [] reversedArraybyTwoPointers = reversedArraybyTwoPointers(arr.clone()); 
        // used clone() so original 'arr' is not permanently modified
        System.out.println("reversedArraybyTwoPointers");
        for (int num : reversedArraybyTwoPointers) {
            System.out.print(num + " ");
        }

    }

    // ✅ Optimal Method: Reverse array in-place using two pointers
    // Time Complexity: O(n), Space Complexity: O(1)
    public static int [] reversedArraybyTwoPointers(int[] arr){
        int n = arr.length;
        int start = 0;        // pointer at beginning
        int end = n - 1;      // pointer at end

        // Keep swapping elements until start and end cross
        while(start < end){
            // Swap values at start and end indexes
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // Move pointers towards the center
            start++;
            end--;
        }
        return arr; // return the reversed array
    }

    // ✅ Brute Force Method: Use an extra array
    // Time Complexity: O(n), Space Complexity: O(n)
    public static int [] reverseArrayByBruteForce(int[] arr){
        int n = arr.length;
        int [] temp = new int[n]; // extra array of same size

        // Copy elements from arr into temp in reverse order
        for(int i = 0; i < n; i++){
            temp[i] = arr[n - 1 - i];
        }

        return temp; // return the reversed array
    }
}
