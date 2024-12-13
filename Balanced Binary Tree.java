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
    public boolean isBalanced(TreeNode root) {

        /* As usual, whenever I deal with a tree problem, my code is terribly long and inefficient. I guess this just means
           that I need to really work on understanding how trees work and how I can optimize it better. So my idea on how to solve is that
           I only how to figure out the height of each node, so I just basically put that into a nested loop and compare each left and right 
           subtrees of each node and see if it is height balanced. If it is not, then return false. Otherwise true!
           In terms of efficieny, the time complexity is at worst O(n) simply because i am using Stacks and Stack pairs and those will grow
           linearly depending on how big the input is. For time complexity, it will be at worst O(n^2) simply because of the nested
           while loops and the many traversals I'm doing due to it.
        */

        //base case
        if(root == null || (root.left == null && root.right == null))
        {
            return true;
        }
        //initialize our root to curr
        TreeNode curr = root;

        //create our treenode pair to track height
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

        //create a stack to track our nodes since we have to figure out the height of each node
        Stack<TreeNode> stack_node = new Stack<>();

        //push the first node
        stack_node.push(curr);
        
        while(!stack_node.isEmpty())
        {
            int max_depth_left = 0;
            int max_depth_right = 0;

            TreeNode current = stack_node.pop();

            if(current.left != null)
            {
                TreeNode curr_left = current.left;

                stack.push(new Pair<>(current.left, 0));
                while(!stack.isEmpty())
                {
                    Pair<TreeNode, Integer> cur = stack.pop();
                    TreeNode node = cur.getKey();
                    int depth = cur.getValue();

                    if(node.right != null)
                    {
                        stack.push(new Pair<>(node.right, depth + 1));
                    }
                    if(node.left != null)
                    {
                        stack.push(new Pair<>(node.left, depth + 1));
                    }

                    max_depth_left = Math.max(max_depth_left, depth);
                }
            }
            else
            {
                max_depth_left = -1;
            }

            if(current.right != null)
            {
                TreeNode curr_right = current.right;

                stack.push(new Pair<>(current.right, 0));
                while(!stack.isEmpty())
                {
                    Pair<TreeNode, Integer> cur = stack.pop();
                    TreeNode node = cur.getKey();
                    int depth = cur.getValue();

                    if(node.right != null)
                    {
                        stack.push(new Pair<>(node.right, depth + 1));
                    }
                    if(node.left != null)
                    {
                        stack.push(new Pair<>(node.left, depth + 1));
                    }

                    max_depth_right = Math.max(max_depth_right, depth);
                }
            }
            else
            {
                max_depth_right = -1;
            }

            //check at every level of nodes to see if it is height balanced\
            int total = Math.abs(max_depth_right - max_depth_left);
            System.out.println(max_depth_right  + " " + max_depth_left + " " + total);

            if(Math.abs(max_depth_right - max_depth_left) > 1)
            {
                return false;
            }

            if(current.left != null)
            {
                stack_node.push(current.left);
            }

            if(current.right != null)
            {
                stack_node.push(current.right );
            }

        }
        return true;
    }
}