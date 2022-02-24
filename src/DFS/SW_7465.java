package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SW_7465 {
    static int []parents;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(bf.readLine());

        for(int t=0; t<T; t++){
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append("#").append(t+1).append(" ");

            makeSet();

            for(int m=0; m<M; m++){
                st = new StringTokenizer(bf.readLine());
                int temp = Integer.parseInt(st.nextToken());
                int temp2 = Integer.parseInt(st.nextToken());

                union(temp, temp2);
            }

            Set<Integer> result = new HashSet<>();

            for(int i=1; i<=N; i++){
                result.add(findSet(i));
            }
            sb.append(result.size()).append("\n");
        }
        System.out.println(sb);
    }

    static void makeSet(){
        parents = new int [N+1];
        for(int i=0; i<=N; i++){
            parents[i] = i;
        }
    }
    static int findSet(int a){
        if(parents[a] == a) return a;
        else return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot==bRoot) return false;
        parents[aRoot] = bRoot;
        return true;
    }
}
