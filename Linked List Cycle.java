/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {


        // count variable to use for the size of the linkedlist
        int count = 0;

        //make a pointer to the head
        ListNode curr = head;

        // Create an ArrayList to hold ListNode objects
        List<ListNode> listNodes = new ArrayList<>();

        //nested loop to go through the linkedlist, add the nodes to the arraylist while the loop runs and then continuesly check while adding
        //to see if it's pointing to a node that's already been added, if it does, it's a cycle!  O(n^2) solution "Could be better"
         while(curr != null)
        {

            for (ListNode node : listNodes) 
            {
                if(node == curr)
                {
                    return true;
                }

            }
            listNodes.add(curr);
            curr = curr.next;

        }

        return false; 


        
    }
}