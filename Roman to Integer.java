//Problem

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].

/////////////////////////////
*/


//Solution
import java.util.ArrayList;

class Solution {
    public int romanToInt(String s) {

        int result = 0;
        // create an arraylist to work with
        ArrayList<Character> list = new ArrayList<>();

        // find lenth of string
        int length = s.length();

        // add string characters to the list
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            list.add(c);

        }

        // sort the list out and figure out the value
        int x = 0;
        while (x != length) {
            if (x < length - 1) {
                if (list.get(x) == 'M') {
                    result = result + 1000;
                }

                if (list.get(x) == 'D') {
                    result = result + 500;
                }
                if (list.get(x) == 'C' && (list.get(x + 1) != 'D' && list.get(x + 1) != 'M')) {
                    result = result + 100;
                } else if (list.get(x) == 'C' && list.get(x + 1) == 'D') {
                    result = result + 400;
                    x++;
                } else if (list.get(x) == 'C' && list.get(x + 1) == 'M') {
                    result = result + 900;
                    x++;
                }
                if (list.get(x) == 'L') {
                    result = result + 50;
                }
                if (list.get(x) == 'X' && (list.get(x + 1) != 'L' && list.get(x + 1) != 'C')) {
                    result = result + 10;
                } else if (list.get(x) == 'X' && list.get(x + 1) == 'L') {
                    result = result + 40;
                    x++;
                } else if (list.get(x) == 'X' && list.get(x + 1) == 'C') {
                    result = result + 90;
                    x++;
                }
                if (list.get(x) == 'V') {
                    result = result + 5;
                }
                if (list.get(x) == 'I' && (list.get(x + 1) != 'V' && list.get(x + 1) != 'X')) {
                    result = result + 1;
                } else if (list.get(x) == 'I' && list.get(x + 1) == 'V') {
                    result = result + 4;
                    x++;
                } else if (list.get(x) == 'I' && list.get(x + 1) == 'X') {
                    result = result + 9;
                    x++;
                }
            } else {
                if (list.get(x) == 'M') {
                    result = result + 1000;
                }
                if (list.get(x) == 'D') {
                    result = result + 500;
                }
                if (list.get(x) == 'C') {
                    result = result + 100;
                }
                if (list.get(x) == 'L') {
                    result = result + 50;
                }
                if (list.get(x) == 'X') {
                    result = result + 10;
                }
                if (list.get(x) == 'V') {
                    result = result + 5;
                }
                if (list.get(x) == 'I') {
                    result = result + 1;
                }
            }
            x++;
        }

        return result;
    }
}