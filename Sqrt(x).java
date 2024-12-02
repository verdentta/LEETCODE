class Solution {
    public int mySqrt(int x) {

        /* This is just a math problem. You just do loops in every place values till you get very close 
           and then you just use floor function to return it. Super Easy! 
           The time complexity for this is O(root(x)) cause that's the only significant time it takes for the first loop and the 
           spacetime complexity is O(1) because you're not allocating any new space to the memory for this function. 
        */

        boolean whole_number = false;

        double y = 0.0;
        for(int i =0; i <= x; i++)
        {
            if( y * y == x)
            {
                return (int) y;
            }

            if(y * y > x )
            {
                y = y - 1.0;dd
                break;
            }
            y = y + 1.0;
        }

        for(int i =0; i <= 9; i++)
        {
            if( y * y == x)
            {
                return (int) y;
            }

            if(y * y > x )
            {
                y = y - 0.1;
                break;
            }
            y = y + 0.1;
        }

        for(int i =0; i <= 9; i++)
        {
            if( y * y == x)
            {
                return (int) y;
            }

            if(y * y > x )
            {
                y = y - 0.01;
                break;
            }
            y = y + 0.01;
        }

        y = Math.floor(y);
        System.out.println(y);


        return (int) y;

       


        
    }
}