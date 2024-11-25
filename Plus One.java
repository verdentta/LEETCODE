class Solution {
    public int[] plusOne(int[] digits) {

        /*  This problem wasn't too hard. It's mostly just using flags to figure out when you're incrementing or not.
            I did run into some problems here and there with my logic, but it's easily fixed with some debugging statements :)
            I also originally wanted to do this problem with the stringbuilder class, which is do-able. But they made the numbers incredibly
            long and tedious, so it's just better to do it this way.
            The runtime and spacetime complexity for this code is O(n) :) 
        */

        //easy base case
        if(digits.length == 1 && digits[0] != 9)
        {
            int temp = digits[0];
            digits[0] = temp + 1;
            return digits;
        }

        //let's use a flag for numbers that end in 9
        boolean nine_flag = false;

        for(int i = digits.length-1; i >= 0; i--)
        {
            // this is used to check if the next leading number is also a 9
            if(nine_flag)
            {
                if(digits[i] == 9)
                {
                    //if it is, we turn it to a zero
                    digits[i] = 0;
                }
                else
                {
                    //if not, then we just increment and break and return
                    int num = digits[i];
                    digits[i] = num + 1;
                    break;
                }
            }
            // this is to check if the first number isn't a 9, if it isn't then just increment and return
            if(digits[digits.length-1] != 9 && nine_flag == false)
            {
                int temp = digits[i];
                digits[i] = temp + 1;
                break;
            }
            //this is basically the first check to see if it's a 9, if so, turn to zero and set nine flag to check if others are nines
            if(digits[digits.length-1] == 9 && nine_flag == false)
            {
                nine_flag = true;
                digits[i] = 0;

            }
            //if the number grows, we make a new array with size pplus one :)
            if(digits[0] == 0)
            {
                int [] new_digits = new int [digits.length + 1];
                new_digits[0] = 1;
                for(int j = 1; j < new_digits.length; j++)
                {
                    new_digits[j] = digits[j -1];
                }
                return new_digits;
            }

        }
        return digits;

    }
}