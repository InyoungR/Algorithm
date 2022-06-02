package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_18352_특정거리도시찾기 {
    static class Node{
        int to;
        Node link;

        public Node(int to, Node link) {
            this.to = to;
            this.link = link;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken()); //도시의 개수
        int m = Integer.parseInt(st.nextToken()); //간선의 개수
        int k = Integer.parseInt(st.nextToken()); //목표 거리
        int x = Integer.parseInt(st.nextToken()); //출발 도시 번호

        Node[] nodes = new Node [n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            nodes[from] = new Node(to, nodes[from]);
        }

        int [] dist = new int[n+1];
        boolean [] V = new boolean[n+1];
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[x] = 0;
        V[x] = true;

        while(!que.isEmpty()){
            int cur =que.poll();

            for(Node city = nodes[cur]; city!=null; city=city.link){
                if(!V[city.to]){
                    V[city.to] = true;
                    dist[city.to] = dist[cur]+1;
                    que.add(city.to);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean exists = false;

        for(int i=1; i<=n; i++){
            if(dist[i] == k){
                exists = true;
                sb.append(i).append("\n");
            }
        }
        if(exists) System.out.println(sb);
        else System.out.println(-1);
    }
}
