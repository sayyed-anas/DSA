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

    int totalSum = 0;

    private void sumRootToLeaf (TreeNode node, int currSum){

        if (node == null){
            return;
        }

        currSum = currSum * 10 + node.val;

        if (node.left == null && node.right == null){
            totalSum += currSum;
            return;
        }

        sumRootToLeaf(node.left, currSum);
        sumRootToLeaf(node.right, currSum);
    }

    public int sumNumbers(TreeNode root) {
        
        sumRootToLeaf(root, 0);

        return totalSum;
    }
}