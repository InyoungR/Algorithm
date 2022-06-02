package WordAnalysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BJ_5430_AC {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=0; t<T; t++){
            String orders = bf.readLine();
            int n = Integer.parseInt(bf.readLine());
            String msg = bf.readLine();

            boolean error = false;
            boolean reverse = false;

            Deque<Integer> nums = new ArrayDeque<>();
            //숫자 입력
            int num = 0;
            if(n>0){
                for(int i=0; i<msg.length(); i++){
                    if(msg.charAt(i) == '[') continue;
                    else if(msg.charAt(i) == ',' || msg.charAt(i) == ']' ) {
                        nums.add(num);
                        num = 0;
                    }
                    else{
                        num = num*10+(msg.charAt(i)-'0');
                    }
                }

            }

            //function 실행
            outer : for(int i=0; i<orders.length(); i++){
                switch(orders.charAt(i)){
                    case 'R':
                        reverse = !reverse;
                        break;
                    case 'D':
                        if(nums.isEmpty()){
                            error = true;
                            break outer;
                        }
                        if(reverse) nums.pollLast();
                        else nums.pollFirst();
                        break;
                }
            }

            if(error) sb.append("error").append("\n");
            else if (!reverse) {
                sb.append('[');
                int s = nums.size();
                for(int i=0; i<s; i++){
                    sb.append(nums.pollFirst()).append(",");
                }
                if(s>0) sb =sb.replace(sb.length()-1,sb.length(),"]").append("\n");
                else sb.append("]").append("\n");
            }
            else {
                sb.append('[');
                int s = nums.size();
                for(int i=0; i<s; i++){
                    sb.append(nums.pollLast()).append(",");
                }
                if(s>0) sb =sb.replace(sb.length()-1,sb.length(),"]").append("\n");
                else sb.append("]").append("\n");
            }
        }

        System.out.println(sb);
    }


}
