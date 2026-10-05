/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null){
            return ans;
        }

        if (root.val == p.val || root.val == q.val){
            ans = root;
            return ans;
        }
        else if (root.val < p.val && root.val < q.val){
           lowestCommonAncestor(root.right, p, q); 
        }
        else if (p.val < root.val && q.val < root.val){
            lowestCommonAncestor(root.left, p, q);
        }
        else {
            ans = root;
        }
     
        return ans;
    }
}