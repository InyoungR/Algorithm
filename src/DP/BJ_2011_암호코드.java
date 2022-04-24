package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2011_암호코드 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String code = bf.readLine();
        int [] dp = new int [code.length()+1];
        int mod = 1000000;

        dp[0] = 1;
        for(int i=1; i<=code.length(); i++){
            if(code.charAt(i-1)-'0'>0) dp[i] = dp[i-1]%mod;
            if(i==1) continue;
            int num = (code.charAt(i-2)-'0')*10 + code.charAt(i-1)-'0';
            if(code.charAt(i-2)-'0'>0 && num <= 26 && num>0) dp[i] = (dp[i]+dp[i-2])%mod;
        }
        System.out.println(dp[code.length()]);
    }
}
