package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BJ_11779 {
    static class Node implements Comparable<Node> {
        int val;
        int to;
        Node link;
        ArrayList<Integer> path = new ArrayList<>();

        public Node(int to, int val) {
            this.val = val;
            this.to = to;
        }

        public Node(int to, int val, Node link) {
            this.val = val;
            this.to = to;
            this.link = link;
        }

        @Override
        public int compareTo(Node o) {
            return this.val-o.val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine()); //도시의 개수 n
        int m = Integer.parseInt(bf.readLine()); //버스의 개수 m

        Node[] nodes = new Node[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodes[from] = new Node(to, cost, nodes[from]);
        }
        st = new StringTokenizer(bf.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        boolean [] V = new boolean[n+1];
        int [] cost = new int [n+1];
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Node> que = new PriorityQueue<>();

        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[from] = 0;
        Node temp = new Node(from, cost[from]);
        temp.path.add(from);
        que.offer(temp);

        while(!que.isEmpty()){
            Node cur = que.poll();

            if(V[cur.to]) continue;
            else V[cur.to] = true;
            if(cur.to == to){
                result = (ArrayList<Integer>) cur.path.clone();
            }

            for(Node i = nodes[cur.to]; i!=null; i=i.link){
                if(!V[i.to] && cost[i.to] > cost[cur.to] + i.val){
                    cost[i.to] = cost[cur.to] + i.val;
                    temp = new Node(i.to, cost[i.to]);
                    temp.path = (ArrayList<Integer>) cur.path.clone();
                    temp.path.add(i.to);
                    que.offer(temp);
                }
            }

        }
        System.out.println(cost[to]);
        System.out.println(result.size());
        for(int p: result){
            System.out.printf("%d ",p);
        }

    }
}
