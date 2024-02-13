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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        //base case
        if (list1 == null && list2 == null) 
        {
            return null; // Both lists are empty, return null
        }

        // initialize the linkedlist with the appropriate heads
        ListNode head1 = list1;
        ListNode head2 = list2;

        //initalize head and current pointers of the merged list
        ListNode merged = null;
        ListNode current = null;

            while (head1 != null && head2 != null) 
            {



                    //check if the first list item is less than or equal to the first list item for the second list
                    if(head1.val <= head2.val)
                    {
                        // since the initialized node for merged listnode is set to null, we need to update it by pointing to head1
                        if(merged == null)
                        {
                            //assigned address of head1 to merged as the head essentially
                            merged = head1;
                            //assign the address of merged to current to work with 
                            current = merged;

                            //have head1 go to the next node since the node we just were on is initialized already as the head so it's not null
                            head1 = head1.next;
                        }
                        else
                        {
                            // have current point to head1 node
                            current.next = head1;
                            //have current move to the pointed node 
                            current = current.next;

                            //have head1 go to the next node since the node in the list since we just visited the current head1 node
                            head1 = head1.next;
                        }

                    }
                    else
                    {
                        // since the initialized node is set to null, we need to update it by pointing to head2
                        if(merged == null)
                        {
                            //assigned address of head2 to merged as the head essentially
                            merged = head2;
                            //assign the address of merged to current to work with 
                            current = merged;

                            //have head2 go to the next node since the node we just were on is initialized already as the head so it's not null
                             head2 = head2.next;
                        }
                        else
                        {
                            //have current point to head2 node
                            current.next = head2;
                            //have current move to the pointed node 
                            current = current.next;

                            //have head2 go to the next node since the node in the list since we just visited the current head2 node
                             head2 = head2.next;
                        }

                    }

                
            }

        //attach the remaining nodes that are available after comparing
        if (current != null) 
        {
            current.next = (head1 != null) ? head1 : head2;
        } 
        else 
        {
            merged = (head1 != null) ? head1 : head2;
        }


        

        return merged;

        
        
    }
}