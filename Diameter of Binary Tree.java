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
    public int diameterOfBinaryTree(TreeNode root) {

        //start with base cases
        if (root == null)
        {
            return 0;
        }
        //base case of when the tree only has one node
        if(root.left == null && root.right == null)
        {
            return 0;
        }
        
        int max_length = 0;

        //okay so the idea is to find the max depth as usual but along the way, you want to find the max depth of each node
        // so starting at root node, find depth, then proceed deeper into other nodes, and find depth again, 
        //get max of each node accordingly till you traverse through each node and find depth.
        //this will gaurantee you that you're always going to get the max length path from node to node
        //This code is written in O(n^2) which is horrible
        //so def redo this problem later 
        //but it works :) 

        Stack<TreeNode> trace_stack = new Stack<>();
        trace_stack.push(root);
        while (!trace_stack.isEmpty())
        {
            TreeNode trace_node = trace_stack.pop();
            
            //let's make a stack pair first to determine the depth of each side of the tree
            //the integer part is to help track the length
            //the plan here is to find the depth of the right tree, left tree and add accordingly to get the maximum diameter  
            Stack<Pair<TreeNode, Integer>> stack = new Stack<>();


            int maxDepth = 0;
            //do a null check to see if a left tree exists
            if(trace_node.left != null)
            {

                // Start with the left node and find depth
                stack.push(new Pair<>(trace_node.left, 1)); // Start with the left node of root node at length 1

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
            }


            int maxDepth2 = 0;
            if(trace_node.right != null)
            {

        
                //re-initialize it to the right node of the root and find depth
                stack.push(new Pair<>(trace_node.right, 1));

                while (!stack.isEmpty()) 
                {
                    Pair<TreeNode, Integer> current = stack.pop();
                    TreeNode node = current.getKey();
                    int depth = current.getValue();

                    // Update max depth if the current depth is higher
                    maxDepth2 = Math.max(maxDepth2, depth);

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

            }

            int total = maxDepth + maxDepth2;
            
            max_length = Math.max(max_length, total);

            if (trace_node.left != null) 
            {
                trace_stack.push(trace_node.left);
            }
            if (trace_node.right != null) 
            {
                trace_stack.push(trace_node.right);
            }

        }

        return max_length; 

            

    }
}