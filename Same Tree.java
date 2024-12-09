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
    public boolean isSameTree(TreeNode p, TreeNode q) 
    {
        /* Definitely could've made code shorter. I simply created lists to essentially record the structure and values in a specific 
           way so that when I did BFS, if the structure was different, it would be evident when comparing the arraylist and same for the 
           values as well. 
           Since the time complexity and space complexity were both O(n), I kept the code as thee same :) 
        */
        //base cases
        if (p == null && q == null )
        {
            return true;
        }
        if (p == null && q != null || p != null && q == null )
        {
            return false;
        }

        //create arraylists to use to create lists to store the structure of the tree and the values of the tree in a order
        List<Integer> tree_1 = new ArrayList<>();
        List<Integer> tree_2 = new ArrayList<>();

        List<Integer> num_1 = new ArrayList<>();
        List<Integer> num_2 = new ArrayList<>();

        //we will use a queue to set an order so that when we read it in a specific way, it will be unique to that structure and values only
        Queue<TreeNode> track = new LinkedList<>();
        track.add(p);

        //loop through and define and store the structure arraylist and value arraylist
        int temp = p.val;
        num_1.add(temp);
        tree_1.add(1); 
        while(!track.isEmpty())
        {
               //denotes the root

            TreeNode node = track.poll();
            
             if(node.left != null)
             {
                track.add(node.left);
                tree_1.add(2); 

                num_1.add(node.left.val);
             }
             else
             {
                tree_1.add(100000);  //sentinel value to denote that it is null
                num_1.add(100000);
             }
             if(node.right != null)
             {
                System.out.println("reached here!");

                track.add(node.right);
                tree_1.add(3);
                num_1.add(node.right.val);
             }
             else
             {
                tree_1.add(100000);  //sentinel value to denote that it is null
                num_1.add(100000);
             }


        }
        //do the same for the second tree
        Queue<TreeNode> track_2 = new LinkedList<>();
        track_2.add(q);

        temp = q.val;
        num_2.add(temp);
        tree_2.add(1); 
        while(!track_2.isEmpty())
        {
               //denotes the root

            TreeNode node = track_2.poll();
            
             if(node.left != null)
             {
                track_2.add(node.left);
                tree_2.add(2); 

                num_2.add(node.left.val);
             }
             else
             {
                tree_2.add(100000);  //sentinel value to denote that it is null
                num_2.add(100000);
             }
             if(node.right != null)
             {
                System.out.println("reached here!");

                track_2.add(node.right);
                tree_2.add(3);
                num_2.add(node.right.val);
             }
             else
             {
                tree_2.add(100000);  //sentinel value to denote that it is null
                num_2.add(100000);
             }


        }
        //compare all 4 lists together and determine if they're the same or not
        if (num_1.equals(num_2) == true && tree_1.equals(tree_2) == true) {
            return true;
        }
        return false;

    }
}