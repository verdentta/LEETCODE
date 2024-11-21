class Solution {
    public List<List<Integer>> generate(int numRows) {


        /*I found this problem pretty easy to solve, at first I thought of doing it recursively since pascal's triable is known
          to be dealt in a recursive way. But then I sort of worked around it and figured out that you can easily do it 
          iteratively since it's much more efficient. Even though both the recursive and iterative ways both have the same runtime
          complexity of O(n^2), the iterative approach is more efficient because it has less overhead compared to the recursive way :)

          So how did I solve it iteratively? Simply manipulate the lists. All you are really doing is adding the numbers between it, taking the sum
          and creating a new list out of it and also adding a 1 at the beginning and end of the new list. Pretty easy! 
        */
        
        //outputlist
        List<List<Integer>> outer_list = new ArrayList<>();

        //base case lists
        List<Integer> base_case_1 = new ArrayList<>();
        List<Integer> base_case_2 = new ArrayList<>();

        //base case #1
        base_case_1.add(1);

        //base case #2
        base_case_2.add(1);
        base_case_2.add(1);

        if(numRows == 1)
        {
            outer_list.add(base_case_1);
            return outer_list;
        }
        if(numRows == 2)
        {
            outer_list.add(base_case_1);
            outer_list.add(base_case_2);
            return outer_list;
        }

        //if not base cases, we then add the base case lists to the outerlists and manipulate using loops for future lists to be add
        //to the outerlist
        outer_list.add(base_case_1);
        outer_list.add(base_case_2);

        //list manipulation 
        if(numRows > 2)
        {
            for(int i = 0; i < numRows - 2; i++)
            {
                List<Integer> temp_list = new ArrayList<>();
                List<Integer> new_list = new ArrayList<>();
                temp_list = base_case_2;
                for(int j = 0; j < temp_list.size(); j++)
                {
                    //do a null check 
                    if(j < temp_list.size()-1)
                    {
                        int a = temp_list.get(j);
                        int b = temp_list.get(j+1);
                        int result = a + b;
                        new_list.add(result);
                    }
                }
                new_list.add(0,1);
                new_list.add(1);
                base_case_2 = new_list;
                outer_list.add(new_list);
            }
        }
        return outer_list;
    }
}