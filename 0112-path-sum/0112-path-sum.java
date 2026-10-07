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

    boolean res = false;

    private void rootToLeaf (TreeNode node, int targetSum, int sum){

        if (node == null || res){
            return;
        }

        sum = sum + node.val;

        if (node.left == null && node.right == null){
            if (sum == targetSum){
                res = true;
                return;
            }
        }

        rootToLeaf(node.left, targetSum, sum);
        rootToLeaf(node.right, targetSum, sum);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {

        rootToLeaf(root, targetSum, 0);

        return res;  
    }
}