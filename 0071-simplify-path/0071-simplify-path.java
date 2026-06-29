class Solution {
    public String simplifyPath(String path) {
        
      
        String[] word = path.split("/");

        Stack<String> st = new Stack<>();

        for (String str : word) {

            if (str.isEmpty()) continue;
    
            if (str.equals(".")) {
                continue;
            }
            if (str.equals("..") && !st.isEmpty()) {
                st.pop();
                continue;
            }

            if (str.equals("..")) continue;
            st.push(str);
        }

        List<String> list = new ArrayList<>(st);

        String result = String.join("/", list);

        return "/" + result;
    
    }
}