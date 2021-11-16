
package LeetCode;

import java.util.ArrayList;
import java.util.List;

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
class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();

        ListNode node = head;
        while(node != null){
            nodes.add(node);
            node = node.next;
        }

        if(nodes.size() == n){
            head = head.next;
            return head;
        }

        ListNode parentNode = nodes.get(nodes.size() - n - 1);
        ListNode deletNode = nodes.get(nodes.size() - n);
        parentNode.next = deletNode.next;
        return head;
    }
}