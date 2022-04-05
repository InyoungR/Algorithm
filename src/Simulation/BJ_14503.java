package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14503 {
    static int [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int [n][m];

        st = new StringTokenizer(bf.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); //0 북 1 동 2 남 3 서

        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //북 동 남 서
        int [] dr = {-1,0,1,0};
        int [] dc = {0,1,0,-1};
        int nr = 0;
        int nc = 0;
        int result = 0;
        boolean[][] V = new boolean[n][m];
        outer: while(true){
            if(!V[r][c]) result += 1;
            V[r][c] = true;

            for(int i=0; i<4; i++){

                d--;
                if(d<0) d = 3;

                nr = r + dr[d];
                nc = c + dc[d];

                if(nr>=0 && nc>=0 && nr<n && nc<m && map[nr][nc] != 1 && !V[nr][nc]) {
                    r = nr;
                    c = nc;
                    continue outer;
                }
            }

            nr = r - dr[d];
            nc = c - dc[d];

            if(nr>=0 && nc>=0 && nr<n && nc<m && map[nr][nc] != 1) {
                r = nr;
                c = nc;
            } else {
                break;
            }

        }

        System.out.println(result);
    }
}
