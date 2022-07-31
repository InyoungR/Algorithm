package Backtracking;

import java.util.Scanner;

public class BJ_18429_근손실 {
    static int answer = 0;
    static int N, K;
    static int [] kits;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        kits = new int [N];
        for(int i=0; i<N; i++){
            kits[i] = sc.nextInt();
        }

        DFS(0,0,500);

        System.out.println(answer);

    }

    static void DFS(int cnt, int v, int sum){

        if(cnt == N){
            answer++;
            return;
        }

        sum -= K;

        for(int i=0; i<N; i++){
            if((v & 1 << i) != 0) continue;
            if(sum + kits[i] >= 500){
                DFS(cnt+1, v | 1<<i, sum+ kits[i]);
            }
        }
    }
}
