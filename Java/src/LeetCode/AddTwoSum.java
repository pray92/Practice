package LeetCode;

import java.math.BigInteger;

public class AddTwoSum {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(null == l1 && null == l2)
            return new ListNode(0);

        ListNode answer = new ListNode();
        ListNode tmpNode = answer;
        int nextUp = 0;
        while(null != l1 || null != l2){
            if(null != l1){
                tmpNode.val += l1.val;
                l1 = l1.next;
            }
            if(null != l2){
                tmpNode.val += l2.val;
                l2 = l2.next;
            }

            if(nextUp > 0) {
                tmpNode.val += nextUp;
            }

            if(tmpNode.val >= 10){
                nextUp = tmpNode.val / 10;
                tmpNode.val %= 10;
            }
            else{
                nextUp = 0;
            }

            if(null != l1 || null != l2){
                tmpNode.next = new ListNode();
                tmpNode = tmpNode.next;
            }
        }

        if(nextUp > 0){
            tmpNode.next = new ListNode();
            tmpNode.next.val = nextUp;
        }

        return answer;
    }

    public static void main(String[] args){
        AddTwoSum sol = new AddTwoSum();

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        /*l2.next.next = new ListNode(4);*/

        var ans = sol.addTwoNumbers(l1, l2);
    }
}
