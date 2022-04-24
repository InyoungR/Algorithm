package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_5582_공통부분문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] text1 = bf.readLine().toCharArray();
        char[] text2 = bf.readLine().toCharArray();

        int [][] result = new int [text1.length+1][text2.length+1];
        int answer = 0;
        for(int i=1; i<=text1.length; i++){
            int max = 0;
            for(int j=1; j<=text2.length; j++){
                if(text1[i-1] == text2[j-1]){
                    result[i][j] = result[i-1][j-1]+1;
                }
                max = Math.max(result[i][j], max);
            }
            answer = Math.max(answer, max);
        }

        System.out.println(answer);
    }
}
