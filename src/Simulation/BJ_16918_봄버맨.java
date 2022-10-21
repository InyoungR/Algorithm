package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16918_봄버맨 {
    static class Bomb{
        int r, c;

        public Bomb(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int time = 1;

        char [][] map = new char [R][C];
        for(int i=0; i<R; i++){
            map[i] = bf.readLine().toCharArray();
        }

        Queue<Bomb> oldQue = new LinkedList<>();
        Queue<Bomb> newQue = new LinkedList<>();

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] == 'O'){
                    oldQue.add(new Bomb(i,j));
                }
            }
        }
        time++;
        int [] dr = {1,-1,0,0};
        int [] dc = {0,0,-1,1};

        while(time<N+1){
            if(time%2 == 0){//new 폭탄 설치
                for(int i=0; i<R; i++){
                    for(int j=0; j<C; j++){
                        map[i][j] = 'O';
                    }
                }
            }else {//기존 폭탄 폭발
                while(!oldQue.isEmpty()){
                    Bomb cur = oldQue.poll();
                    map[cur.r][cur.c] = '.';

                    for(int dir=0; dir<4; dir++){
                        int nr = cur.r+dr[dir];
                        int nc = cur.c+dc[dir];

                        if(nr<0 || nc<0 || nr>=R || nc>=C) continue;

                        map[nr][nc] = '.';
                    }
                }

                for(int i=0; i<R; i++){
                    for(int j=0; j<C; j++){
                        if(map[i][j] == 'O'){
                            oldQue.add(new Bomb(i,j));
                        }
                    }
                }
            }

            time++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
