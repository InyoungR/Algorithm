package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1325 {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());//노드의 개수
        int m = Integer.parseInt(st.nextToken());//간선의 개수

        ArrayList<Integer> [] computers = new ArrayList[n+1];

        for(int i=0; i<=n; i++){
            computers[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            computers[from].add(to);
        }

        int [] result = new int [n+1];

        for(int i=1; i<=n; i++){
            boolean [] V = new boolean [n+1];
            DFS(i, computers, V, result);
        }
        int max = 0;
        for(int i=1; i<=n; i++){
            max = Math.max(max, result[i]);
        }

        for(int i=1; i<=n; i++){
            if(result[i] == max) sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    static void DFS(int to, ArrayList<Integer>[] computers, boolean[] V, int[] result){
        V[to] = true;
        for(int i: computers[to]){
            if(!V[i]){
                result[i]++;
                DFS(i, computers, V, result);
            }
        }

    }
}
