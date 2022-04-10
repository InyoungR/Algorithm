package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14502_연구소 {
    static class empty{
        int r,c;

        public empty(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class virus{
        int r,c;

        public virus(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M, Ecnt, Vcnt, result;
    static empty[] empties;
    static virus[] viruses;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int [][] map = new int [N][M];
        empties = new empty [N*M];
        viruses = new virus [N*M];
        Ecnt = 0; Vcnt = 0; result = 0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<M; j++){
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if(temp == 0){
                    empties[Ecnt++] = new empty(i,j);
                } else if(temp == 2){
                    viruses[Vcnt++] = new virus(i,j);
                }
            }
        }

        buildWar(0,0, map);

        System.out.println(result);
    }

    static void buildWar(int idx, int cnt, int [][] map){
        if(cnt == 3){
            spreadVirus(map);
            return;
        }
        for(int i=idx; i<Ecnt; i++){
            empty e = empties[i];
            map[e.r][e.c] = 1;
            buildWar(i+1, cnt+1, map);
            map[e.r][e.c] = 0;
        }
    }

    private static void spreadVirus(int[][] map) {
        int [][] builtMap = new int [N][M];

        for(int i=0; i<N; i++){
            builtMap[i] = map[i].clone();
        }
        Queue<virus> que = new LinkedList<>();
        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,-1,1};

        for(int i=0; i<Vcnt; i++){
            que.add(viruses[i]);
        }

        while(!que.isEmpty()){
            virus cur = que.poll();

            for(int dir=0; dir<4; dir++){
                int nr = cur.r + dr[dir];
                int nc = cur.c + dc[dir];

                if(nr>=0 && nc>=0 && nr<N && nc<M && builtMap[nr][nc] == 0 ){
                    builtMap[nr][nc] = 2;
                    que.add(new virus(nr,nc));
                }
            }
        }
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(builtMap[i][j] == 0) cnt++;
            }
        }

        result = Math.max(cnt, result);
    }
}
