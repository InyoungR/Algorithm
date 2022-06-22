package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2533_사회망서비스 {
    static class Node{
        int child;
        Node link;

        public Node(int child, Node link) {
            this.child = child;
            this.link = link;
        }
    }

    static  Node [] list;
    static  int [][] dp;
    static  boolean [] V;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(bf.readLine());
        list = new Node[n+1];

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list[from] = new Node(to, list[from]);
            list[to] = new Node(from, list[to]);
        }
        dp = new int [n+1][2];
        V= new boolean[n+1];

        dp[1] = DFS(1);

        System.out.println(Math.min(dp[1][0],dp[1][1]));
    }

    //0은 자신이 얼리어답터일경우, 1은 자신이 얼리어답터가 아닌경우
    static int[] DFS(int node){
        V[node] = true;
        if(list[node] == null){
            dp[node] = new int []{1,0};
            return dp[node];
        }
        int early = 0;
        int notEarly = 0;

        for(Node n = list[node]; n != null; n = n.link){
            if(V[n.child]) continue;
            dp[n.child] = DFS(n.child);
            int [] cur = dp[n.child];
            if(cur[1]<cur[0]){
                early+= cur[1];
            } else {
                early += cur[0];
            }
            notEarly += cur[0];

        }

        return new int [] {early+1, notEarly};
    }
}
