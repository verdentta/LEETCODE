/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {

        //let's use an arraylist to compare and see if it's symmetric
        List<Integer> myList = new ArrayList<>();

        //let's also use a stack to work and create in order traversal
        Stack<TreeNode> stack = new Stack<>();

        TreeNode clone;
        TreeNode clone2;
        clone = root;
        clone2 = root;

        //base case
        if(root == null)
        {
            return false;
        }
        //This should create a list from inorder traversal
        else
        {
            while(root != null || !stack.isEmpty())
            {
                while(root != null)
                {
                    stack.push(root);
                    root = root.left;
                }

                root = stack.pop();
                myList.add(root.val);
                root = root.right;
            }
        } 

        //first check the list if it has an odd number of nodes. If it has even number, then it's not symmetric
        if(myList.size() % 2 == 0)
        {
            return false;
        }

        //otherwise we check if the first value matches with the last value then the second value matches the second last value, etc. 
        for(int i = 0; i <= myList.size() / 2; i++)
        {
            if (!myList.get(i).equals(myList.get(myList.size() - 1 - i))) 
            {
                return false;
            }
            else
            {
                continue;
            }
            
        }

        //now check if the nodes are places symmetrically structured
        //So they way I solved this in figuring out if the structure of the left subtree and the right subtree are the same by 
        //counting how many times it can go left in a row for the left subtree and counting how many times it can go right
        //in a row for the right sub trees. If both counters match up, they should have the same structure. You can make this as complex as you want for more
        //complex cases but for the sake of this problem, this would suffice. 
        int counter1 = 0;
        int counter2 = 0;

        while(clone != null)
        {
            clone = clone.left;
            counter1++;
        }
        while(clone2 != null)
        {
            clone2 = clone2.right;
            counter2++;
        }
        if(counter1 != counter2)
        {
            return false;
        }
        


        return true;
    }
}