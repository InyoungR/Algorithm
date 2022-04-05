package DP;

import java.util.Scanner;

public class BJ_2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] stairs = new int [n+1];
        int [] costs = new int [n+1];
        for(int i=1; i<=n; i++){
            stairs[i] = sc.nextInt();
        }

        costs[1] = stairs[1];
        if(n>1) costs[2] = stairs[1]+stairs[2];

        for(int i=3; i<=n; i++){
            costs[i] = Math.max(costs[i-2], costs[i-3]+stairs[i-1]) + stairs[i];
        }

        System.out.println(costs[n]);
    }


}
