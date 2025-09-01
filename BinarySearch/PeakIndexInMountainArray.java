public class PeakIndexInMountainArray {

    // Function to find the peak index in a mountain array using Binary Search
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < arr[mid + 1]) {
                // We are in the increasing slope
                start = mid + 1;
            } else {
                // We are in the decreasing slope (or at the peak)
                end = mid;
            }
        }

        // start == end → peak index
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 4, 6, 5, 3, 1};
        int peakIndex = peakIndexInMountainArray(arr);
        System.out.println("Peak index: " + peakIndex);
        System.out.println("Peak value: " + arr[peakIndex]);
    }
}

/*
-------------------------------
📘 Dry Run Example
Input: arr = [0, 2, 4, 6, 5, 3, 1]

Step 1: start=0, end=6
        mid=(0+6)/2=3 → arr[3]=6, arr[4]=5
        arr[mid] > arr[mid+1] → decreasing → end=3

Step 2: start=0, end=3
        mid=(0+3)/2=1 → arr[1]=2, arr[2]=4
        arr[mid] < arr[mid+1] → increasing → start=2

Step 3: start=2, end=3
        mid=(2+3)/2=2 → arr[2]=4, arr[3]=6
        arr[mid] < arr[mid+1] → increasing → start=3

Step 4: start=3, end=3 → loop exits

✅ Peak Index = 3
✅ Peak Value = 6
-------------------------------

📌 Explanation:
- A mountain array first increases, then decreases.
- If arr[mid] < arr[mid+1], it means we are still climbing the mountain → move right (start = mid + 1).
- If arr[mid] >= arr[mid+1], we are on the decreasing slope (or at the peak) → move left (end = mid).
- Eventually, start == end, which gives the index of the peak element.

⏱ Time Complexity: O(log n)   → because of binary search
📦 Space Complexity: O(1)      → only pointers used
-------------------------------
*/
