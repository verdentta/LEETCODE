/*
Palindrome Number
Given an integer x, return true if x is a 
palindrome
, and false otherwise.

 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-231 <= x <= 231 - 1
 

Follow up: Could you solve it without converting the integer to a string?

*/

//Solution

import java.util.ArrayList;

class Solution {

    public boolean isPalindrome(int x) {

        ArrayList<Integer> list = new ArrayList<>();
        int check = x;
        int first = 0;

        // checks obvious cases
        if (x < 0) {
            return false;
        }
        if (x >= 0 && x <= 9) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        } else {
            // sorts the number into a list
            while (check != 0) {
                first = check % 10;
                if (first >= 0) {
                    list.add(first);
                    check = check / 10;
                }

            }

            // compares to see if it is a palindrome
            int size = list.size();
            for (int j = 0; j <= size; j++) {
                if (list.get(j) != list.get(size - 1)) {
                    return false;
                }
                size = size - 1;
            }
        }
        return true;
    }
}