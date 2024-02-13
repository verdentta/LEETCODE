class Solution 
{
    public boolean isValid(String s) 
    {
        //initialize boolean variable to track 
        boolean check = true;

        //initalize our token counters
        // we initialize these counters for each type of brace so we can track them to see if each brace is appropriately closed eventually

        StringBuilder sb = new StringBuilder();
        char lastCharacter;


        int curvyBrace = 0;
        int sqaureBrace = 0;
        int curlyBrace = 0;

        //we loop through the string and compare using charAt and each time we go through a brace, we increment or decrement appropriately

        //base case
        if(s.charAt(0) == '}' || s.charAt(0) == ']' || s.charAt(0) == ')' || s.charAt(s.length() - 1) == '(' || s.charAt(s.length() - 1) == '{' ||  s.charAt(s.length() - 1) == '[')
        {
            return false;
        }

        if(s.length() == 1)
        {
            return false;
        }
        if(s.length() % 2 != 0)
        {
            return false;
        }

        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                curvyBrace++;
                sb.append("T");
            }
            if(s.charAt(i) == '[')
            {
                sqaureBrace++;
                sb.append("S");
            }
            if(s.charAt(i) == '{')
            {
                curlyBrace++;
                sb.append("Q");
            }
            if(s.charAt(i) == ')')
            {
                curvyBrace--;
                if (sb.length() > 0) 
                {
                    lastCharacter = sb.charAt(sb.length() - 1);
                    if( lastCharacter == 'T')
                    {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    else
                    {
                        check = false;
                        break;
                    }
                }
                else
                {
                    check = false;
                    break;
                }
            }
            if(s.charAt(i) == ']')
            {
                sqaureBrace--;
                if (sb.length() > 0) 
                {
                    lastCharacter = sb.charAt(sb.length() - 1);
                    if( lastCharacter == 'S')
                    {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    else
                    {
                        check = false;
                        break;
                    }
                }
                else
                {
                    check = false;
                    break;
                }
            }
            if(s.charAt(i) == '}')
            {
                curlyBrace--;
                if (sb.length() > 0) 
                {
                    lastCharacter = sb.charAt(sb.length() - 1);
                    if( lastCharacter == 'Q')
                    {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    else
                    {
                        check = false;
                        break;
                    }
                }
                else
                {
                    check = false;
                    break;
                }
            }
        }
        
        
        //if any of the token counters is not equal to zero, meaning, there is braces there were not close appropriately or there were an odd number, then 
        //check is false
        if(curvyBrace != 0 || sqaureBrace != 0 || curlyBrace != 0)
        {
            check = false;
        }
        if(s.length() > 2)
        {

        for(int j = 0; j < s.length(); j++)
        {
            if(s.charAt(j) == '(')
            {
                if(s.charAt(j+1) == '}' || s.charAt(j+1) == ']' )
                {
                    check = false;
                    break;
                }
            }
            if(s.charAt(j) == '{')
            {
                if(s.charAt(j+1) == ')' || s.charAt(j+1) == ']' )
                {
                    check = false;
                    break;
                }
            }
            if(s.charAt(j) == '[')
            {
                if(s.charAt(j+1) == '}' || s.charAt(j+1) == ')' )
                {
                    check = false;
                    break;
                }
            }
            
        }

        }
        
        return check;
    }
}