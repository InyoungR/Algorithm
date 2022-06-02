package Greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ_1715_카드정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> que = new PriorityQueue<>();

        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            que.add(sc.nextInt());
        }

        int result = 0;

        while(que.size() >=2){
            int a = que.poll()+que.poll();
            result += a;
            que.add(a);
        }

        System.out.println(result);
    }
}
