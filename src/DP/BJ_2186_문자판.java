package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2186_문자판 {
    static int N, M, K;
    static char [][] board;
    static int [][][] DP;
    static char [] target;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for(int i=0; i<N; i++){
            board[i] = bf.readLine().toCharArray();
        }

        target = bf.readLine().toCharArray();
        DP = new int [target.length][N][M];

        for(int i=0; i<target.length; i++){
            for(int j=0; j<N; j++){
                Arrays.fill(DP[i][j], -1);
            }
        }

        int result = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] == target[0]) {
                    DFS(1, i, j);
                    result += DP[0][i][j];
                }
            }
        }

        System.out.println(result);
    }

    static void DFS(int idx, int r, int c){

        if(idx == target.length) return;

        int [] dr = {-1,1,0,0};
        int [] dc = {0,0,-1,1};

        int answer = 0;
        for(int dir=0; dir<4; dir++){
            for(int i=1; i<=K; i++){
                int nr = r + dr[dir]*i;
                int nc = c + dc[dir]*i;

                if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
                if(target[idx] != board[nr][nc]) continue;
                if(DP[idx][nr][nc] == -1 && idx == target.length-1) DP[idx][nr][nc] = 1;
                else if(DP[idx][nr][nc] == -1) DFS(idx+1, nr, nc);
                answer+= DP[idx][nr][nc];
            }
        }

        DP[idx-1][r][c] = answer;
    }
}
