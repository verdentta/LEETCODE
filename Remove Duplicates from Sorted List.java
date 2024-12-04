/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        /* Was not hard at all, probably one of the cleaniest codes I've written so far. Very short and efficient! 
           The idea is simple, loop through the list till null, while doing so, keep a pointer that saves the previous node
           while checking each node to see if it is the same value as the previous node value. If so, update pointers accordinlgy.
           Time and Space complexity for this code is O(n) because you're only looping once and O(1) because you're just reading
           the values from a list and editing it only and not creating any more space in memory. :) 
        */

        ListNode curr = head;
        ListNode save = head;

        while(curr != null)
        {
            if(curr == head)
            {   
                curr = curr.next;
                continue;
            }
            if(curr.val != save.val)
            {
                save.next = curr;
                save = curr; 
            }
            if(curr.val == save.val && curr.next == null)
            {
                save.next = null;
            }
            curr = curr.next;
        }
        return head;
    }
}