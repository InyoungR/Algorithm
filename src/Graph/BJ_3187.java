package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3187 {

    static int R, C;
    static int cntS,cntW;
    static boolean[][] V ;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int sheep = 0;
        int wolf = 0;
        char[][] map = new char[R][C];
        V = new boolean[R][C];

        for(int i=0; i<R; i++){
            map[i] = bf.readLine().toCharArray();
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                cntS=0; cntW=0;
                if((map[i][j] =='v' || map[i][j] =='k') && !V[i][j]){
                    V[i][j] = true;
                    if(map[i][j] == 'v') cntW +=1;
                    if(map[i][j] == 'k') cntS +=1;
                    eatSheep(i,j,map);
                    if(cntS>cntW) sheep += cntS;
                    else wolf += cntW;
                }
            }
        }

        System.out.println(sheep+" "+wolf);
    }

    static void eatSheep(int r, int c, char[][] map){
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,-1,1};

        for(int i=0; i<4; i++){
            int rr = r+ dr[i];
            int cc = c+ dc[i];

            if(rr<0 || rr>=R || cc<0 || cc>= C || map[rr][cc] =='#'||V[rr][cc]) continue;
            V[rr][cc] = true;
            switch(map[rr][cc]){
                case '.':
                    eatSheep(rr,cc, map);
                    break;
                case 'v':
                    cntW +=1;
                    eatSheep(rr,cc, map);
                    break;
                case 'k':
                    cntS +=1;
                    eatSheep(rr,cc,map);
                    break;
            }
        }
    }
}
