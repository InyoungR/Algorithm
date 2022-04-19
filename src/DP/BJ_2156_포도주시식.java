package DP;

import java.util.Scanner;

public class BJ_2156_포도주시식 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] wines = new int [n+1];
        int [] dp = new int [n+1];
        for(int i=1; i<=n; i++){
            wines[i] = sc.nextInt();
        }
        dp[1] = wines[1];
        if(n>=2) dp[2] = wines[2]+wines[1];

        for(int i=3; i<=n; i++){
            dp[i] = Math.max(dp[i-2], dp[i-3]+wines[i-1]) + wines[i];
            if(i-4>=0) dp[i] = Math.max(dp[i-4]+wines[i-1]+wines[i], dp[i]);
        }

        System.out.println(Math.max(dp[n],dp[n-1]));
    }


}
