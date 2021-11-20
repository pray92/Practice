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
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length <= 0)
            return null;

        ListNode ret = null, lastNode = null;
        ListNode ret2 = null;
        while(true){
            int minValue = Integer.MAX_VALUE;
            int minNodeIndex = 0;
            boolean isEmpty = true;
            for(int i = 0; i < lists.length; ++i){
                if(lists[i] == null)
                    continue;

                int value = lists[i].val;
                if(minValue > value) {
                    minValue = value;
                    minNodeIndex = i;
                    isEmpty = false;
                }
            }

            if(isEmpty)
                break;

            // If it's first time
            if(null == ret){
                ret = new ListNode();
                ret2 = ret;
            }

            ret.val = minValue;
            ret.next = new ListNode();
            lastNode = ret;
            ret = ret.next;

            lists[minNodeIndex] = lists[minNodeIndex].next;
        }

        if(null != lastNode)
            lastNode.next = null;

        return ret2;
    }
}
