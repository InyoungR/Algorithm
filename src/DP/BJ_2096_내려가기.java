package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2096_내려가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int n = Integer.parseInt(bf.readLine());

        int [][] nums = new int [n][3];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<3; j++){
                nums[i][j]  =  Integer.parseInt(st.nextToken());
            }
        }

        int [][] dp = new int [n][3];
        dp[0] = nums[0].clone();

        for(int r=0; r<n-1; r++){
            for(int c=0; c<3; c++){
                for(int i=-1; i<=1; i++){
                    int nr = r+1;
                    int nc = c+i;
                    if(nc>=0 && nc<3 && dp[nr][nc] < dp[r][c] + nums[nr][nc]){
                        dp[nr][nc] = dp[r][c] + nums[nr][nc];
                    }
                }
            }
        }
        int max = 0;
        for(int i=0; i<3; i++){
            max = Math.max(dp[n-1][i], max);
        }
        sb.append(max).append(" ");

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], 987654321);
        }
        dp[0] = nums[0].clone();

        for(int r=0; r<n-1; r++){
            for(int c=0; c<3; c++){
                for(int i=-1; i<=1; i++){
                    int nr = r+1;
                    int nc = c+i;
                    if(nc>=0 && nc<3 && dp[nr][nc] > dp[r][c] + nums[nr][nc]){
                        dp[nr][nc] = dp[r][c] + nums[nr][nc];
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<3; i++){
            min = Math.min(dp[n-1][i], min);
        }
        sb.append(min);

        System.out.println(sb);
    }
}
