package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1926 {

    static int max, result, n, m, width;
    static int [] dr = {-1,1,0,0};
    static int [] dc = {0,0,-1,1};
    static int [][] map;
    static boolean [][] isVisited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());
        //도화지의 크기 n x m
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int [n][m];
        isVisited = new boolean[n][m];
        max=0;
        result=0;

        //데이터 입력받기
        for(int j=0; j<n; j++) {
            st = new StringTokenizer(bf.readLine());
            for(int k=0; k<m; k++) {
                map[j][k] = Integer.parseInt(st.nextToken());
            }
        }

        //탐색 시작
        for(int j=0; j<n; j++) {
            for(int k=0; k<m; k++) {
                if(!isVisited[j][k]) {
                    if(map[j][k] ==1) {
                        width=0;
                        Recursion(j,k);
                        result +=1;
                        max = Math.max(width,max);
                    } else {
                        isVisited[j][k]=true;
                    }
                }

            }
        }

        sb.append(result).append("\n");
        sb.append(max).append("\n");

        System.out.println(sb.toString());
    }


    static void Recursion(int r, int c) {

        isVisited[r][c]=true;
        width+=1;

        for(int dir=0; dir<4; dir++) {
            int rr = r+ dr[dir];
            int cc = c+ dc[dir];

            if(rr>=0 && cc>=0 && rr<n && cc<m && !isVisited[rr][cc]) {
                if(map[rr][cc] == 1) Recursion(rr, cc);
                else isVisited[rr][cc]=true;
            }
        }
    }
}