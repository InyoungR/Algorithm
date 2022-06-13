package BellmanFord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3860_할로윈묘지 {
    static class Edge{
        int start,end,cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        String msg = null;

        while((msg = bf.readLine())!=null){
            st = new StringTokenizer(msg);
            int W = Integer.parseInt(st.nextToken()); //column
            int H = Integer.parseInt(st.nextToken()); //row

            if(W== 0 && H == 0) break;

            int G = Integer.parseInt(bf.readLine()); //묘비의 개수
            ArrayList<Integer> symmetries = new ArrayList<>();
            int [][] map = new int [H][W];

            for(int i=0; i<G; i++){
                st = new StringTokenizer(bf.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                map[r][c] = -1; //묘비
           }

            ArrayList<Edge> edges = new ArrayList<>();

            int E = Integer.parseInt(bf.readLine()); //귀신구멍의 개수

            //귀신구멍 간선에 더하기기
            for(int i=0; i<E; i++){
                st = new StringTokenizer(bf.readLine());
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                edges.add(new Edge(y1*W+x1, y2*W+x2, T));
                map[y1][x1] = -2; //귀신구멍입구에서는 나갈 수 없다
            }

            int [] dr = {-1,1,0,0};
            int [] dc = {0,0,-1,1};

            //간선 구하기
            for(int r=0; r<H; r++){
                for(int c=0; c<W; c++){
                    int a = r*W+c;
                    if(a == H*W-1) break;
                    if(map[r][c] != 0) continue;

                    for(int dir=0; dir<4; dir++){
                        int nr = r+ dr[dir];
                        int nc = c+ dc[dir];

                        if(nr<0 || nc<0 || nr>=H || nc>=W || map[nr][nc] == -1) continue;

                        int b = nr*W+nc;

                        edges.add(new Edge(a,b,1));
                    }
                }
            }

           int INF = 987654321;
           int costs [] = new int [W*H];
           Arrays.fill(costs,INF);
           costs[0] = 0;
           boolean isUpdated = false;

           outer: for(int i=0; i<W*H; i++){
               for(Edge edge: edges){
                   if(costs[edge.start] ==INF) continue;
                   if(costs[edge.end] > costs[edge.start] +edge.cost) {
                       costs[edge.end] = costs[edge.start] + edge.cost;
                       isUpdated = true;
                       if(i == W*H-1) break outer;
                   }
               }

               if(!isUpdated) break;
               isUpdated = false;
           }

            if(isUpdated) sb.append("Never").append("\n");
            else if(costs[W*H-1] != INF) sb.append(costs[W*H-1]).append("\n");
            else sb.append("Impossible").append("\n");
        }

        System.out.println(sb);
    }
}
