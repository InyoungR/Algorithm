package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack();
        int pillows [][] = new int[N][2]; //0은 위치, 1은 높이
        int result = 0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            pillows[i][0] = Integer.parseInt(st.nextToken());
            pillows[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pillows, ((o1, o2) -> o1[0]-o2[0]));

        for(int i=0; i<N; i++){
            while(!stack.empty()){
                if(stack.peek()[1] <= pillows[i][1]){
                    if(stack.size()==1) {
                        result += (pillows[i][0] - stack.peek()[0]) * stack.peek()[1];
                        stack.pop();
                        break;
                    }
                    stack.pop();
                } else break;
            }
            stack.push(pillows[i]);
        }
        if(!stack.empty()){
            while(!stack.empty() && stack.size()>=2){
                int [] temp = stack.pop();
                result += (temp[0] - stack.peek()[0])*temp[1];
            }
            result += stack.pop()[1];
        }
        sb.append(result);
        System.out.println(sb);

    }
}
