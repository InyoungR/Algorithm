package Math;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ_1094 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        PriorityQueue<Integer> sticks = new PriorityQueue<>();
        sticks.add(64);
        int result = 64;

        while(result>x){
            int s = sticks.poll();
            int half = s/2;
            int sum = 0;
            result = 0;

            for(int i: sticks){
                sum += i;
            }

            if(sum+half>=x) sticks.add(half);
            else {
                sticks.add(half);
                sticks.add(half);
            }
            for(int i: sticks){
                result += i;
            }
        }

        System.out.println(sticks.size());
    }
}
