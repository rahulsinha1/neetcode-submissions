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
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode current = new ListNode(-1);
        current.next = head;

        while(current !=null && current.next!=null){

            if(set.contains(current.next)){
                return true;
            }
            set.add(current.next);
            current = current.next;
        }
        return false;
    }
}
