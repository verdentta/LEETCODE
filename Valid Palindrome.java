class Solution {
    public boolean isPalindrome(String s) {

        /* Easy problem where you simply just filter out the string and then do a loop to determine if it's a palindrome 
           or not. This problem is more of a test to see how well you can use the built in functions to determine validity.
           The space and time complexity for this problem is both O(n) since you're only using one loop to read and create memory.
        */

        //first convert all characters to lowercase
        s = s.toLowerCase();

        //remove all spaces
        s = s.replace(" ", "");

        //next we'll remove all characters that are not alphabet characters or numbers.
        String final_string = "";
        for(int i = 0; i < s.length(); i++)
        {
            char temp = s.charAt(i);
            if(Character.isLetter(temp) || Character.isDigit(temp))
            {
                String str = String.valueOf(temp);
                final_string = final_string.concat(str);
            }
        }
        //now all we have to do is loop and figure out if each character matches both ways
        int count = final_string.length()-1;
        for(int i = 0; i < final_string.length(); i++)
        {
            char front = final_string.charAt(i);
            char back = final_string.charAt(count);

            if(front != back)
            {
                return false;
            }
            count--;
        }
        return true;
    }
}