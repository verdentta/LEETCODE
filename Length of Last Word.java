class Solution {
    public int lengthOfLastWord(String s) {

        /*  Super easy Problem to solve. Didn't have any difficulty solving this.
            The runtime complexity for this code is obviously O(n)
            The spacetime complexity for this code is O(1) because there are no additional
            data structures like arrays or lists that grow with the input size.The memory required
            for these variables is constant regardless of the size of the string s.
        */

        //So my logic for this problem is simply to start at the end of the string, and go backwards while incrementing a counter
        //when you a letter and then break when you don't see a letter anymore

        //let's do some base cases
        if(s.length() == 1 && s.charAt(0) != ' ')
        {
            return 1;
        }
        if(s.length() == 1 && s.charAt(0) == ' ')
        {
            return 0;
        }

        int counter = 0;
        for(int i = s.length()-1; i >= 0; i--)
        {
            if(s.charAt(i) == ' ')
            {
                continue;
            }
            else
            {
                counter++;
                if(i-1 >= 1)
                {
                    if(s.charAt(i-1) == ' ')
                    {
                        break;
                    }
                }
            }
        }
        return counter; 
    }
}