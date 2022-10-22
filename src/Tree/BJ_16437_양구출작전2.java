package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_16437_양구출작전2 {
    static class Island{
        String kind;
        int cnt;
        List<Integer> links = new ArrayList<>();

        public Island() {
        }

        public Island(String kind, int cnt, int link) {
            this.kind = kind;
            this.cnt = cnt;
            this.links.add(link);
        }
    }

    static int n;
    static Island[] islands;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(bf.readLine());
        islands = new Island[n+1];

        for(int i=1; i<=n; i++){
            islands[i] = new Island();
        }

        for(int i=2; i<=n; i++){
            st = new StringTokenizer(bf.readLine());
            String kind = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());
            int link = Integer.parseInt(st.nextToken());

            islands[i].kind = kind;
            islands[i].cnt = cnt;
            islands[link].links.add(i);
        }

        long answer = DFS(1);

        System.out.println(answer);

    }

    static long DFS(int idx){

        Island cur = islands[idx];

        if(cur.links.size()==0){
            if(cur.kind.equals("S")) return cur.cnt;
            else return 0;
        }

        long sheepCnt = 0;
        for(int i : cur.links){
            sheepCnt += DFS(i);
        }

        if(idx==1) return sheepCnt;

        if(cur.kind.equals("S")){
            sheepCnt += cur.cnt;
        } else {
            if(sheepCnt<cur.cnt) return 0;
            sheepCnt -= cur.cnt;
        }

        return sheepCnt;
    }
}
