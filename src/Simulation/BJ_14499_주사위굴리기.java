package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14499_주사위굴리기 {
    static class Dice{
        int top, bot, left,right,front,back;

        void one(){
            int temp = this.top;
            this.top = this.left;
            this.left = this.bot;
            this.bot = this.right;
            this.right = temp;
        }

        void two(){
            int temp = this.top;
            this.top = this.right;
            this.right = this.bot;
            this.bot = this.left;
            this.left = temp;
        }

        void three(){
            int temp = this.top;
            this.top = this.front;
            this.front = this.bot;
            this.bot = this.back;
            this.back = temp;
        }

        void four(){
            int temp = this.top;
            this.top = this.back;
            this.back = this.bot;
            this.bot = this.front;
            this.front = temp;
        }
    }
    static Dice dice = new Dice();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); //지도의 세로
        int M = Integer.parseInt(st.nextToken()); //지도의 가로
        int r = Integer.parseInt(st.nextToken()); // 주사위 좌표
        int c = Integer.parseInt(st.nextToken()); // 주사위 좌표
        int k = Integer.parseInt(st.nextToken()); //명령의 개수

        int [][] map = new int [N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int [] dr = {0,0,0,-1,1};
        int [] dc = {0,1,-1,0,0};
        st = new StringTokenizer(bf.readLine());

        for(int i=0; i<k; i++){
            int dir = Integer.parseInt(st.nextToken());
            int nr = r+dr[dir];
            int nc = c+dc[dir];

            if(nr<0 || nc<0 || nr>=N || nc>=M) continue;

            roleDice(dir);
            if(map[nr][nc] == 0) map[nr][nc] = dice.bot;
            else {
                dice.bot = map[nr][nc];
                map[nr][nc] = 0;
            }

            r = nr;
            c = nc;
            sb.append(dice.top).append("\n");
        }
        System.out.println(sb);
    }

    static void roleDice(int dir){
        switch(dir){
            case 1:
                dice.one();
                break;
            case 2:
                dice.two();
                break;
            case 3:
                dice.three();
                break;
            case 4:
                dice.four();
                break;
        }
    }
}
