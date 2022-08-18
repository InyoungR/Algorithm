package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_14500_테트로미노 {
    static int n,m,answer;
    static int [][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int [n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<m; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                DFS(i,j,1, paper[i][j]);
            }
        }

    }

    static void DFS(int r, int c, int cnt, int sum){

        if(cnt>4) {
            answer = Math.max(answer, sum);
            return;
        }
        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,-1,1};


        for(int dir = 0; dir<4; dir++){
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(nr<0 || nc<0 || nr>=n || nc>=m) continue;

            DFS(nr,nc,cnt+1, sum+paper[nr][nc]);
        }
    }

    static void DFS2(int r, int c, int cnt, int sum){

        if(cnt>4) {
            answer = Math.max(answer, sum);
            return;
        }
        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,-1,1};


        for(int dir = 0; dir<4; dir++){
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(nr<0 || nc<0 || nr>=n || nc>=m) continue;

            DFS(nr,nc,cnt+1, sum+paper[nr][nc]);
        }
    }
    static String listToString(ArrayList<Integer> nodeList){
        StringBuilder sb = new StringBuilder();
        Collections.sort(nodeList);

        for(int i : nodeList){
            sb.append(i);
        }

        return sb.toString();
    }
}
