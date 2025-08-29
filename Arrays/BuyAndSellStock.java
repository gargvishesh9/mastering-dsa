/**
 * Best Time to Buy and Sell Stock (LeetCode 121)
 *
 * Problem:
 *  You are given an array where price[i] represents the stock price on day i.
 *  You can complete only one transaction:
 *      → Buy on one day
 *      → Sell on a later day
 *
 * Task:
 *  Find the maximum profit you can achieve. If no profit is possible, return 0.
 *
 * Approach:
 *  - Track the minimum price (buyingPrice) as we move through the array.
 *  - At each day (price[i]), check:
 *      → If selling today gives more profit than previous max, update maxProfit.
 *      → If today's price is lower than buyingPrice, update buyingPrice.
 *
 * Why this works:
 *  Profit = sellingPrice - buyingPrice
 *  To maximize profit, we need the smallest buyingPrice before a higher sellingPrice.
 *
 * Time Complexity: O(n)  (single pass through prices)
 * Space Complexity: O(1) (only two variables)
 */

public class BuyAndSellStock {

    public static void main(String[] args) {
        int[] price = {7, 1, 5, 3, 6, 4};
        int maxProfit = buyAndSellStock(price);
        System.out.println("Max profit is " + maxProfit); // Expected: 5 (Buy at 1, Sell at 6)
    }

    public static int buyAndSellStock(int[] price) {
        int n = price.length;

        int maxProfit = 0;                   // Stores the maximum profit found so far
        int buyingPrice = Integer.MAX_VALUE; // Keeps track of the lowest price seen so far (best day to buy)

        for (int i = 0; i < n; i++) {
            // If current price is greater than the lowest buyingPrice → potential profit
            if (buyingPrice < price[i]) {
                int profit = price[i] - buyingPrice;   // Profit if sold today
                maxProfit = Math.max(maxProfit, profit);
            } else {
                // Found a new lower price → better buying opportunity
                buyingPrice = price[i];
            }
        }
        return maxProfit;
    }
}
