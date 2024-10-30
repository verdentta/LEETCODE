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
    public int maxDepth(TreeNode root) {

    /**
    *  Just a side note, I had to use util.pair to create a stack that had both treenode and depth values so that 
    *  i can keep track of the depth while traversing through the nodes
    *  and return when it reached max depth
    *  each node has it's own depth value to track
    */
        //base case of when the tree has no nodes;
        if (root == null)
        {
            return 0;
        }
        //base case of when the tree only has one node
        if(root.left == null && root.right == null)
        {
            return 1;
        }

    Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
    stack.push(new Pair<>(root, 1)); // Start with the root node at depth 1

    int maxDepth = 0;
    while (!stack.isEmpty()) 
    {
        Pair<TreeNode, Integer> current = stack.pop();
        TreeNode node = current.getKey();
        int depth = current.getValue();

        // Update max depth if the current depth is higher
        maxDepth = Math.max(maxDepth, depth);

        // Add children to the stack with depth increased by 1
        if (node.left != null) 
        {
            stack.push(new Pair<>(node.left, depth + 1));
        }
        if (node.right != null) 
        {
            stack.push(new Pair<>(node.right, depth + 1));
        }
    }
    return maxDepth;
        
    }   
}