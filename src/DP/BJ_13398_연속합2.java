package DP;

import java.util.Scanner;

public class BJ_13398_연속합2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [] nums = new int [n];
        int [][] dp = new int [2][n];
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }

        dp[0][0] = dp[1][0] = nums[0];
        int result = nums[0];

        for(int i=1; i<n; i++){
            dp[0][i] = Math.max(dp[0][i-1]+nums[i], nums[i]);
            dp[1][i] = Math.max(dp[1][i-1] + nums[i] , dp[0][i-1]);
            int max = Math.max(dp[0][i],dp[1][i]);
            result = Math.max(result, max);
        }

        System.out.println(result);

    }

}
