class Solution {

    int[] dr = {1, -1};
    int[] dc = {0,  1};

    public String convert(String s, int numRows) {

        if (numRows == 1) return s;
        
        char[][] gr = new char[numRows][s.length() * 2];
        int row = 1;
        int col = 0;

        gr[0][0] = s.charAt(0);
        int count = 0;
        int down = 1;

        for (int i = 1; i < s.length(); i++) {
            // 4 - 1 = 3
            if (row < numRows - 1 && down == 1) {
                gr[row][col] = s.charAt(i);
                row++;
                count++;
                continue;
            }

            if (row == numRows - 1 && down == 1) {
                down = 0;
                gr[row][col] = s.charAt(i);
                col++;
                row--;
                continue;
            }

            if (row > 0 && down == 0) {
                gr[row][col] = s.charAt(i);
                col++;
                row--;
                continue;
            }

            if (row == 0 && down == 0) {
                down = 1;
                gr[row][col] = s.charAt(i);
                row++;
            }
        }

        String answer = "";

        for (int i = 0; i < gr.length; i++) {
            for (int j = 0; j < gr[i].length; j++) {
                
                if (gr[i][j] != 0) {
                    answer += gr[i][j];
                }
            }
            
        }
       

        return answer;
    }

   
}