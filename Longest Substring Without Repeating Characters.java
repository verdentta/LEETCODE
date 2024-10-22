class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        //temporary storages
        ArrayList<String> tempstore_1 = new ArrayList<String>();
        ArrayList<String> tempstore_2 = new ArrayList<String>();

        int len_of_string = s.length(); 

        //base cases
        if(len_of_string == 0)
        {
            return 0;
        }
        if(len_of_string == 1)
        {
            return 1;
        }

        //add the first substring of string s to the temporary storage
        String temp = s.substring(0, 1); //  
        tempstore_1.add(temp); // 

        //begin comparing
        for(int i = 1; i < len_of_string; i++)
        {    
            temp = s.substring(i, i+1); // w

            int counter = 0;
            int size_of_tempstore_1 = tempstore_1.size();
            for(int j = 0; j < tempstore_1.size(); j++)
            {
                if(temp.compareTo(tempstore_1.get(j)) != 0)
                {
                    counter++;
                }
                else
                {
                    if( j > 0 )
                    {
                        for(int k = j; k> -1; k--)
                        {
                          tempstore_1.remove(k);  
                        }
                        tempstore_1.add(temp); //[b,g,r,o]
                        break;
                    }
                    else
                    {
                        tempstore_1.remove(j); //
                        tempstore_1.add(temp); //
                        break;
                    }
                }
            }

            //if the new substring is not equal to any old substrings in the arraylist, then add it
            if(counter == size_of_tempstore_1)
            {
                tempstore_1.add(temp); // [b,g,r,o,v]
            }

            if(tempstore_1.size() > tempstore_2.size())
            {
                tempstore_2.clear();
                tempstore_2.addAll(tempstore_1);
            }

                
            
        }

        return tempstore_2.size();
       
    }
}