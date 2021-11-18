package LeetCode;
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

/*
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1 && null == l2)
            return null;

        ListNode retNode = new ListNode();
        ListNode node = retNode;
        while(null != l1 && null != l2){
            if(l1.val <= l2.val){
                retNode.val = l1.val;
                l1 = l1.next;
            }else{
                retNode.val = l2.val;
                l2 = l2.next;
            }

            retNode.next = new ListNode();
            retNode = retNode.next;
        }
        while(null != l1){
            retNode.val = l1.val;
            l1 = l1.next;

            if(null == l1)
                break;

            retNode.next = new ListNode();
            retNode = retNode.next;
        }
        while(null != l2){
            retNode.val = l2.val;
            l2 = l2.next;

            if(null == l2)
                break;

            retNode.next = new ListNode();
            retNode = retNode.next;
        }
        return node;
    }
}
 */
