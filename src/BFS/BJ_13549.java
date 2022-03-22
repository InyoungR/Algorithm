package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_13549 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //수빈위치
        int K = sc.nextInt(); //동생위치

        Queue<int []> que = new LinkedList<>();
        que.offer(new int []{N,0});
        boolean [] V = new boolean[1000001];
        int result = Integer.MAX_VALUE;
        while(!que.isEmpty()){
            int [] pol = que.poll();
            int now = pol[0];
            int sec = pol[1];

            if(now == K) result = Math.min(result, sec);
            V[now] = true;

            if(now*2<=1000000 && !V[now*2]){
                que.offer(new int [] {now*2, sec});
            }

            if(now+1<=1000000 && !V[now+1]){
                que.offer(new int [] {now+1, sec+1});
            }

            if(now-1>=0 && !V[now-1]){
                que.offer(new int [] {now-1, sec+1});
            }
        }
        System.out.println(result);
    }
}
