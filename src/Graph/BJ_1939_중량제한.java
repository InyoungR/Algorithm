package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1939_중량제한 {
    static class Bridge{
        int to,limit;
        Bridge next;

        public Bridge(int to, int limit, Bridge next) {
            this.to = to;
            this.limit = limit;
            this.next = next;
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

        Queue<int[]> que = new LinkedList<>();
        boolean [] V = new boolean[N+1];
        que.add(new int []{factory1, Integer.MAX_VALUE});
        int max = 0;
        while(!que.isEmpty()){
            int [] cur = que.poll();
            V[cur[0]] = true;

            for(Bridge b = bridges[cur[0]]; b != null; b = b.next){
                if(!V[b.to] && b.limit<= cur[1]){
                    if(b.to == factory2) {
                        max = Math.max(max, b.limit);
                        continue;
                    }
                    que.add(new int []{b.to, b.limit});
                }
            }
        }

        System.out.println(max);


    }
}
