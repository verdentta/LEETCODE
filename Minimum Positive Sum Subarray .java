class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        

        /*  Probably the worst code I've written so far. I tried implementing sliding window algorithm but I totally messed it up.
            I mean you live and learn! I might redo this problem but I actually like looking at how horrible my solutions are
            so that when I slowly get better at this, I can see the progress. :) 
            The runtime complexity for this code is O(n^3) (worst case scenario) which is probably the worst I've done so far!
            And it's the same for space complexity too!
        */

        //base case O(n)
        int lowest = 999999999;
        if(l == 1 && r == 1)
        {
             for(int i = 0; i < nums.size(); i++)
             {
                if(nums.get(i) > 0)
                {
                    lowest= Math.min(nums.get(i), lowest);
                }
            
             }

             if(lowest <= 0 || lowest == 999999999)
             {
                return -1;
             }
             
             else
             {
                return lowest;
             }
        }
        
        int lowest_num = 99999999;
        
        //let's try to the sliding window approach. The approach is basically having two pointers and you can essentially
        //slide the window as you iterate through in order to find whatever you're looking for.

        //initialize the pointers
    

        //first loop is to increment through the different window sizes
        while(l <= r)
        {
            int left_pointer = 0;
            int right_pointer = l-1;
            int total = 0;

            //second loop is to increment through all the values
            for(int i = 0; i < nums.size(); i++)
            {
                //third loop is to increment through the specific window size and add the values
                int count = 0;
                for(int j = i; j <= right_pointer && j < nums.size(); j++)
                {
                    
                    total+= nums.get(j);
                    count++;
                }
                if(total > 0 && count == l)
                {
                    lowest_num = Math.min(lowest_num, total);
                }
                count = 0;
                total = 0;
                right_pointer++;

            }
            l++;
        }
        if(lowest_num == 99999999)
        {
            lowest_num = -1;
        }
        return lowest_num;
        
    }
}