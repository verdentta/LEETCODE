/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //used to set a flag to exit outer loop
        boolean exit = false;

        //point to the current heads with another variable to later use
        ListNode curr = headA;
        ListNode curr2 = headB;
        ListNode found_node = null;

        //You can probably make this more efficient by first finding which is the smaller list and starting with that

        //You essentially just double loop through both lists, comparing addresses of the node till you find a match, then break, break outer and return 

            while(curr != null)
            {
                while(curr2 != null)
                {
                    if (curr == curr2)
                    {
                        found_node = curr;
                        exit = true;
                        break;
                    }
                    if (exit) break;
                    curr2 = curr2.next;
                }
                curr2 = headB;
                curr = curr.next;
            }
        
        return found_node; 
      
    }
}