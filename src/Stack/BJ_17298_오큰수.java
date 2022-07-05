package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int [] answer = new int [n+1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Stack<int []> stack = new Stack<>();

        for(int i=1; i<=n; i++){
            int a = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek()[1]<a){
                answer[stack.peek()[0]] = a;
                stack.pop();
            }
            stack.push(new int []{i,a});
        }

        while(!stack.isEmpty()){
            int [] X = stack.pop();
            answer[X[0]] = -1;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=n; i++){
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);

    }
}
