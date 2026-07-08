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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //Now split into two, first half may be bigger than 2nd. 

        ListNode list1 = head;
        ListNode list2 = slow.next;
        slow.next = null;


        //Reverse the 2nd list
        ListNode prev = null;
        ListNode current = list2;
        while(current!=null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        list2 = prev;

        //Now create a result node

        while (list1!=null && list2!=null){
            ListNode l1Next = list1.next;
            ListNode l2Next = list2.next;

            list1.next = list2;
            list2.next = l1Next;

            list1 = l1Next;
            list2 = l2Next;
        }
    }
}
