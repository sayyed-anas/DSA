/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    Stack<TreeNode> asc = new Stack<>();
    Stack<TreeNode> desc = new Stack<>();

    private TreeNode getSmall(){

        TreeNode small = null;

        small = asc.peek();
        asc.pop();

        TreeNode rightChild = small.right;

        while (rightChild != null){

            asc.push(rightChild);
            rightChild = rightChild.left;
        }

        return small;
    }

    private TreeNode getBig(){

        TreeNode big = desc.peek();
        desc.pop();

        TreeNode leftChild = big.left;

        while (leftChild != null){

            desc.push(leftChild);
            leftChild = leftChild.right;
        }

        return big;
    }     

    public boolean findTarget(TreeNode root, int k) {
        
        TreeNode l = root;
        TreeNode r = root;

        while (l != null){
            asc.push(l);
            l = l.left;
        }

        while (r != null){
            desc.push(r);
            r = r.right;
        }

        TreeNode i = getSmall();
        TreeNode j = getBig();

        while (i != null && j != null && i != j && i.val < j.val){

            int sum = i.val + j.val;

            if (sum == k){
                return true;
            }
            else if (sum > k){
                j = getBig();
            }
            else {
                i = getSmall();
            }
        }

        return false;
    }
}