package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_18405_경쟁적전염 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        int [][] map = new int [N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<N; j++){
                int a = Integer.parseInt(st.nextToken());
                if(a!= 0){
                    pq.add(new int [] {a,i,j});
                    map[i][j] = a;
                }
            }
        }

        st = new StringTokenizer(bf.readLine());
        int sec = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        Queue<int[]> que = new LinkedList<>();

        while(!pq.isEmpty()){
            que.add(pq.poll());
        }
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        while(!que.isEmpty() && sec-->0){
            int s = que.size();

            for(int i=0; i<s; i++){
                int [] cur = que.poll();
                int no = cur[0];
                int r = cur[1];
                int c = cur[2];

                for(int dir=0; dir<4; dir++){
                    int nr = r + dr[dir];
                    int nc = c + dc[dir];

                    if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
                    if(map[nr][nc] != 0) continue;

                    map[nr][nc] = no;
                    que.add(new int [] {no,nr,nc});
                }
            }
        }

        System.out.println(map[y-1][x-1]);
    }
}
