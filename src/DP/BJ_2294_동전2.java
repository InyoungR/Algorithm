package DP;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2294_동전2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] dp = new int [k+1];
        int [] coins = new int [n];

        for(int i=0; i<n; i++){
            coins[i] = sc.nextInt();
        }

        Arrays.fill(dp, 987654321);
        dp[0] = 0;

        for(int i=0; i<k; i++){
            for(int j=0; j<n; j++){
                if(i+coins[j]<=k){
                    dp[i+coins[j]] = Math.min(dp[i+coins[j]], dp[i]+1);
                }
            }
        }

        System.out.println(dp[k]==987654321?-1:dp[k]);
    }
}
