import java.util.*;


class Solution {
    
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    int result = Integer.MAX_VALUE;
    
    public int solution(int[][] board, int r, int c) {
      
        boolean[] seen = new boolean[7];
        int pair = 0;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int num = board[i][j];
                if (board[i][j] == 0) continue;
                if (seen[num]) continue;
                seen[num] = true;
                pair++;
            }
        }
        
        dfs(board, r, c, pair, 0);
        
        
        
        return result;
    }
    
    private void dfs(int[][] board, int row, int col, int pair, int sum) {
        
        if (pair == 0) {
            result = Math.min(result, sum);
            return;
        }
        
        for (int number = 1; number <= 6; number++) {
            
            int[] a = null;
            int[] b = null;
            
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == number) {
                        if (a == null) a = new int[]{i, j};
                        else b = new int[]{i, j};
                    }
                }
            }
            
             if (b == null) continue;
            
            
            for (int t = 0; t < 2; t++) {
                
                int[] start = (t == 0) ? a : b;
                int[] end = (t == 0) ? b : a;
                
                
                int curr = sum + bfs(row, col, start[0], start[1], board) + 1;
                // 이 부분 헷갈린다.
                
                
                curr += bfs(start[0], start[1], end[0], end[1], board) + 1;
                
                board[start[0]][start[1]] = 0;
                board[end[0]][end[1]] = 0;
                
                dfs(board, end[0], end[1], pair - 1, curr);
                
                board[start[0]][start[1]] = number;
                board[end[0]][end[1]] = number;
                
            }
        }
        
    }
    
    
    private int bfs(int sr, int sc, int tr, int tc, int[][] board) {
        
        
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visit = new boolean[4][4];
        
        que.add(new int[]{sr, sc});
        visit[sr][sc] = true;
        int dis = 0;
        
        
        while (!que.isEmpty()) {
            
            int size = que.size();
            
            for (int i = 0; i < size; i++) {
                
                int[] cur = que.poll();
                int cr = cur[0];
                int cc = cur[1];
                if (cr == tr && cc == tc) return dis;
                
                for (int d = 0; d < 4; d++) {
                    int nr = cr + dr[d];
                    int nc = cc + dc[d];
                    
                    if (nr < 0 || nr >= 4|| nc < 0 || nc >= 4) continue;
                
                    if (!visit[nr][nc]) {        
                        visit[nr][nc] = true;
                        que.add(new int[]{nr, nc});
                    }
                    
                    
                    
                    int[] move = cMove(cr, cc, board, d);
                    if (visit[move[0]][move[1]]) continue;
                    visit[move[0]][move[1]] = true;
                    que.add(new int[]{move[0], move[1]});
                }
                
            }
            
            dis++;
            
        }
        
        return 0;
        
        
    }
    
    private int[] cMove(int r, int c, int[][] board, int d) {
        int nr = r;
        int nc = c;
        
        while (true) {
            int tr = nr + dr[d];
            int tc = nc + dc[d];
            
            if (tr < 0 || tr >= 4|| tc < 0 || tc >= 4) {
                break;
            }
            nr = tr;
            nc = tc;
            
            if (board[nr][nc] != 0) {
                return new int[]{nr, nc};
            }
        }
        
        return new int[]{nr, nc};
        
        
    }
}