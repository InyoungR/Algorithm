package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1327_소트게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); //순열의 크기
        int K = Integer.parseInt(st.nextToken()); //한번에 뒤집는 숫자

        st = new StringTokenizer(bf.readLine());
        PriorityQueue<Integer> que0 = new PriorityQueue<>();
        StringBuilder start = new StringBuilder();
        for(int i=0; i<N; i++){
            int a = Integer.parseInt(st.nextToken());
            que0.add(a);
            start.append(a);

        }

        StringBuilder answer0 = new StringBuilder();
        while(!que0.isEmpty()){
            answer0.append(que0.poll());
        }
        String answer = answer0.toString();
        HashSet<String> set = new HashSet<>();
        Queue<String> que = new LinkedList<>();
        que.add(start.toString());
        set.add(start.toString());

        int result = -1;
        boolean flag = false;
        outer : while(!que.isEmpty()){
            result++;
            int s = que.size();

            for(int j=0; j<s; j++){
                String cur = que.poll();
                if(cur.equals(answer)) {
                    flag = true;
                    break;
                }

                for(int i=0; i<=start.length()-K; i++){
                    String next = change(cur, i, K);
                    if(set.contains(next)) continue;
                    if(next.equals(answer)){
                        flag = true;
                        result++;
                        break outer;
                    }
                    que.add(next);
                    set.add(next);
                }

            }
        }

        if(flag) System.out.println(result);
        else System.out.println(-1);
    }
    static String change(String input, int start, int N){
        StringBuilder sb = new StringBuilder();
        sb.append(input);

        int end = start+N-1;
        while(start<end){
            sb.setCharAt(end, input.charAt(start));
            sb.setCharAt(start, input.charAt(end));
            start++;
            end--;
        }

        return sb.toString();
    }
}
