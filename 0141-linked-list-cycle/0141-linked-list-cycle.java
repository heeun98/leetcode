/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {


        ListNode cur = head;

        Set<ListNode> set = new HashSet<>();

        if (cur == null) return false;
        set.add(cur);

        while (cur.next != null) {
            cur = cur.next;
            if (set.contains(cur)) {
                return true;
            }
            set.add(cur);
        }

        return false;
        
    }
}