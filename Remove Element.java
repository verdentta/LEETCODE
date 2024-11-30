class Solution {
    public int removeElement(int[] nums, int val) {
        
        /* Super easy problem to solve. Not much to talk about. Just iterate and re-organize everything using an extra array,
            that's pretty much it! Not much complex thinking involved to be honest.
            The code runs fast at O(n) for both runtime and space complexity!
            This could have been better solved using pointers which I might redo later on!
        */

        //first figure out how many elements are not val
        int counter = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if( nums[i] != val)
            {
                counter++;
            }
        }

        //then make a separate array to put all the values that are not val 
        int [] array = new int [counter];

        //iterate and add into the new array
        int count = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if( nums[i] != val)
            {
                array[count] = nums[i];
                count++;
            }
        }

        //take the new array and iterate into the old array and store back the values that are not equating 
        //to val into the beginning indices. This is basically how you're shifting the values.
        for(int i = 0; i < counter; i++)
        {
            nums[i] = array[i];
            
        }

        return counter;
    }
}