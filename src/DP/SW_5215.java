package DP;

import java.util.Scanner;

public class SW_5215 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
            int n = sc.nextInt();
            int l = sc.nextInt()/100;
            int [][] weights = new int [n+1][2];
            int [][] result = new int [n+1][l+1];
            for(int i=1; i<=n; i++){
                weights[i][1] = sc.nextInt()/100; //무게
                weights[i][0] = sc.nextInt(); //가치
            }

            for(int i=1; i<=n; i++){
                for(int w=1; w<=l; w++){
                    if(weights[i][0]<=w){
                        result[i][w] = Math.max(result[i-1][w], weights[i][1] + result[i-1][w-weights[i][0]]);
                    } else {
                        result[i][w] = result[i-1][w];
                    }
                }
            }
            sb.append("#").append(t+1).append(" ").append(result[n][l]).append("\n");
        }
        System.out.println(sb);
    }

}
