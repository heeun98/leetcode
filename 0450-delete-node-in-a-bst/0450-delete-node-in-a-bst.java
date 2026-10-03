class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) return root;

        TreeNode cur = root;
        TreeNode parent = null;          // ✅ 부모 추적용 변수 추가
        TreeNode find = null;

        while (cur != null) {
            if (cur.val == key) {
                find = cur;
                break;
            }

            parent = cur;                // ✅ 내려가기 전에 현재 노드를 부모로 저장

            if (cur.val > key) {
                cur = cur.left;
            } else {                     // ✅ if → else
                cur = cur.right;
            }
        }

        if (find == null) return root;   // ✅ 못 찾은 경우를 루프 밖에서 처리

        // ✅ 자식 0~1개: 지역 변수 대신 parent의 참조를 바꿈
        if (find.left == null || find.right == null) {
            TreeNode child = (find.left != null) ? find.left : find.right;

            if (parent == null) {        // ✅ 루트 삭제 → 남은 자식이 새 루트
                return child;
            }

            if (parent.left == find) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            return root;
        }

        // 자식 2개: 기존 코드 그대로
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