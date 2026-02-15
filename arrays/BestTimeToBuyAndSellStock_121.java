public class BestTimeToBuyAndSellStock_121 {


/**
 * Approach:
 * Simple approach to calculate the best time to buy and sell.
 * For maximum profit we need to buy stock at lowest price and sell where the sell is greater than buy.
 * The first day is the stock we purchased so we compare with that price isnt there any other day which is lower than the current?
 * For that we need to keep two things update - first we find the lowest buy point along with that we compare the profit which is i - minBuy
 * 
 * 
 * Time Complexity: O(n)
 *  - We iterate once through the array.
 *  - Math.max and Math.min operations O(1).
 *
 * Space Complexity: O(1)
 *  - No extra space is used except variables.
 *
 * Brute Force Complexity:
 *  - Time: O(n^2)
 *  - Space: O(1)
 */


    public static int Bruteforce(int[] prices) {
        int profit = 0;
        for(int i =0; i < prices.length; i++){
            for(int j = i+1; j < prices.length; j++){
                if(prices[i] < prices[j] && prices[j] - prices[i] > profit)  {
                    profit = prices[j] - prices[i];
                }
            }
        }
        return profit;
    }

    public static int Optimized(int[] prices) {
        int minBuy = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > minBuy){
                profit = Math.max(profit, prices[i] - minBuy);
            }
            minBuy = Math.min(prices[i], minBuy);
        }
        return profit;
    }       

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        System.out.println("Bruteforce Result: " + Bruteforce(prices));
        System.out.println("Optimized Result: " + Optimized(prices));
    }
}