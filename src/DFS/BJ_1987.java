package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1987 {
    static int [][] board;
    static int R, C, result;
    static boolean [][] isVisited;
    static boolean[] alphabet = new boolean[26];
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int [R][C];
        isVisited = new boolean[R][C];
        for(int i=0; i<R; i++){
            String s = bf.readLine();
            for(int j=0; j<C; j++){
                board[i][j] = s.charAt(j)-'A';
            }
        }
        result = 0;

        findWay(0,0,0);
        System.out.println(result);
    }

    static void findWay(int r, int c, int cnt){
        //이미 다녀온 알파벳이라면
        if(alphabet[board[r][c]]) {
            result = Math.max(result, cnt);
            return;
        } else{
            alphabet[board[r][c]] = true;
            for(int dir=0; dir<4; dir++){
                int rr = r+ dr[dir];
                int cc = c+ dc[dir];

                if(rr>=0 && cc>=0 && rr<R && cc<C){
                    findWay(rr,cc,cnt+1);
                }
            }
        } alphabet[board[r][c]]=false;
    }
}
