package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_11000_강의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> {
            if(o1[0] != o2[0]) return o1[0] - o2[0];
            else return o1[1]-o2[1];
        });
        PriorityQueue<Integer> answer = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            que.offer(new int [] {
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            });
        }

        answer.offer(que.poll()[1]);

        while(!que.isEmpty()){
            int[] nextClass = que.poll();
            if(nextClass[0] < answer.peek()){
                answer.offer(nextClass[1]);
            } else {
                answer.poll();
                answer.offer(nextClass[1]);
            }
        }

        System.out.println(answer.size());
    }
}
