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

    TreeNode prev = null;
    boolean ans = true;

    private void isValid(TreeNode node){

        if (node == null){
            return;
        }

        isValid(node.left);

        if (prev == null){
            prev = node;
        }
        else {
            if (prev.val >= node.val){
                ans = false;
            }
            prev = node;
        }

        isValid(node.right);
    }
    public boolean isValidBST(TreeNode root) {
        
        isValid(root);
        return ans;
    }
}