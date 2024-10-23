class Solution {
    public int majorityElement(int[] nums) {
        

        //inspired by boyer moore's algorithm of having a candidate and a counter and incrementing or decrementing the counter
        // if you see the same element again, if not, do the same for the next element

        int temp =  0;  
        int counter = 1;  
         
        for(int i = 0; i < nums.length; i++)
        {
            //initalize the first candidate if temp is 0
            if( temp == 0)
            {
                temp = nums[i];
                continue;
            }
           if(temp == nums[i])
           {
            counter++;  
           }
           else
           {
             counter--;  
           }

           if(counter == 0)
           {
            temp = nums[i];
            counter = 1;
            
           }
        }
        return temp; 

    }
}