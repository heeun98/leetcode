class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

       for (int i = 0; i < strs.length; i++) {

            String tmp = strs[i];
            char[] ch = strs[i].toCharArray();

            Arrays.sort(ch);

            String str = new String(ch);

            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(tmp);
       }

        return new ArrayList<>(map.values());

    }


}