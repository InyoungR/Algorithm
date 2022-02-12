package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> result = new ArrayList<>();
        Queue<Integer> circle = new LinkedList<>();

        for(int i=1; i<=N; i++){
            circle.offer(i);
        }

        while(circle.size()>0){
            for(int i=0; i<K-1; i++){
                circle.offer(circle.poll());
            }
            result.add(circle.poll());
        }

        sb.append("<");
        for(int i=0; i<N;i++){
            sb.append(result.get(i)).append(", ");
        }
        sb.setLength(sb.length()-2);
        sb.append(">");

        System.out.println(sb.toString());

    }
}
