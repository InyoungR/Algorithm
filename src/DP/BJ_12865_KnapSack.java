package DP;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_12865_KnapSack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //냅색의 수
        int K = sc.nextInt(); //무게 한도

        int [][] weights = new int [N+1][2];
        int [][] result = new int [N+1][K+1];
        for(int i=1; i<=N; i++){
            weights[i][0] = sc.nextInt(); //무게
            weights[i][1] = sc.nextInt(); //가치
        }

        for(int i=1; i<=N; i++){
            for(int w=1; w<=K; w++){
                if(weights[i][0]<=w){
                    result[i][w] = Math.max(result[i-1][w], weights[i][1] + result[i-1][w-weights[i][0]]);
                } else {
                    result[i][w] = result[i-1][w];
                }
            }
        }

        System.out.println(result[N][K]);

    }
}
