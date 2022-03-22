package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_17471 {
    static class Node{
        int pop;
        ArrayList<Integer> near = new ArrayList<Integer>();

        public Node(int pop) {
            this.pop = pop;
        }
    }

    static Node [] map;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new Node[n+1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=1; i<=n; i++){
            map[i] = new Node(Integer.parseInt(st.nextToken()));
        }

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(bf.readLine());
            int k = Integer.parseInt(st.nextToken());

            for(int j=0; j<k; j++){
                map[i].near.add(Integer.parseInt(st.nextToken()));
            }
        }

        //구역을 나눈다

        //나눈 구역들이 서로 이어져 있는지 확인

        //거리를 비교

    }

    static void DFS(int idx, int flag){

        flag |= (1<<idx);

        for(int i=0; i<map[idx].near.size(); i++){

        }
    }

    static void check(int flag){
        boolean [] V = new boolean [n+1];
        int start = 0;
        int cnt = 0;
        for(int i=1; i<=n; i++){
            if((flag & 1 << i) != 0) {
                V[i] = true; // 다른팀에 포함되어 있다면 true
            } else start = i;
        }


    }
}
