package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11062_카드게임 {
    static int n = 0;
    static int [] cards = null;
    static int [][] dp = null;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());

        for(int t=0; t<T; t++){
            n = Integer.parseInt(bf.readLine());
            cards = new int [n];
            dp = new int [n][n];

            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int i=0; i<n; i++){
                cards[i] = Integer.parseInt(st.nextToken());
            }

            int answer = DFS(0,n-1,0);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static int DFS(int i, int j, int turn){
        if(j<i) return 0;
        if(dp[i][j] != 0) return dp[i][j];

        if(turn % 2 == 0){
            return dp[i][j] = Math.max(DFS(i+1,j,turn+1)+cards[i], DFS(i,j-1,turn+1)+cards[j]);
        } else {
            return dp[i][j] = Math.min(DFS(i+1,j,turn+1),DFS(i,j-1,turn+1));
        }
    }

}
