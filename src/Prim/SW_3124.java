package Prim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW_3124 {
    static class Node implements Comparable<Node>{
        int link, val;
        Node next;

        public Node(int link, int val, Node next) {
            this.link = link;
            this.val = val;
            this.next = next;
        }

        @Override
        public int compareTo(Node o) {
            return val-o.val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            st = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(st.nextToken()); //정점개수
            int e = Integer.parseInt(st.nextToken()); //간선개수

            Node[] nodes = new Node [v+1];

            for(int i=0; i<e; i++){
                st = new StringTokenizer(bf.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());

                nodes[from] = new Node(to, val, nodes[from]);
                nodes[to] = new Node(from, val, nodes[to]);
            }

            boolean [] V = new boolean[v+1];
            int [] answer = new int [v+1];
            PriorityQueue<Node> que = new PriorityQueue<>();
            Arrays.fill(answer,Integer.MAX_VALUE);
            answer[1] =  0;
            que.add( new Node(1,0,null));
            long result = 0;
            int cnt = 0;
            while(!que.isEmpty()){
                Node cur = que.poll();

                if(V[cur.link]) continue;
                V[cur.link] = true;
                result += cur.val;
                if(++cnt == v) break;

                for(Node next= nodes[cur.link]; next!=null; next = next.next){
                    if(!V[next.link] && next.val < answer[next.link]){
                        answer[next.link] = next.val;
                        que.add(next);
                    }
                }
            }

            //for(int i=1; i<=v; i++) result += answer[i];

            sb.append("#").append(t+1).append(" ").append(result).append("\n");

        }
        System.out.println(sb);
    }
}
