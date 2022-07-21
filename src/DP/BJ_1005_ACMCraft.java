package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1005_ACMCraft {
    static int N, K;
    static int [] costs;
    static long [] DP;
    static ArrayList<Integer> [] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        for(int t=0; t<T; t++){
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            costs = new int [N+1];
            DP = new long [N+1];
            tree = new ArrayList[N+1];
            st = new StringTokenizer(bf.readLine());
            for(int i=1; i<=N; i++){
                costs[i] = Integer.parseInt(st.nextToken());
                tree[i] = new ArrayList<>();
                DP[i] = -1;
            }

            for(int i=0; i<K; i++){
                st = new StringTokenizer(bf.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                tree[to].add(from);
            }
            int target = Integer.parseInt(bf.readLine());
            DFS(target);
            sb.append(DP[target]).append("\n");
        }
        System.out.println(sb);
    }

    static void DFS(int cur){
        if(tree[cur].isEmpty()){
            DP[cur] = costs[cur];
            return;
        }
        ArrayList<Integer> next = tree[cur];
        long result = 0L;
        for(int i=0; i<next.size(); i++){
            if(DP[next.get(i)] == -1) DFS(next.get(i));
            result = Math.max(DP[next.get(i)], result);
        }
        DP[cur] = result + costs[cur];
    }
}
