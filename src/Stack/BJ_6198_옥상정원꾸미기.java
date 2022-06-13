package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_6198_옥상정원꾸미기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();
        Long result = 0L;

        for(int i=0; i<N; i++){
            int a = Integer.parseInt(bf.readLine());

            while(!stack.isEmpty() && stack.peek()<=a){
                stack.pop();
            }
            result += stack.size();
            stack.push(a);
        }

        System.out.println(result);

    }
}
