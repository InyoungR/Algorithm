package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        Stack<int[]> towers = new Stack<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            int temp = Integer.parseInt(st.nextToken());

            while(!towers.empty()){
                if(towers.peek()[0] < temp){
                    towers.pop();
                } else {
                    sb.append(towers.peek()[1]).append(" ");
                    break;
                }
            }

            if(towers.empty()) sb.append("0 ");
            towers.push(new int [] {temp, i+1});

        }
        System.out.println(sb);

    }
}
