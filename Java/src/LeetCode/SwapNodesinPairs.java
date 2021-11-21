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
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if(null == head)
            return null;

        if(null == head.next)
            return head;

        // Head 유지
        ListNode tmpNode = head;
        head = head.next;
        tmpNode.next = head.next;
        head.next = tmpNode;

        ListNode parentNode = tmpNode;
        tmpNode = tmpNode.next;
        while(null != tmpNode && null != tmpNode.next){
            ListNode node = tmpNode;
            ListNode nextNode = tmpNode.next;

            parentNode.next = nextNode;
            node.next = nextNode.next;
            nextNode.next = node;

            parentNode = node;
            tmpNode = node.next;
        }

        return head;
    }
    
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        {
            head.add(2); head.add(3); head.add(4);head.add(5);head.add(6);
        }
        ListNode ret = new SwapNodesinPairs().swapPairs(head);
        ret.print();
    }
}
