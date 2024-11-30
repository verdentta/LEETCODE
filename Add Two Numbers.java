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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        

        /* Overall, this problem wasn't super hard. Just tedious. It was just a matter of setting appropriate 
            flags at the right moments and then doing the correct calculations. The only hiccup I had was 
            recreating the Listnode structure from the arraylist solution that i generated. I didn't know
            how to correctly loop and plug in the arraylist items in a linkedlist. I DO NOW :) 
            This code definetly could've been written better in my humble opinion. 
            It operates at both runtime and spacetime O(n).
            There were a couple of other ways I could've approached this to make it more efficient but since it was a medium
            level difficulty problem, I went with comfort. 
        */

        ArrayList<Integer> col = new ArrayList<Integer>();
        
        //first figure out which is the bigger list
        int l1_size = 0;
        int l2_size = 0;

        ListNode head1 = l1;
        ListNode head2 = l2;
        while(head1 != null)
        {
            l1_size++;
            head1 = head1.next;
        }

         while(head2 != null)
        {
            l2_size++;
            head2 = head2.next;
        }
        head1 = l1;
        head2 = l2;

        //set head to the bigger list to head
        if(l1_size >= l2_size)
        {
            head1 = l1;
            head2 = l2;
        }
        else
        {
            head1 = l2;
            head2 = l1;
        }

        int temp = 0;
        boolean carry_counter = false;
        while(head1 != null)
        {
            //everytime you loop, check the carry_counter flag, if flagged,set temp to 1
            if(carry_counter)
            {
                temp = 1;
                carry_counter = false;
            }

            //do a null check and the calculate
            if(head2 != null)
            {
                int second_val = head2.val;
                int first_val = head1.val;
                temp = temp + first_val + second_val;
            }
            else
            {
                int second_val = 0;
                int first_val = head1.val;
                temp = temp + first_val + second_val;
            }

            //after adding the two values, if it's greater or equal to 10, then -10 
            if(temp >= 10)
            {
                carry_counter = true;
                temp = temp - 10;
            }

            //add to queue
            col.add(temp);
            
            //the worst case where we have to expand our list because it grew
            if(carry_counter && head1.next == null)
            {
                col.add(1);
            }

            
            //increment to the next values in the list
            head1 = head1.next;
            if(head2 != null && head2.next != null)
            {
                head2 = head2.next;
            }
            else
            {
                head2 = null;
            }

            //reset temp
            temp = 0;

        }

        //create a new listnode using loops and iterate through your list of return values into the listnode 

        //set the head and tail
        ListNode head = null, tail = null;

        for(int values : col)
        {
            ListNode node = new ListNode(values);
            if(head == null)
            {
                head = node;
                tail = node;
            }
            else
            {
                tail.next = node;
                tail = node;
            }
        }

        System.out.println(col);

        return head;
        
    }
}