package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9084_동전 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        for(int t=1; t<=T; t++){
            int n = Integer.parseInt(bf.readLine());
            int [] coins = new int [n];

            st = new StringTokenizer(bf.readLine());
            for(int i=0; i<n; i++){
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int goal = Integer.parseInt(bf.readLine());
            int[] result = new int [goal+1];
            result[0] = 1;

            for(int i=0; i<n; i++ ){
                for(int j=coins[i]; j<=goal; j++){
                    result[j] += result[j-coins[i]];
                }
            }

            sb.append(result[goal]).append("\n");
        }
        System.out.println(sb);
    }
}
