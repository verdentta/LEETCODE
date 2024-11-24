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
    public TreeNode invertTree(TreeNode root) {


        /* Overall, this problem was a little hard since I first was originally trying to solve this problem by only
           swapping the values only which was entirely wrong! I then later learned that you actually had to swap the structure
           itself in order to properly solve it. I also learned how useful queues are when solving binary tree problems.
           Normally I used stacks to solve linkedlist or tree problems but queue work in a similar manner and are also very
           useful in key situations like this. Since I was processing the nodes level by level in order to swap, I had to do 
           BFS. And since I was  doing BFS, I had to work in a manner where I was processing the nodes by FIFO manner.
           Stacks is best used when doing DFS which utilizes LIFO which isn't really great for processing nodes level by level. 
        */

        //no tree base case
        if(root == null)
        {
            return root;
        }

        //let's use a queue this time, instead of a stack
         Queue<TreeNode> queue = new LinkedList<>();

        // Start with the root node in the queue
         queue.add(root); 

        while(!queue.isEmpty())
        {
            
            //remove the first node from the queue
            TreeNode current = queue.poll();
            TreeNode clone_1;
            TreeNode clone_2;

            //process the left and right subtrees
            if(current.left != null)
            {
                clone_1 = current.left;
            }
            else
            {
                clone_1 = null;
            }
            if(current.right != null)
            {
                clone_2 = current.right;
            }
            else
            {
                clone_2 = null;
            }
            
            //this is where we swap the structure by pointing it in reverse
            current.left = clone_2;
            current.right = clone_1;
            
            //after we swap the structure, we then add the children to process further 
            if(current.left != null)
            {
                queue.add(current.left);
            }
            if(current.right != null)
            {
                queue.add(current.right);
            }

        }

        return root;
    }
}