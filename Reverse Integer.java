class Solution {
    public int reverse(int x) {
        boolean negative_flag = false;

        /*  Even thought this problem was labeled as "medium" it honestly wasn't to me.
            It was just mostly string manipulation. Obviously, you could also do this a bit more 
            mathematically but since I was familiar with the stringbuilder class in java, I thought why not.
            The space and runtime complexity for this program is O(n^2)! Happy Coding :) 

        */

        if (x < 0) 
        {
            negative_flag = true;  // Set flag to remember if it was negative
        }

        String num = String.valueOf(x);  // Convert number to string
        StringBuilder result_num = new StringBuilder();

        for (int i = num.length() - 1; i >= 0; i--) 
        {
            //get rid of the negative symbol
            if(num.charAt(i) == '-')
            {
                continue;
            }
            String temp = Character.toString(num.charAt(i));  // Reverse digits
            result_num.append(temp);
        }

        String s = result_num.toString();  // Get the reversed string
        long return_val = Long.parseLong(s);  // Parse the reversed string into a long

        // Reapply the negative sign if needed
        if (negative_flag) 
        {
            return_val = return_val * -1;
        }

        // Check for overflow or underflow
        if (return_val > Integer.MAX_VALUE || return_val < Integer.MIN_VALUE) 
        {
            return 0;
        }

        // Cast the result to int and return
        return (int) return_val;
    }
}
