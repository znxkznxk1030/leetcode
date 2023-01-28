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
        ListNode head = null;
        ListNode curr = null;
        
        while (list1 != null && list2 != null) {
            ListNode next = list1.val < list2.val? new ListNode(list1.val): new ListNode(list2.val);
            
            if (list1.val < list2.val) {
                list1 = list1.next;
            } else {
                list2 = list2.next;
            }
            
            if (head == null) {
                head = curr = next;
                continue;
            }
            
            curr.next = next;
            curr = next;
        }
        
        while(list1 != null) {
            ListNode next = new ListNode(list1.val);
            
            list1 = list1.next;
            
            if (head == null) {
                head = curr = next;
                continue;
            }
            
            curr.next = next;
            curr = next;
        }
        
        while(list2 != null) {
            ListNode next = new ListNode(list2.val);
            
            list2 = list2.next;
            
            if (head == null) {
                head = curr = next;
                continue;
            }
            
            curr.next = next;
            curr = next;
        }
        
        
        return head;
    }
}