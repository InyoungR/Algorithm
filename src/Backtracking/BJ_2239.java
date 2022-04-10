package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2239 {
    static class empty {
        int r,c,part;

        public empty(int r, int c, int part) {
            this.r = r;
            this.c = c;
            this.part = part;
        }
    }
    static int cnt;
    static empty[] empties;
    static boolean [][][] V;
    static int [][] map = new int [9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        empties = new empty[81];
        V = new boolean[3][9][10];
        //0은 세로, 1은 가로, 2는 사각형
        cnt = 0;
        for(int i=0; i<9; i++){
            String msg = bf.readLine();
            for(int j=0; j<9; j++){
                int temp = msg.charAt(j)-'0';
                if(temp == 0){
                    if(i<=2 && j<=2) empties[cnt++] = new empty(i,j,0);
                    else if(i<=2 && j<=5) empties[cnt++] = new empty(i,j,1);
                    else if (i<=2 && j<=8) empties[cnt++] = new empty(i,j,2);
                    else if (i<=5 && j<=2) empties[cnt++] = new empty(i,j,3);
                    else if (i<=5 && j<=5) empties[cnt++] = new empty(i,j,4);
                    else if (i<=5 && j<=8) empties[cnt++] = new empty(i,j,5);
                    else if (i<=8 && j<=2) empties[cnt++] = new empty(i,j,6);
                    else if (i<=8 && j<=5) empties[cnt++] = new empty(i,j,7);
                    else if (i<=8 && j<=8) empties[cnt++] = new empty(i,j,8);
                } else {
                    if(i<=2 && j<=2) V[2][0][temp] = true;
                    else if(i<=2 && j<=5) V[2][1][temp] = true;
                    else if (i<=2 && j<=8) V[2][2][temp] = true;
                    else if (i<=5 && j<=2) V[2][3][temp] = true;
                    else if (i<=5 && j<=5) V[2][4][temp] = true;
                    else if (i<=5 && j<=8) V[2][5][temp] = true;
                    else if (i<=8 && j<=2) V[2][6][temp] = true;
                    else if (i<=8 && j<=5) V[2][7][temp] = true;
                    else if (i<=8 && j<=8) V[2][8][temp] = true;
                }
                V[0][i][temp] = true;
                V[1][j][temp] = true;
                map[i][j] = temp;
            }
        }

        DFS(0);

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean DFS(int idx){
        if(idx == cnt){
            return true;
        }
        empty cur = empties[idx];

        for(int i=1; i<=9; i++){
            if(!V[0][cur.r][i] && !V[1][cur.c][i] && !V[2][cur.part][i]){
                V[0][cur.r][i] = true;
                V[1][cur.c][i] = true;
                V[2][cur.part][i] = true;
                map[cur.r][cur.c] = i;
                if(DFS(idx+1)) return true;
                V[0][cur.r][i] = false;
                V[1][cur.c][i] = false;
                V[2][cur.part][i] = false;
                map[cur.r][cur.c] = 0;
            }
        }
        return false;
    }
}
