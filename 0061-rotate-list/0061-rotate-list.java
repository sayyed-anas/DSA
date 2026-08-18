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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null){
            return head;
        }

        int totalNodes = 1;
        ListNode lastNode = head;

        while (lastNode.next != null){
            totalNodes++;
            lastNode = lastNode.next;
        }

        k = k % totalNodes;

        if (k == 0){
            return head;
        }

        ListNode t = head;
        int count = 1;

        while (t != null){
            if (count == (totalNodes - k)){
                break;
            }
            count++;
            t = t.next;
        }

        ListNode headNode = t.next;
        lastNode.next = head;
        t.next = null;

        return headNode;
    }
}