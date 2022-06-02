package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1937_욕심쟁이판다 {
    static int n;
    static int [][] map, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        dp = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        int result = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(dp[i][j] ==-1) DFS(i,j);
                result = Math.max(result, dp[i][j]);
            }
        }

        System.out.println(result);

    }

    static int DFS(int r, int c){
        int [] dr = {-1,1,0,0};
        int [] dc = {0,0,-1,1};

        int max = 0;
        for(int dir=0; dir<4; dir++){
            int nr = r+dr[dir];
            int nc = c+dc[dir];

            if(nr<0 || nc<0 || nr>=n || nc>= n) continue;
            if(map[nr][nc] <= map[r][c]) continue;
            if(dp[nr][nc] == -1) DFS(nr,nc);
            max = Math.max(max, dp[nr][nc]);
        }
        if(max == 0) {
            dp[r][c] = 1;
            return 1;
        }
        dp[r][c] = max+1;
        return max+1;
    }
}
