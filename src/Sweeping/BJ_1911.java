package Sweeping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1911 {
    static class Puddle implements Comparable<Puddle>{
        int start, end;

        public Puddle(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Puddle o) {
            return start==o.start? end-o.end : start-o.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue <Puddle> que = new PriorityQueue<>();
        PriorityQueue <Puddle> que2 = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            que.add(new Puddle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int cnt = 0;
        int length = 0;
        int remain = 0;
        Puddle pud = que.poll();
        int from = pud.start;
        int to = pud.end;

        while(!que.isEmpty()){
            pud = que.poll();
            if(pud.start<=to){
                to = pud.end;
            } else {
                que2.add(new Puddle(from,to));
                from = pud.start;
                to = pud.end;
            }
        }
        que2.add(new Puddle(from,to));

        to = 0;
        while(!que2.isEmpty()){
            pud = que2.poll();

            if(to<pud.start){
                to = pud.start;
            }

            while(to<pud.end){
                to += k;
                cnt += 1;
            }
        }

        System.out.println(cnt);

    }
}
