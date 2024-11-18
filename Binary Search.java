class Solution {
    public int search(int[] nums, int target) {    

        //implements binary search from my own understanding of it
        //wasn't that hard, just tedious at times
        //stop stalking my code bro :P lol jk idc 

        boolean found = false;

        //define min and max for binary search
        int min = 0;
        int max = nums.length - 1; 

        //make an index variable;
        int index = 0;

        //base case
        if(nums.length == 1)
        {
            if (target == nums[0])
            {
                return 0;
            }
            else
            {
                return -1;
            }
        }

        while(found == false)
        {
            index = (min + max) / 2;
            if(target == nums[index])
            {
                break;
            }
            else if(target > nums[index])
            {
                min = index+1;
                
                
            }
            else if(target < nums[index])
            {
                max = index -1;
                //cannot have max be negative so im doing a negative check here
                if(max < 0)
                {
                    max = 0;
                }
            }
            if(min == max)
            {
                index = min;
                if(target == nums[index])
                {
                    break;
                }
                index = -1;
                break;
            }
        }
        return index;
    }
}