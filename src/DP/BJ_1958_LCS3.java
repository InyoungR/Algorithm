package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1958_LCS3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] text1 = bf.readLine().toCharArray();
        char[] text2 = bf.readLine().toCharArray();
        char[] text3 = bf.readLine().toCharArray();

        int [][][] dp = new int[text1.length+1][text2.length+1][text3.length+1];
        int max = 0;
        for(int i=1; i<=text1.length; i++){
            for(int j=1; j<=text2.length; j++){
                for(int k=1; k<=text3.length; k++){

                    if(text1[i-1] == text2[j-1] && text2[j-1] == text3[k-1] ){
                        dp[i][j][k] = dp[i-1][j-1][k-1] +1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i-1][j][k],Math.max(dp[i][j-1][k],dp[i][j][k-1]));
                    }
                }
            }
        }

        System.out.println(dp[text1.length][text2.length][text3.length]);
    }
}
