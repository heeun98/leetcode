class Solution {
    public int solution(String skill, String[] skill_trees) {
        int prev = -1;
        boolean flag = true;
        int count = 0;
        
        int skillIdx = 0;
        
        for (int i = 0 ; i < skill_trees.length; i++) {
            String ele = skill_trees[i];
            flag = true;
            prev = -1;
            skillIdx = 0;
            
            for (int j = 0; j < ele.length(); j++) {
                char al = ele.charAt(j);
                int idx = skill.indexOf(al);
                
               
                if (idx == -1) continue;
                if (skillIdx >= skill.length()) continue;
                
                if (idx == skillIdx) { // 여기서는 어떻게 해야할까
                    skillIdx++;
                } else {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
               
                count++;
            } 
            
        }
        
        return count;
    }
}