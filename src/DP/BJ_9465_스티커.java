package DP;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_9465_스티커 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for(int t=1; t<=T; t++){
            int n = sc.nextInt();
            int [][] stickers = new int [2][n+1];
            int [][] dp = new int [2][n+1];
            for(int i=0; i<2; i++){
                for(int j=1; j<=n; j++){
                    stickers[i][j] = sc.nextInt();
                }
            }

            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for(int j=2; j<=n; j++){
                for(int i=0; i<2; i++){
                    dp[i][j] = Math.max(Math.max(dp[i][j-2],dp[1-i][j-2]), dp[1-i][j-1]) + stickers[i][j];
                }
            }
            sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
        }
        System.out.println(sb);

    }
}
