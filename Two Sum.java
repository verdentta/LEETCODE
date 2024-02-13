class Solution {
    public int[] twoSum(int[] nums, int target) {

        //initialize the array to store our result later
        int result[] = new int[2];

        //we're going to use a double loop as a way to compare and check our conditions to see if both indices are hitting the target
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = 0; j < nums.length; j++)
            {
                //if both pointers are pointing to the same indicee, we break out of this inner loop so the outter loop points at a different indicee 
                if(i == j)
                {
                    break;
                }
                //otherwise we compare to check our condition
                else
                {
                    //if the target is hit, return the indices by adding it to the array and returning it :)
                    if(nums[i] + nums[j] == target)
                    {
                        result[1] = i;
                        result[0] = j;
                        return result;
                    }
                }
            }
        }
        return result;       
    }
}