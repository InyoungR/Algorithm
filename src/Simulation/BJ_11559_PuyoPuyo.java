package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BJ_11559_PuyoPuyo {
    static class puyo{
        int r,c; //row, column, type
        char t;
        public puyo(int r, int c, char t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
    static char [][] map;
    static Queue<List<puyo>> puyos = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        map = new char [12][6];

        for(int i=0; i<12; i++){
            map[i] = bf.readLine().toCharArray();
        }

        int result = 0;

        findBlock();

        while(!puyos.isEmpty()){
            int s = puyos.size();
            result++;

            for(int i=0; i<s; i++){
                List<puyo> block = puyos.poll();
                int s2 = block.size();

                for(int j=0; j<s2; j++){
                    puyo p = block.get(j);

                    map[p.r][p.c] = '.';
                }
            }

            for(int c=0; c<6; c++){
                int r = 11;
                while(r>0){
                    if(map[r][c] == '.'){
                        int nr = r-1;
                        while(nr>0 && map[nr][c] =='.' ) nr--;

                        map[r][c] = map[nr][c];
                        map[nr][c] = '.';
                    }
                    r--;
                }
            }

            findBlock();

        }

        System.out.println(result);

    }

    static void findBlock(){
        int []dr = {-1,1,0,0};
        int []dc = {0,0,-1,1};

        boolean [][] V = new boolean[12][6];
        for(int i=11; i>=0; i--){
            for(int j=0; j<6; j++){
                if(map[i][j] != '.' && !V[i][j]){
                    List<puyo> block = new ArrayList<>();
                    Queue<puyo> que = new LinkedList<>();
                    int cnt = 0;

                    puyo p = new puyo(i, j, map[i][j]);
                    V[i][j] = true;
                    block.add(p);
                    que.add(p);

                    while(!que.isEmpty()){
                        puyo cur = que.poll();

                        for(int dir=0; dir<4; dir++){
                            int nr = cur.r+dr[dir];
                            int nc = cur.c+dc[dir];

                            if(nr<0 || nc<0 || nr>=12 || nc>=6 || V[nr][nc] || map[nr][nc] != cur.t) continue;

                            puyo np = new puyo(nr,nc,map[nr][nc]);
                            que.add(np);
                            block.add(np);
                            V[nr][nc] = true;

                        }
                    }
                    if(block.size()>=4) puyos.add(block);
                }
            }
        }
    }
}
