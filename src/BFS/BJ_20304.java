package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_20304 {
    static int N, M, result;
    static int[] passwords;
    static Queue<int[]> que = new LinkedList<>();
    static boolean[] used;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //0이상 N이하의 범위에서만
        M= sc.nextInt(); //비번의 개수 M
        passwords = new int [M];
        used = new boolean[N+1];
        for(int i=0; i<M; i++){
            passwords[i] = sc.nextInt();
        }
        result = 0;
        BFS();
        System.out.println(result);
    }

    static void BFS(){
        for(int i=0; i<M; i++){
            que.add(new int[]{passwords[i],0}); //패스워드:0 안전도:1
            used[passwords[i]]=true;
        }

        while(!que.isEmpty()){
            int [] temp= que.poll();
            result = Math.max(result, temp[1]);

            for(int i=1; i<=N; i=i<<1){
                int admin = temp[0]^i;
                if(admin>N)continue;

                if(!used[admin]){
                    used[admin] = true;
                    que.add(new int[]{admin, temp[1]+1});
                }
            }
        }
    }
}
