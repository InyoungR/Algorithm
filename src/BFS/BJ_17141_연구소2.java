package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17141_연구소2 {
    static ArrayList<int[]> spots = new ArrayList<>();
    static int[][] chosen = null;
    static int N, M, answer;
    static int [][] mapOrigin;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken()); //연구소 크기
        M = Integer.parseInt(st.nextToken()); // 바이러스의 개수

        mapOrigin = new int [N][N];
        chosen = new int [M][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<N; j++){
                int a = Integer.parseInt(st.nextToken());
                if(a==2){
                    spots.add(new int[]{i,j});
                    continue;
                }
                mapOrigin[i][j] = a;
            }
        }
        int INF = 987654321;
        answer = INF;

        Choose(0, 0);
        if(answer == INF) System.out.println(-1);
        else System.out.println(answer);

    }

    static void Choose(int cnt, int idx){
        if(cnt == M){
            Spread();
            return;
        }
        if(idx == spots.size()) return;

        for(int i=idx; i<spots.size(); i++){
            chosen[cnt] = spots.get(i);
            Choose(cnt+1, i+1);

        }
    }

    static void Spread(){
        int time = 0;
        Queue<int[]> que = new LinkedList<>();
        int [][] map = new int [N][N];

        for(int i=0; i<N; i++){
            map[i] = mapOrigin[i].clone();
        }

        for(int i=0; i<M; i++){
            que.add(chosen[i]);
            map[chosen[i][0]][chosen[i][1]] = 2;
        }
        int []dr = {-1,1,0,0};
        int []dc = {0,0,-1,1};
        while(!que.isEmpty()){
            int s = que.size();
            boolean flag = false;

            for(int i=0; i<s; i++){
                int [] cur = que.poll();
                int r = cur[0];
                int c = cur[1];

                for(int dir=0; dir<4; dir++){
                    int nr = r + dr[dir];
                    int nc = c + dc[dir];

                    if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
                    if(map[nr][nc] != 0) continue;

                    map[nr][nc] = 2;
                    que.add(new int []{nr,nc});
                    flag = true;
                }
            }

            if(flag) time++;
        }

        boolean flag = false;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 0){
                    flag = true;
                    break;
                }
            }
        }

        if(!flag) answer = Math.min(answer, time);
    }
}
