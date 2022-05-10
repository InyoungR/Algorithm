package Greedy;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ_1744_수묶기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> que2 = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            int temp = sc.nextInt();
            if(temp > 0) que.add(temp);
            else que2.add(temp);
        }
        int result = 0;

        while(que.size()>=2){
            int a = que.poll();
            int b = que.poll();

            if(a*b >a+b){
                result += a*b;
            } else {
                result += a;
                que.add(b);
            }
        }

        while(!que.isEmpty()){
            result += que.poll();
        }

        while(que2.size()>=2){
            int a = que2.poll();
            int b = que2.poll();

            if(a*b >a+b){
                result += a*b;
            } else {
                result += a;
                que2.add(b);
            }
        }

        while(!que2.isEmpty()){
            result += que2.poll();
        }

        System.out.println(result);
    }
}
