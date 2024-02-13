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
    public List<Integer> inorderTraversal(TreeNode root) {
        

        //let's use an arraylist to return the list
        List<Integer> myList = new ArrayList<>();

        //let's use a stack to be more efficient
        Stack<TreeNode> stack = new Stack<>();


        TreeNode clone;
        //base case
        if(root == null)
        {

            return myList;
        }
        else
        {
            //if root is not null or the stack isn't empty, we loop
            while(root != null || !stack.isEmpty())
            {
                //we make an inner loop to keep pushing to the left most node
                while(root != null)
                {
                    //keep adding to the stack while we traverse to the leftmost node
                    stack.push(root);
                    root = root.left;
                }
                //once we hit the left most node, we jump back to the parent node of it and loop again with the inner loop to find the leftmost node
                root = stack.pop();
                //add the leftmost node to the list
                myList.add(root.val);
                //now go traverse once right then loop again to the see the leftmost node and so forth
                root = root.right;

            }
        }
        return myList;

    }
}