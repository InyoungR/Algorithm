package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_11724 {
    static int cnt=0;
    static ArrayList<Integer> [] graph;
    static boolean [] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());//노드의 개수
        int M = Integer.parseInt(st.nextToken());//간선의 개수

        graph = new ArrayList[N+1];
        isVisited = new boolean [N+1];

        for(int i=0; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int temp = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            graph[temp].add(temp2);
            graph[temp2].add(temp);

        }

        for(int i=1; i<N+1; i++){
            if(!isVisited[i]) {
                Linked(graph[i], i);
                cnt +=1;
            }

        }

        System.out.println(cnt);
    }

    public static void Linked(ArrayList<Integer> node, int idx){
        if(isVisited[idx]) return;

        isVisited[idx] = true;

        for(int i=0; i<node.size(); i++){
            Linked(graph[node.get(i)], node.get(i));
        }
    }

}
