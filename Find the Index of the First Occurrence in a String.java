class Solution {
    public int strStr(String haystack, String needle) {
        
        /* Overall, this problem wasn't that bad. A lot of debugging statements were needed to figure out why some loops weren't running
           properly and why some conditions weren't met at times. It's largely due to how the indices were being tracked as I've noticed.
           The space complexity for this program is O(1) since no new memory is being created, you're simply reading the memory and that's 
           about it. For runtime, there is a double nested loop, but since i'm not iterating over each and every indice and instead cutting it
           in half since i'm only iterating on the characters that have matching first and last characters it's going to be O(m*n). 
        */

        //base cases
        if(haystack.length() < needle.length())
        {
            return -1;
        }
        if(haystack.length() == needle.length())
        {
            //just loop and check
            for(int i = 0; i < needle.length(); i++)
            {
                if(needle.charAt(i) != haystack.charAt(i))
                {
                    return -1;
                }
            }
            return 0;
        }

        //complex cases
        int indice= 0;
        for(int i = 0; i < haystack.length()-needle.length()+1; i++)
        {
            char first = haystack.charAt(i);
            char second = haystack.charAt(i + (needle.length() - 1));
            
            if(first == needle.charAt(0) && second == needle.charAt(needle.length()-1))
            {
                int count = 0;
                for(int j = i; j < i + needle.length(); j++)
                {
                    if(haystack.charAt(j) == needle.charAt(count))
                    {

                        count++;
                    }
                }
                if(count == needle.length())
                {
                    indice = i;
                    break;
                }
            }
            else
            {
                indice = -1;
            }         
        }
        return indice;

    }
}