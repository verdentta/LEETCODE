class Solution {
    public String addBinary(String a, String b) {

        /*  Overall, this problem wasn't really hard, just super tedious at times. So the idea to solve this problem is
            do binary addition using strings, concatenate as follows, then you have to reverse it since when you concatenate, it does so 
            in the wrong order for the binary representation. That's pretty much it! You essentially loop through both strings
            do binary additions, reverse it, and return it :)
            Both time and space complexities are O(n). 
        */

        int max_len = Math.max(a.length(), b.length());

        String big ="";
        String small ="";
        if(a.length() >= b.length())
        {
            big = a;
            small = b;
        }
        else
        {
            big = b;
            small = a;
        }

        int diff = big.length() - small.length();
        //code works well to here ----

        //do some binary math
        boolean carry = false;
        String return_val = "";
        String binary_big ="";
        String binary_small ="";
        for(int i = big.length()-1; i >= 0; i--)
        {
            if(diff == 0)
            {
                binary_small = Character.toString(small.charAt(i));
            }
             if(diff > 0)
            {
                if(i-diff < 0)
                {
                    binary_small = "0";
                }
                else
                {
                    binary_small = Character.toString(small.charAt(i-diff));
                }
            }

            
            binary_big = Character.toString(big.charAt(i));
            System.out.println(binary_big + "  " + binary_small);
            if(binary_big.equals("1") && binary_small.equals("0"))
            {
                if(carry)
                {
                    return_val = return_val.concat("0");
                    carry = true;
                    
                }
                else
                {
                    return_val = return_val.concat("1");
                }
            }
            if(binary_big.equals("0") && binary_small.equals("1"))
            {
                if(carry)
                {
                    return_val = return_val.concat("0");
                    carry = true;
                    
                }
                else
                {
                    return_val = return_val.concat("1");
                    
                }
            }
            if(binary_big.equals("0") && binary_small.equals("0"))
            {
                if(carry)
                {
                    return_val = return_val.concat("1");
                    carry = false;
                    
                }
                else
                {
                    return_val = return_val.concat("0");
                }
            }
            if(binary_big.equals("1") && binary_small.equals("1"))
            {
                if(carry)
                {
                    return_val = return_val.concat("1");
                    carry = true;
                    
                }
                else
                {
                    return_val = return_val.concat("0");
                    carry = true;
                }
            }

            if(i == 0 && carry == true)
            {
                return_val = return_val.concat("1");
               

            }

        }
        String reverse ="";
        for(int i = return_val.length()-1; i >= 0; i--)
        {
            reverse = reverse.concat(Character.toString(return_val.charAt(i)));
        }
        return reverse;
        
    }
}