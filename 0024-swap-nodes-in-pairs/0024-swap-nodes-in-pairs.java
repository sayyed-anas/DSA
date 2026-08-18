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

    private static void reverse(ListNode head, int times){
        ListNode curr = head;
        ListNode prev = null;

        while (times != 0){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            times--;
        }
    }

    public ListNode swapPairs(ListNode head) {
        
        if (head == null){
            return head;
        }

        ListNode left = head;
        ListNode prevLeft = null;
        ListNode right;
        ListNode nextLeft;
        ListNode res = null;
        int size = 2;

        while (true){

            right = left;

            for (int i = 0; i < (size - 1); i++){
                if (right == null){
                    break;
                }
                right = right.next;
            }

            if (right != null){
                nextLeft = right.next;
                reverse(left,size);

                if (prevLeft != null){
                    prevLeft.next = right;
                }
                prevLeft = left;

                if (res == null){
                    res = right;
                }

                left = nextLeft;
            }
            else {
                if (prevLeft != null){
                    prevLeft.next = left;
                }
                if (res == null){
                    res = left;
                }
                break;
            }
        }
        return res;
    }
}