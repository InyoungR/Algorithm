package Simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1953 {
    static class Pos{
        int r,c,time;


        public Pos(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;

        }
    }
    static int [] dr = {-1,1,0,0};
    static int []dc = {0,0,-1,1};
    static Queue<Pos> que = new LinkedList<>();
    static int [][] map;
    static int N,M;
    static boolean [][]V;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Simulation/SW_1953.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());

        for(int t=1; t<=T; t++){
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken()); //맵의 세로
            M = Integer.parseInt(st.nextToken()); //맵의 가로
            int R = Integer.parseInt(st.nextToken()); //맨홀 r
            int C = Integer.parseInt(st.nextToken()); //맨홀 c
            int L = Integer.parseInt(st.nextToken()); //시간

            map = new int [N][M];
            V = new boolean[N][M];
            int answer = 0;

            for(int i=0; i<N; i++){
                st = new StringTokenizer(bf.readLine());
                for(int j=0; j<M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            que.add(new Pos(R,C,1));
            V[R][C] = true;

            while(!que.isEmpty()){
                Pos po = que.poll();
                if(po.time > L) continue;
               answer+=1;

                Move(po);
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void Move(Pos po){

        int type = map[po.r][po.c];
        //상0,하1,좌2,우3
        for(int dir=0; dir<4; dir++){
            if(type ==2 && (dir==2 || dir==3)) continue;
            if(type ==3 && (dir==0 || dir==1)) continue;
            if(type ==4 && (dir==2 || dir==1)) continue;
            if(type ==5 && (dir==2 || dir==0)) continue;
            if(type ==6 && (dir==0 || dir==3)) continue;
            if(type ==7 && (dir==1 || dir==3)) continue;

            int nr = po.r+dr[dir];
            int nc = po.c+dc[dir];

            if(nr>=0 && nc>=0 && nr<N && nc<M && !V[nr][nc] && map[nr][nc] != 0){

                if(dir==0 && (map[nr][nc] ==3 || map[nr][nc] ==4 || map[nr][nc] ==7)) continue;
                if(dir==1 && (map[nr][nc] ==3 || map[nr][nc] ==5 || map[nr][nc] ==6)) continue;
                if(dir==2 && (map[nr][nc] ==2 || map[nr][nc] ==6 || map[nr][nc] ==7)) continue;
                if(dir==3 && (map[nr][nc] ==2 || map[nr][nc] ==4 || map[nr][nc] ==5)) continue;

                que.add(new Pos(nr,nc, po.time+1));
                V[nr][nc] = true;
            }
        }
    }
}
