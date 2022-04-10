package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17086_아기상어2 {
    static class shark{
        int r,c,d;

        public shark(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [][] map = new int [n][m];
        ArrayList<shark> sharks= new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<m; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1) {
                    map[i][j] = -1;
                    sharks.add(new shark(i,j,0));
                }
            }
        }
        Queue<shark> que = new LinkedList<>();
        int []dr = {-1,1,0,0,-1,-1,1,1};
        int []dc = {0,0,-1,1,-1,1,-1,1};

        for(shark s: sharks){
            que.add(s);
        }
        int answer = 0;
        while(!que.isEmpty()){
            shark cur = que.poll();

            for(int dir=0; dir<8; dir++){
                int nr = cur.r+dr[dir];
                int nc = cur.c+dc[dir];

                if(nr>=0 && nc>=0 && nr<n && nc<m && map[nr][nc] == 0){
                    map[nr][nc] = cur.d+1;
                    que.add(new shark(nr,nc,cur.d+1));
                    answer = Math.max(answer, cur.d+1);
                }
            }
        }
        System.out.println(answer);
    }
}
