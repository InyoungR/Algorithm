package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1915_가장큰정사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [][] map = new int [n][m];
        int [][] dp = new int [n][m];
        for(int i=0; i<n; i++){
            String msg = bf.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = msg.charAt(j)-'0';
            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 || j==0){
                    dp[i][j] = map[i][j];
                }else {
                   if(map[i][j] == 0){
                       dp[i][j] = 0;
                   }else {
                       int min = Math.min(dp[i-1][j], dp[i][j-1]);
                       min = Math.min(min, dp[i-1][j-1]);
                       dp[i][j] = min+1;
                   }

                }
                cnt = Math.max(cnt, dp[i][j]);
            }
        }
        System.out.println(cnt*cnt);
    }
}
