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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();

        if (root == null){
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftRight = false;

        while(!q.isEmpty()){

            int lvlSize = q.size();
            List<Integer> tmp = new ArrayList<>(lvlSize);

            while(lvlSize-- != 0){

                TreeNode t = q.peek();
                q.poll();

                tmp.add(t.val);
                
                if (t.left != null){
                    q.offer(t.left);
                }
                if (t.right != null){
                    q.offer(t.right);
                }
            }

            if (leftRight == true){
                Collections.reverse(tmp);
            }
                
            leftRight = !leftRight;
            res.add(tmp);
        }

        return res;
    }
}