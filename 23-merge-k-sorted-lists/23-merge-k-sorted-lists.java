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
    public ListNode mergeKLists(ListNode[] lists) {
        
        Comparator<ListNode> cmp=new Comparator<ListNode>()
        {
            @Override
            public int compare(ListNode l1,ListNode l2)
            {
                return l1.val-l2.val;
            }
        };
        
        PriorityQueue<ListNode> pq=new PriorityQueue<ListNode>(cmp);
        
        for(ListNode l:lists)
        {
            if(l!=null)
            {
                pq.add(l);
            }
        }
        
        ListNode head=new ListNode(0);
        ListNode point=head;
        
        while(!pq.isEmpty())
        {
            point.next=pq.poll();
            point=point.next;
            ListNode next=point.next;
            if(next!=null)
            {
                pq.add(next);
            }
        }
        
        return head.next;
        
    }
}