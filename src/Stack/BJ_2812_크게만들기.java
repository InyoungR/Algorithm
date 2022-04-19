package Stack;

import java.util.Scanner;
import java.util.Stack;

public class BJ_2812_크게만들기 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        char[] number = sc.next().toCharArray();
        Stack<Character> stack = new Stack<>();

        int cnt = 0;
        for(int i=0; i<N; i++){
            char cur = number[i];
            while(!stack.isEmpty() && cnt<K && stack.peek()<cur){
                stack.pop();
                cnt++;
            }
            stack.push(cur);
        }
        int idx = 0;
        for(char c: stack){
            sb.append(c);
            idx++;
            if(idx == N-K) break;
        }
        System.out.println(sb);
    }
}
