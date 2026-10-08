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

    private void validate(TreeNode node, List<Integer> list){

        if (node == null){
            return;
        }

        validate(node.left, list);
        list.add(node.val);
        validate(node.right, list);
    }

    public boolean isValidBST(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();

        validate(root, list);

        for (int i = 0; i < list.size() - 1; i++){

            if (list.get(i) >= list.get(i+1)){
                return false;
            }
        }

        return true;
    }
}