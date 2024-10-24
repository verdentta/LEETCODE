class Solution {
    public void moveZeroes(int[] nums) {
        
        //first run a loop to determine how many zeros exist in the array
        int counter = 0;
        int temp = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
                counter++;
            }
        }
        //now we sort accordingly using a double for loop with how many zeros we have thanks to the counter
        for(int k = 0; k < counter; k++)
        {
            for(int j = 0; j < nums.length -1; j++)
            {
                //if it's a zero, just keep swapping
                if( nums[j] == 0)
                {
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        } 
    }
}