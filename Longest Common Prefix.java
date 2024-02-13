class Solution {
    public String longestCommonPrefix(String[] strs) {
    

    //find length of array of strings
    int length = strs.length;

    //define a base case

   if (length == 1) {
        return strs[0]; // Return the single string in the array
    }

     String foutput = "";
     String output = "";
    
     


    //begin traverse through array using loop
    //this will traverse the first item with the rest with another loop inside
    for(int i = 0; i < 1; i++)
    {   
        //start declaring each string with it's own variable
        String firstString = strs[0];

        //initialize a repeat counter for strings that are all the same
        int repeatCount = 1;

        for(int j = 1; j < length; j++)
        {
            //start declaring each string with it's own variable
            String comparedString = strs[j];
        

           //if each and every string is the same, we continue out of the loop and say the finaloutput would just be the first string
            if(firstString.equals(comparedString))
            {
                //here we initialize a counter to keep track of strings that are all the same
                repeatCount++;
                //here we say that if the amount of strings that are the same are equal to the length of the array
                //then the finaloutput for prefix is the same as any string.
                if(repeatCount == length)
                {
                    foutput = firstString; 
                }
                continue;
            }

            //otherwise, find the commonprefix between the two strings that are declared previously
            output = findCommonPrefix(firstString, comparedString);

            //if the output returns from the method as "", that means the first two strings had no common prefix which means the rest is negligible so 
            // no point in continuing the loop, so a break must happen here and output for the whole array would be ""
            if(output == "")
            {
                foutput = "";
                break;
            }

            //if the final output is empty but output is not, then let foutput be output
            if(foutput.equals("") && !output.equals(""))
            {
                foutput = output;
            }
            //otherwise if foutput isn't empty and output isn't also not empty, then compare the two again to get the prefix among them
            else if(!foutput.equals("") && !output.equals(""))
            {
                foutput = findCommonPrefix(foutput, output);
            }

        }
        
    }

    return foutput;

    }
    public static String findCommonPrefix(String str1, String str2)
    {
            String output = "";
            String firstString = str1;
            String comparedString = str2;

            //condition to satisfy the empty case
            if(firstString.isEmpty() || comparedString.isEmpty())
            {
                return "";
            }

            //find the shortest length of both strings
            int firstStringLength = firstString.length();
            int comparedStringLength = comparedString.length();

            //use the shortest length string value to create the next loop to iterate over both strings to find the prefix
            int lengthToLoop = 0;
            if(firstStringLength >= comparedStringLength)
            {
                lengthToLoop = comparedStringLength;
            }
            else
            {
                lengthToLoop = firstStringLength;
            }

            //loop again now to traverse through the characters of both firstString and comparedString using lengthToLoop
            //initialize character values
            char f;
            char c;

            //first see if the first  character is the same with the rest, if it isn't, then it is not a prefix at all!
            if(firstString.charAt(0) != comparedString.charAt(0))
            {
                output = "";
            }
            //traverse and build the prefrix using the loop
            else
            {
                //problem with this loop is that it builds on same characters but doesn't add on appropriately after the first prefix
                
                for(int h = 0; h < lengthToLoop; h++)
                    {
                        f = firstString.charAt(h);
                        c = comparedString.charAt(h);
                        //if both characters are the same
                        if(f == c)
                        {
                            output = output + f; 
                        }
                        else
                        {
                            break;
                        }

                    }
            }
            return output; 
    }
}

