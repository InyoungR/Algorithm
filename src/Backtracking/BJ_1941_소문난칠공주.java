package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_1941_소문난칠공주 {
    static char [][] map = new char[5][5];
    static int combi [] = new int [7];
    static int [] dr = {-1,1,0,0};
    static int [] dc = {0,0,-1,1};
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<5; i++){
            map[i] = bf.readLine().toCharArray();
        }


        princesses(0,0,0);

        System.out.println(result);
    }

    private static void princesses(int idx, int cnt, int total) {

        if(total == 7){
            if(cnt >=4 && isLinked()) {
                result++;
            }
            return;
        }
        for(int i=idx; i<25; i++){
           int r = i/5;
           int c = i%5;

           combi[total] = i;
           if(map[r][c] == 'S'){
               princesses(i+1, cnt+1, total+1);
           } else {
               princesses(i+1, cnt, total+1);
           }
        }
    }

    static boolean isLinked(){
        boolean [][] isPrincess = new boolean[5][5];
        boolean [][] V = new boolean[5][5];
        Queue<int[]> que = new LinkedList<>();

        for(int i=0; i<7; i++){
            int r = combi[i]/5;
            int c = combi[i]%5;

            isPrincess[r][c] = true;
            if(i==0){
                que.add(new int [] {r,c});
                V[r][c] = true;
            }
        }

        int cnt = 1;
        while(!que.isEmpty() && cnt<7){
            int [] cur = que.poll();

            for(int i=0; i<4; i++){
                int nr = cur[0]+ dr[i];
                int nc = cur[1]+ dc[i];

                if(nr>=0 && nc>= 0 && nr<5 && nc<5 && !V[nr][nc]){
                    V[nr][nc] = true;
                    if(isPrincess[nr][nc]) {
                        que.add(new int [] {nr,nc});
                        cnt++;
                    }
                }
            }

        }
        if(cnt == 7) return true;
        else return false;
    }
}
