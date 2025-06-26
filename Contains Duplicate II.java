class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        /* Decided to do the next duplicate problem since I was already warmed up to it. The way you should've solved this problem was by using both
         * hashsets and sliding window algo, but I decided to go with hashmaps since it's similar to tree problems in a way since you're technically tracking
         * two things at a time and for that, hashmaps are perfect for it since you can have one Integer be for tracking indices while the other for the actual value
         * The solution's runtime speed is O(n) because you're just looping once and
         * for space-time complexity, pretty much the same idea as runtime but you're only storing n elements 
         * in the worst case scenario, hence it would be O(n) as well. 
         */
        
        //fastest and best way to deal with this is to use a hashmap that also tracks indices
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) 
        {
            if (map.containsKey(nums[i])) 
            {
                //check to see if it is <= k
                if(Math.abs(map.get(nums[i]) - i) <= k)
                {
                    return true;
                }
                else
                {
                    map.put(nums[i], i);
                }
            } 
            else 
            {
                map.put(nums[i], i); // Store the value and its index
            }
        }

        return false;
    }
}