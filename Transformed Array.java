class Solution {
    public int[] constructTransformedArray(int[] nums) {

        int [] results = new int[nums.length];
        for(int i = 0; i< nums.length; i++)
        {
            if(nums[i] > 0)
            {
                if(i + nums[i] < nums.length && i + nums[i] >= 0)
                {
                    results[i] = nums[i + nums[i]];
                }
                else
                {
                    int temp = nums[i] + i;
                    while(temp >= nums.length)
                    {
                        temp = temp - nums.length;
                    }
                    results[i] = nums[temp];
                }
            }
                    
                
            if(nums[i] < 0)
            {
                if(i + nums[i] >= 0 && i + nums[i] < nums.length)
                {
                    results[i] = nums[i + nums[i]];
                }
                else
                {
                    int temp = nums[i] + i;
                    while(temp < 0)
                    {
                        temp = temp + nums.length;
                    }
                    results[i] = nums[temp];
                }
            }
            if(nums[i] == 0)
            {
                results[i] = nums[i];
            }
        }
        return results;
    }
    
}