package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15486_퇴사2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(bf.readLine());
        int [][] appointments = new int [n+1][2];
        int [] dp = new int [n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(bf.readLine());
            appointments[i][0] = Integer.parseInt(st.nextToken());
            appointments[i][1] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for(int i=1; i<=n; i++){
            int t = appointments[i][0];
            int profit = appointments[i][1];
            if(i+t-1<=n) {
                dp[i+t-1] = Math.max(dp[i+t-1], dp[i-1]+profit);
            }
            dp[i] = Math.max(dp[i-1], dp[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
