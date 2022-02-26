package BruteForce;

import java.util.Scanner;
import java.util.Stack;

public class BJ_2635 {
    static int N, result, second, size;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();
        stack.push(N);

        for(int i=N; i>=1; i--){
            Brute(i);
        }
        stack.clear();
        stack.push(N);
        stack.push(second);
        sb.append(result+2).append("\n");
        while(!stack.isEmpty()) {
            int c = stack.pop();//두번째수
            int b = stack.pop();//첫번째수

            if (b >= c) {
                stack.push(c);
                stack.push(b - c);
                sb.append(b).append(" ");
            } else {
                sb.append(b).append(" ").append(c);
            }
        }
        System.out.println(sb);
    }

    static void Brute(int a){
        stack.clear();
        stack.push(N);
        stack.push(a);
        size = 0;

        while(!stack.isEmpty()){
            int c = stack.pop();//두번째수
            int b = stack.pop();//첫번째수

            if(b>=c) {
                stack.push(c);
                stack.push(b-c);
                size += 1;
            } else break;
        }

        if(size>=result) {
            second = a;
            result = Math.max(result, size);
        }
    }
}
