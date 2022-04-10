package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17135_캐슬디펜스 {
    static class archer{
        int r,c,d,no;

        public archer(int r, int c, int d, int no) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.no = no;
        }
    }
    static int N,M,D,answer=0,total=0;
    static int [][] map = null;
    static int [] chosen = new int [3];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int [N+1][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<M; j++){
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if(temp == 1) total++;

            }
        }
        Arrays.fill(map[N],-1);

        placeArcher(0,0);

        System.out.println(answer);
    }

    static void placeArcher(int idx, int cnt){
        if(cnt == 3){
            playGame();
            return;
        }
        for(int i=idx; i<M; i++){
            chosen[cnt] = i;
            placeArcher(i+1, cnt+1);
        }
    }

    private static void playGame() {
        int dr[]  = {0,-1,0};
        int dc[]  = {-1,0,1};
        int cnt = 0, kill = 0;
        int [][] Nmap = new int[N+1][M];

        for(int i=0; i<=N; i++){
            Nmap[i] = map[i].clone();
        }

        for(int r=N; r>0; r--){
            Queue<archer> que = new LinkedList<>();
            Queue<archer> que2 = new LinkedList<>();

            for(int j=0; j<M; j++){
                if(Nmap[r][j] == 1){
                    cnt++;
                }
                Nmap[r][j] = -1;
            }

            for(int j=0; j<3; j++){
                que.add(new archer(r,chosen[j],0, j));
            }
            int cnt2 = 0;
            boolean archers[] = new boolean[3];
            while(cnt<total && !que.isEmpty() && cnt2<3){
                archer cur = que.poll();
                if(archers[cur.no]) continue;

                for(int dir=0; dir<3; dir++){
                    int nr = cur.r+dr[dir];
                    int nc = cur.c+dc[dir];

                    if(nr>=0 && nc>=0 && nr<N && nc<M){
                        if(Nmap[nr][nc] == 0 && cur.d+1 <D){
                            que.add(new archer(nr,nc,cur.d+1, cur.no));
                        } else if(Nmap[nr][nc] >= 1 && cur.d+1<=D){
                            que2.add(new archer(nr,nc,cur.d+1, cur.no));
                            cnt2++;
                            archers[cur.no] = true;
                            break;
                        }

                    }
                }
            }

            while(!que2.isEmpty()){
                archer enemy = que2.poll();
                if(Nmap[enemy.r][enemy.c] == 1){
                    Nmap[enemy.r][enemy.c] = 0;
                    cnt++;
                    kill++;
                }
            }
            if(cnt==total)break;
        }
        answer = Math.max(answer, kill);
    }
}
