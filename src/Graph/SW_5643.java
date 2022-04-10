package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_5643 {
    static class Node {
        int no;
        Node link;

        public Node(int no, Node link) {
            this.no = no;
            this.link = link;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(bf.readLine()); //학생 수
            int M = Integer.parseInt(bf.readLine()); //간선 수

            Node [] nodes = new Node[N+1]; //제대로 간선
            Node [] nodesR = new Node[N+1];//거꾸로 간선

            for(int i=0; i<M; i++){
                st = new StringTokenizer(bf.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                nodes[from] = new Node(to, nodes[from]);
                nodesR[to] = new Node(from, nodesR[to]);
            }

            int result = 0;

            for(int i=1; i<=N; i++){
                int smaller = 0;
                int bigger = 0;
                int [] check = new int [N+1];

                check[0] = -1;
                check[i] = -1;

                Queue<Integer> que = new LinkedList<>();
                que.add(i);

                while(!que.isEmpty()){
                    int cur = que.poll();
                    for(Node node = nodes[cur]; node != null; node = node.link){
                        if(check[node.no] == 0) {
                            check[node.no] = 1;
                            que.add(node.no);
                        }
                    }
                }
                que.add(i);
                while(!que.isEmpty()){
                    int cur = que.poll();
                    for(Node node = nodesR[cur]; node != null; node = node.link){
                        if(check[node.no] == 0) {
                            check[node.no] = 2;
                            que.add(node.no);
                        }
                    }
                }
                boolean flag = true;
                for(int j=1; j<=N; j++){
                    if(check[j] == 0) {
                        flag = false;
                        break;
                    }
                }

                if(flag) result += 1;
            }
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}
