package DP;

import java.util.Scanner;

public class SW_5215_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
            int n = sc.nextInt();
            int l = sc.nextInt();
            int [][] weights = new int [n+1][2];
            int [] result = new int [l+1];
            for(int i=1; i<=n; i++){
                weights[i][0] = sc.nextInt(); //가치
                weights[i][1] = sc.nextInt(); //무게
            }

            for(int i=1; i<=n; i++){
                for(int w=l; w>0; w--){
                    if(weights[i][1]<=w){
                        result[w] = Math.max(result[w], weights[i][0] + result[w-weights[i][1]]);
                    }
                }
            }
            sb.append("#").append(t+1).append(" ").append(result[l]).append("\n");
        }
        System.out.println(sb);
    }

}
