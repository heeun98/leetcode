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
    public TreeNode searchBST(TreeNode root, int val) {

        TreeNode cur = root;

        if (cur == null) return null;

        while (cur != null) {
            if (cur.val == val) {
                return cur;
            }

            if (cur.val < val) {
                if (cur.right == null) return null;
                cur = cur.right;
            }

            if (cur.val > val) {
                if (cur.left == null) return null;
                cur = cur.left;
            }
        }

        return null;
    }
}