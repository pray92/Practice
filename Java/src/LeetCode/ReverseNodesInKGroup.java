// 21:40
package LeetCode;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(null == head || null == head.next || k == 1)
            return head;

        ListNode lastNode = head;
        ListNode nextPeriodNode = getNode(head, k + 1);
        ListNode ret = getReversedNode(head, k);

        lastNode.next = nextPeriodNode;

        ListNode curNode = nextPeriodNode;
        while(null != curNode){
            ListNode prevNode = lastNode;
            lastNode = curNode;
            nextPeriodNode = getNode(curNode, k + 1);

            ListNode reversedNode = getReversedNode(curNode, k);
            if(null == reversedNode)
                break;

            prevNode.next = reversedNode;
            lastNode.next = nextPeriodNode;

            curNode = nextPeriodNode;
        }


        return ret;
    }

    /**
     *
     * @param head
     * @return reverse 이후 첫번째 노드
     */
    ListNode getReversedNode(ListNode head, int k){
        if(null == head)
            return null;

        if(1 == k)
            return head;

        ListNode curNode = head;
        for(int i = 1; i <= k; ++i){
            if(null == curNode)
                return null;
            curNode = curNode.next;
        }

        ListNode prevNode = null;
        curNode = head;
        ListNode nextNode = null;
        for(int i = 1; i <= k ; ++i){
            nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }
        head.next = null;
        return prevNode;
    }

    ListNode getNode(ListNode head, int k){
        if(null == head)
            return null;

        ListNode node = head;
        for(int i = 1; i < k; ++i){
            if(null == node)
                return null;
            node = node.next;
        }

        return node;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        {
            head.add(2); head.add(3);
            head.add(4); head.add(5); head.add(6); head.add(7);
        }
        head = new ReverseNodesInKGroup().reverseKGroup(head, 1);
        head.print();
    }
}
