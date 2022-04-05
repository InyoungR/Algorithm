package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_4485 {
    static class Node implements Comparable<Node>{
        int val;
        int r,c;


        public Node(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return val-o.val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String msg;
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        while(!(msg = bf.readLine()).equals("0")){
            int n = Integer.parseInt(msg);
            int [][] map = new int[n][n];
            int [][] costs = new int [n][n];

            for(int i=0; i<n; i++){
                st = new StringTokenizer(bf.readLine());
                for(int j=0; j<n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int dr [] = {-1,1,0,0};
            int dc [] = {0,0,-1,1};
            int r = 0; int c = 0;
            for(int i=0; i<n; i++){
                Arrays.fill(costs[i],Integer.MAX_VALUE);
            }
            costs[0][0] = map[0][0];
            Queue<Node> que = new LinkedList<>();
            que.add(new Node(0,0,map[0][0]));

            while(!que.isEmpty()){
                Node cur = que.poll();

                if(costs[cur.r][cur.c]< cur.val) continue;

                for(int dir=0; dir<4; dir++){
                    int rr = cur.r+ dr[dir];
                    int cc = cur.c+ dc[dir];

                    if(rr>=0 && cc>=0 && rr<n && cc<n){
                        if(costs[rr][cc] > costs[cur.r][cur.c] + map[rr][cc]){
                            costs[rr][cc] = costs[cur.r][cur.c] + map[rr][cc];
                            que.add(new Node(rr,cc,costs[rr][cc]));
                        }

                    }
                }
            }

            sb.append("Problem ").append(cnt++).append(": ").append(costs[n-1][n-1]).append("\n");

        }

        System.out.println(sb);
    }
}
