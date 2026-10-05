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

    private static void inOrder(TreeNode node, List<Integer> list){

        if (node == null){
            return;
        }

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
    public boolean findTarget(TreeNode root, int k) {
        
        List<Integer> res = new ArrayList<>();

        inOrder(root, res);

        int left = 0;
        int right = res.size() - 1;

        while (left < right){

            int sum = res.get(left) + res.get(right);

            if (sum == k){
                return true;
            }
            else if (sum > k){
                right--;
            }
            else {
                left++;
            }
        }

        return false;
    }
}