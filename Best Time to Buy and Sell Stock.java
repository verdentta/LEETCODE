class Solution {
    public int maxProfit(int[] prices) {
        /*  
            The bread and butter to this problem is just tracking the minimum price. That's it :) 
            Initially this code ran at O(n^2) but thanks to leetcode and how they give you cases up to prices.length <= 105
            O(n^2) will time out so you have to optimize further :)

            As I said before, you essentially have to track the minimum price, then check accordiningly to see if you have 
            maximum profit. As you iterate through, if you find a minimum price lower than before, update accordingly and 
            check the maximum profit. You essentially iterate like this through the whole list and return max profit. :) 
        */

        //base case #1
        if(prices.length == 1)
        {
            return 0;
        }

        //base case # 2
        if(prices.length == 2)
        {
            if(prices[0] > prices[1])
            {
                return 0;
            }
            else
            {
                return prices[1] - prices[0];
            }
        }

        int profit = 0;
        int max_profit = 0;
    
        int min = prices[0];

        int price = 0;
        int day = 0;

         for(int i = 0; i < prices.length; i++)
         {
            if(min >= prices[i] && i != prices.length-1)
            {
                min = Math.min(min, prices[i]);
                price = min;
                day = i;
            }

            if(price < prices[i] && day < i)
            {
                profit = prices[i] - price;
                max_profit = Math.max(max_profit, profit);
            }
         }
        
        return max_profit; 
    }
}