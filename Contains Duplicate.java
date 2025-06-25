class Solution {
    public boolean containsDuplicate(int[] nums) {

        /* Back again. This problem was pretty challenging if you don't know how to use a hashset/table. So learning hashsets and practising 
         * on this problem was a good intro to hashsets in general. Besides that, once you know how hashsets work, the way this data structure is designed
         * solving this problem is superrrr easy.
         * The solution's runtime speed is O(n) because you're just looping once and all the operations for hashsets are pretty much O(1) for 
         * for when you're doing checks and adding. For space-time complexity, pretty much the same idea as runtime but you're only storing n elements 
         * in the worst case scenario, hence it would be O(n) as well. 
         */

        //fastest and best way to deal with this is to use a hashset
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++)
        {
            //do a check to see if it exists in the hashset
            if(set.contains(nums[i]))
            {
                   return true;
            }
            else
            {
                 set.add(nums[i]);
            }
            
        }

        return false;
        
    }
}