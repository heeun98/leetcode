class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) return root;

        TreeNode parent = null;
        TreeNode find = null;

        TreeNode cur = root;

        while (cur != null) {

            if (cur.val == key) {
                find = cur;
                break;
            }

            parent = cur;

            if (cur.val > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        if (find == null) return root;

        if (find.left == null || find.right == null) {

            TreeNode child = (find.left != null) ? find.left : find.right;

            if (parent == null) return child;

            if (parent.left == find) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            return root;
        }

        TreeNode succParent = find;
        TreeNode succ = find.right;

        while (succ.left != null) {
            succParent = succ;
            succ = succ.left;
        }

        find.val = succ.val;

        if (succParent == find) {
            succParent.right = succ.right;
        } else {
            succParent.left = succ.right;
        }

        return root;
    }
}