public class SmallestElement {

    //Time Complexity -> O(n)
    public static void main(String[] args) {
        int [] numbers = {1,2,9,4,5};
        int num = smallestNumber(numbers);
        System.out.println("Smallest number is "+ num);
    }

    public static int smallestNumber(int [] numbers){
        int min = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

}
