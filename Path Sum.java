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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        

        /* I'm back!! So for the time complexity, worst case is O(n) since you have to visit every node in the worst case scenario. For 
         * space complexity, it would also be O(n) since the worst case would be the stack growing linearly to reading each node to 
         * finding the targetSum. How I solved this is by using the same technique i used for maximum depth of a tree which is by using 
         * util.pairs to track the targetSum value as i went deeper and deeper into the tree and when i hit the leaf nodes, 
         * I'd essentially just do a check.
         */

        //do some base cases:
        if (root == null)
        {
            return false;
        }
        if(root.left == null && root.right == null)
        {
            if(root.val != targetSum)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, root.val)); // Start with the root node and the root.val for key and value

        int target = targetSum;
        while (!stack.isEmpty()) 
        {
            Pair<TreeNode, Integer> current = stack.pop();
            TreeNode node = current.getKey();
            int val = current.getValue();

            // do a check whenever val is equal to target and it is a leaf child
            if(target == val && node.left == null && node.right == null)
            {
                return true;
            }

            // Add children to the stack with value increased by the next node value
            if (node.left != null) 
            {
                stack.push(new Pair<>(node.left, val + node.left.val));
            }
            if (node.right != null) 
            {
                stack.push(new Pair<>(node.right, val + node.right.val));
            }
        }

        return false;
    }
}