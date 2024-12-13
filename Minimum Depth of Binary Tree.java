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
    public int minDepth(TreeNode root) {

        /* Overall, this is probably the easiest tree problem I have ever done so far! 
           I do have to give credit though to the other tree problems i've done because the solution to this problem is pretty much
           the same as the other tree problems where i have to determine the height. To determine the height, i basically used a treenode
           pair along with an integer to keep track and from there, i pretty much updated the depth with that pair value with math.min
           everytime it reached a leaf node. 
           The spacetime and runtime complexity for this code is both O(n) :) 
        */

        //initial base cases 
        if(root == null)
        {
            return 0;
        }
        if(root.left == null && root.right == null)
        {
            return 1;
        }
        
        //let's create a queue that is also a Pair that has TreeNode and Integer(integer to track the depth)
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();

        //initalize the root as curr
        TreeNode curr = root;

        //push the root onto the stack
        stack.add(new Pair<>(curr, 1));

        //initialize our depth tracker with a high value so it takes the minimum when comparing
        int depth = 999999;

        //create a while loop to traverse the tree and find min depth
        while(!stack.isEmpty())
        {
            Pair<TreeNode, Integer> current = stack.poll();
            TreeNode node = current.getKey();
            int value = current.getValue();

            if(node.left != null)
            {
                stack.add(new Pair<>(node.left, value + 1));
            }
            if(node.right != null)
            {
                stack.add(new Pair<>(node.right, value + 1));
            }
            if(node.left == null && node.right == null)
            {
                depth = Math.min(depth, value);
            }

            //added this line to make it faster
            if(depth <= value)
            {
                break;
            }
            
        }

        return depth;

    }
}