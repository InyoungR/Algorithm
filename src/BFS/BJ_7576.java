package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576 {

    static int [][] map;
    static int [] dr = {-1, 1, 0, 0};
    static int [] dc = {0,0,-1,1};
    static boolean [][] isVisited;
    static Queue<int[]> queue = new LinkedList<>();
    static int day, M, N;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int [N][M];
        isVisited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==1) queue.offer(new int [] {i,j,0});
            }
        }
        Bfs();

        outer : for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0) {
                    System.out.println(-1);
                    flag = true;
                    break outer;
                }
            }
        }

        if(!flag){
            System.out.println(day);
        }

    }

    static void Bfs(){

        while(!queue.isEmpty()){
            int [] temp = queue.poll();
            int rr = temp[0];
            int cc = temp[1];
            int cnt = temp[2];

            isVisited[rr][cc] = true;
            day = Math.max(day, cnt);

            for(int dir=0; dir<4; dir++){
                int rrr = rr + dr[dir];
                int ccc = cc + dc[dir];
                if(rrr >=0 && ccc>=0 && rrr<N && ccc<M && !isVisited[rrr][ccc]){
                    if(map[rrr][ccc] == 0) {
                        map[rrr][ccc] = 1;
                        queue.offer(new int [] {rrr, ccc, cnt+1});
                    }
                    else isVisited[rrr][ccc] = true;
                }
            }
        }
    }
}
