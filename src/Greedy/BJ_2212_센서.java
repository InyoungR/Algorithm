package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_2212_센서 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); //센서의 개수
        int K = Integer.parseInt(bf.readLine()); //집중국의 개수

        PriorityQueue<Integer> que = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++){
            que.add(Integer.parseInt(st.nextToken()));
        }
        PriorityQueue<Integer> reverse = new PriorityQueue<>(Comparator.reverseOrder());
        int prior = que.poll();
        while(!que.isEmpty()){
            int cur = que.poll();
            reverse.add(cur-prior);
            prior = cur;
        }
        int sum = 0;
        while(!reverse.isEmpty()){
            if(--K>0) {reverse.poll(); continue;}
            sum += reverse.poll();
        }

        System.out.println(sum);

    }
}
