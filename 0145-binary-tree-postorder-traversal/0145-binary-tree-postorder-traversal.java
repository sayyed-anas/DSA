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

    private static void func(TreeNode node, List<Integer> list){

        if (node == null){
            return;
        }

        func(node.left, list);
        func(node.right, list);
        list.add(node.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();

        func(root, list);

        return list;
    }
}