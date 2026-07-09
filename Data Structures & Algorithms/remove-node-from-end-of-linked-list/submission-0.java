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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);   // fix 1: real placeholder node
        dummy.next = head;

        ListNode pointer1 = dummy;
        ListNode pointer2 = dummy;
        for(int i =0;i<=n;i++){
            pointer2 = pointer2.next;
            //System.out.println(pointer2.val);
        }

        while (pointer2!=null){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        pointer1.next = pointer1.next.next;

        return dummy.next;
    }
}
