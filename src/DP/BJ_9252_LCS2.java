package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Stack;

public class BJ_9252_LCS2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] text1 = bf.readLine().toCharArray();
        char[] text2 = bf.readLine().toCharArray();

        int [][] dp = new int [text1.length+1][text2.length+1];

        for(int i=1; i<=text1.length; i++){
            for(int j=1; j<=text2.length; j++){

                if(text1[i-1] == text2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        Stack<Character> stack = new Stack<>();
        int r = text1.length;
        int c = text2.length;

        while(r>0 && c>0){
            if(text1[r-1] == text2[c-1]){
                stack.push(text1[r-1]);
                r--;
                c--;
            } else if(dp[r-1][c]>dp[r][c-1]){
                r--;
            } else{
                c--;
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(dp[text1.length][text2.length]);
        System.out.println(sb);
    }
}
