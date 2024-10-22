//had a hard time solving this one, had to use extra resources on xor

class Solution {
    public int singleNumber(int[] nums) {
        
        //base case 
        if(nums.length == 1)
        {
            return nums[0];
        }

        //initialize the temp array to work with
        int[] temp = new int[1];
        int var = 0;
        
        //loop to compare with
        for(int i = 0; i < nums.length; i++)
        {
            var = var ^ nums[i]; 
            
        }
        //return statement
        return var;
    }
}

