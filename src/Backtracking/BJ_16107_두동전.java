package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16107_두동전 {
    static class twoCoins{
        int r1,c1,r2,c2;

        public twoCoins(int r1, int c1, int r2, int c2) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char [][] board = new char[N][M];
        Queue<twoCoins> que = new LinkedList<>();

        ArrayList<Integer> coins = new ArrayList<>();
        for(int i=0; i<N; i++){
            String msg = bf.readLine();
            for(int j=0; j<M; j++){
                char temp = msg.charAt(j);
                board[i][j] = temp;
                if(temp == 'o') {
                    coins.add(i);
                    coins.add(j);
                }
            }
        }

        que.add(new twoCoins(coins.get(0),coins.get(1),coins.get(2),coins.get(3)));

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        boolean [][][][] V = new boolean[N][M][N][M];

        V[coins.get(0)][coins.get(1)][coins.get(2)][coins.get(3)] = true;


        int cnt = 0;
        outer : while(!que.isEmpty() && cnt++<=10){
            int s = que.size();

            for(int i=0; i<s; i++){
                twoCoins cur = que.poll();

                for(int dir=0; dir<4; dir++){
                    int nr1 = cur.r1+dr[dir];
                    int nr2 = cur.r2+dr[dir];
                    int nc1 = cur.c1+dc[dir];
                    int nc2 = cur.c2+dc[dir];

                    boolean check1 = checkRange(nr1,nc1,N,M);
                    boolean check2 = checkRange(nr2,nc2,N,M);

                    if(!check1 && !check2) continue;
                    else if(check1 && check2){
                        if(V[nr1][nc1][nr2][nc2]) continue;
                        if(board[nr1][nc1] == '#') {
                            nr1 = cur.r1;
                            nc1 = cur.c1;
                        }
                        if(board[nr2][nc2] == '#') {
                            nr2 = cur.r2;
                            nc2 = cur.c2;
                        }
                        que.add(new twoCoins(nr1, nc1, nr2, nc2));
                        V[nr1][nc1][nr2][nc2] = true;

                    } else {
                        break outer;
                    }
                }
            }
        }

        if(cnt > 10) System.out.println(-1);
        else System.out.println(cnt);

    }

    static boolean checkRange(int r, int c, int N, int M){
        if(r<0 || c<0 || r>=N || c>=M) return false;
        return true;
    }
}
