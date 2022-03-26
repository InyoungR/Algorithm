package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        String txt = bf.readLine();
        int m = Integer.parseInt(bf.readLine());

        for(int i=0; i<txt.length(); i++){
            left.push(txt.charAt(i));
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(bf.readLine());
            String x = st.nextToken();

            switch(x){
                case "L":
                    if(!left.isEmpty()) right.push(left.pop());
                    break;
                case "D":
                    if(!right.isEmpty()) left.push(right.pop());
                    break;
                case "B":
                    if(!left.isEmpty()) left.pop();
                    break;
                case "P":
                    left.push(st.nextToken().charAt(0));
                    break;

            }
        }

        while(!left.isEmpty()){
            right.push(left.pop());
        }

        StringBuilder sb = new StringBuilder();

        while(!right.isEmpty()){
            sb.append(right.pop());
        }

        System.out.println(sb);
    }
}
