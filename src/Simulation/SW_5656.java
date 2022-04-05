package Simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SW_5656 {
    static class brick implements Comparable<brick>{
        int r,c,val;

        public brick(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }

        @Override
        public int compareTo(brick o) {
            return r==o.r?o.val-val:r-o.r;
        }
    }
    static int N,W,H, result;
    static PriorityQueue<brick> bricks = new PriorityQueue<>();
    static brick [] targets;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Simulation/SW_5656.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());

        for(int t=1; t<=T; t++){
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            int [][] map = new int [H][W];
            bricks = new PriorityQueue<>();

            for(int i=0; i<H; i++){
                st = new StringTokenizer(bf.readLine());
                for(int j=0; j<W; j++){
                    int temp = Integer.parseInt(st.nextToken());
                    map[i][j]= temp;
                    if(temp>1){
                        bricks.add(new brick(i,j,temp));
                    }
                }
            }

            targets = new brick[N];
            for(int i=0; i<N; i++){
                targets[i] = bricks.poll();
            }
            result = 987654321;

            DFS(0, map, 0);

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    static void DFS(int cnt, int [][] map, int flag){

        if(cnt >= N){
            result = Math.min(result, Count(map));
            return;
        }

        int [][] Nmap = new int [H][W];

        for(int i=0; i<N; i++){
            if((flag & 1<<i) != 0) continue;
            int Ncnt = cnt;
            brick target = targets[i];

            Nmap = shoot(target.c, map);
            Ncnt += 1;

            while(Nmap[target.r][target.c] != 0 && Ncnt<N){
                Nmap = shoot(target.c,Nmap);
                Ncnt += 1;
            }
            DFS(Ncnt, Nmap, flag | 1<<i);

        }


    }

    static int[][] shoot(int c, int [][] map){
        int [] dr = {-1,1,0,0};
        int [] dc = {0,0,-1,1};

        Queue<brick> que = new LinkedList<>();

        for(int i=0; i<H; i++){
            if(map[i][c] > 0){
                que.add(new brick(i,c,map[i][c]));
                break;
            }
        }

        while(!que.isEmpty()){
            brick cur = que.poll();
            //벽돌의 숫자가 하나라면 하나만 drop
            if(cur.val==1){
                map[cur.r][cur.c] = 0;
            //벽돌의 숫자가 둘 이상이라면 que에 넣어준다
            }else {
                map[cur.r][cur.c] = 0;
                for(int i=1; i<cur.val; i++){
                    for(int j=0; j<4; j++){
                        int nr = cur.r + dr[j]*i;
                        int nc = cur.c + dc[j]*i;

                        if(nr>=0 && nc >= 0 && nr<H && nc<W && map[nr][nc]>0){
                            que.add(new brick(nr, nc, map[nr][nc]));
                        }
                    }
                }
            }

            //혹시 떨어뜨려야하는 벽돌이 있다면 drop
            int nr = cur.r + dr[0];
            int nc = cur.c + dc[0];

            while(nr>=0 && nc>=0 && nr<H && nc<W && map[nr][nc]>0){
                map[nr][nc] = 0;
                nr += dr[0];
                nc += dc[0];
            }
        }
        return map;
    }

    static int Count(int [][] map){
        int cnt = 0;
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(map[i][j]>0) cnt += 1;
            }
        }
        return cnt;
    }
}
