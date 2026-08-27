import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> tree = new TreeMap<>();

        for (String s : operations) {
            String[] parts = s.split(" ");
            String op = parts[0];
            int num = Integer.parseInt(parts[1]);

            if (op.equals("I")) {
                tree.put(num, tree.getOrDefault(num, 0) + 1);
                continue;
            }

            if (tree.isEmpty()) continue;

            int key = (num == 1) ? tree.lastKey() : tree.firstKey();
            int cnt = tree.get(key);
            if (cnt - 1 == 0) tree.remove(key);
            else tree.put(key, cnt - 1);
        }

        if (tree.isEmpty()) return new int[]{0, 0};
        return new int[]{tree.lastKey(), tree.firstKey()};
    }
}