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
class Solution 
{
    public ListNode reverseList(ListNode head) 
    {
        // count variable to use for the size of the linkedlist
        int count = 0;

        //make a pointer to the head
        ListNode curr = head;

        //first figure out the size of the linkedlist
        while(curr != null)
        {
            count++;
            curr = curr.next;
        }
        
        //count should now have the size of the linkedlist

        //re-initialize or point curr as the head again
        curr = head;

        //make a temporary array to store the values from the linked list
        int [] temp = new int [count];
        for(int i = 0; i < count; i++)
        {
            temp[i] = curr.val;
            curr = curr.next;
        }

        //re-initialize or point curr as the head again
        curr = head;


        //loop again and go through the linkedlist via updating along with the array with the new values and you're done :) 
        for(int j = count-1; j >= 0; j--)
        {
            curr.val = temp[j];
            curr = curr.next;
        }
        
        return head;


    }
}