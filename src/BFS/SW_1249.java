package BFS;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1249 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BFS/SW_1249.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(bf.readLine());

        for(int t=1; t<=T; t++){
            int n = Integer.parseInt(bf.readLine());

            int [][] map = new int [n][n];
            int [][] time = new int [n][n];

            for(int i=0; i<n; i++){
                String msg = bf.readLine();
                for(int j=0; j<n; j++){
                    map[i][j] = msg.charAt(j)-'0';
                }
            }

            for(int i=0; i<n; i++){
                Arrays.fill(time[i], 987654321);
            }

            //BFS 시작
            int [] dr = {-1,1,0,0};
            int [] dc = {0,0,-1,1};
            Queue<int[]> que = new LinkedList<>();

            que.add(new int [] {0,0,0});
            time[0][0] = 0;

            while(!que.isEmpty()){
                int [] cur = que.poll();

                if(cur[2]>time[cur[0]][cur[1]]) continue;

                for(int dir=0; dir<4; dir++){
                    int nr = cur[0] + dr[dir];
                    int nc = cur[1] + dc[dir];

                    if(nr>=0 && nc>=0 && nr<n && nc<n){
                        if(time[nr][nc]>time[cur[0]][cur[1]] + map[nr][nc]){
                            time[nr][nc] = time[cur[0]][cur[1]] + map[nr][nc];
                            que.add(new int[] {nr,nc, time[nr][nc]});
                        }
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(time[n-1][n-1]).append("\n");
        }
        System.out.println(sb);
    }
}
