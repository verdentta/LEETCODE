class Solution {
    public List<Integer> getRow(int rowIndex) {

        /* I did Pascal's Triangle(the first problem) and I found it extremely easy to do and 
           doing the second one wasn't that hard either. I just did it exactly the same way I solved it before
           but for this one, it's less work, you're just building only one main list, re-using each row you build in each
           iteration to build for the next row and return when you have found rowIndex.
           Time complexity is O(n^2) simply because it's a double loop to figure out the rowIndex. For space complexity
           it's O(n) because you're only tracking the current row. You never store memory of the previous row and you're only
           focused on the current iteration row. Therefore, the solution only maintains one list (temp), whose size is proportional
           to the input rowIndex + 1, and doesn't use any additional memory that scales with n^2.(The memory grows linearly in each iteration)
        */

        List<Integer> temp = new ArrayList<>();

        //base case#1
        List<Integer> base_case_1 = new ArrayList<>();
        base_case_1.add(1);
        if(rowIndex == 0)
        {   
            return base_case_1;     
        }
        //base case#2
        List<Integer> base_case_2 = new ArrayList<>();
        base_case_2.add(1);
        base_case_2.add(1);
        if(rowIndex == 1)
        {   
            return base_case_2;     
        }
        //if it's greater than the base cases, just manipulate the list as you iterate through
        //by re-using the previous row in each new iteration and updating the list
        temp = base_case_2;
        if(rowIndex > 1)
        {
            for(int i = 0; i <= rowIndex - 2; i++)
            {
                List<Integer> return_list = new ArrayList<>();
                for(int j = 0; j < temp.size(); j++)
                {
                    //do a null check
                    if(j < temp.size()-1)
                    {
                        int first = temp.get(j);
                        int second = temp.get(j+1);
                        int total = first + second;
                        return_list.add(total);
                    }
                }

                return_list.add(0,1);
                return_list.add(1);
                temp = return_list;
            }
        }



        return temp;
        
    }
}