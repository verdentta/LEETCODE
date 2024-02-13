import java.lang.Math;
class Solution {
    public int climbStairs(int n) {
        
        //use an iterative approach
        //this is based off the fibonacci sequence

        //initialize the variables that will carry the previous values to calculate from
        int prev1 = 2;
        int prev2 = 3;
        int fib = 0;

        //easy base cases to solve right away
        if(n <= 3)
        {
            return n;
        }

        //if base cases don't satisfy, iterate through to solve for n'
        for(int i = 3; i < n; i++)
        {
            fib = prev1 + prev2;
            prev1 = prev2;
            prev2 = fib;

        }

        //return n once found 
        return fib;
    }
}