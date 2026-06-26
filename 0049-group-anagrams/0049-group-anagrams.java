class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        

        Node[] nodes = new Node[strs.length];

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String newWord = new String(ch);
            nodes[i] = new Node(i, newWord);
        }


        Arrays.sort(nodes, (o1, o2) -> o1.word.compareTo(o2.word));

        String ss = "";

        // 이 과정 깔끔하게 못하나?
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(strs[nodes[0].idx]);

        for (int i = 1; i < strs.length; i++) {    
            if (nodes[i].word.equals(nodes[i - 1].word)) {
                list.add(strs[nodes[i].idx]);
            } else {
                result.add(list);
                list = new ArrayList<>();
                list.add(strs[nodes[i].idx]);
            }
        }

        result.add(list);

        return result;

    }

    static class Node {
        int idx;
        String word;

        public Node(int idx, String word) {
            this.idx = idx;
            this.word = word;
        }
    }
}