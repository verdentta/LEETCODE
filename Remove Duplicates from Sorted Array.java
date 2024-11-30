import java.util.ArrayList;
class Solution {
    public int removeDuplicates(int[] nums) {

        /*  Overall, this problem was pretty easy when it was finally understood, however the description for this problem 
            was utter trash. All they really want you to do is edit the array they give you and then return the number
            of unique elements that the array has so that they can splice the original array you edited. This was not properly
            conveyed at all! But the actual coding for this problem was overall I would as pretty easy :) 
            Both the time and space complexities for this program is O(n) which is decent efficiency!
        */

        //create a dynamic list to work with and add all the unique values to
        ArrayList<Integer> list = new ArrayList<Integer>();

        //I'm going first loop through the list and change every repeated value with the exception of the first value to 404
        // to indicate that it is a repeated value (404 is an appropriate value to use since -100 <= nums[i] <= 100)
        int unique = 0;
        for(int i = 0; i < nums.length; i++)
        {   
            //set the first value as unique
            if(i == 0)
            {
                unique = nums[0];
            }
            else
            {
                if(nums[i] == unique)
                {
                    nums[i] = 404;
                }
                else
                {
                    unique = nums[i];
                }
            }
        }
        //take all the unique elements and add it to a dynamic list
        for(int i = 0; i < nums.length; i++)
        {
            if(i == 0)
            {
                list.add(nums[i]);
            }
            else
            {
                if(nums[i] != 404)
                {
                    list.add(nums[i]);
                }
                else
                {
                    continue;
                }
            }
        }
        //loop again through your dynamic list and edit the original nums array
        for(int i = 0; i < list.size(); i ++)
        {
            nums[i] = list.get(i);
        }

        return list.size();
    }
}