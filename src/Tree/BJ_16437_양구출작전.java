package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16437_양구출작전 {
    static class island{
        boolean isWolf, isLeaf, V;
        int cnt,next;

        public island() {
        }

        public island(boolean isWolf, int cnt, int next) {
            this.isWolf = isWolf;
            this.cnt = cnt;
            this.next = next;
            this.isLeaf = true;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        island[] islands = new island[n+1];
        for(int i=2; i<=n; i++){
            st = new StringTokenizer(bf.readLine());
            String wolf = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            if(islands[i] == null) islands[i] = new island(wolf.equals("W"), cnt, next);
            else {
                islands[i].isWolf = wolf.equals("W")?true:false;
                islands[i].cnt = cnt;
                islands[i].next = next;
            }

            if(islands[next] == null ) islands[next] = new island();
            islands[next].isLeaf = false;
        }

        long answer = 0;
        for(int i=n; i>=2; i--){
            if(!islands[i].isLeaf) continue;
            if(islands[i].isWolf) continue;

            int sheep = islands[i].cnt;
            island island = islands[i];
            while(sheep>0 && island.next != 1){

                island = islands[island.next];
                if(island.V) {answer+=sheep; break;}
                if(island.isWolf) sheep -= island.cnt;
                else sheep += island.cnt;

                island.V = true;
            }

            if(island.next == 1) answer += sheep;
        }

        System.out.println(answer);

    }
}
