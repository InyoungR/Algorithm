package BellmanFord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1865_웜홀 {
    static class Edge {
        int from, to, time;

        public Edge(int from, int to, int time) {
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(bf.readLine());

        for(int t=0; t<T; t++){
            st = new StringTokenizer(bf.readLine());

            int N = Integer.parseInt(st.nextToken()); //지점의 수
            int M = Integer.parseInt(st.nextToken()); //도로의 수
            int W = Integer.parseInt(st.nextToken()); //웜홀의 수

            ArrayList<Edge> edges = new ArrayList<>();

            for(int i=0; i<M; i++){
                st = new StringTokenizer(bf.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                edges.add(new Edge(from, to, cost));
                edges.add(new Edge(to, from, cost));
            }

            for(int i=0; i<W; i++){
                st = new StringTokenizer(bf.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                edges.add(new Edge(from, to, cost*-1));
            }

            int INF = 987654321;
            int [] times = new int [N+1];
            Arrays.fill(times, INF);
            times[1] = 0;
            boolean isUpdated = false;

            outer: for(int i=0; i<N; i++){
                isUpdated = false;
                for(Edge edge : edges){
                    if(times[edge.to] > times[edge.from] + edge.time){
                        times[edge.to] = times[edge.from] + edge.time;
                        isUpdated = true;
                        if(i==N-1) break outer;
                    }
                }
                if(!isUpdated) break;
            }

            sb.append(isUpdated?"YES":"NO").append("\n");

       }

        System.out.println(sb);
    }
}
