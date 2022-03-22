package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17144 {

    static class Mimun {
        int r,c,val;

        public Mimun(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }
    static int R,C,T;
    static int [][] room;
    static Queue<Mimun> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        room = new int [R][C];
        int purifier [] = new int [2];
        for(int i=0, k=0; i<R; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<C; j++){
                int temp = Integer.parseInt(st.nextToken());
                room[i][j] = temp;
                if(temp == -1) purifier[k++] = i;
            }
        }

        for(int i=0; i<T; i++){
            Spread();
            room[purifier[0]][0] = -1;
            room[purifier[1]][0] = -1;
            RotateTop(0,purifier[0],0,C);
            RotateBot(purifier[1],R-1,0,C);
        }

        int result = 0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                result += room[i][j];
            }
        }
        System.out.println(result+2);
    }

    static void Spread(){

        int [] dr = {-1,1,0,0};
        int [] dc = {0,0,-1,1};
        int [][] copy = new int[R][C];

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){

                if(room[i][j] > 0){
                    int mimun = room[i][j];
                    int mi = mimun/5;

                    for(int dir=0; dir<4; dir++){
                        int r = i+dr[dir];
                        int c = j+dc[dir];

                        if(r>=0 && c>=0 && r<R && c<C && room[r][c] != -1){
                            copy[r][c] += mi;
                            mimun -= mi;
                        }
                    }
                    copy[i][j] += mimun;
                }

            }
        }

        for(int i=0; i<R; i++){
            room[i] = copy[i].clone();
        }

    }

    //하좌상우
    static void RotateTop(int rs, int re, int cs, int ce){
        for(int i=re-2; i>=rs; i--) room[i+1][cs] = room[i][cs];
        for(int i=cs+1; i<ce; i++) room[rs][i-1] = room[rs][i];
        for(int i=rs+1; i<=re; i++) room[i-1][ce-1] = room[i][ce-1];
        for(int i=ce-2; i>=cs+1; i--) room[re][i+1] = room[re][i];
        room[re][cs+1] = 0;
    }
    //상좌하우
    static void RotateBot(int rs, int re, int cs, int ce){
        for(int i=rs+2; i<=re; i++) room[i-1][cs] = room[i][cs];
        for(int i=cs+1; i<ce; i++) room[re][i-1] = room[re][i];
        for(int i=re-1; i>=rs; i--) room[i+1][ce-1] = room[i][ce-1];
        for(int i=ce-2; i>=cs+1; i--) room[rs][i+1] = room[rs][i];
        room[rs][cs+1] = 0;
    }
}
