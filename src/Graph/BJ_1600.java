package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1600 {
    static class monkey{
        int r,c,jump,cnt;


        public monkey(int r, int c, int jump, int cnt) {
            this.r = r;
            this.c = c;
            this.jump = jump;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int [] dr = {-1,1,0,0};
        int [] dc = {0,0,-1,1};
        int [] dr2 = {2,2,1,1,-2,-2,-1,-1};
        int [] dc2 = {-1,1,2,-2,1,-1,2,-2};
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        char [][] map = new char[H][W];
        boolean [][][] V = new boolean[n+1][H][W];
        for(int i=0; i<H; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<W; j++){
                map[i][j] = st.nextToken().charAt(0);
            }
        }
        for(int i=0; i<=n; i++){
            V[i][0][0] = true;
        }
        Queue<monkey> que = new LinkedList<>();
        que.add(new monkey(0,0,0,0));
        int result = Integer.MAX_VALUE;
        boolean flag = false;
        while(!que.isEmpty()){
            monkey cur = que.poll();
            if(cur.c==W-1 && cur.r==H-1) {
                result = Math.min(result,cur.cnt);
                flag = true;
                continue;
            }
            if(cur.jump<n){
                for(int dir=0; dir<8; dir++){
                    int r = cur.r+dr2[dir];
                    int c = cur.c+dc2[dir];

                    if(r>=0 && c>= 0 && r<H && c<W && map[r][c] != '1' && !V[cur.jump+1][r][c]){
                            que.add(new monkey(r,c,cur.jump+1,cur.cnt+1));
                            V[cur.jump+1][r][c] = true;
                    }
                }
            }

            for(int dir=0; dir<4; dir++){
                int r = cur.r+dr[dir];
                int c = cur.c+dc[dir];

                if(r>=0 && c>= 0 && r<H && c<W && map[r][c] != '1' && !V[cur.jump][r][c]){
                        que.add(new monkey(r,c,cur.jump,cur.cnt+1));
                        V[cur.jump][r][c] = true;
                }
            }

        }

        if(!flag) System.out.println(-1);
        else System.out.println(result);
    }
}
