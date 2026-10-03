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
    public TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode newNode = new TreeNode(val);
        TreeNode cur = root;
        if (cur == null) {
            root = newNode;
            return root;
        }

        while (true) {
            if (cur.val < val) {
                if (cur.right == null) {
                    cur.right = newNode;
                    break;
                }
                cur = cur.right;
            } else {
                if (cur.left == null) {
                    cur.left = newNode;
                    break;
                }
                cur = cur.left;
            }
        }

        return root;
    }
}