package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1325_ing {
    static int n, m, max;
    static int [] result;
    static boolean V[];
    static ArrayList<Integer> [] computers;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());//노드의 개수
        int m = Integer.parseInt(st.nextToken());//간선의 개수
        computers = new ArrayList[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if(computers[from] == null){
                computers[from] = new ArrayList<>();
                computers[from].add(to);
            } else {
                computers[from].add(to);
            }
        }
        max = 0;
        result = new int [n+1];

        for(int i=1; i<=n; i++){
            V = new boolean [n+1];

            DFS(i, 1);

        }

        for(int i=1; i<=n; i++){
            if(result[i] == max) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    static void DFS(int to, int cnt){
        V[to] = true;
        if(computers[to] != null){
            boolean flag = false;
            for(int i: computers[to]){
                if(!V[i]){
                    flag = true;
                    DFS(i, cnt+1);
                }
            }
            if(!flag){
                result[to]  = Math.max(result[to], cnt);
                max = Math.max(max, cnt);
                return;
            }
        } else {
            result[to]  = Math.max(result[to], cnt);
            max = Math.max(max, cnt);
            return;
        }
    }
}
