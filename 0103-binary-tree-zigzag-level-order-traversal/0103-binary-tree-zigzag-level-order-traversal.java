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
        boolean leftRight = true;

        while(!q.isEmpty()){

            int lvlSize = q.size();
            List<Integer> tmp = new ArrayList<>(
                Collections.nCopies(lvlSize, 0)
            );

            int first = 0;
            int last = tmp.size() - 1;

            while(lvlSize-- != 0){

                TreeNode t = q.peek();
                q.poll();

                if (leftRight == true){
                    tmp.set(first, t.val);
                    first++;
                }
                else {
                    tmp.set(last, t.val);
                    last--;
                }
                
                if (t.left != null){
                    q.offer(t.left);
                }
                if (t.right != null){
                    q.offer(t.right);
                }
            }
                
            leftRight = !leftRight;
            res.add(tmp);
        }

        return res;
    }
}