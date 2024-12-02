class Solution {
    public boolean checkIfExist(int[] arr) {

        /* Super easy coding problem that can be solved using loops. Just double loop and compare, that's it.
           Problem is solved at O(n^2) for runtime which isn't bad at all because the cases only go up to 2 <= arr.length <= 500
           and spacetime is only O(1) because you're just reading the array and not really allocating space for anything.
        */
        for(int i = 0; i < arr.length; i++)
        {
            int temp = arr[i] * 2;
            for(int j = 0; j < arr.length; j++)
            {
                if( i == j)
                {
                    continue;
                }
                else
                {
                    if(temp == arr[j])
                    {
                        return true;
                    }
                    
                }
            }
        }
        return false;
        
    }
}