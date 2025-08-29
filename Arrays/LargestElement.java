public class LargestElement {

    //Time Complexity -> O(n)
    public static void main(String[] args) {
        int [] numbers = {1,2,9,4,5};
        int num = largestNumber(numbers);
        System.out.println("Largest number is "+ num);
    }

    public static int largestNumber(int [] numbers){
        int max = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
}
