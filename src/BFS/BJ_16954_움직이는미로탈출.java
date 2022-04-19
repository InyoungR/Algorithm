package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_16954_움직이는미로탈출 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char [][] map = new char[8][8];
        boolean [][] V = new boolean[8][8];
        Queue<int[]> que = new LinkedList<>();

        for(int i=0; i<8; i++){
            String msg = bf.readLine();
            map[i] = msg.toCharArray();
        }

        int [] dr = {-1,1,0,0,-1,-1,1,1,0};
        int [] dc = {0,0,-1,1,-1,1,-1,1,0};
        que.add(new int [] {7,0});
        boolean flag = false;
        V[7][0] = true;
        outer: while(!que.isEmpty()){

            int s = que.size();
            V = new boolean[8][8];

            for(int i=0; i<s; i++){
                int [] cur = que.poll();

                for(int dir=0; dir<9; dir++){
                    int r = cur[0] + dr[dir];
                    int c = cur[1] + dc[dir];

                    if(r<0 || c<0 || r>=8 || c>=8 || map[r][c] == '#' || V[r][c]) continue;
                    if(r-1>=0 && map[r-1][c] =='#') continue;

                    if(r == 0 && c == 7) {flag = true; break outer;}
                    que.add(new int [] {r,c});
                    V[r][c] = true;
                }
            }


            for(int i=7; i>0; i--){
                map[i] = map[i-1].clone();
            }
            Arrays.fill(map[0],'.');
        }

        if(flag) System.out.println(1);
        else System.out.println(0);
    }
}
