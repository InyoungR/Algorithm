package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1939_중량제한 {
    static class Bridge implements Comparable<Bridge>{
        int to,limit;
        Bridge next;

        public Bridge(int to, int limit) {
            this.to = to;
            this.limit = limit;
        }

        public Bridge(int to, int limit, Bridge next) {
            this.to = to;
            this.limit = limit;
            this.next = next;
        }

        @Override
        public int compareTo(Bridge o) {
            return o.limit - limit;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); //섬 개수
        int M = Integer.parseInt(st.nextToken()); //다리 개수

        Bridge[] bridges = new Bridge[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            bridges[from] = new Bridge(to,limit,bridges[from]);
            bridges[to] = new Bridge(from,limit,bridges[to]);
        }

        st = new StringTokenizer(bf.readLine());
        int factory1 = Integer.parseInt(st.nextToken());
        int factory2 = Integer.parseInt(st.nextToken());

        PriorityQueue<Bridge> que = new PriorityQueue<>();
        boolean [] V = new boolean[N+1];
        int [] weights = new int [N+1];
        que.add(new Bridge(factory1, Integer.MAX_VALUE));

        while(!que.isEmpty()){
            Bridge cur = que.poll();

            if(V[cur.to]) continue;
            if(cur.to == factory2) break;
            V[cur.to] = true;

            for(Bridge b = bridges[cur.to]; b != null; b = b.next){
                if(!V[b.to] && weights[b.to] < Math.min(cur.limit, b.limit) ){
                    weights[b.to] = Math.min(b.limit, cur.limit);
                    que.add(new Bridge(b.to, weights[b.to]));
                }
            }
        }

        System.out.println(weights[factory2]);


    }
}
