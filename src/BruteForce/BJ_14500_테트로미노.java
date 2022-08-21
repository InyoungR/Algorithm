package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_14500_테트로미노 {
    static int n,m,answer;
    static int [][] paper;
    static boolean [][] V;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int [n][m];
        V = new boolean [n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<m; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                V[i][j] = true;
                DFS(i,j,1, paper[i][j]);
                V[i][j] = false;
                DFS2(i,j,paper[i][j]);
            }
        }
        System.out.println(answer);

    }

    static void DFS(int r, int c, int cnt, int sum){

        if(cnt>=4) {
            answer = Math.max(answer, sum);
            return;
        }
        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,-1,1};


        for(int dir = 0; dir<4; dir++){
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(nr<0 || nc<0 || nr>=n || nc>=m || V[nr][nc]) continue;

            V[nr][nc] = true;
            DFS(nr,nc,cnt+1, sum+paper[nr][nc]);
            V[nr][nc] = false;
        }
    }

    static void DFS2(int r, int c, int no){


        int dr[] = {0,0,-1};
        int dc[] = {1,2,1};

        int sum = no;
        for(int dir=0; dir<3; dir++){
            int nr = r+dr[dir];
            int nc = c+dc[dir];

            if(nr<0 || nc<0 || nr>=n || nc>=m) break;
            else sum += paper[nr][nc];
        }
        answer = Math.max(answer, sum);


        dr = new int []{1,2,1};
        dc = new int []{0,0,1};
        sum = no;
        for(int dir=0; dir<3; dir++){
            int nr = r+dr[dir];
            int nc = c+dc[dir];

            if(nr<0 || nc<0 || nr>=n || nc>=m) break;
            else sum += paper[nr][nc];
        }
        answer = Math.max(answer, sum);

        dr = new int []{-1,0,1};
        dc = new int []{1,1,1};
        sum = no;
        for(int dir=0; dir<3; dir++){
            int nr = r+dr[dir];
            int nc = c+dc[dir];

            if(nr<0 || nc<0 || nr>=n || nc>=m) break;
            else sum += paper[nr][nc];
        }
        answer = Math.max(answer, sum);

        dr = new int []{0,0,1};
        dc = new int []{1,2,1};
        sum = no;
        for(int dir=0; dir<3; dir++){
            int nr = r+dr[dir];
            int nc = c+dc[dir];

            if(nr<0 || nc<0 || nr>=n || nc>=m) break;
            else sum += paper[nr][nc];
        }
        answer = Math.max(answer, sum);
    }

}
