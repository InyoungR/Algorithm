package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10942_팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int N = Integer.parseInt(bf.readLine());
        int [] nums = new int [N+1];
        st = new StringTokenizer(bf.readLine());

        for(int i=1; i<=N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(bf.readLine());

        boolean [][] dp = new boolean[N+1][N+1];

        for(int e=1; e<=N; e++){
            for(int s=1; s<=N; s++){
                if(e < s) continue;
                if(s == e) {
                    dp[s][e] = true;
                    continue;
                }
                if(Math.abs(e-s) == 1 && nums[s] == nums[e]) {
                    dp[s][e] = true;
                    continue;
                }
                if(dp[s+1][e-1] && nums[s] == nums[e]){
                    dp[s][e] = true;
                }
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(dp[s][e]) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb);

    }
}
