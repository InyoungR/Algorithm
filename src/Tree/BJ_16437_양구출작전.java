package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_16437_양구출작전 {

    static List<Integer>[] list;
    static long[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        list = new List[n+1];
        memo = new long[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=2; i<=n; i++){
            st = new StringTokenizer(bf.readLine());
            String kind = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());
            int link = Integer.parseInt(st.nextToken());

            list[link].add(i);
            if(kind.equals("W")){
                cnt *= -1;
            }
            memo[i] = cnt;
        }

        DFS(1,-1);

        System.out.println(memo[1]);

    }

    static void DFS(int idx, int pa) {

        for(int nxt: list[idx]){
            DFS(nxt, idx);
        }

        if(pa != -1){
            if(memo[idx]>0){
                memo[pa] += memo[idx];
            }
        }
    }

}
