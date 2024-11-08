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
    public boolean isPalindrome(ListNode head) {

        ListNode curr = head;

        //first figure out the size of the linkedlist to determine if it's even or odd number of elements
        //to do this we simple use a while loop to loop through till we hit null

        int counter = 0; // initialize our counter
        Stack<Integer> stack = new Stack<>(); // let's make a stack to work with later in the loops

        while(curr !=null)
        {
            counter++;
            curr = curr.next;
        }

        curr = head; //re-initialize the pointer back to the head after counting so we could use it later


        if(counter % 2 == 0)
        {
            for(int i = 0; i < counter/2; i++)
            {
                stack.push(curr.val);
                curr = curr.next;
            }

            for(int i = 0; i < counter/2; i++)
            {
                int val = stack.pop();
                if(curr.val == val)
                {
                    curr = curr.next;
                    continue;
                }
                else
                {
                    return false;
                }
            }
        }   
        else
        {
            for(int i = 0; i < counter/2; i++)
            {
                stack.push(curr.val);
                curr = curr.next;
            }
            curr = curr.next;                           // we skip the middle value since the list is odd and will have a midde value
            for(int i = 0; i < counter/2; i++)
            {
                
                int val = stack.pop();
                if(curr.val == val)
                {
                    curr = curr.next;
                    continue;
                }
                else
                {
                    return false;
                }
            }
        }
        
        return true;

        //final notes: The way I did this is by first figuring out if the size of the list is even or odd, then i used stacks to push and pop out the 
        // linkedlist values and compared it for if it's a palindrome or not.
        //When it was even, i simply compared each value with the first and second half 
        //but when it was odd, i had to skip the middle value since it didn't matter
        //This code has a time complexity of O(n) and space complexity of O(n) as well :) 
    }
}