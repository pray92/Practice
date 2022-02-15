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
public class RemoveDuplicateFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(null == head)
            return null;

        ListNode answer = head;

        ListNode prevNode = head;
        ListNode nextNode = head.next;
        while(null != nextNode){
            if(prevNode.val == nextNode.val){
                prevNode.next = nextNode.next;
            } else{
                prevNode = nextNode;
            }
            nextNode = prevNode.next;
        }

        return answer;
    }
}
