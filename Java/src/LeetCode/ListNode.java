package LeetCode;

public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     public void add(int val){
          if(null == next){
               next = new ListNode(val);
          }
          else{
               add(this, val);
          }
     }
     private void add(ListNode node, int val){
          if(null == node.next){
               node.next = new ListNode(val);
          }
          else{
               add(node.next, val);
          }
     }

     public void print(){
          ListNode node = this;
          while(null != node){
               System.out.print(node.val + " ");
               node = node.next;
          }
          System.out.println();
     }

}
