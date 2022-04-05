package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        int [][] costs = new int [n][3];
        int [][] memo = new int [n][3];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            costs[i][0] = Integer.parseInt(st.nextToken());
            costs[i][1] = Integer.parseInt(st.nextToken());
            costs[i][2] = Integer.parseInt(st.nextToken());
        }

        memo[0] = costs[0].clone();

        for(int i=1; i<n; i++){
            memo[i][0] = Math.min(memo[i-1][1],memo[i-1][2])+costs[i][0];
            memo[i][1] = Math.min(memo[i-1][0],memo[i-1][2])+costs[i][1];
            memo[i][2] = Math.min(memo[i-1][0],memo[i-1][1])+costs[i][2];
        }

        int result = Integer.MAX_VALUE;

        for(int i=0; i<3; i++){
            result = Math.min(result, memo[n-1][i]);
        }

        System.out.println(result);
    }
}
